Narrative:
In order to log in into Gmail
As a user
I want to make sure that log in page works as expected 

Meta: 
 
@theme parameters

Scenario: User need to validate MC devloper Links.
Meta:
@Scenario1

Given home mc page https://developer.mastercard.com/account/log-in
When use click on menu link
Then user able to validate page is loaded


Scenario: User need to validate MC devloper Links with Example tables.
Meta:
@Scenario2

Given home mc page https://developer.mastercard.com/account/log-in
When use click on menu link
Then user able to validate page is loaded:
|page|
|Solutions|
|APIs|
|New & Experimental|
|Partner Programs|
|Case Studies|
|Blog|
|Support|
|Search|
|Sign Up|
|Log In|