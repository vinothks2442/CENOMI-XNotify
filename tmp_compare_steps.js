const fs = require('fs');
const feature = fs.readFileSync('src/test/java/com/xnotify/bdd/web/features/TeamManagement.feature','utf8');
const defs = fs.readFileSync('src/test/java/com/xnotify/bdd/web/step_definitions/TeamManagementSteps.java','utf8');
const stepLines = [];
feature.split(/\r?\n/).forEach(line => {
  const trimmed = line.trim();
  if (/^(Given|When|Then|And|But)\b/.test(trimmed)) {
    let step = trimmed.replace(/^(And|But)\s+/, '');
    if (/^(Given|When|Then)\b/.test(step)) {
      step = step.replace(/^(Given|When|Then)\s+/, '');
    }
    stepLines.push(step);
  }
});
const patterns = [];
const re = /@(Given|When|Then|And|But)\("([^"]+)"\)/g;
let m;
while ((m = re.exec(defs)) !== null) {
  patterns.push(m[2]);
}
function escapeRegex(str) {
  return str.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
}
function patternToRegex(pattern) {
  let regexStr = '';
  const parts = pattern.split(/(\{string\}|\{int\})/);
  for (const part of parts) {
    if (part === '{string}') {
      regexStr += '"([^\"]*)"';
    } else if (part === '{int}') {
      regexStr += '(\\d+)';
    } else {
      regexStr += escapeRegex(part);
    }
  }
  return new RegExp('^' + regexStr + '$');
}
const compiled = patterns.map(p => ({ pattern: p, regex: patternToRegex(p) }));
const missing = [];
for (const step of stepLines) {
  const matched = compiled.some(c => c.regex.test(step));
  if (!matched) missing.push(step);
}
const uniq = [...new Set(missing)].sort();
console.log('TOTAL feature steps', stepLines.length);
console.log('TOTAL unique missing', uniq.length);
uniq.forEach(s => console.log(JSON.stringify(s)));