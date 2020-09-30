package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DrawScreenElements extends Screen {

    public DrawScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='backArrowBlue']")
    @AndroidFindBy(id = "rl_close")
    public MobileElement buttonBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='+ INFO']")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'INFO')]")
    public MobileElement buttonMoreInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'PARTICIPA')]")
    @AndroidFindBy(xpath = "//android.widget.Button[(@content-desc='¡PARTICIPA AHORA!')]")
    public MobileElement nowParticipateButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[1]")
    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    public MobileElement checkConditions;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'acepte las condiciones')]")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[@content-desc='He leído y acepto las condiciones del sorteo']")
    public MobileElement acceptConditionsText;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[contains(@name,'Image')])[1]")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='¡Compártelo con tus amigos!' or @content-desc='¡Ya estás participando!']")
    public MobileElement verifyShowMessageDraw;


}
