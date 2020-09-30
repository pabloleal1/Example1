package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.MyCardScreenElements;

public class MyCardScreen extends MyCardScreenElements {

    public MyCardScreen(DriverManager driver) {
        super(driver);
    }


    public boolean isGRCodeImageVisible() {
        return isPresent(qrCodeImage);
    }

    public void clickqrCodeImage() {
        waitForVisible(qrCodeImage, 10);
        click(qrCodeImage);
    }

    public boolean verifyGRCodeImageVisible() {
        return isPresent(qrCodeCardDataLink);
    }

    public void clickButtonClose() {
        waitForVisible(buttonClose, 10);
        click(buttonClose);
    }

}
