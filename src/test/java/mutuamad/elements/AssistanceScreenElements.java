package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AssistanceScreenElements extends Screen {

    public AssistanceScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ASISTENCIA']")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement assistanceTittleScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Has tenido...']")
    @AndroidFindBy(id = "tv_question")
    public MobileElement assistanceTittleStartProcess;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'COCHE')][1]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'COCHE')][1]")
    public MobileElement assistanceCarHome;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'HOGAR')][1]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'HOGAR')][1]")
    public MobileElement assistanceHome;

    //Kind of Assitance

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Un accidente']")
    @AndroidFindBy(id = "tv_response_1")
    public MobileElement accidentAssistance;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Un robo']")
    @AndroidFindBy(id = "tv_response_2")
    public MobileElement robberyAssistance;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Una avería / otros']")
    @AndroidFindBy(id = "tv_response_3")
    public MobileElement failureAssistance;
    /////////////////////////////////////////


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'arranca')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'arranca')]")
    public MobileElement carAssistNotStart;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'batería')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'batería')]")
    public MobileElement carAssistBattery;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'combustible')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'combustible')]")
    public MobileElement carAssistGas;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'eléctrico')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'eléctrico')]")
    public MobileElement carAssistElectricity;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'mecánico')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'mecánico')]")
    public MobileElement carAssistMechanic;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'motor')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'motor')]")
    public MobileElement carAssistEngine;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'pinchazo')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'pinchazo')]")
    public MobileElement carAssistWheel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'otros')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'otros')]")
    public MobileElement carAssistOther;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Superficie')]/parent::*")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Superficie')]")
    public MobileElement carAssistanceSuperficie;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'A dónde')]/following-sibling::*[1]")
    @AndroidFindBy(id = "tv_where")
    public MobileElement locationSendAssistanceText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Introduce la dirección']")
    @AndroidFindBy(id = "et_address")
    public MobileElement locationSendAssistanceAddress;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    @AndroidFindBy(id = "tv_street_title")
    public MobileElement locationSendAssistanceAutoSuggest;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='GRIS OSCURO']")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[9]")
    public MobileElement assistanceCarColorDarkGray;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='imgCallCenter']/following-sibling::*[1]")
    @AndroidFindBy(id = "tvTitle_callCenter")
    public MobileElement assistanceHomeText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]")
    @AndroidFindBy(id = "rl_response_3")
    public MobileElement responseYesAssistance;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sí']")
    @AndroidFindBy(id = "rl_yes")
    public MobileElement responseYesBatteryCar;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement telephoneAssistance;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name,'Permitir') or starts-with(@name,'Allow')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    public MobileElement allowDeviceLocationPopup;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")//no use in iOS
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.mutua.mutua:id/map']/android.widget.LinearLayout/android.widget.TextView")
    public MobileElement googleMapsLocationMapText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_continue")
    public MobileElement buttonContinue;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'CONFIRMAR')]")
    @AndroidFindBy(id = "btn_confirm")
    public MobileElement buttonConfirm;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconClose']")
    @AndroidFindBy(id = "rlClose")
    public MobileElement buttonCancel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ACEPTAR']")
    @AndroidFindBy(id = "btn_finish_assistance")
    public MobileElement buttonAcceptAssistance;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='NO']")
    @AndroidFindBy(id = "button2")
    public MobileElement buttonNoCancelAssistance;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SÍ']")
    @AndroidFindBy(id = "button1")
    public MobileElement buttonYesCancelAssistante;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'contacta con nosotros')]")
    @AndroidFindBy(id = "bt_callCenter")
    public MobileElement CallCenterPhoneScreen;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Has tenido...']")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Has tenido...')]")
    public MobileElement hasTenidoScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'HOGAR')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'HOGAR')]")
    public MobileElement homeInsurance;

    ////////////////////
    //Spare Tyre Screen//
    ////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'repuesto?')]")
    @AndroidFindBy(id = "tv_question")
    public MobileElement spareTyreScreen;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sí']")
    @AndroidFindBy(id = "rl_yes")
    public MobileElement spareTyreAnswerYes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No']")
    @AndroidFindBy(id = "rl_no")
    public MobileElement spareTyreAnswerNO;
    public Integer slowTime  = 10;

    ///////////////////////////////
    //Breakdown assistance Screen//
    ///////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'te recordamos')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'te recordamos')]")
    public MobileElement breakdownAssistanceScreen ;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_continue")
    public MobileElement ContinueButtonBreakdownAssistanceScreen ;

}
