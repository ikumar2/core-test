Feature: Sample API Test
@Test
  Scenario: Verify GET request to JSONPlaceholder
    When I send a GET request to "/todos/1"
    Then the response status code should be 200
    And the response should contain a todo item with title "delectus aut autem"