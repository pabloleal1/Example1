package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CustomerSupportScreenElements extends Screen {

    public CustomerSupportScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name,'Permitir') or starts-with(@name,'Allow')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    public MobileElement buttonPopupAlertAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OFICINAS']")
    @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='OFICINAS']")
    public MobileElement tabOffices;



}
