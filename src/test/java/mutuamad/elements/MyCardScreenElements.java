package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MyCardScreenElements extends Screen {

    public MyCardScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeImage")
    @AndroidFindBy(id = "iv_card_detail_qrcode_with_europoints")
    public MobileElement qrCodeImage;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    @AndroidFindBy(id = "rl_card_data")
    public MobileElement qrCodeCardDataLink;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowBlue']")
    @AndroidFindBy(id = "rlClose")
    public MobileElement buttonClose;

}
