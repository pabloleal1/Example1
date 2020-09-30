package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class PrincipalScreenElements extends Screen  {

    public PrincipalScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(id = "//")
    @AndroidFindBy(id = "message")
    public MobileElement StartingPopUp;

    @iOSXCUITFindBy(id = "//")
    @AndroidFindBy(id = "button2")
    public MobileElement quitStartingPopUp;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='nextImage'])[1]")
    @AndroidFindBy(id = "av_logo")
    public MobileElement viewFlipperTutorial;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SALTAR']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='SALTAR']")
    public MobileElement buttonTutoQuit;

    @iOSXCUITFindBy(id = "//")
    @AndroidFindBy(id = "buttonNext")
    public MobileElement buttonTutoNext;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='AHORA NO']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NO, GRACIAS']")
    public MobileElement linkNotificationsCancel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='menu']")
    @AndroidFindBy(id = "rl_home")
    public MobileElement linkMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='INICIAR SESIÓN']")
    @AndroidFindBy(id = "ll_login")
    public MobileElement linkLoginOptionMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowWhite']")
    @AndroidFindBy(id = "rlClose")
    public MobileElement buttonBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Mis ventajas']")
    @AndroidFindBy(id = "title_discounts")
    public MobileElement advantageLink;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[1]/preceding-sibling::*")
    @AndroidFindBy(id = "tv_number_policies")
    public MobileElement myInsuranceLink;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeButton[2]")
    @AndroidFindBy(id = "tv_show_all_discounts")
    public MobileElement dealsForMe;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'll_row_recyclerview_discount')][1]")
    public MobileElement firstAdvantage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'll_row_recyclerview_discount')][2]")
    public MobileElement secondAdvantage;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tienes acumulado en carburante']")
    public MobileElement repsolAdvantage;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='El plazo de tus seguros sin coste']")
    public MobileElement regalosAdvantage;

}
