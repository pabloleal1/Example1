package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.MyInjuryScreenElements;

public class MyInjuryScreen extends MyInjuryScreenElements {

    public MyInjuryScreen(DriverManager driver) {
        super(driver);
    }


    public void clickMotorBikeWheels() {
        waitForVisible(motorBikeWheels, 21);
        click(motorBikeWheels);
    }

    public void clickMotorBikeShockAbsorber() {
        waitForVisible(motorBikeShockAbsorber, 21);
        click(motorBikeShockAbsorber);
    }

    public void clickMotorHeadlightLeft() {
        waitForVisible(motorHeadlightLeft, 21);
        click(motorHeadlightLeft);
    }

    public void clickMotorHeadlightRight() {
        waitForVisible(motorHeadlightRight, 21);
        click(motorHeadlightRight);
    }

    public void clickCarWheels() {
        waitForVisible(carWheels, 21);
        click(carWheels);
    }

    public void clickCarFeders() {
        waitForVisible(carFeders, 21);
        click(carFeders);
    }

    public void clickCarFeders2() {
        waitForVisible(carFeders2, 21);
        click(carFeders2);
    }

    public void clickCarHeadlightsRight() {
        waitForVisible(carHeadlightsRight, 21);
        click(carHeadlightsRight);
    }

    public void clickCarHeadlightsRight2() {
        waitForVisible(carHeadlightsRight2, 21);
        click(carHeadlightsRight2);
    }

    public void clickCarHeadlightsLeft() {
        waitForVisible(carHeadlightsLeft, 21);
        click(carHeadlightsLeft);
    }

    public void clickCarHeadlightsLeft2() {
        waitForVisible(carHeadlightsLeft2, 21);
        click(carHeadlightsLeft2);
    }

    public void clickCarWindow() {
        waitForVisible(carWindow, 21);
        click(carWindow);
    }

    public void insertOnTheMyInjuryFields(String MyInjury) {
        waitForVisible(myInjuryField, 21);
        sendKeys(myInjuryField, MyInjury);
    }

    public void clickButtonContinue() {
        waitForVisible(buttonContinue, 21);
        click(buttonContinue);
    }

    public String getTextFromMyInjuryField() {
        waitForVisible(myInjuryField,20);
        return getText(myInjuryField);
    }

}
