package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.ConfigurationScreenElements;

public class ConfigurationScreen extends ConfigurationScreenElements {

    public ConfigurationScreen(DriverManager driver) {
        super(driver);
    }


    public boolean isEnabledFirngerPrint() {
        return isEnabled(buttonFingerPrint);
    }

    public void clickButtonFingerPrint() {
        click(buttonFingerPrint);
    }

    public boolean isEnabledNotifications() {
        return isEnabled(buttonNotifications);
    }

    public void clickButtonNotifications() {
        click(buttonNotifications);
    }

    public void clickButtonContactData() {
        waitForClick(buttonContactData, 21);
        click(buttonContactData);
    }

    public boolean verifyButtonContactDataFromSettingScreenIsShown() {
        return isPresent(buttonContactData);
    }

    public void clickAllowDeviceLocationPopup() {
        try
        {
            click(allowDevicePopup);
        }
        catch (Exception e) { }
    }
}
