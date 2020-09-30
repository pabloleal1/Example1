package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MailBoxScreenElements extends Screen {

    public MailBoxScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[3]/XCUIElementTypeButton[1])[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'TODOS')])")
    public MobileElement totalMailText;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "rl_settings")
    public MobileElement buttonSettings;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "search_src_text")
    public MobileElement searchInput;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "search_close_btn")
    public MobileElement searchClose;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell[1])[1]")
    @AndroidFindBy(id = "ll_mail_item")
    public MobileElement firstBoxMailBox;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable)[1]")
    @AndroidFindBy(id = "rv_mailbox")
    public MobileElement boxMailBox;

    //Tabs
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'TODOS')]")
    @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='NO LEÍDO']")
    public MobileElement tabAllMessages;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'NO LEÍDO')]")
    @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='NO LEÍDO']")
    public MobileElement tabnotRead;

    //List Msjs
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell[1])[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'll_mail_item')]")
    public MobileElement boxRowMail;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='pinkDot'][1]")
    @AndroidFindBy(id = "iv_read_mail")
    public MobileElement iconMailRead;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'iv_mail_type')]")
    public MobileElement imageMail; //imagen
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText)[4]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'tv_mail_date')]")
    public MobileElement labelDateMail;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText)[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'tv_mail_title')]")
    public MobileElement labelTittleMail;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/XCUIElementTypeStaticText)[3]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'tv_mail_subtitle')]")
    public MobileElement labelSubtittleMail;

    //Cross Sell: Propensity and Pregranted
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "pv_propensity_mailbox")
    public MobileElement boxPropensity;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_propensity_title")
    public MobileElement labelPropensityTitle;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_propensity_description")
    public MobileElement labelPropensityDescription;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_propensity_action")
    public MobileElement labelPropensityAction;

    //Detail Msj
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowWhite']/following-sibling::*")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement labelTitleDetail;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]//XCUIElementTypeImage")
    @AndroidFindBy(id = "iv_mail_detail_type")
    public MobileElement labelDetailImage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[4]")
    @AndroidFindBy(id = "tv_mail_detail_date")
    public MobileElement labelDetailDate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "tv_mail_detail_title")
    public MobileElement labelDetailTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]")
    @AndroidFindBy(id = "tv_mail_detail_subtitle")
    public MobileElement labelDetailSubtitleText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    @AndroidFindBy(id = "tv_mail_text")
    public MobileElement labelDetailText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeButton")
    @AndroidFindBy(id = "btn_mail_primary_button")
    public MobileElement buttonDetailMail;

    //Part
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_title_policy")
    public MobileElement partTitlePolicyText;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "ll_icon")
    public MobileElement partIcon;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_state_details_report")
    public MobileElement partDetailText;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "rv_detail_report_tracing")
    public MobileElement partHistory;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "btn_more_info_detail_report")
    public MobileElement partButtonMoreInfo;



}
