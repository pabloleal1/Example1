package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReportsScreenElements extends Screen {

    public ReportsScreenElements(DriverManager driver) {
        super(driver);
    }


    public static final List<String> DAMAGE_FRONT_POINT = Collections.unmodifiableList(Arrays.asList("2","4","6","11"));
    public static final List<String> DAMAGE_FRONT_RIGHT = Collections.unmodifiableList(Arrays.asList("1","2","3"));


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DAR PARTE']")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement textTitleGivePart;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sí, sin contrario']")
    @AndroidFindBy(id = "rl_response_1")
    public MobileElement carReportYesWithoutOther;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No']")
    @AndroidFindBy(id = "rl_response_2")
    public MobileElement carReportWithOther;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sí']")
    @AndroidFindBy(id = "rl_response_1")
    public MobileElement vehicleOrThingYes;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No']")
    @AndroidFindBy(id = "rl_response_2")
    public MobileElement vehicleOrThingNo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Daños varios']")
    @AndroidFindBy(id = "rl_response_2")
    public MobileElement carReportDamages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Una persona')]")
    @AndroidFindBy(id = "rl_response_3")
    public MobileElement personObjectOrAnimal;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Un vehículo')][1]")
    @AndroidFindBy(id = "rl_response_1")
    public MobileElement aVehicule;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Mas de un vehículo')][1]")
    @AndroidFindBy(id = "rl_response_2")
    public MobileElement moreThanOneVehicle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'no cubre') or contains(@name,'vía telefónica')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'no cubre') or contains(@text, 'vía telefónica')]")
    public MobileElement notCoverTypeAccident;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_continue")
    public MobileElement buttonContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='EL COCHE NO TIENE DAÑOS']")
    @AndroidFindBy(id = "btn_continue")
    public MobileElement buttonTheCarHasNoDamage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_enter")
    public MobileElement buttonContinuePart;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[contains(@resource-id, 'rl_edit_report_summary')])[1]")
    public MobileElement carReportWhenAndWhere;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    @AndroidFindBy(id = "tv_date")
    public MobileElement carReportWhenDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]")
    @AndroidFindBy(id = "tv_date")
    public MobileElement calendarDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconClose']")
    @AndroidFindBy(id = "rlClose")
    public MobileElement closeReportScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_continue")
    public MobileElement continueButtonFromImplicityScreen;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LOCALÍZAME']/preceding-sibling::*[2]")
    @AndroidFindBy(id = "tv_edit_report_where_address")
    public MobileElement locationSendWhereText;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]")
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[contains(@resource-id, 'rl_edit_report_summary')])[2]")
    public MobileElement whatHappened;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Introduce la dirección']")
    @AndroidFindBy(id = "et_address")
    public MobileElement locationSendAssistanceAddress;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[contains(@resource-id,'item_address')])[1]")
    public MobileElement locationSendAssistanceAutoSuggest;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][5]")
    @AndroidFindBy(xpath = "//android.widget.ToggleButton[contains(@resource-id, 'check169') or contains(@resource-id, 'check126')]")
    public MobileElement carReportDamageFrontPoint;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][6]")
    @AndroidFindBy(xpath = "//android.widget.ToggleButton[contains(@resource-id, 'check151') or contains(@resource-id, 'check136')]")
    public MobileElement carReportDamageRightPoint;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='damageEmpty'][last()]/following::*)[3]")
    @AndroidFindBy(id = "btn_navigation_right")
    public MobileElement buttonCarDamageNext;

    //View add other damage and images
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[1]")
    @AndroidFindBy(id = "et_detail")
    public MobileElement carReportOtherDamageText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='cameraImage']")
    @AndroidFindBy(id = "ll_add_photo")
    public MobileElement carReportAddImages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'biblioteca')]")
    @AndroidFindBy(id = "button1")
    public MobileElement carReportOptionsAddImages;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeAlert)[1]//XCUIElementTypeButton[starts-with(@name,'Permitir') or starts-with(@name,'Allow')]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'permission_allow_button')]")
    public MobileElement allowDeviceAccessImagesPopup;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/parent::*)[1]")
    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@resource-id,'icon_thumb')])[1]")
    public MobileElement selectFirstImage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/parent::*)[2]")
    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@resource-id,'icon_thumb')])[2]")
    public MobileElement selectSecondImage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/parent::*)[3]")
    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@resource-id,'icon_thumb')])[3]")
    public MobileElement selectThirdImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    @AndroidFindBy(xpath = "(//android.widget.ImageView[contains(@resource-id,'icon_mime')])[1]")
    public MobileElement acceptAddImages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeImage[not(@name)]")
    @AndroidFindBy(id = "iv_photo")
    public MobileElement verifyImageIsLoad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='pinkDeleteIcon']/parent::*")
    @AndroidFindBy(id = "iv_remove_photo")
    public MobileElement deleteFirstImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='garbageImage']")
    @AndroidFindBy(id = "ib_edit_report_damage_remove_photo")
    public MobileElement deleteAllImages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'eliminar todas')]")
    @AndroidFindBy(id = "message")
    public MobileElement alertDeleteAllImages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'eliminar esta')]")
    @AndroidFindBy(id = "message")
    public MobileElement alertDeleteFirstImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ACEPTAR']")
    @AndroidFindBy(id = "button1")
    public MobileElement acceptDeleteImages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CANCELAR']")
    @AndroidFindBy(id = "button2")
    public MobileElement cancelDeleteImages;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='¿QUÉ LE HA PASADO?']")
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[contains(@resource-id, 'rl_edit_report_summary')])[3]")
    public MobileElement carReportwhatHappenedToIt;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='¿CÓMO HA PASADO?']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='¿CÓMO HA PASADO?']")
    public MobileElement carReportHowHappened;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Otras situaciones')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Otras situaciones')]")
    public MobileElement buttonOtherSituations;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[1]")
    @AndroidFindBy(id = "et_finalString")
    public MobileElement howHappenedText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'ENVIAR PARTE')]")
    @AndroidFindBy(id = "btn_edit_report_continue")
    public MobileElement buttonSendReport;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ahora no']")
    @AndroidFindBy(id = "btn_no_ask_more")
    public MobileElement buttonRatingNoAskMore;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='ReportOk']")
    @AndroidFindBy(id = "tv_confirmed_report_title")
    public MobileElement OKReportReceived;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[1]/XCUIElementTypeStaticText)[3]")
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[contains(@resource-id, 'rl_edit_report_summary')])[1]")
    public MobileElement verifyReportOptionInformed;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GUARDAR PARTE']")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'GUARDAR PARTE')]")
    public MobileElement buttonSaveReport;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Aceptar']")
    @AndroidFindBy(id = "button1")
    public MobileElement buttonSavedReportAceptar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GUARDAR PARTE']")
    @AndroidFindBy(id = "btn_right")
    public MobileElement buttonSavedReportAceptarToClose;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR SIN GUARDAR']")
    @AndroidFindBy(id = "btn_left")
    public MobileElement buttonSavedReportCancelarToClose;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    @AndroidFindBy(id = "iv_arrow")
    public MobileElement reportSavedPreviously;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconTrash']")
    @AndroidFindBy(id = "iv_bin")
    public MobileElement buttonBin;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'Eliminar')])[1]")
    @AndroidFindBy(id = "iv_prohibited")
    public MobileElement buttonDeleteReportSaved;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='trailing0']")
    @AndroidFindBy(id = "noUsedAndroid")
    public MobileElement buttonConfirmDeleteReportSaved;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell)[1]")
    @AndroidFindBy(xpath = "//android.widget.ListView[contains(@resource-id,'lv_saved_reports')]/android.widget.RelativeLayout")
    public MobileElement verifyListReportsSaved;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Estamos trabajando')]")
    @AndroidFindBy(id = "tv_bodyText_callCenter")
    public MobileElement assistanceHomeText;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='fail']")
    @AndroidFindBy(id = "tvTitle_callCenter")
    public MobileElement callCenterScreen;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name,'Permitir') or starts-with(@name,'Allow')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    public MobileElement allowDeviceLocationPopup;


    // Give a part
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'golpe')]")
    @AndroidFindBy(id = "view_response_1")
    public MobileElement vehicleHit;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'robado')]")
    @AndroidFindBy(id = "view_response_2")
    public MobileElement vehicleStolen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'incendio')]")
    @AndroidFindBy(id = "view_response_3")
    public MobileElement thereWasAFire;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]")
    @AndroidFindBy(id = "view_response_4")
    public MobileElement anyMalfunction;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'motín')]")
    @AndroidFindBy(id = "view_response_5")
    public MobileElement vehicleTerrorism;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'no ha sufrido')]")
    @AndroidFindBy(id = "view_response_6")
    public MobileElement vehicleWasNotDamage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'TE AYUDAMOS')]")
    @AndroidFindBy(id = "tv_question_help")
    public MobileElement linkHelpYou;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    @AndroidFindBy(id = "view_response_1")
    public MobileElement withAVehicle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
    @AndroidFindBy(id = "view_response_2")
    public MobileElement morethanOneVehicle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]")
    @AndroidFindBy(id = "view_response_3")
    public MobileElement withAPersonAnimalOrObject;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[5]")
    @AndroidFindBy(id = "view_response_4")
    public MobileElement noContraries;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    @AndroidFindBy(id = "view_response_1")
    public MobileElement breakageOfPanes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
    @AndroidFindBy(id = "view_response_2")
    public MobileElement otherDamages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    @AndroidFindBy(id = "view_response_1")
    public MobileElement myVehicleWasStolen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
    @AndroidFindBy(id = "view_response_2")
    public MobileElement elementsFromMyVehicleWereStolen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    @AndroidFindBy(id = "view_response_1")
    public MobileElement myVehicleShowedUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
    @AndroidFindBy(id = "view_response_2")
    public MobileElement myVehicleNonShowedUp;

    //We are currently working to improve your experience
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='reportRedirectImage']")
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'iv_report_sso') or contains(@resource-id,'iv_report_callcenter')]")
    public MobileElement imageFromImprovingExperienceScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_report_continue_sso")
    public MobileElement continueButtonfromImprovingExperienceScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Elige el seguro') or contains(@name,'ha ocurrido')]")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Elige el seguro') or contains(@content-desc,'ha ocurrido')]")
    public MobileElement verifyTextWebviewGivePart;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
    @AndroidFindBy(id = "rv_identification_report_help")
    public MobileElement verifyTextHelpYou;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowBlue']")
    @AndroidFindBy(id = "rl_back")
    public MobileElement backArrowHelpYou;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name,'página')])[1]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement shownSSO;

    // Your policy does not cover this type of accident
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'no cubre')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'no cubre')]")
    public MobileElement notCoverThisAccident;


    // Your policy does not cover this type of accident
    @iOSXCUITFindBy(xpath = "//id")
    @AndroidFindBy(id = "tv_bodyText_callCenter")
    public MobileElement verifyHighPartHome;


}
