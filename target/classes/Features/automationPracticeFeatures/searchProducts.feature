# new feature
# Tags: optional

Feature: Search for products in selected category

  Scenario Outline: Users select category and search product

    Given web page of automation practice "<url>"
     When user move mouse cursor to top level menu category "<category>"
     Then submenu will appear and user select subcategory "<subcategory>"
     Then user select value of sort order "<sortOrder>"

    Examples:
       | url                                     | category | subcategory    | sortOrder           |
       | http://automationpractice.com/index.php | DRESSES  | CASUAL DRESSES | Price: Lowest first |