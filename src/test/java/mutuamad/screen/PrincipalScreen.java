package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.PrincipalScreenElements;

public class PrincipalScreen extends PrincipalScreenElements  {

    public PrincipalScreen(DriverManager driver) {
        super(driver);
    }


    public void closeStartingPopUp() {
        if(isPresent(StartingPopUp))
        {
            click(quitStartingPopUp);
        }
    }

    public boolean verifyViewFlipperTutorial() {
        return isEnabled(viewFlipperTutorial);
    }

    public void clickbuttonTutoQuit() {
        waitForClick(buttonTutoQuit, 120);
        click(buttonTutoQuit);
    }

    public void clickDealsForMe() {
        waitForClick(dealsForMe, 15);
        click(dealsForMe);
    }

    public void clickMyInsuranceLink() {
        waitForClick(myInsuranceLink, 15);
        click(myInsuranceLink);
    }

    public void clickbuttonTutoNext() {
        waitForClick(buttonTutoNext, 10);
        click(buttonTutoNext);
    }

    public void clickLinkNotificationCancel() {
        waitForClick(linkNotificationsCancel, 30);
        click(linkNotificationsCancel);
    }

    public void clickLinkMenu() {
        waitForClick(linkMenu, 10);
        click(linkMenu);
    }

    public void clickLinkOptionLoginMenu() {
        waitForClick(linkLoginOptionMenu, 10);
        click(linkLoginOptionMenu);
    }

    public void clickBack() {
        waitForClick(buttonBack, 10);
        click(buttonBack);
    }

    public void clickAdvantageLink() {
        waitForClick(advantageLink, 10);
        click(advantageLink);
    }

    public void clickFirstAdvantage() {
        waitForClick(firstAdvantage, 10);
        click(firstAdvantage);
    }

    public void clickSecondAdvantage() {
        waitForClick(secondAdvantage, 10);
        click(secondAdvantage);
    }
    public void clickRepsolAdvantage() {
        waitForClick(repsolAdvantage, 10);
        click(repsolAdvantage);
    }

    public boolean verificShowsMoreThanOne() {
        return isPresent(secondAdvantage);
    }

    public boolean verify_Repsol_Advantage_Is_Shown() {
        return isPresent(regalosAdvantage);
    }

    public void clickRegalosAdvantage() {
        waitForClick(regalosAdvantage, 10);
        click(regalosAdvantage);
    }
}
