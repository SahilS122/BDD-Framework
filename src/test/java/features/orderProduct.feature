Feature: Place the order

  @PlaceOrder
  Scenario Outline: Search the product on home and offers page
    Given User is on GreenKart home page
    When User search the product <ProductName>
    And User gets the actual product name
    And User add quantity <ProductQuantity> for the product
    And User navigates to checkout page
    And User validates the product name
    And User validates the Apply Promo Code button
    And User places the order
    And User selects "India" from Choose Country
    And User accepts Terms & Conditions and clicks on Proceed
    Then User validates successful order placed message
    And User is on GreenKart home page

    Examples: 
      | ProductName | ProductQuantity |
      | Cauli       |               3 |
      | Beet        |               5 |
