package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.JsonParseData;
import mutuamad.elements.PasswordLostScreenElements;

public class PasswordLostScreen extends PasswordLostScreenElements {

    public PasswordLostScreen(DriverManager driver) {
        super(driver);
    }


    public void clickAllowDeviceSMSPopup(){
        try {
            click(allowDeviceSMSPopup);
        } catch (Exception ignored){ }
    }

    public boolean isHeadTitlePresent()  {
        return isPresent(headTitle);
    }

    public void sendNIFNumberCorrect() throws Exception {
        String nif = JsonParseData.get("user", "nif_nie_passLost");
        waitForVisible(NifNumber, 5);
        sendKeys(NifNumber, nif);
    }

    public void sendNIFNumberWrong() {
        waitForVisible(NifNumber, 5);
        sendKeys(NifNumber, "XXXXXXX");
    }

    public void sendNIFNumberNotRegister() {
        waitForVisible(NifNumber, 5);
        sendKeys(NifNumber, "32077793S");
    }

    public void clickCheckConditions() {
        tapStartElement(checkConditions);
    }

    public boolean isAllErrorsPresent()  {
        return isEnabled(errorDataTextErrors);
    }

    public boolean isOneErrorPresent()  {
        return isPresent(errorDataTextError);
    }

    public boolean isTextSecurityQuestionsPresent()  {
        return isPresent(textSecurityQuestions);
    }

    public void clickButtonContinuar() {
        waitForVisible(buttonContinuar, 20);
        click(buttonContinuar);
    }

    public void clickButtonContinuePhone() {
        waitForVisible(buttonContinuePhone, 20);
        click(buttonContinuePhone);
    }

    public boolean isPresentVerifyTelephoneNumber() {
        return isEnabled(verifyTelephoneNumber);
    }

    public void clickSendCodeAnotherTelephone() {
        waitForVisible(sendCodeAnotherTelephone, 20);
        click(sendCodeAnotherTelephone);
    }

    public void sendTelephoneUserValid() throws Exception {
        String telephone = JsonParseData.get("user", "telmobile");
        waitForVisible(telephoneNumber, 5);
        sendKeys(telephoneNumber, telephone);
    }

    public void sendTelephoneUserWrong() {
        waitForVisible(telephoneNumber, 5);
        sendKeys(telephoneNumber, "000000000");
    }

    public void clickLinkPhoneHelp() {
        click(linkPhoneHelp);
    }

    public boolean isPresentTextCallPhoneNumber() {
        return isEnabled(textCallPhoneNumber);
    }

    public boolean isPresentVerifyEnrollmentOtpCodeInput() {
        return isEnabled(verifyEnrollmentOtpCodeInput);
    }

    public void clickButtonBack() {
        click(buttonBack);
    }
    public void clickButtonCerrar() {
        click(buttonCerrar);
    }

    public void clickLegalConditionsLink() {
        click(linkConditions);
    }

    public void clickDataProtectionLink() {
        click(linkProtection);
    }

}
