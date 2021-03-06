package com.libraryCT.step_definitions;

import com.libraryCT.pages.WelcomePage;
import com.libraryCT.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class LogoutStepDefs {

    @When("user should able to log out")
    public void user_should_able_to_log_out() {
        WelcomePage mainPage = new WelcomePage();
        BrowserUtils.waitForClickablility(mainPage.usernameNavDropDown,3);
        mainPage.usernameNavDropDown.click();
        BrowserUtils.waitForClickablility(mainPage.logOut,3);
        mainPage.logOut.click();
    }
}
