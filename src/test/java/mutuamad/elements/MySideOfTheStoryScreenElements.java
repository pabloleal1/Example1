package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MySideOfTheStoryScreenElements extends Screen {

    public MySideOfTheStoryScreenElements(DriverManager driver) {
        super(driver);
    }


    ///Common button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_continue")
    public MobileElement buttonContinue;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[1]")
    @AndroidFindBy(id = "et_finalString")
    public MobileElement mySideOfStroyField;

}
