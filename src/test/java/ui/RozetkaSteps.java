package ui;

import io.qameta.allure.Step;

public class RozetkaSteps {
    @Step("search milka on rozetka page")
    public void searchMilkaOnRozetkaPage() {
        RozetkaSearchPage rozetkaSearchPage = new RozetkaSearchPage();
        rozetkaSearchPage.searchMilka();
    }

    @Step("open product page")
    public void openProductPage() {
        RozetkaSearchPage rozetkaSearchPage = new RozetkaSearchPage();
        rozetkaSearchPage.openMilkaPage();
    }

    @Step("check if the button is active")
    public void checkIfTheButtonIsActive() {
        RozetkaSearchPage rozetkaSearchPage = new RozetkaSearchPage();
        rozetkaSearchPage.checkingBuyButton();

    }

    @Step("click on the account button")
    public void clickOnTheAccountButton() {
        RozetkaAccountPage rozetkaAccountPage = new RozetkaAccountPage();
        rozetkaAccountPage.clickAccountButton();
    }

    @Step("check if the modal login is displayed")
    public void checkIfTheModalLogonIsDisplayed() {
        RozetkaAccountPage rozetkaAccountPage = new RozetkaAccountPage();
        rozetkaAccountPage.checkingDisplayingModalLogin();
    }

    @Step("checking elements of modal login")
    public void checkElementsOfLoginModal() {
        RozetkaAccountPage rozetkaAccountPage = new RozetkaAccountPage();
        rozetkaAccountPage.checkingElementsOfModalLogin();
    }
}
