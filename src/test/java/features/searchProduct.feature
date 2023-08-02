Feature: Search the product
	
	@SearchProduct
  Scenario: Search the product on home and offers page
    Given User is on GreenKart home page
    When User search the product tom
    And User gets the actual product name
    Then User search tom product exists in offers page
    And User validates product name from home and offers page

	@SearchProduct
  Scenario Outline: Search the product on home and offers page
    Given User is on GreenKart home page
    When User search the product <ProductName>
    And User gets the actual product name
    Then User search <ProductName> product exists in offers page
    And User validates product name from home and offers page

    Examples: 
      | ProductName |
      | Cauli       |
      | Beet        |
