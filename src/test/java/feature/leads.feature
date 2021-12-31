Feature: Create Leaftaps test cases in Cucumber

Background:
Given Launch the Chrome Browser
And Load the link
And Enter the UserName ID
And Enter the Password
And Click the Login button
Then CRM/SFA Page should appear
Given Enther CRM/SFA link
Then Leaftaps Home Page should appear
Given Click Leads
Then Leaftaps Leads Page should appear

Scenario Outline: TC001 CreateLead
Given Click Create Leads
Then Leaftaps Create Lead Page should appear
Given Enter companyName as <compName>
And Enter firstName as <firstName>
And Enter lastName as <lastName>
And Click Create Lead button 
Then Lead should be created

Examples:
|compName|firstName|lastName|
|'Wipro'|'Mahesh'|'Waran'|
|'Facebook'|'Sara'|'Sabreen'|
|'Watsapp'|'Nithin'|'Mithran'|

Scenario Outline: TC002 EditLead
Given Click FindLeads
And Enter the name in FirstName <fName>
And Click FindLeads
And Select the First searched Lead
Then Lead should get open
Given Click Edit button
And Update CompanyName <compName>
And Click Update
Then Lead should be updated

Examples:
|fName|compName|
|'Mahesh'|'Amazon'|
|'Babu'|'Test'|

Scenario Outline: TC003 EditLead
Given Click Merge Lead
And Click the icon in From Lead
And Enter the From Lead Name <fromName>
And Click the icon in To Lead
And Enter the TO Lead Name <toName>
And Click Merge button
Then Click Ok in the Alert
And Leads should be Merged

Examples:
|fromName|toName|
|'Mahesh'|'Sara'|
|'Gopi'|'Babu'|

Scenario Outline: TC004 DeleteLead

Given Click Find Lead button
And Enter the Lead ID to Delete <leadID>
And Click Delete Lead Button
Then Lead should be deleted <leadID>

Examples:
|leadID|
|'10005'|
|'10006'|

Scenario Outline: TC005 Duplicate Lead
Given Click Find Leads Button 
And Click Email option
And Enter <mail> to it
And Click Find Leads button
And Click first occurance of the lead
And Click Duplicate Lead button
And Click Create Lead button
And Verify the Lead is duplicated

Examples:
|mail|
|'test'|
