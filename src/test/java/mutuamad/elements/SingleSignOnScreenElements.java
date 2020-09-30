package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SingleSignOnScreenElements extends Screen {

    public SingleSignOnScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[1])[1]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement textTitle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage/following-sibling::*)[1]")
    @AndroidFindBy(id = "tv_discount")
    public MobileElement textTitleDiscount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconClose']")
    @AndroidFindBy(id = "iv_close")
    public MobileElement buttonCloseSSO;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Parte del')]")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Parte del')]")
    public MobileElement viewPartsSSO;

}
