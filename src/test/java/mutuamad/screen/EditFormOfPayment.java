package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.aventstack.extentreports.ExtentTest;
import mutuamad.elements.EditFormOfPaymentElements;

public class EditFormOfPayment extends EditFormOfPaymentElements {

    public EditFormOfPayment(DriverManager driver) {
        super(driver);
    }


    public void clickModifyBankAccount(String bankAccountString) {
        waitForClick(BankAccountField, 30);
        sendKeys(BankAccountField, bankAccountString);
    }

    public void clicksaveButtonField() {
        if(isEnabled(saveButtonField))
        {
            waitForClick(saveButtonField, 30);
            click(saveButtonField);
            System.out.println("Button bank Account Activate");
        }
        else
        {
            System.out.println("Button bank Account NO Activate");
        }
    }

    public boolean verifyButtonIsEnable(){

        return isEnabled(saveButtonField);

    }

    public boolean isEnabledImageEdition() {
        return isEnabled(imageVerifyEdition);
    }


    public void clickDropDownMenu() {
        click(dropDownMenu);
    }

    public boolean verifyEditCreditCard(){
        return isEnabled(editCreaditCard);
    }

    public void clickEditCreditCard() {
        click(editCreaditCard);
    }

    public boolean verifyPopUpEditCreditCard(){
        return isEnabled(popUpCreditCard);
    }

}
