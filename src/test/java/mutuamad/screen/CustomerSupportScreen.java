package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.CustomerSupportScreenElements;

public class CustomerSupportScreen extends CustomerSupportScreenElements {

    public CustomerSupportScreen(DriverManager driver) {
        super(driver);
    }


    public void clickButtonPopupAlertAllow() {
        try
        {
            waitForClick(buttonPopupAlertAllow, 30);
            click(buttonPopupAlertAllow);
        } catch (Exception ex) {}
    }

    public void goToTabOffice() {
        click(tabOffices);
    }

    public void doScrollDown() {
        scrollDown();
    }

}
