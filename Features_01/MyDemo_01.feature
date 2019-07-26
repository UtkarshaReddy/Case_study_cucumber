Feature:  My validation on American Express

@Regression @Smoke
Scenario: I want to login

Given I have an account
And I will provide the data
Then My login is scuccess

@Smoke
Scenario: I want to view my membership

Given I have logged in
Then I click on Reward points
And I will check for myrewards

@Sanity
Scenario: I want to refer my friend

Given I am offered with referal bonus
When I share the link with my friend
Then I will get some zeta points
And I will enjoy my friday party