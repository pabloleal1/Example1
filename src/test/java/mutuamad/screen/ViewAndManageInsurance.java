package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.ViewAndManageInsuranceElements;

public class ViewAndManageInsurance extends ViewAndManageInsuranceElements {

    public ViewAndManageInsurance(DriverManager driver) {
        super(driver);
    }


    public boolean verifyBannerGlobalisIsPresent(){
        return isPresent(bannerLogoGlobalis);
    }

    public void clickOnTheCoveragesLinkFromMyInsuranceScreen(){
        waitForClick(coveragesText,10);
        click(coveragesText);
    }

    public void clickButtonClose() {
        driver.navigate().back();
    }
}
