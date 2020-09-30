package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ContactDataScreenElements extends Screen {

    public ContactDataScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_contact_phone')]//android.widget.EditText")
    public MobileElement textContactPhone;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_contact_email')]//android.widget.EditText")
    public MobileElement textContactEmail;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='contactDataUnChecked']")
    @AndroidFindBy(id = "cb_email")
    public MobileElement checkEmail;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Button']")
    @AndroidFindBy(id = "cb_postal_code")
    public MobileElement checkPC;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GUARDAR']")
    @AndroidFindBy(id = "btn_save_changes")
    public MobileElement buttonSaveChanges;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowWhite']")
    @AndroidFindBy(id = "rl_close")
    public MobileElement buttonClose;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Aceptar']")
    @AndroidFindBy(id = "button2")
    public MobileElement CloseModalWindow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lo sentimos']")
    @AndroidFindBy(id = "alertTitle")
    public MobileElement TittleLoSentimos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Aceptar']")
    @AndroidFindBy(id = "button2")
    public MobileElement buttonAceptar;



}
