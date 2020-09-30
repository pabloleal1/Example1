package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.JsonParseData;
import io.appium.java_client.MobileElement;
import mutuamad.Utilities;
import mutuamad.elements.ReportsScreenElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;


public class ReportsScreen extends ReportsScreenElements {

    public ReportsScreen(DriverManager driver) {
        super(driver);
    }



    public boolean verify_Dar_Parte_ScreenIsShown() {
        return isPresent(textTitleGivePart);
    }


    public void closeReportScreen() {
        waitForVisible(closeReportScreen, 10);
        click(closeReportScreen);
    }

    public void clickContinueButtonFromImplicityScreen() {
        click(continueButtonFromImplicityScreen);
    }

    public void clickButtonContinue() {
        click(buttonContinue);
    }

    public void clickButtonTheCarHasNoDamage() {
        click(buttonTheCarHasNoDamage);
    }

    public void clickOnWhatHappenedSection (){
        waitForVisible(whatHappened, 21);
        click(whatHappened);
    }

    public void clickReportWhenAndWhere() {
        click(carReportWhenAndWhere);
    }

    public void clickCalendarPreviousMonth() {
        //click(calendarPreviousMonth);
    }

    public void clickCalendarButtonOK() {
        //click(calendarButtonOK);
    }
    public void insertLocationWhereTextOnlyAndroidEmulator() throws Exception {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            clickLocationSendWhereText();
            sendLocationSendAssistanceAddress();
            selectLocationSendAssistanceAutoSuggest();
        }
    }

    public void clickLocationSendWhereText() {
        click(locationSendWhereText);
    }

    public void sendLocationSendAssistanceAddress() throws Exception {
        String address = JsonParseData.get("user", "addressAssistance");
        waitForVisible(locationSendAssistanceAddress, 5);
        sendKeys(locationSendAssistanceAddress, address);
    }

    public void selectLocationSendAssistanceAutoSuggest() {
        click(locationSendAssistanceAutoSuggest);
    }

    public void clickCarReportDamageFrontPoint() {
        waitForVisible(carReportDamageFrontPoint, 10);
        click(carReportDamageFrontPoint);

    }

    public void clickCarReportDamageRightPoint() {
        waitForVisible(carReportDamageRightPoint, 10);
        click(carReportDamageRightPoint);
    }

    public void clickButtonNext() {
        click(buttonCarDamageNext);
    }

    public void sendOtherDamageText() throws  Exception {
        if( isPresent(carReportOtherDamageText)){
            String otherDamage = JsonParseData.get("user", "otherDamageText");
            waitForVisible(carReportOtherDamageText, 5);
            sendKeys(carReportOtherDamageText, otherDamage);
        }
    }

    public void clickCarReportAddImages() {
        tapElementCoordinates(carReportAddImages);
    }

    public void clickCarReportOptionsAddImages() {
        click(carReportOptionsAddImages);
    }

    public void clickAllowDeviceAccessImagesPopup() {
        try
        {
            click(allowDeviceAccessImagesPopup);
        } catch (Exception ignored){ }

    }

    public void clickSelectFirstImage() {
        click(selectFirstImage);
    }

    public void clickSelectSecondImage() {
        click(selectSecondImage);

    }

    public void clickSelectThirdImage() {
        click(selectThirdImage);
    }

    public void clickAcceptAddImages() {
        if(!driver.getCapabilities().getPlatform().is(Platform.LINUX)){
            Utilities.sleep(1000);
            click(acceptAddImages);
        }
    }

    public boolean verifyImageIsLoad() {
        return isEnabled(verifyImageIsLoad);
    }

    public void clickDeleteFirstImage() {
        click(deleteFirstImage);
    }

    public void clickDeleteAllImages() {
        click(deleteAllImages);
    }

    public boolean verifyalertDeleteAllImages() {
        return isPresent(alertDeleteAllImages);
    }

    public boolean verifyalertDeleteFirstImages()
    {
        return isPresent(alertDeleteFirstImage);
    }

    public void clickAcceptDeleteImages()
    {
        click(acceptDeleteImages);
    }

    public void clickCancelDeleteImages()
    {
        click(cancelDeleteImages);
    }


    public void clickCarReportWhatHappenedToIt() {
        click(carReportwhatHappenedToIt);
    }


    public void clickCarReportHowHappened() {
        click(carReportHowHappened);
    }

    public void clickButtonOtherSituations() {
        click(buttonOtherSituations);
    }

    public void clickAllowDeviceMicrophonePopup() {
        try
        {
            click(allowDeviceLocationPopup);
            click(allowDeviceLocationPopup);
        }
        catch (Exception ignored) { }
    }

    public void sendHowHappenedText() throws Exception {

        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            String howHappened = JsonParseData.get("user", "howHappened");
            waitForVisible(howHappenedText, 5);
            //click(buttonOtherSituations);
            sendKeys(howHappenedText, howHappened);
            hideKeyboard();
        } else
            {
            String howHappened = JsonParseData.get("user", "howHappened");
            waitForVisible(howHappenedText, 5);
            sendKeys(howHappenedText, howHappened);
            hideKeyboard();
        }
    }


    public void clickButtonSaveReport() {
        click(buttonSaveReport);
    }

    public void clickButtonSavedReportAceptar() {
        click(buttonSavedReportAceptar);
    }

    public void clickButtonSavedReportAceptarToClose() {
        click(buttonSavedReportAceptarToClose);
    }
    public void clickButtonSavedReportCancelarToClose() {
        click(buttonSavedReportCancelarToClose);
    }


    public void clickButtonReportSavedPreviously() {
        click(reportSavedPreviously);
    }
    public void clickButtonBin() {
        click(buttonBin);
    }
    public void clickButtonDeleteReportSaved() {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX)){
            click(buttonDeleteReportSaved);
        } else {
            click(buttonDeleteReportSaved);
            click(buttonConfirmDeleteReportSaved);
        }
    }

    public boolean verifyReportOptionInformedIsShown (){
        return isPresent(verifyReportOptionInformed);
    }
    public boolean verifyListReportsSavedIsShown (){
        return isEnabled(verifyListReportsSaved);
    }


    public void clickButtonSendReport() {
        click(buttonSendReport);
    }

    public boolean verifySendReportIsShown(){
        return isPresent(buttonSendReport);
    }

    public void clickButtonRatingNoAskMore() {
        click(buttonRatingNoAskMore);
    }

    public boolean verifyOKReportReceived() {
        return isEnabled(OKReportReceived);
    }

    public void clickAllowDeviceLocationPopup() {
        try
        {
            click(allowDeviceLocationPopup);
        }
        catch (Exception ignored) { }
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

    public void clickPolicyX(String typePolicy, int x){
        Utilities.sleep(2000);
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            click((MobileElement)driver.findElement(By.xpath("(//*[starts-with(@text, '"+typePolicy+"')])["+x+"]")));
        }
        else
        {
            click((MobileElement)driver.findElement(By.xpath("(//XCUIElementTypeStaticText[starts-with(@name,'"+typePolicy+"')])["+x+"]")));
        }
    }

    public boolean verifyTeHaOcurridoScreenISShown (){
        Utilities.sleep(2000);
        return isEnabled(callCenterScreen);
    }

    // Options Give a Part
    public void clickVehicleHit() {
        waitForVisible(vehicleHit, 10);
        click(vehicleHit);
    }

    public boolean verifyVehicleHitOptionIsShown() {
        return isPresent(vehicleHit);
    }

    public void clickVehicleStolen() {
        waitForVisible(vehicleStolen, 10);
        click(vehicleStolen);
    }

    public boolean verifyVehicleStoleOptionIsShown() {
        return isPresent(vehicleStolen);
    }

    public void clickThereWasAFire() {
        waitForVisible(thereWasAFire, 10);
        click(thereWasAFire);
    }

    public boolean verifyThereWasAFireOptionIsShown() {
        return isPresent(thereWasAFire);
    }


    public void clickAnyMalfunction() {
        waitForVisible(anyMalfunction, 10);
        click(anyMalfunction);
    }

    public boolean verifyAnyMalfunctionOptionIsShown() {
        return isPresent(anyMalfunction);
    }

    public void clickVehicleTerrorism() {
        waitForVisible(vehicleTerrorism, 10);
        click(vehicleTerrorism);
    }

    public boolean verifyVehicleTerrorismOptionIsShown() {
        return isPresent(vehicleTerrorism);
    }

    public void clickVehicleWasNotDamage() {
        waitForVisible(vehicleWasNotDamage, 10);
        click(vehicleWasNotDamage);
    }

    public boolean verifyVehicleWasNotDamageOptionIsShown() {
        return isPresent(vehicleWasNotDamage);
    }

    public void cliclinkHelpYou() {
        waitForVisible(linkHelpYou, 10);
        scrollDown();
        click(linkHelpYou);
    }

    public void clickwithAVehicle() {
        waitForVisible(withAVehicle, 10);
        click(withAVehicle);
    }

    public void clickmorethanOneVehicle() {
        waitForVisible(morethanOneVehicle, 10);
        click(morethanOneVehicle);
    }

    public void clickwithAPersonAnimalOrObject() {
        waitForVisible(withAPersonAnimalOrObject, 10);
        click(withAPersonAnimalOrObject);
    }

    public void clickNoContraries() {
        waitForVisible(noContraries, 10);
        click(noContraries);
    }

    public void clickbreakageOfPanes() {
        waitForVisible(breakageOfPanes, 10);
        click(breakageOfPanes);
    }

    public void clickotherDamages() {
        waitForVisible(otherDamages, 10);
        click(otherDamages);
    }

    public void clickMyVehicleWasStolen() {
        waitForVisible(myVehicleWasStolen, 10);
        click(myVehicleWasStolen);
    }

    public void clickelementsFromMyVehicleWereStolen() {
        waitForVisible(elementsFromMyVehicleWereStolen, 10);
        click(elementsFromMyVehicleWereStolen);
    }

    public void clickMyVehicleShowedUp() {
        waitForVisible(myVehicleShowedUp, 10);
        click(myVehicleShowedUp);
    }

    public void clickMyVehicleNonShowedUp() {
        waitForVisible(myVehicleNonShowedUp, 10);
        click(myVehicleNonShowedUp);
    }

    public void clickcontinueButtonfromImprovingExperienceScreen() {
        waitForVisible(continueButtonfromImprovingExperienceScreen, 10);
        click(continueButtonfromImprovingExperienceScreen);
    }

    public boolean verifyImprovingExperienceScreenISShown() {
        return isEnabled(imageFromImprovingExperienceScreen);
    }

    public boolean verifyTextWebviewGivePart() {
        return isPresent(verifyTextWebviewGivePart);
    }
    public boolean verifyshownSSO() {
        return isEnabled(shownSSO);
    }

    public boolean verifyTextHelpYou() {
        return isPresent(verifyTextHelpYou);
    }

    public void clickBackArrowHelpYou() {
        waitForVisible(backArrowHelpYou, 10);
        click(backArrowHelpYou);
    }

    public boolean verifyNotCoverThisAccident() {
        return isPresent(notCoverThisAccident);
    }

    public boolean verifyHighPartHomeScreen() {
        return isEnabled(verifyHighPartHome);
    }


}
