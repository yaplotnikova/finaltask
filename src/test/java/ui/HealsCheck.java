package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class HealsCheck extends BaseTest {
    @BeforeMethod
    public void baseUiSetup() throws MalformedURLException {

        super.baseUiSetup();
    }

    @Test
    public void firstUITest() {
        RozetkaSteps rozetkaSteps = new RozetkaSteps();
        rozetkaSteps.searchMilkaOnRozetkaPage();
        rozetkaSteps.openProductPage();
        rozetkaSteps.checkIfTheButtonIsActive();
    }

    @Test
    public void secondUITest() {
        RozetkaSteps rozetkaSteps = new RozetkaSteps();
        rozetkaSteps.clickOnTheAccountButton();
        rozetkaSteps.checkIfTheModalLogonIsDisplayed();
        rozetkaSteps.checkElementsOfLoginModal();

    }
}
