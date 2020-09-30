package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.Utilities;
import mutuamad.elements.EmmeScreenElements;

public class EmmeScreen extends EmmeScreenElements {

    public EmmeScreen(DriverManager driver) {
        super(driver);
    }


    public void clickBurgerIcon() {
        waitForClick(burgerIcon, 21);
        click(burgerIcon);
    }

    public boolean verify_Eme_Was_Open (){
        return isPresent(burgerIcon);
    }

    public void clickAcceptEmmeRecording() {
        try
        {
        click(acceptEmmeRecording); } catch (Exception e) {
        }
    }

    public void clickCloseBurgerIcon() {
        waitForClick(closeBurgerIcon, 21);
        click(closeBurgerIcon);
    }

    public void clickaAccidentPartsOption() {
        waitForClick(accidentPartsOption, 21);
        click(accidentPartsOption);
    }

    public boolean verifyPartesExpected() {
        Utilities.sleep(4000);
        return isPresent(partesExpected);
    }

    public void clickaAssistanceOption() {
        waitForClick(assistanceOption, 21);
        click(assistanceOption);
    }

    public void verifyAssistanceExpected() {
        Utilities.sleep(4000);
        if(isPresent(assitanceExpected))
        {
            System.out.println("Asistance button works properly");
        }
        else
        {
            System.out.println("Asistance button DOESN'T works properly");
        }
    }

    public void clickaCarCenterOption() {
        waitForClick(carCenterOption, 21);
        click(carCenterOption);
    }

    public void verifyCentersExpected() {
        Utilities.sleep(4000);
        if(isPresent(centersExpected))
        {
            System.out.println("Centers button works properly");
        }
        else
        {
            System.out.println("Center button DOESN'T works properly");
        }
    }

    public void clickaCardSoyOption() {
        waitForClick(cardSoyOption, 21);
        click(cardSoyOption);
    }

    public void verifyCardSoyExpected() {
        Utilities.sleep(4000);
        if(isPresent(cardSoyExpected))
        {
            System.out.println("card Soy button works properly");
        }
        else
        {
            System.out.println("card Soy button DOESN'T works properly");

        }
    }

    public void clickOKDeviceLocationPopup() {
        try
        {
            click(OKDeviceRecorderPopup);
        }
        catch (Exception e) { }
    }

    public void setSearchEmeField(String Search) {
        waitForVisible(emmeField, 10);
        click(emmeField);
        sendKeys(emmeField, Search);
        click(acceptEmmeFieldButton);
    }

    public void clickCloseEmmeScreen() {
        waitForVisible(closeEmmeScreen, 10);
        click(closeEmmeScreen);
    }

    public boolean latestSameMessage(String Search){
        return latestMessage.getText().equals(Search);
    }


    public boolean verify_Icon_Is_Shown (){
        return isEnabled(emeIcon);
    }

    public boolean verify_Ask_Eme_Button_Is_Shown  (){
        return isPresent(askEmeButton);
    }

    public boolean verify_watch_Eme_Video_Is_Shown (){
        return isPresent(watchVideoEmeButton);
    }

    public void click_On_Eme_Button (){
        waitForVisible(askEmeButton, 10);
        click(askEmeButton);
    }
    public void click_On_Eme_Video (){
        waitForVisible(watchVideoEmeButton, 10);
        click(watchVideoEmeButton);
    }
    public void click_On_Play_Eme_Video (){
        waitForVisible(playVideoEmeButton, 10);
        click(playVideoEmeButton);
    }
    public boolean verify_play_Eme_Video_Is_Shown (){
        return isEnabled(playVideoEmeButton);
    }
}
