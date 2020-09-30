package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MyInsuranceScreenElements extends Screen {

    public MyInsuranceScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "iv_icon_amazon")
    public MobileElement amazonLogo;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "tv_tab_title")
    public MobileElement secondInsurance;
    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView")
    public MobileElement nextInsurance;

}
