Feature: First_automation_test_mail

  Scenario: Confirmation mail

Given type webpage url for gmail home page "https://www.google.com/intl/pl/gmail/about/#"
    When hit <Zaloguj się>
    Then typein user login "aaaaa"
    Then click <Dalejlogin>
    Then typein user password "xxxx"
    Then click <Dalejpassword>
    Then click <Utwórz>
    Then type receiver mail "yyyy"
#    Then type receiver mail ""
    Then type "Greetings from Warsaw-first automation test" in message title
    Then click <add photo> "https://imagizer.imageshack.us/a/img923/6069/VY1ehD.jpg"
    #"https://drive.google.com/open?id=1Dz18daKxHfhiCyZ-PNMJiSiPLTl_wZew"
    #Then click <Adres internetowy (URL)>
    Then type in message body text "Hello! This message is to confirm first automation test code. Greetings from Jarek, Piotr i Kuba. "
#    Then type in message body text "Hello! This message is generated by automated test. Please do not respond on this message."
    Then hit 'Wyslij' button
    Then hit 'J' profile icon
    Then hit 'Wyloguj' button
