package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.DrawScreenElements;
import org.openqa.selenium.Platform;

public class DrawScreen extends DrawScreenElements {

    public DrawScreen(DriverManager driver) {
        super(driver);
    }


    public void moreInfo() {
        waitForVisible(buttonMoreInfo, 21);
        click(buttonMoreInfo);
    }

    public void clickCheckConditions() {
        waitForVisible(checkConditions, 21);
        tapElementCoordinates(checkConditions);
    }

    public void clickNowParticipate() {
        waitForVisible(nowParticipateButton, 21);
        tapElementCoordinates(nowParticipateButton);
    }

    public void clickButtonBack() {
        waitForVisible(buttonBack, 21);
        click(buttonBack);
    }

    public boolean verifyAcceptConditionsIsShonw() {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX)){
            return (acceptConditionsText.getAttribute("checked").equals("false"));
        }
        else {
            return isPresent(acceptConditionsText);
        }
    }

    public boolean verifyShowMessageDraw() {
        return isPresent(verifyShowMessageDraw);
    }

}
