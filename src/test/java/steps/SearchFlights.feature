Feature: Search a flight with multiple conditions
  Background:
    Given User on the flight Search Page

  Scenario Outline: Search an one way flight with multiple conditions
    When User searches a flight from "<FlyFrom>" to "<DestinationTo>"
    And selects the flight type "<FlightType>"
    And selects the depart date "<DepartDate>"
    And selects the number of passengers "<Adults>" "<Children>" "<Infants>"
    And User clicks on Search button
    Then The search results should display flights matching the criteria

    Examples:
    | FlyFrom | DestinationTo | FlightType | DepartDate | Adults | Children | Infants |
    | LHE     | DXB           | One Way    | 18-02-2025 | 1      | 0        | 0       |
