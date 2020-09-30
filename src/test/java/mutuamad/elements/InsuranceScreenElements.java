package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;

public class InsuranceScreenElements extends Screen {

    public InsuranceScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//o")
    @AndroidFindBy(id = "tv_show_manage")
    public MobileElement buttonViewInsuranceDetails;

    ///////////////////////////////////////////////
    //My Insurance Screen (Main Insurance Screen)//
    ///////////////////////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains (@name,'imgInsurance')]/preceding-sibling::*")
    @AndroidFindBy(id = "tv_title_policy")
    public MobileElement textTitleDetailsInsurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='car'])[2]/preceding-sibling::*")
    @AndroidFindBy(id = "tv_tab_title")
    public MobileElement buttonSecondInsurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]")
    public MobileElement nextInsurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@resource-id, 'rl_tabs')]//android.widget.LinearLayout[3]")
    public MobileElement nextMoreInsurance;

    @iOSXCUITFindBy(xpath = "//o")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView")
    public MobileElement nextInsuranceFromInsuranceScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VER Y GESTIONAR MI PÓLIZA'][1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'VER Y GESTIONAR MI PÓLIZA')]")
    public MobileElement linkOptionSeeAndManageMyPolicy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DAR Y GESTIONAR PARTES'][1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'DAR Y GESTIONAR PARTES')]")
    public MobileElement linkOptionGetAndGestionParts;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VER RECIBOS'][1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'VER RECIBOS')]")
    public MobileElement linkOptionSeeReceipts;
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////
    //Informacion _Y gestion de la poliza (GENERAL)//
    ////////////////////////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]")
    @AndroidFindBy(id = "iv_icon_amazon")
    public MobileElement amazonLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COBERTURAS']")
    @AndroidFindBy(id = "ll_coverages_container")
    public MobileElement buttonOptionsDetailsCoverage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PERSONAS']")
    @AndroidFindBy(id = "ll_people_container")
    public MobileElement buttonOptionsDetailsPeople;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='COCHE']")
    @AndroidFindBy(id = "ll_manage_info_container")
    public MobileElement buttonOptionsDetailsManage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowWhite']")
    @AndroidFindBy(id = "rlClose")//android.widget.RelativeLayout
    public MobileElement buttonBack;
    ///////////////////////////////////////////////////////////////////

    ///////////////////////////////
    ///Gestiones Mas Frecuentes///
    //////////////////////////////

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GESTIONES MÁS FRECUENTES']")
    @AndroidFindBy(id = "tv_frequently_manages")
    public MobileElement buttonFrecuencyManages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Modificar cuenta bancaria']")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[1]")
    public MobileElement optionFrecuencyModifyBankAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Añadir o modificar coberturas']")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]")
    public MobileElement optionFrecuencyAddModifyCoverages;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Reportar accesorios']")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[3]")
    public MobileElement optionFrecuencyNewAccessories;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ceder póliza']")
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[4]")
    public MobileElement optionTransferInsurancePolicy;
    ///////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////
    //Informacion _Y gestion de la poliza (Personas)//
    //////////////////////////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TOMADOR DEL SEGURO']")
    @AndroidFindBy(xpath = "//android.widget.ExpandableListView[@resource-id='com.mutua.mutua:id/elv_explandableList']/android.widget.RelativeLayout[1]")
    public MobileElement buttonPeopleInsuranceOwner;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONDUCTOR HABITUAL DEL VEHÍCULO']")
    @AndroidFindBy(xpath = "//android.widget.ExpandableListView[@resource-id='com.mutua.mutua:id/elv_explandableList']/android.widget.RelativeLayout[2]")
    public MobileElement buttonPeopleInsuranceDriver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PROPIETARIO DEL VEHÍCULO']")
    @AndroidFindBy(xpath = "//android.widget.ExpandableListView[@resource-id='com.mutua.mutua:id/elv_explandableList']/android.widget.RelativeLayout[3]")
    public MobileElement buttonPeopleInsuranceCarOwner;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MODIFICAR CONDUCTOR HABITUAL']")
    @AndroidFindBy(id = "btn_modify_info")
    public MobileElement buttonModifyDriver;
    ///////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////
    //////////////DATOS DEL TOMADOR///////////////////
    //////////////////////////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[10]/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_person_street')]//android.widget.EditText")
    public MobileElement editPersonStreet;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[11]/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_person_postal_code')]//android.widget.EditText")
    public MobileElement editPersonCP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PROVINCIA']/following-sibling::*[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_person_city')]//android.widget.EditText")
    public MobileElement editPersonCity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PROVINCIA']/following-sibling::*[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_person_province')]//android.widget.EditText")
    public MobileElement editPersonProvince;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TELÉFONO']/following-sibling::*[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_person_phone_number')]//android.widget.EditText")
    public MobileElement editPersonPhoneNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TELÉFONO MÓVIL']/following-sibling::*[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_person_mobile_number')]//android.widget.EditText")
    public MobileElement editPersonMobileNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='EMAIL']/following-sibling::*[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'et_person_email')]//android.widget.EditText")
    public MobileElement editPersonEmail;
    ////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////
    //////////////Dar y Gestionar Partes ////////////
    /////////////////////////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'cl_state_report')][1]")
    public MobileElement firstPartsInList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable")
    @AndroidFindBy(id = "ll_evolution_report")
    public MobileElement textEvolutionReport;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeButton")
    @AndroidFindBy(id = "rv_detail_report_tracing")
    public MobileElement textDetailReportTracing;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MÁS INFORMACIÓN DEL PARTE']")
    @AndroidFindBy(id = "btn_more_info_detail_report")
    public MobileElement buttonMoreInfoDetailReport;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "tv_bodyText_callCenter")
    public MobileElement textCallCenter;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[1]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement textTitlePayment;
    ////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////
    //////////////Coche desde Informacion y gestion de la poliza ////////////
    /////////////////////////////////////////////////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MODIFICAR DATOS COCHE']")
    @AndroidFindBy(id = "btn_first_button")
    public MobileElement buttonEditData;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='REPORTAR ACCESORIOS']")
    @AndroidFindBy(id = "btn_second_button")
    public MobileElement buttonAccessories;
    ////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////
    //////////////Coberturas desde Informacion y gestion de la poliza ///////
    /////////////////////////////////////////////////////////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='AÑADIR O MODIFICAR COBERTURAS']")
    @AndroidFindBy(id = "btn_coverage")
    public MobileElement buttonEditCoverageData;
    ////////////////////////////////////////////////////////////////

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MODIFICAR DATOS TOMADOR']")
    @AndroidFindBy(id = "btn_modify_info")
    public MobileElement buttonModifyInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='MODIFICAR PROPIETARIO']")
    @AndroidFindBy(id = "btn_modify_info")
    public MobileElement buttonModifyCarOwner;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GUARDAR CAMBIOS']")
    @AndroidFindBy(id = "btn_modify_info")
    public MobileElement buttonSaveData;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconClose']")
    @AndroidFindBy(id = "rl_close")
    public MobileElement buttonClose;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='GUARDAR']")
    @AndroidFindBy(id = "btn_first_button_edit_bank_account")
    public MobileElement buttonEditBankAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "message")
    public MobileElement textSaveDates;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeButton")
    @AndroidFindBy(id = "button2")
    public MobileElement buttonAccept;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='editTextClear']")
    @AndroidFindBy(id = "iv_custom_textinputlayout_clear")
    public MobileElement iconclearText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton[1]")
    @AndroidFindBy(id = "ivEditBankAccount")
    public MobileElement modifyBankAccountLink;

    @iOSXCUITFindBy(xpath = "//o")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'll_option_button')]")
    public By OptionsDetailInsurance;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id, 'll_item')])[1]")
    public MobileElement viewFirstPayment;

}


