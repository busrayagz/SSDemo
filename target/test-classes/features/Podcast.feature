Feature: As a teacher I want to go to Podcast page
  @podcast @ui
  Scenario: Verify teacher on the Podcast page
    Given User navigate to SchoolStatus.com
    And User login as a Teacher successfully
    And User go to Resources module
    When User clicks on Podcast module from dropdown
    Then Verify Title is "ClassDismissed Podcast"

