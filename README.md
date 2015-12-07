# CucumberDemo
Cucumber demo bij Atos test competence

Build status: [![Circle CI](https://circleci.com/gh/vincentfree/TreeAPI.svg?style=svg)](https://circleci.com/gh/vincentfree/TreeAPI)

# Benodigdheden voor de demo zijn:
- Java IDE met cucumber plugin. 
- Selenium wordt aan de hand van de pom geimporteerd.
- Firefox (wordt als webdriver gebruikt)

voorbeeld stukje Gerkin
```cucumber
Scenario Outline: verify whether the check-out date field accepts a later date than check-in date
  Given I am on the adactin site
  When I set the location to "<Location>"
  And I select Hotel "<Hotels>"
  And I select Room type "<Roomtype>"
  Then the search results in an error message
Examples:
  |Location  |Hotels        |Roomtype  |
  |Sydney    |Hotel Creek   |Standard  |
  |London    |Hotel Sunshine|Double    |
```

