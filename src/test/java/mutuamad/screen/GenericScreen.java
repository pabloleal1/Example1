package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import io.appium.java_client.MobileElement;
import mutuamad.elements.GenericScreenElement;

public class GenericScreen extends GenericScreenElement {

    public GenericScreen(DriverManager driver) {
        super(driver);
    }


    //POP UP GOOGLE PLAY SERVICES//
    public boolean verifyPopUpIsShown() {
        waitForVisible(googlePlayServices, 10);
        return isPresent(googlePlayServices);
    }

    public void clickUpdateButton() {
        waitForClick(updateButton, 10);
        click(updateButton);
    }
    //END POP UP GOOGLE SERVICES//

}
