package com.mycom.test.iu.features_api;

import com.mycom.test.iu.api.domain.AlertSync;
import com.mycom.test.nova.credentials.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ManageAlertSync
{
   @Given("^I log in with username \"(.*?)\" and password \"(.*?)\"$")
   public void I_log_in_with_username_and_password(String username, String password) throws Throwable
   {
      User.get().setUser(username, password);
   }

   @When("^I generate alert \"(.*?)\" on AMO \"(.*?)\" of Class \"(.*?)\" and expect (\\d+)$")
   public void i_generate_alert_on_AMO_of_Class_and_expect(String alertName, String amo, String amoClass, int statusCode)
   {
      AlertSync.setBaseURL();
      AlertSync.setAlertDetails(alertName, amo, amoClass);
      AlertSync.genAlert(statusCode);
   }
}
