package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RegalosScreenElements extends Screen {

    public RegalosScreenElements(DriverManager driver) {
        super(driver);
    }


    //Ventaja
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement titulo_Ventaja;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "btn_type_action_1")
    public MobileElement btn_Ventaja;

    //Regalos - Mis seguros
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "rl_global_position_gift")
    public MobileElement cintillo;

}
