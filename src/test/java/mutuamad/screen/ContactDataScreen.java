package mutuamad.screen;

import com.atsistemas.appium.DriverManager;

import mutuamad.Utilities;
import mutuamad.elements.ContactDataScreenElements;

public class ContactDataScreen extends ContactDataScreenElements {

    public ContactDataScreen(DriverManager driver) {
        super(driver);
    }


    public void setTextPhoneNumber(String Phone) throws Exception{
        waitForVisible(textContactPhone, 5);
        sendKeys(textContactPhone, Phone);
        Utilities.sleep(2000);
        hideKeyboard();
    }

    public String getTextPhoneNumber() throws Exception{
        waitForVisible(textContactPhone, 5);
        return getText(textContactPhone);
    }

    public void setTextMail(String mail) throws Exception{
        waitForVisible(textContactEmail, 5);
        sendKeys(textContactEmail, mail);
        Utilities.sleep(2000);
        hideKeyboard();
    }

    public String getTextMail() throws Exception{
        waitForVisible(textContactEmail, 5);
        return getText(textContactEmail);
    }

    public void ClearPhoneNumberField() throws Exception{
        waitForVisible(textContactPhone, 5);
        clearField(textContactPhone);
    }

    public void ClearMailField() throws Exception{
        waitForVisible(textContactEmail, 5);
        clearField(textContactEmail);
    }

    public void clickButtonSaveChanges() {
        Utilities.sleep(2000);
        click(buttonSaveChanges);
    }

    public void clickCheckEmail() {
        Utilities.sleep(2000);
        click(checkEmail);
    }

    public void verifiChecks() {
       if (isEnabled(checkPC))
       {
           Utilities.sleep(2000);
           click(checkPC);
       }
       else
       {
           Utilities.sleep(2000);
           click(checkEmail);
       }
    }

    public void clickButtonClose() {
        waitForClick(buttonClose, 10);
        click(buttonClose);
    }

    public void clickCloseModalWindow() {
        waitForClick(CloseModalWindow, 10);
        click(CloseModalWindow);
    }

    public void verifyWasWrong() {
        waitForClick(TittleLoSentimos, 10);
        if(getText(TittleLoSentimos).equals("Lo sentimos"))
        {
            click(buttonAceptar);
        }
    }
}
