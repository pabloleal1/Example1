package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.WelcomeScreenElements;
import org.openqa.selenium.Platform;

public class WelcomeScreen extends WelcomeScreenElements {

    public WelcomeScreen(DriverManager driver) {
        super(driver);
    }


    public void clickEmmeButton() {
        waitForVisible(emmeButton, 30);
        click(emmeButton);
    }

    public boolean verifyEmmeButtonisShown() {
        return isPresent(emmeButton);
    }

    public boolean verifyHolaIsShown() {
        return isPresent(welcomeUserText);
    }

    public String getTextWelcomeUser() {
        waitForVisible(welcomeUserText, 50);
        return getText(welcomeUserText);
    }

    public void clickTextWelcomeUser() {
        waitForVisible(welcomeUserButton, 50);
        click(welcomeUserButton);
    }

    public void clickFirstAdvantage() {
        waitForVisible(firstAdvantage, 30);
        click(firstAdvantage);
    }

    public void verifyReportButtonIsShown(){
        if(isPresent(buttonReports))
        {
            System.out.println("Report button is shown properly");
        }
        else
        {
            System.out.println("No Report button is shown ");

        }
    }

    public void clickLinkAllAdvantages() {
        waitForVisible(linkAllAdvantages, 30);
        click(linkAllAdvantages);
    }

    public void clickButtonMyCards() {
        waitForClick(buttonMyCards, 30);
        click(buttonMyCards);


        if (driver.getCapabilities().getPlatform().is(Platform.MAC)){
        //    click(buttonMyCards);
        }
    }

    public void clickButtonAssistance() {
        waitForClick(buttonAssistance, 30);
        click(buttonAssistance);
    }

    public boolean verifyButtonAssistanceIsShown() throws Exception {
        return isPresent(buttonAssistance);
    }

    public void clickButtonSearchCarchWorkShop() {
        waitForClick(buttonSearchCarWorkshop, 30);
        click(buttonSearchCarWorkshop);
    }

    public boolean verifyCarWorkShopIsShown() throws Exception {
        return isPresent(buttonSearchCarWorkshop);
    }


    public void clickButtonReports() {
        waitForClick(buttonReports, 30);
        click(buttonReports);
    }

    public boolean verifyButtonReportsIsShown() throws Exception {
        return isPresent(buttonReports);
    }

    public void clickButtonMenu() {
        waitForClick(buttonMenu, 30);
        click(buttonMenu);
    }

    public void clickIconCloseMenu() {
        waitForClick(iconCloseMenu, 30);
        click(iconCloseMenu);
    }

    public void clickButtonIconMailBox() {
        waitForClick(buttonIconMailBox, 30);
        click(buttonIconMailBox);
    }

    public boolean verifyMailButonFromHomeIsShown() {
        return isPresent(buttonIconMailBox);
    }

    public void clickOptionSettings() {
        waitForClick(optionSettings, 30);
        click(optionSettings);
    }

    public void clickOptionMyInsurance() {
        waitForClick(optionMyInsurance, 30);
        click(optionMyInsurance);
    }

    public void clickOptionFirstInsurance() {
        waitForClick(optionFirstInsurance, 30);
        click(optionFirstInsurance);
    }

    public void clickOptionCustomerSupport() {
        waitForClick(optionCustomerSupport, 30);
        click(optionCustomerSupport);
    }

    public void clickOptionFrequentQuestions() {
        waitForClick(optionFrequentQuestions, 30);
        click(optionFrequentQuestions);
    }

    public void clickOptionPrivacityPolitics() {
        waitForClick(optionPrivacityPolitics, 30);
        click(optionPrivacityPolitics);
    }

    public void clickOptionMailBox() throws Exception {
        waitForClick(optionMailBox, 30);
        click(optionMailBox);
    }

    public boolean verifyPriceCalculateIsShown() throws Exception {
        return isPresent(priceCalculation);
    }

    public boolean verifyDropDownMyInsuranceFromMenuIsShown() throws Exception {
        return isPresent(myInsuranceDropDownMenuFromMenu);
    }

    public boolean verifyMailButonFromMenuIsShown() {
        return isPresent(optionMailBox);
    }

    public boolean isMailNumberVisible() {
        return isPresent(optionMailNumber);
    }

    public boolean verifyEmeButtonIsShowOnHomeScreen(){
        return isPresent(emeButtonHome);
    }

    public void clickOnEmeButtonFromHomeScreen(){
        waitForVisible(emeButtonHome, 10);
        click(emeButtonHome);
    }

    public boolean verifyQRCodeIsShown() {
        return isPresent(QRcode);
    }

    //Google Play servicecs
    public boolean verifyGoogleServiceUpdate() {
        try
        {
            return isPresent(googleServiceUpdate);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean verifyCalculaTuSeguroIsShown() {
        return isPresent(calculaTuSeguro);
    }


    //Menu
    public boolean verifyMenuAssistanceIsShown() throws Exception {
        return isPresent(menu_Assistance);
    }

    public boolean verifyMenuSendReportIsShown() throws Exception {
        return isPresent(menu_SendReport);
    }

    public boolean verifyMenuookingForCarShopIsShown() throws Exception {
        return isPresent(menu_LookingForCarShop);
    }

}
