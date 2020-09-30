package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WelcomeScreenElements extends Screen {

    public WelcomeScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu' or @name='menuDueDate']")
    @AndroidFindBy(id = "rl_home")
    public MobileElement buttonMenu;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'mailbox')]")
    @AndroidFindBy(id = "iv_menu_navigation_mailbox")
    public MobileElement buttonIconMailBox;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='closeWhite']")
    @AndroidFindBy(id = "navigation_close")
    public MobileElement iconCloseMenu;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name])[1]")
    @AndroidFindBy(id = "tv_username")
    public MobileElement welcomeUserText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[1]/preceding-sibling::*")
    @AndroidFindBy(id = "tv_username")
    public MobileElement welcomeUserButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.mutua.mutua:id/ll_row_recyclerview_discount'][3]")
    public MobileElement firstAdvantage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Mis ventajas']")
    @AndroidFindBy(id = "title_discounts")
    public MobileElement linkAllAdvantages;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[last()]")
    @AndroidFindBy(id = "fragment_card_preview")
    public MobileElement buttonMyCards;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='assistanceTag']")
    @AndroidFindBy(id = "iv_assistance")
    public MobileElement buttonAssistance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='BUSCAR TALLER']")
    @AndroidFindBy(id = "tv_garages")
    public MobileElement buttonSearchCarWorkshop;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='DAR PARTE']")
    @AndroidFindBy(id = "tv_reports")
    public MobileElement buttonReports;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='AJUSTES']")
    @AndroidFindBy(id = "btn_settings")
    public MobileElement buttonSettingsApplication;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='assistanceTag']/preceding-sibling::*[1]")
    @AndroidFindBy(id = "ll_username_policies")
    public MobileElement optionMyInsurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeStaticText[last()]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.RelativeLayout")
    public MobileElement optionFirstInsurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONTACTO']")
    @AndroidFindBy(id = "ll_contact")
    public MobileElement optionCustomerSupport;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='AYUDA']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'AYUDA')]")
    public MobileElement optionFrequentQuestions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'PRIVACIDAD Y CONDICIONES')]")
    public MobileElement optionPrivacityPolitics;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='mailbox']/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'MENSAJES')]")
    public MobileElement optionMailBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "tv_number_messages")
    public MobileElement optionMailNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='AJUSTES']")
    @AndroidFindBy(id = "ll_setting")
    public MobileElement optionSettings;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/following-sibling::*/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    @AndroidFindBy(id = "cbFloatingButton")
    public MobileElement emmeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CALCULAR SEGURO']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CALCULAR SEGURO']")
    public MobileElement priceCalculation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeOther[1]")
    @AndroidFindBy(id = "ll_policies_option_menu_policy")
    public MobileElement myInsuranceDropDownMenuFromMenu;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='repsol'])[1]/following::*[1]")
    @AndroidFindBy(id = "iv_card_detail_qrcode_with_europoints")
    public MobileElement QRcode;

    //Google Play services
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PREGUNTAR A EME']")
    @AndroidFindBy(id = "tv_chatbot_notice_action")
    public MobileElement emeButtonHome;

    //Google Play services
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "alertTitle")
    public MobileElement googleServiceUpdate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CALCULAR SEGURO']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'CALCULAR SEGURO')]")
    public MobileElement calculaTuSeguro;


    //

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text ='ASISTENCIA EN CARRETERA']")
    public MobileElement menu_Assistance;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text ='DAR PARTE']")
    public MobileElement menu_SendReport;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text ='BUSCAR TALLER']")
    public MobileElement menu_LookingForCarShop;
}
