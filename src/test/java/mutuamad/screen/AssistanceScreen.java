package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.JsonParseData;
import io.appium.java_client.MobileElement;
import mutuamad.Utilities;
import mutuamad.elements.AssistanceScreenElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;

public class AssistanceScreen extends AssistanceScreenElements {

    public AssistanceScreen(DriverManager driver) {
        super(driver);
    }

    public boolean verifyAssistanceTittleIsShown() {
        return isPresent(assistanceTittleScreen);
    }

    public boolean verifyAssistanceTittleStartProcessIsShown() {
        return isEnabled(assistanceTittleStartProcess);
    }

    public void clickFirstAssistanceCar() {
        waitForClick(assistanceCarHome, slowTime);
        click(assistanceCarHome);
    }

    public void clickAssistanceCar(int x){
        Utilities.sleep(2000);
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            click((MobileElement)driver.findElement(By.xpath("(//*[starts-with(@text, 'COCHE')])["+x+"]")));
        }
        else
        {
            click((MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeStaticText[starts-with(@name,'COCHE')])["+x+"]")));
        }
    }

    public boolean verifyHomeInsurance() {
        return isPresent(homeInsurance);
    }

    public void clickFirstHomeInsurance() {
        click(homeInsurance);
    }

    public void clickAccidentAssistance() {
        waitForClick(accidentAssistance, slowTime);
        click(accidentAssistance);
    }

    public void clickRobberyAssistance() {
        waitForClick(robberyAssistance, slowTime);
        click(robberyAssistance);
    }

    public void clickFailureAssistance() {
        waitForClick(failureAssistance, slowTime);
        click(failureAssistance);
    }

    public void clickCarAssistanceNotStart() {
        waitForClick(carAssistNotStart, slowTime);
        click(carAssistNotStart);
    }

    public void clickCarAssistanceBattery() {
        waitForClick(carAssistBattery, slowTime);
        click(carAssistBattery);
    }

    public void clickCarAssistanceGas() {
        waitForClick(carAssistGas, slowTime);
        click(carAssistGas);
    }

    public void clickCarAssistanceElectricity() {
        waitForClick(carAssistElectricity, slowTime);
        click(carAssistElectricity);
    }

    public void clickCarAssistanceMechanic() {
        waitForClick(carAssistMechanic, slowTime);
        click(carAssistMechanic);
    }

    public void clickCarAssistanceEngine() {
        waitForClick(carAssistEngine, slowTime);
        click(carAssistEngine);
    }

    public void clickCarAssistanceWheel() {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX)){
            scrollDown();
        }
        waitForClick(carAssistWheel, slowTime);
        click(carAssistWheel);
    }

    public void clickCarAssistanceOther() {
        scrollTo(carAssistElectricity, carAssistWheel);
        waitForClick(carAssistOther, slowTime);
        click(carAssistOther);
    }

    public void clickFirstAssistanceHome() {
        waitForClick(assistanceHome, slowTime);
        click(assistanceHome);
    }

    public String getAsistanceHomeText() {
        return getText(assistanceHomeText);
    }

    public void clickCarAssistanceSuperficie() {
        waitForClick(carAssistanceSuperficie, slowTime);
        click(carAssistanceSuperficie);
    }

    public void clickCarassistanceCarColorDarkGray() {
        waitForClick(assistanceCarColorDarkGray, 10);
        click(assistanceCarColorDarkGray);
    }

    public void clickResponseYesAssistance() {
        waitForClick(responseYesAssistance, slowTime);
        click(responseYesAssistance);
    }

    public void clickResponseYesBatteryCar() {
        waitForClick(responseYesBatteryCar, slowTime);
        click(responseYesBatteryCar);
    }

    public void setTelephoneAssistanceUser() throws Exception {
        String telephone = JsonParseData.get("user", "telAssistance");
        waitForVisible(telephoneAssistance, slowTime);
        sendKeys(telephoneAssistance, telephone);
    }

    public String getTextGoogleLocationMap() {
        String text = "";
        try {
            if (isPresent(googleMapsLocationMapText)) {
                text = getText(googleMapsLocationMapText);
            }
        } catch (Exception ignored) { }
        return text;
    }

    public void clickAllowDeviceLocationPopup() {
        try {
            click(allowDeviceLocationPopup);
            click((MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name='Aceptar']"));
        } catch (Exception ignored) {}
    }

    public void clickLocationSendAssistanceText() {
        click(locationSendAssistanceText);
    }

    public void sendLocationSendAssistanceAddress() throws Exception {
        String address = JsonParseData.get("user", "addressAssistance");
        waitForVisible(locationSendAssistanceAddress, 5);
        sendKeys(locationSendAssistanceAddress, address);
    }

    public void selectLocationSendAssistanceAutoSuggest() {
        waitForClick(locationSendAssistanceAutoSuggest, slowTime);
        click(locationSendAssistanceAutoSuggest);
    }

    public void clickButtonContinue() {
        waitForClick(buttonContinue, slowTime);
        click(buttonContinue);
    }

    public void clickButtonConfirm() {
        waitForClick(buttonConfirm, slowTime);
        click(buttonConfirm);
    }

    public void clickButtonAcceptAssistance() {
        waitForClick(buttonAcceptAssistance, slowTime);
        click(buttonAcceptAssistance);
    }

    public void clickButtonCancel() {
        waitForClick(buttonCancel, slowTime);
        click(buttonCancel);
    }

    public void clickButtonNoCancelAssistance() {
        waitForClick(buttonNoCancelAssistance, slowTime);
        click(buttonNoCancelAssistance);
    }

    public void clickButtonYesCancelAssistance() {
        waitForClick(buttonYesCancelAssistante, slowTime);
        click(buttonYesCancelAssistante);
    }

    public void closeAsisstance(){
        waitForClick(buttonCancel,10);
        click(buttonCancel);
    }

    public boolean clickInsuranceAndVerifyCallCenterIsShown(int x){
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX)){
            click((MobileElement)driver.findElement(By.id("bt_callCenter")));
        }else {
            click((MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeStaticText[contains(@name,'COCHE')])["+x+"]")));
        }
        return isPresent(CallCenterPhoneScreen);
    }

    public boolean verifyhasTenidoScreenIsShown(int x){
        return isPresent(hasTenidoScreen);
    }

    public void selectNOFromSpareTypeScreen() {

        if(spareTyreScreen.isDisplayed()){
            click(spareTyreAnswerNO);
        }
    }

    public void selectYesFromSpareTypeScreen() {

        if(spareTyreScreen.isDisplayed()){
            click(spareTyreAnswerYes);
        }
    }

    public void continueFromBreakDownScreen() {

        if(breakdownAssistanceScreen.isDisplayed()){
            click(ContinueButtonBreakdownAssistanceScreen);
        }
    }

    public int allInsuranceXSize(String typePolicy){
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            return driver.findElements(By.xpath("//*[starts-with(@text, '"+typePolicy+"')]")).size();
        }
        else
        {
            return driver.findElements(By.xpath("(//XCUIElementTypeStaticText[starts-with(@name,'"+typePolicy+"')])")).size();
        }
    }

    public boolean verifyCallCenterIsShown(){
        return isPresent(CallCenterPhoneScreen);
    }

    public boolean verifyHasTenidoScreenScreenIsShown(){
        return isPresent(hasTenidoScreen);
    }
}
