Feature: End-to-End User Journey

  Scenario Outline: Registered user performs end-to-end journey
    Given the user is on the home page
    When the user navigates to the registration page
    And the user fills in registration details with "<firstName>", "<lastName>", "<email>", "<company>", "<password>", "<day>", "<month>", "<year>"
     Then the registration is successful
    When the user searches for a product by name "<productName>"
    And adds the product to the cart
    And proceeds to checkout
    And downloads the invoice
    And logs out
    Then the user is successfully logged out

    Examples:
      | firstName | lastName | email                    | company      | password   | day | month   | year | productName |
      | John      | Doe      | john1231.doe@example.com | Example Inc. | Password1! | 1   | January | 1990 | Apple       |
