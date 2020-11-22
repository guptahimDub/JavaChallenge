# language: en

# encoding: UTF-8
Feature: Distance calculation of two given points

  Scenario: Check if user is under 100 km distance range from intercom dublin office
    Given a user with with id "2"
    And his name is "Test One"
    And his latitude is "53.339428"
    And his is longitude "-6.32"
    When calculated the user distance to intercom dublin office
    Then it should be less or equal 100 km distance from intercom dublin office

  Scenario: Check if user is over 100 km distance range from intercom dublin office
    Given a user with with id "2"
    And his name is "Test Two"
    And his latitude is "12.21212"
    And his is longitude "-32.32"
    When calculated the user distance to intercom dublin office
    Then it should be greater then 100 km distance from intercom dublin office
