#Autor: BrahiamAc
  #Language: en

Feature: Registrar un nuevo usuario en la aplicación
  Como nuevo usuario,
  quiero poder registrarme en la aplicación,
  para acceder a nuevas funcionalidades.

  Background:
    Given Estoy en la pagina de registro

  Scenario: Registro exitoso de un nuevo usuario
    When Ingreso mis datos de usuario válidos
    And envio el formulario
    Then debo ver un mensaje "Registration is successful"

  Scenario: Registro fallido por correo electrónico ya registrado
    When Ingreso un correo electrónico ya registrado
    And envio el formulario
    Then debo ver un mensaje "User already exists"

  Scenario: Validacion de contraseñas diferentes
    When Ingreso una contraseña "Password123#"
    And ingreso una confirmación de contraseña diferente
    Then debo ver un mensaje "Passwords do not match"

  Scenario Outline: Validacion de reglas de contraseña
    When Ingreso una contraseña "<password>"
    And ingreso el mismo valor en la confirmación de contraseña
    And envio el formulario
    Then debo ver un mensaje "<error_message>"

    Examples:
      | password         | error_message                         |
      |Abc123.          |Password not long enough                  |
      |abcd1234.        |Password must have uppercase characters   |
      |Abcdefg.         |Password must have numeric characters     |
      |Abcd1234         |Password must have symbol characters      |