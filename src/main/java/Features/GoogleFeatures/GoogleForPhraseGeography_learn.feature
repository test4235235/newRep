Feature: Google search for geography

  Scenario Outline: Search for geography item in Google

    Given search web page
     When type in search "<phrase>"
     Then click search
     Then check web page "<phrase>"

    Examples:
      | phrase |
      | Poland |
      | Germany |
      | China |
      | Australia |