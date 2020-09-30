package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GenericScreenElement extends Screen {

    public GenericScreenElement(DriverManager driver) {
        super(driver);
    }


    //Google play services pop up
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "alertTitle")
    public MobileElement googlePlayServices;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "button1")
    public MobileElement updateButton;
    ///End Google play Services///

}
