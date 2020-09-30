package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import io.appium.java_client.MobileElement;
import mutuamad.Utilities;
import mutuamad.elements.AdvantageScreenElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;

public class AdvantageScreen extends AdvantageScreenElements {

    public AdvantageScreen(DriverManager driver) {
        super(driver);
    }


    public String getTextTitleAdvantage() {
        waitForVisible(labelTitle, 20);
        return labelTitle.getText();
    }

    public void clickButtonClose() {
        waitForVisible(buttonClose, 10);
        click(buttonClose);
    }

    public void clickMonthsDrawAdvantage() {
        waitForVisible(MonthsDrawAdvantage, 10);
        click(MonthsDrawAdvantage);
    }

    public void clickOcioAdvantage() {
        waitForVisible(OcioAdvantage, 10);
        click(OcioAdvantage);
    }

    public void clickTravelAdvantage() {
        waitForVisible(travelAdvantage, 10);
        click(travelAdvantage);
    }

    public void clickLifeStyleAdvantage() {
        waitForVisible(lifeStyleAdvantage, 10);
        click(lifeStyleAdvantage);
    }

    public void clickOnlineAdvantage() {
        waitForVisible(onlineAdvantage, 10);
        click(onlineAdvantage);
    }

    public void clickOtherMutuaProductsAdvantage() {
        waitForVisible(otherMutuaProductsAdvantage, 10);
        click(otherMutuaProductsAdvantage);
    }

    public void clickservicesAdvantage() {
        waitForVisible(servicesAdvantage, 10);
        click(servicesAdvantage);
    }

    public void clickButtonBack() {
        try
        {
            waitForVisible(buttonBack, 10);
            click(buttonBack);
        }
        catch (Exception e)
        {
            driver.navigate().back();
        }
    }

    public void clickFirstAdvantage() {
        waitForVisible(firstAdvantage, 10);
        click(firstAdvantage);
    }

    public void clickFirstDiscountInsideAdvantage() {
        waitForVisible(firstDiscountInsideAdvantage, 10);
        click(firstDiscountInsideAdvantage);
    }

    public void clickAllowDeviceLocationPopup() {
        try
        {
            click(allowDeviceLocationPopup);
        }
        catch (Exception ignored) { }
    }

    public void searchAdvantage(String KeyWord) {
        if(isPresent(searchField))
        {
            click(searchField);
        }
        if(isPresent(searchField3))
        {
            click(searchField3);
        }
        sendKeys(searchField2, KeyWord);
        try
        {
            if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
            {
                tapElementNextTo(searchField2);
                click((MobileElement) driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'tv_description') and contains(@text,'"+KeyWord+"')]")));
            }
            else
            {
                click((MobileElement) driver.findElement(By.xpath("//XCUIElementTypeCell[1]")));
                click((MobileElement) driver.findElement(By.xpath("(//XCUIElementTypeCell//XCUIElementTypeStaticText[contains(@name,'"+KeyWord+"')])[1]")));
            }
        }
        catch (Exception ex){}

    }

    public void clickFirstResult() {
        if(isPresent(firstResult))
        {
            click(firstResult);
        }
    }

    public boolean veriFirstResultIsShown() {
        return isPresent(firstResult);
    }

    public void clickMoreInfo() {
        waitForVisible(moreInfo, 10);
        click(moreInfo);
    }

    public void verifyErrorMessageIsShown() {
        waitForVisible(errorMessage, 10);
        isPresent(errorMessage);
    }

    public void clickActionAdvantage() {
        waitForVisible(buttonActionAdvantage, 10);
        click(buttonActionAdvantage);
    }

    public boolean verifyLoSentimosScreenisShown() {
        return isPresent(loSentimosScreen);
    }

    public void selectEcoMutuaPlateAdvantage(){
        waitForVisible(ecoMutuaPlateAdvantage, 10);
        click(ecoMutuaPlateAdvantage);
    }

    public boolean verifyEcoMutuaPlateAdvantageIsShown(){
        return isPresent(ecoMutuaPlateAdvantage);
    }

    public boolean verifyChoferItvIsShown() {
        return isPresent(choferItvAdvantage);
    }
    public void clickChoferAdvantage() {
        waitForVisible(choferItvAdvantage, 10);
        click(choferItvAdvantage);
    }

}
