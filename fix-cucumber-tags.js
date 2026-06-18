const fs = require('fs');
const path = 'C:\\Users\\TECQNIO\\Documents\\GitHub\\CENOMI-XNotify\\src\\test\\java\\com\\xnotify\\bdd\\web\\features\\CampaignBuilder.feature';
const text = fs.readFileSync(path, 'utf8');
const lines = text.split(/\r?\n/);
const clean = s => {
  if (!s) return '';
  return s
    .replace(/Re-Engagement/g, 'ReEngagement')
    .replace(/Lead Nurture/g, 'LeadNurture')
    .replace(/Welcome Series/g, 'WelcomeSeries')
    .replace(/All Users/g, 'AllUsers')
    .replace(/New Users/g, 'NewUsers')
    .replace(/Inactive Users/g, 'InactiveUsers')
    .replace(/Active Users/g, 'ActiveUsers')
    .replace(/Timezone Optimized/g, 'TimezoneOptimized')
    .replace(/[^A-Za-z0-9]/g, '');
};
const out = [];
for (let i = 0; i < lines.length; i++) {
  const line = lines[i];
  const tagMatch = line.match(/^\s*@\S+/);
  const scenarioMatch = i + 1 < lines.length ? lines[i + 1].match(/^\s*Scenario:\s*(.+)$/) : null;
  if (tagMatch && scenarioMatch) {
    const block = [];
    let j = i + 1;
    while (j < lines.length && lines[j].trim() !== '') {
      block.push(lines[j]);
      j++;
    }
    let campaignType = '', goal = '', audience = '', node = '', schedule = '', validationNode = '';
    for (const l of block) {
      let m;
      if ((m = l.match(/user selects campaign type as "([^"]+)"/))) campaignType = m[1];
      if ((m = l.match(/user selects campaign goal as "([^"]+)"/))) goal = m[1];
      if ((m = l.match(/user selects audience as "([^"]+)"/))) audience = m[1];
      if ((m = l.match(/user adds "([^"]+)" node/))) node = m[1];
      if ((m = l.match(/configures "([^"]+)" schedule type/))) schedule = m[1];
      if ((m = l.match(/validation for ([Pp]ush|[Ee]mail) node/))) validationNode = m[1];
    }
    let tag = '';
    if (!campaignType && validationNode) {
      tag = 'Validation_' + clean(validationNode);
    } else {
      const parts = [campaignType, goal, audience, node, schedule].filter(Boolean).map(clean);
      tag = parts.join('_');
      if (!tag) tag = 'Scenario';
    }
    out.push('  @' + tag);
  } else if (!/^\s*@TC_\d+/.test(line)) {
    out.push(line);
  }
}
fs.writeFileSync(path, out.join('\r\n'), 'utf8');
