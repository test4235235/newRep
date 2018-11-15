Feature: Log in to account and go to user history orders

  Background: Log in to account and go to user order history page

    Given user is on automation practice web page
     When user click link text 'Sign In'
     Then user fill text fields with username "petr_84@interia.pl" and password "Anastazy123"
     Then user click button sign in
     Then user check is logged in

  Scenario: User check history order page

    Given user is logged in to account
    When user click link to history order
    Then user see page history order
    Then user come back to main account page and log out

