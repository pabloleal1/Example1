package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.MySideOfTheStoryScreenElements;

public class MySideOfTheStoryScreen extends MySideOfTheStoryScreenElements {

    public MySideOfTheStoryScreen(DriverManager driver) {
        super(driver);
    }


    public void clickButtonContinue() {
        waitForVisible(buttonContinue, 21);
        click(buttonContinue);
    }

    public void setMySideOfStroyField(String MySideOfStory) {
        waitForVisible(mySideOfStroyField, 21);
        sendKeys(mySideOfStroyField, MySideOfStory);
    }

}
