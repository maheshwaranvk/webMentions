Feature: Login Functionality of Leaftapes

Background: 
Given Open Chrome Browser
And Load Url

Scenario Outline: TC_001 postive Test Cases
And Give UserName as <userID>
And Give PassWord as <password>
When Click the Login Button
Then Home Page should appear

Examples:
|userID|password|
|'Demosalesmanager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|

Scenario Outline: TC_002 negative Test Cases
And Give UserName as <userID>
And Give PassWord as <password>
When Click the Login Button
But Error Page should appear

Examples:
|userID|password|
|'Demosalesmanager12'|'crmsfa'|
|'DemoCSR'|'crmsfa34'|
