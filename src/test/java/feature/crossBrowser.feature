Feature: Perform CrossBrowser Testing

Scenario Outline: TC_001
Given Open browser as <browser>
And Load Google Url
Then Google Url should open

Examples:
|browser|
|'chrome'|
|'firefox'|
|'edge'|