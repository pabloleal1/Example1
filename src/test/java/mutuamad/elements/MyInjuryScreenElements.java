package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MyInjuryScreenElements extends Screen {

    public MyInjuryScreenElements(DriverManager driver) {
        super(driver);
    }


    ///Motorbike Screen Damages
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][11]")
    @AndroidFindBy(id = "check31")
    public MobileElement motorBikeWheels;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][10]")
    @AndroidFindBy(id = "check28")
    public MobileElement motorBikeShockAbsorber;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][8]")
    @AndroidFindBy(id = "check15")
    public MobileElement motorHeadlightLeft;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][9]")
    @AndroidFindBy(id = "check14")
    public MobileElement motorHeadlightRight;

    //Car Screen damages
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][13]")
    @AndroidFindBy(id = "check39")
    public MobileElement carWheels;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][9]")
    @AndroidFindBy(id = "check35")
    public MobileElement carFeders;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][6]")
    @AndroidFindBy(id = "check34")
    public MobileElement carFeders2;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][8]")
    @AndroidFindBy(id = "check30")
    public MobileElement carHeadlightsRight;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][4]")
    @AndroidFindBy(id = "check28")
    public MobileElement carHeadlightsRight2;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][7]")
    @AndroidFindBy(id = "check36")
    public MobileElement carHeadlightsLeft;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][3]")
    @AndroidFindBy(id = "check38")
    public MobileElement carHeadlightsLeft2;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='damageEmpty'][2]")
    @AndroidFindBy(id = "check32")
    public MobileElement carWindow;

    //Commons buttons my injure screen
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    @AndroidFindBy(id = "btn_continue")
    public MobileElement buttonContinue;

    //Dialogue box screen
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[1]")
    @AndroidFindBy(id = "et_damage")
    public MobileElement myInjuryField;


}
