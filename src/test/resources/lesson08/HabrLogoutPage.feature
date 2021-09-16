Feature: log in to habr page

Scenario:
  Given I fill login and password
  When I click the develop
  And I click on companies
  And I click on company name by Mail.ru
  And I click on news
  And I click on the bookmark
  And I click on the user icon
  Then Success logout from Habr