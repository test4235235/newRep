Feature: Register new user in Automation Practice web page

  Scenario Outline: create new user of Automation Practice web page

    Given user view Automation Practice web page
     When user click button register new user
     Then user put adres mail "<mail>"
     Then user click button 'create new account'
     Then user select title "<title>"
     Then user set firstname "<name>"
     Then user set lastname "<surname>"
     Then user set new address mail "<mail>"
     Then user set password "<password>"
     Then user set date of birth "<birthdate>"
     Then user click check 'newsletter'
     Then user click check 'special offer'
     Then user set text address firstname "<name>"
     Then user set text address lastname "<surname>"
     Then user set text company "<company>"
     Then user set text address "<address>"
     Then User set text address line 2 "<addressLine2>"
     Then user set country name "<country>"
     Then user set city and state "<city>"
     Then user set zipcode "<zipcode>"
     Then user set addition information text field "<additionalInformation>"
     Then user set home phone "<homephone>" and mobile phone "<mobilephone>"
     Then user set address alias "<address_alias>"
     Then user click 'register new user'
     Then user verify is logged in

    Examples:
    | mail | title | name     | surname  | password    | birthdate    | company | address            | addressLine2                | country       | city     | zipcode | additionalInformation | homephone    | mobilephone | address_alias |
    |      | Mr    | Anastazy | Maliniak | Anastazy123 | 1-March-1980 | none    | 1 New Orchard Road | Armonk, New York 10504-1722 | United States | New York | 10504   | test                  | 914-499-1900 | 691891726   | anastazy123   |