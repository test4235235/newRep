Feature: Google search feature

  Scenario Outline: Search phrase in Google

   Given web page with Google search
    When we paste in Google search text field "<phrase>"
    Then we search phrase by click search button
    Then we check web page title name with phrase "<phrase>"

    Examples:
    | phrase |
    | panda |
    | elephant |
    | lion |
    | cat |