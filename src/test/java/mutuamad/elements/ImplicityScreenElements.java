package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ImplicityScreenElements extends Screen {

    public ImplicityScreenElements(DriverManager driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    @AndroidFindBy(id = "noUsedAndroid")
    public MobileElement typePickerWheel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeToolbar[@name='Toolbar']//XCUIElementTypeButton[@name='OK']")
    @AndroidFindBy(id = "noUsedAndroid")
    public MobileElement iOSButtonOKKeyboard;

    //Details of involved
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'culpable')]/following-sibling::*[1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'culpable')]/following::*[2]")
    public MobileElement guiltyDropDownMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Firmaste')]/following-sibling::*[1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Firmaste')]/following::*[2]")
    public MobileElement friendlyReportDropDownMenu;


    //Images
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'FRONTAL')]/preceding-sibling::*[2]")
    @AndroidFindBy(id = "ll_add_photo_friendly_front")
    public MobileElement addFrontImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'POSTERIOR')]/preceding-sibling::*[2]")
    @AndroidFindBy(id = "ll_add_photo_friendly_back")
    public MobileElement addPostImage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='pinkDeleteIcon'])[1]/preceding::*[3]")
    @AndroidFindBy(id = "iv_remove_photo_friendly_front")
    public MobileElement deleteFrontImage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='pinkDeleteIcon'])[1]/preceding::*[3]")
    @AndroidFindBy(id = "iv_remove_photo_friendly_back")
    public MobileElement deletePostImage;


    //Details of the opposite
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'matrícula')]/following-sibling::*[2]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'matrícula')]/following::*[2]")
    public MobileElement vehiclePlateOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'matrícula')]/following-sibling::*[5]")
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Introduce')]")
    public MobileElement vehiclePlatesField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'aseguradora')]/following-sibling::*[2]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text, 'aseguradora')]/following::*)[2]")
    public MobileElement insuranceOptions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'aseguradora')]/following-sibling::*[5]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text, 'aseguradora')]/following::*)[5]")
    public MobileElement insuranceSelector;



    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Teléfono')]/following-sibling::*[1]")
    @AndroidFindBy(id = "et_question_contrary_phone")
    public MobileElement contraryPhoneNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Firmaste')]/following-sibling::*[1]")
    @AndroidFindBy(id = "sp_question_company")
    public MobileElement insuranceContraryCompanyDropDownMenu;



    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'CONTINUAR')]")
    public MobileElement buttonContinue;


    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text, 'conducía')]/following::*)[2]")
    public MobileElement clickGuiltyOption;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sí']")
    public MobileElement clickNoOption;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    public MobileElement clickYesOption;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mutua']")
    public MobileElement clickDesconocidaOption;


    //Partes Robo

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'cerrado')]/following-sibling::*[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text, 'cerrado')]/following::*)[2]")
    public MobileElement vehicleClosed;


    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "btn_edit_report_steal_continue")
    public MobileElement btnContinuarRobo;
}
