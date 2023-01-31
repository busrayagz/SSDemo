Feature: Create Student

  @student
  Scenario: Create student as a teacher and verify status code is 201
    Given I logged SchoolStatus api as a "teacher"
    When I send POST request "/api/students/student" endpoint with following information
      | name   | Messi      |
      | gender | Male       |
      | phone  | 3658945621 |
    Then status code should be 201
