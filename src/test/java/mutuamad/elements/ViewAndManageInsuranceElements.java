package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ViewAndManageInsuranceElements extends Screen {

    public ViewAndManageInsuranceElements(DriverManager driver) {
        super(driver);
    }


    //Back button from view and manage screen
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "rl_close")
    public MobileElement backButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[5]")
    @AndroidFindBy(id = "include_globalis_layout")
    public MobileElement bannerLogoGlobalis;

    //SectionsButtons
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_coverages_header")
    public MobileElement coveragesText;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_people_header")
    public MobileElement peopleText;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_manage_info_header")
    public MobileElement CarMotorBikeText;

}
