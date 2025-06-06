Feature: Scenario 2 - Add and remove product from "cumpleaños" category

  Scenario: Add and then remove a "cumpleaños" product
    Given that a buyer wants to manage their cart
    When the buyer opens the website at "https://www.floristeriamundoflor.com/"
    And navigates to the "Cumpleaños" category
    And adds product "MDF 0001" to the cart
    Then the cart should contain 1 item
    And the cart should contain "MDF 0001"
    When the buyer removes product "MDF 0001" from the cart
    Then the cart should contain 0 items
    And the cart should not contain "MDF 0001"

  # NOTA IMPORTANTE: Los pasos de verificación (Then) requieren que los localizadores
  # en ShoppingCartElements.java sean correctos y que las Questions funcionen correctamente.

  # NOTA IMPORTANTE: Reemplaza "Nombre Producto Cumpleaños" con el nombre real de un producto
  # de la categoría "Cumpleaños" en la página web.
  # La verificación "And the cart should not contain" requerirá una nueva Question. 