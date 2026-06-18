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
const pattern = 'user selects role as {string}';
const step = 'user selects role as "Admin"';
const regex = patternToRegex(pattern);
console.log(regex);
console.log(regex.test(step));