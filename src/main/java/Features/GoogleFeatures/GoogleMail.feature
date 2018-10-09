Feature: First_automation_test_mail

  Scenario: Confirmation mail

Given type webpage url for gmail home page "https://www.google.com/intl/pl/gmail/about/#"
    When hit <Zaloguj się>
    Then typein user login "..."
    Then click <Dalejlogin>
    Then typein user password "..."
    Then click <Dalejpassword>
    Then click <Utwórz>
    Then type receiver mail "..."
    Then type "First automation test" in message title
    Then type in message body text "Hello! This message is to confirm first automation test code"
    Then hit 'Wyslij' button
    Then hit 'J' profile icon
    Then hit 'Wyloguj' button