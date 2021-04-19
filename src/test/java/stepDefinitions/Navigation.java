package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LaunchPage;

public class Navigation{

    @Given("User navigates to launch page")
    public void userNavigatesToLaunchPage() {
        LaunchPage launchPage = new LaunchPage();
        launchPage.navigateToLaunchPage();
    }
    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        LaunchPage launchPage = new LaunchPage();
        launchPage.enterUsername(username).enterPassword(password).clickLoginButton();
    }
    @Then("User validates correct login")
    public void userValidatesCorrectLogin() {
        HomePage homePage = new HomePage();
        homePage.validarHomePage();
    }

    @Then("User validates error message {string}")
    public void userValidatesErrorMessage(String errorMessage) {
        HomePage homePage = new HomePage();
        homePage.validarErrorMessage(errorMessage);
    }
}
