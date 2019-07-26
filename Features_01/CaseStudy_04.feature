Feature: proceeding to checkout without adding an item to cart
Scenario: The one where the user moves to cart without adding any item in it
Given Alex has registered in to TestMeApp
When Alex search a particular product like headphones
And Try to proceed to payment without adding any item in the cart
Then TestMeApp doesn't display the cart icon
