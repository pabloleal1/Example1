package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EmmeScreenElements extends Screen {

    public EmmeScreenElements(DriverManager driver) {
        super(driver);
    }


    ///Text field from Emme Screen and acept button. Close Emme Screen
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='shape']/preceding-sibling::*[1]")
    @AndroidFindBy(id = "etText")
    public MobileElement emmeField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='send icon']")
    @AndroidFindBy(id = "ibButtonRight")
    public MobileElement acceptEmmeFieldButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='img ico close']")
    @AndroidFindBy(id = "ivClose")
    public MobileElement closeEmmeScreen;
    ///////////////////////////////////////////////////

    // Accept that the ME record your voice
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeButton[@name='Permitir']")
    @AndroidFindBy(id = "//")
    public MobileElement acceptEmmeRecording;
    ///////////////////////////////////////////////////

    /// Burger Icon and Options from burgen Icon
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeButton")
    @AndroidFindBy(id = "lvBurgerAnimation")
    public MobileElement burgerIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.View")
    public MobileElement closeBurgerIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='ASISTENCIA']")
    @AndroidFindBy(id = "iv_asistencia")
    public MobileElement assistanceOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PARTES']")
    @AndroidFindBy(id = "iv_partes")
    public MobileElement accidentPartsOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TALLERES']")
    @AndroidFindBy(id = "iv_talleres")
    public MobileElement carCenterOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TARJETA SOY']")
    @AndroidFindBy(id = "iv_tarjetaSoy")
    public MobileElement cardSoyOption;

    /// Results Expected
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PEDIR GRÚA']")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]")
    public MobileElement assitanceExpected;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DAR PARTE']")
    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'partes de accidente:')])")
    public MobileElement partesExpected;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='Buscar taller'])")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.view.View[5]/android.widget.TextView")
    public MobileElement centersExpected;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='VER MI TARJETA']")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]")
    public MobileElement cardSoyExpected;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'OK') or contains(@name,'Permitir')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    public MobileElement OKDeviceRecorderPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeStaticText")
    @AndroidFindBy(id = "tvMessageUser")
    public MobileElement latestMessage;


    //Help Elements
    @iOSXCUITFindBy(id = "emeBigLogo")
    @AndroidFindBy(id = "ivHelp")
    public MobileElement emeIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='PREGUNTAR A EME']")
    @AndroidFindBy(id = "btnHelpChatbot")
    public MobileElement askEmeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='VER VÍDEO']")
    @AndroidFindBy(id = "btnHelpVideo")
    public MobileElement watchVideoEmeButton;

    @iOSXCUITFindBy(id = "WebView")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'control')]")
    public MobileElement playVideoEmeButton;

}
