package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ConfigurationScreenElements extends Screen {

    public ConfigurationScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[2]")
    @AndroidFindBy(id = "swc_fingerprint")
    public MobileElement buttonFingerPrint;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[1]")
    @AndroidFindBy(id = "swc_notification")
    public MobileElement buttonNotifications;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='DATOS DE CONTACTO']/preceding-sibling::*[1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DATOS DE CONTACTO']")
    public MobileElement buttonContactData;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name,'Permitir') or starts-with(@name,'Allow')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    public MobileElement allowDevicePopup;

}
