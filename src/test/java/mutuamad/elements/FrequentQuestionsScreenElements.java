package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FrequentQuestionsScreenElements extends Screen {

    public FrequentQuestionsScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='\uF002']/following::*[1]")
    @AndroidFindBy(xpath = "//android.widget.EditText")
    public MobileElement editTextQuestion;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'container')]//android.webkit.WebView/*[3]")
    public MobileElement firstQuestionText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'container')]//android.webkit.WebView/*[4]")
    public MobileElement secondQuestionText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[3]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'container')]//android.webkit.WebView/*[5]")
    public MobileElement thirdQuestionText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[4]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, 'container')]//android.webkit.WebView/*[6]")
    public MobileElement fourthQuestionText;



}
