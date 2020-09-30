package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PasswordLostScreenElements extends Screen {


    public PasswordLostScreenElements(DriverManager driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Permitir' or @name='Allow']")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    public MobileElement allowDeviceSMSPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='RECUPERAR CONTRASEÑA']")
    @AndroidFindBy(id = "tvTitleBlueToolbar")
    public MobileElement headTitle;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
    @AndroidFindBy(id = "etCustomInputField")
    public MobileElement NifNumber; //inputDocumento
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'CONTINUAR')]")
    @AndroidFindBy(id = "btnContinueEnrollment")
    public MobileElement buttonContinuar;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'CONTINUAR')]")
    @AndroidFindBy(id = "btnContinuePhone")
    public MobileElement buttonContinuePhone;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSwitch)[1]")
    @AndroidFindBy(id = "scAgreeEnrollmentTerms")
    public MobileElement checkConditions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='condiciones legales']")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'condiciones legales') or contains(@text,'condiciones legales')]")
    public MobileElement linkConditions;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='politica de protección de datos']")
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'politica de protección de datos') or contains(@text,'politica de protección de datos')]")
    public MobileElement linkProtection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='icoMobileHigh']")
    @AndroidFindBy(id = "llPhoneNumber")
    public MobileElement verifyTelephoneNumber;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'ESTE NO ES')]")
    @AndroidFindBy(id ="tvEnrollmentPhoneNotMyNumber")
    public MobileElement sendCodeAnotherTelephone;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id, 'ciEditPhoneNumber')]//android.widget.EditText")
    public MobileElement telephoneNumber;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'AYUDA')]")
    @AndroidFindBy(id ="tvEnrollmentPhoneHelp")
    public MobileElement linkPhoneHelp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'AYUDA')]")
    @AndroidFindBy(id ="com.android.dialer:id/digits")//android.widget.EditText
    public MobileElement textCallPhoneNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='icoMobile']")
    @AndroidFindBy(id ="enrollmentOtpCodeInput")
    public MobileElement verifyEnrollmentOtpCodeInput;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'válido')])[1]")
    @AndroidFindBy(id = "tvCustomInputFieldError")
    public MobileElement errorDataTextError;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='imgKO']")
    @AndroidFindBy(id = "tvKoInfoTitle")
    public MobileElement errorDataTextErrors;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'por tu seguridad')]")
    @AndroidFindBy(id = "tvSecurityInfotitle")
    public MobileElement textSecurityQuestions;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icoBackWhite']")
    @AndroidFindBy(id = "rlBackBlueToolbar")
    public MobileElement buttonBack;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icoCloseWhite']")
    @AndroidFindBy(id = "iv_close")
    public MobileElement buttonCerrar;

}
