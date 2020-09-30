package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.ServicesScreenElements;

public class ServicesScreen extends ServicesScreenElements {

    public ServicesScreen(DriverManager driver) {
        super(driver);
    }


    public void moreInfo() {
        waitForClick(buttonMoreInfo, 21);
        click(buttonMoreInfo);
        scrollDown();
    }

    public void clickCheckConditions() {
        scrollDown();
        waitForClick(checkConditions, 21);
        click(checkConditions);
    }

    public void clickAcceptConditions() {
        scrollDown();
        waitForClick(nowParticipateButton, 21);
        click(nowParticipateButton);
    }

    public void clickButtonBack() {
        waitForClick(buttonBack, 21);
        click(buttonBack);
    }

    public void verifyAcceptConditionsIsShonw() {
        scrollDown();
        waitForClick(acceptConditionsText, 21);
        if(isPresent(acceptConditionsText))
        {
            click(checkConditions);
        }
    }
    public void quitCaptcha() {
        if(isPresent(captchaCheck)){
            click(captchaClose);
        }
    }

    public boolean captchaIsShown(){
        return isPresent(captchaCheck);
    }

    public void quitPopUpFromForgetPass() {
        if(isPresent(continueButtonfromPopUpForgotPass)){
            click(continueButtonfromPopUpForgotPass);
        }
    }
}
