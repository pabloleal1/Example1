package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EditFormOfPaymentElements extends Screen {

    public EditFormOfPaymentElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "et_account_bank")
    public MobileElement BankAccountField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GUARDAR']")
    @AndroidFindBy(id = "btn_first_button_edit_bank_account")
    public MobileElement saveButtonField;

    @iOSXCUITFindBy(id = "accountSuccess")
    @AndroidFindBy(id = "iv_message_image_message")
    public MobileElement imageVerifyEdition;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton")
    @AndroidFindBy(id = "ivExpandableTextViewArrow")
    public MobileElement dropDownMenu;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[2]/XCUIElementTypeButton)[2]")
    @AndroidFindBy(id = "ivEditCardNumber")
    public MobileElement editCreaditCard;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeAlert)[1]")
    @AndroidFindBy(id = "alertTitle")
    public MobileElement popUpCreditCard;
}
