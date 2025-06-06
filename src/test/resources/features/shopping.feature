Feature: Shopping for flowers
  As a customer
  I want to select and add products to the shopping cart

  Scenario: Escenario 1: Seleccionar dos productos de la categoría amor para agregarlos al carro de compras
    Given that the user is on the home page
    When the user navigates to the "amor" category page
    And the user adds the first two visible products to the shopping cart
    Then the shopping cart should show 2 items 