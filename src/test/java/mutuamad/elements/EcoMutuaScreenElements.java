package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;

public class EcoMutuaScreenElements extends Screen {

    public EcoMutuaScreenElements(DriverManager driver) {
        super(driver);
    }


    //////////////////
    //Policy selector/
    //////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TUS VEHÍCULOS']")
    @AndroidFindBy(id = "//")
    public MobileElement selectorTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]")
    @AndroidFindBy(id = "//")
    public MobileElement firstPolicy;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[last()]/XCUIElementTypeStaticText")
    @AndroidFindBy(id = "//")
    public MobileElement ecoSearchOthePlatePolicyList;


    ///////////////////////
    //License plate detail/
    ///////////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowBlue']")
    @AndroidFindBy(id = "//")
    public MobileElement buttonBack;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeImage[1]")
    @AndroidFindBy(id = "iv_eco_mutua_detail")
    public MobileElement ecoMutuaLogo;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "tv_eco_mutua_detail_title_policy")
    public MobileElement vehiclePlate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText/following-sibling::XCUIElementTypeStaticText[@name]")
    @AndroidFindBy(id = "tv_eco_mutua_detail_description_policy")
    public MobileElement vehicleType;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeImage[2]")
    @AndroidFindBy(id = "iv_eco_mutua_detail_policy")
    public MobileElement vehicleLogo;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]")
    @AndroidFindBy(id = "rl_eco_mutua_detail_info")
    public MobileElement ecoMutuaInfo;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[6]/XCUIElementTypeStaticText")
    @AndroidFindBy(id = "tv_detail_eco_mutua_link")
    public MobileElement ecoMoreInfoLink;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[7]/XCUIElementTypeButton")
    @AndroidFindBy(id = "btn_detail_eco_mutua")
    public MobileElement ecoSearchOthePlate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CALCULAR PRECIO']")
    @AndroidFindBy(id = "iv_detail_eco_mutua_banner")
    public MobileElement ecoMutuaBanner;

    /////////////////
    //Pop-up Fields//
    /////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "alertTitle")
    public MobileElement OtherPlatePopUpTittle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement OtherPlatePopUpField;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeAlert//XCUIElementTypeButton)[1]")
    @AndroidFindBy(id = "button2")
    public MobileElement OtherPlatePopUpBTNCancelar;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeAlert//XCUIElementTypeButton)[2]")
    @AndroidFindBy(id = "button1")
    public MobileElement OtherPlatePopUpBTNAceptar;

}
