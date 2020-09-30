package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AdvantageScreenElements extends Screen {

    public AdvantageScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Lo sentimos'][1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Lo sentimos')]")
    public MobileElement loSentimosScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconClose']")
    @AndroidFindBy(id = "iv_back")
    public MobileElement buttonClose;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowBlue']")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@resource-id, 'rl_close') or contains(@resource-id, 'rl_back')]")
    public MobileElement buttonBack;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='MIS EUROPUNTOS']")
    public MobileElement labelTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[1]")
    public MobileElement firstAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[7]")
    public MobileElement OcioAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[13]")
    public MobileElement travelAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[18]")
    public MobileElement lifeStyleAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[5]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[23]")
    public MobileElement onlineAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[6]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[28]")
    public MobileElement otherMutuaProductsAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[7]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[33]")
    public MobileElement servicesAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[8]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'lv_categories')]/descendant::*[38]")
    public MobileElement MonthsDrawAdvantage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'll_discount_row')][1]")
    public MobileElement firstDiscountInsideAdvantage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name,'Permitir') or starts-with(@name,'Allow')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    public MobileElement allowDeviceLocationPopup;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "ll_search_category_discount")
    public MobileElement searchField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "et_autocomplete_search")
    public MobileElement searchField2;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "tv_filter")
    public MobileElement searchField3;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    @AndroidFindBy(id = "ll_discount_row")
    public MobileElement firstResult;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='downExpandArrow']")
    @AndroidFindBy(id = "rl_more_info")
    public MobileElement moreInfo;
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeTable[@name='Empty list']")
    @AndroidFindBy(id = "tv_description_error_category")
    public MobileElement errorMessage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[last()]")
    @AndroidFindBy(id = "btn_type_action_1")
    public MobileElement buttonActionAdvantage;

    //Pop-UP from Advantages Screen
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[last()]")
    @AndroidFindBy(id = "dialog_container")
    public MobileElement popUpAdvantagesScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[last()]")
    @AndroidFindBy(id = "permission_allow_button")
    public MobileElement allowButtonFromPopUp;

    /////////////
    //Advantages//
    ////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[last()]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'tv_discount')])[1]")
    public MobileElement ecoMutuaPlateAdvantage;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'tv_discount')])[1]")
    public MobileElement choferItvAdvantage;

}
