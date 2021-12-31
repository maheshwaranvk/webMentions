Feature: ServiceNow Application

Scenario: TC001 Create an Incident

Given Load to ServiceNow Application
And Enter UserName here
And Enter Password here
And Click Login
Then Check Login Successfull
Given Search Incident filter Navigator
And Click All
And Click New
Then Create Incident Page should appear
Given Select a Caller from dropdown
And Enter value for short description
And Read the incident
And Click on Submit button
And Search the incident number in the list
Then Incident should be created successfully