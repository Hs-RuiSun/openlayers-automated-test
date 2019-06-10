package com.cgi.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class GherkinSteps {
    @Given("User is on Home Page")
    public void user_is_on_home_page(){}

    @When("User Navigate to LogIn Page")
    public void user_navigate_to_login_page(){}

    @When("User enters Credentials to LogIn")
    public void user_enters_credentials_to_login(DataTable credentials) {
        //Map<String, String> credential = credentials.asMaps(String.class, String.class)
    }

    @Then("Message displayed Login Successfully")
    public void message_displayed(){

    }
}
