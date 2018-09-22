Feature: Alert Sync between NIMS PM and NX AM

  #Alert deifination, AMO and Class name must be present in NX
  Scenario: Generate Alert in AM from NIMS
    Given I log in with username "Admin" and password "NetExpert"
    When I generate alert "alarm_api" on AMO "qa-rhel-vm4,1" of Class "cpu" and expect 200
