Feature: Log in to my account on automation practice

  Scenario Outline: Login to my account automation practice

   Given user is on automation practice web page
    When user click link text 'Sign In'
    Then user fill text fields with username "<username>" and password "<password>"
    Then user click button sign in
    Then user check is logged in

    Examples:
      | username | password |
      | petr_84@interia.pl | Anastazy123 |
