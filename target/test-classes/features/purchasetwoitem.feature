
Feature: Successfully purchase item

  Scenario: Add to cart and purchase item
    Given user is login
    And click add to cart
    Then validate message
    And click to cart
    And click check out
    And fill payment option
    And click place order

  Scenario: Purchase after viewing a product
    Given user is login
    And click view second product
    And click add to cart
    Then validate message
    And click to cart
    And click check out
    And fill payment option
    And click place order
