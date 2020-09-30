package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginScreenElements extends Screen {

    public LoginScreenElements(DriverManager driver) {
        super(driver);
    }


    //Login
    @iOSXCUITFindBy(id = "icoCloseWhite")
    @AndroidFindBy(id = "rlClose")
    public MobileElement iconClose;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'ciLoginId')]//android.widget.EditText")
    public MobileElement textLoginUsername;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'ciLoginPassword')]//android.widget.EditText")
    public MobileElement textPassword;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[2]")
    @AndroidFindBy(id = "btn_enter_login")
    public MobileElement btnLogin;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'OLVIDADO')]")
    @AndroidFindBy(id = "tv_lost_password")
    public MobileElement lostPassword;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "btn_init_after")
    public MobileElement iniciarSesioDespues;

    //Notifications
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='ACTIVAR NOTIFICACIONES']")
    @AndroidFindBy(id = "av_notification")
    public MobileElement notificationsLabel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='AHORA NO']")
    @AndroidFindBy(id = "tv_cancel")
    public MobileElement ahoraNoNotification;

    //Cuidamos de ti
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Cuidamos de ti')]")
    @AndroidFindBy(id = "av_insurance")
    public MobileElement weTakeCareOfYouTitleLabel;

    //Tarjeta
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Tarjeta SOY')]")
    @AndroidFindBy(id = "av_card")
    public MobileElement cardTitleLabel;

    /////////////////
    //Error Message//
    /////////////////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'válid')]")
    @AndroidFindBy(id = "tvCustomInputFieldError")
    public MobileElement errorMessageTittle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert//XCUIElementTypeButton")
    @AndroidFindBy(id = "button1")
    public MobileElement btnAceptar;

}
