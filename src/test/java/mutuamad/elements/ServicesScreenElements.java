package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ServicesScreenElements extends Screen {

    public ServicesScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "rl_close")
    public MobileElement buttonBack;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]/android.widget.Button")
    public MobileElement buttonMoreInfo;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[4]/android.view.View/android.view.View[2]/android.widget.Button")
    public MobileElement nowParticipateButton;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "conditions")
    public MobileElement checkConditions;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "//*[contains(@text, 'acepte')]")
    public MobileElement acceptConditionsText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Additional security check') or contains(@name, 'Access Denied')]")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='No soy un robot']")
    public MobileElement captchaCheck;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "rl_close")
    public MobileElement captchaClose;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "button1")
    public MobileElement continueButtonfromPopUpForgotPass;


}
