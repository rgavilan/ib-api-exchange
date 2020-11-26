#Author: Izertis
#Keywords Summary : api-exchange
Feature: Communication between ontological infrastructure and semantic infrastructure

  Scenario: The Delta-processor launches a request to the api-exchange to request the delta file between 2 versions
    Given call to api exchange delta controller
    Then the api exchange retrieves the data from the ontological infrastructure layer
    Then the api exchange creates the delta file with the received data
    Then the api exchange sends the delta file to the Delta processor
