package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import mutuamad.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import mutuamad.elements.ImplicityScreenElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Ignore;

import java.util.HashMap;
import java.util.List;

public class ImplicityScreen extends ImplicityScreenElements {

    public ImplicityScreen(DriverManager driver) {
        super(driver);
    }

    public void clickiOSButtonOKKeyboard() {
        click(iOSButtonOKKeyboard);
    }

    //Details of involved
    public void clickGuiltyDropDownMenu() {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(guiltyDropDownMenu, 21);
            click(guiltyDropDownMenu);
            click(clickYesOption);
        }
        else
        {
            waitForVisible(guiltyDropDownMenu, 21);
            click(guiltyDropDownMenu);
            HashMap<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.05);
            params.put("element", typePickerWheel.getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            clickiOSButtonOKKeyboard();

        }
    }

    public void clickNoFriendlyReportDropDownMenu() {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(friendlyReportDropDownMenu, 21);
            click(friendlyReportDropDownMenu);
            click(clickNoOption);
        }
        else
        {
            waitForVisible(friendlyReportDropDownMenu, 21);
            click(friendlyReportDropDownMenu);
            HashMap<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.05);
            params.put("element", typePickerWheel.getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            driver.executeScript("mobile: selectPickerWheelValue", params);
            clickiOSButtonOKKeyboard();
        }
    }

    public void clickYesFriendlyReportDropDownMenu() {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(friendlyReportDropDownMenu, 21);
            click(friendlyReportDropDownMenu);
            click(clickYesOption);

        }
        else
        {
            waitForVisible(friendlyReportDropDownMenu, 21);
            click(friendlyReportDropDownMenu);
            HashMap<String, Object> params = new HashMap<>();
            params.put("order", "previous");
            params.put("element", typePickerWheel.getId());
            try{
                driver.executeScript("mobile: selectPickerWheelValue", params);
                driver.executeScript("mobile: selectPickerWheelValue", params);
            } catch (Exception x){ }

            clickiOSButtonOKKeyboard();
        }
    }

    public void clickAddFrontImage() {
        waitForVisible(addFrontImage, 21);
        click(addFrontImage);
    }

    public void clickAddPostImage() {
        waitForVisible(addPostImage, 21);
        click(addPostImage);
    }

    public void clickDeleteFrontImage() {
        waitForVisible(deleteFrontImage, 21);
        click(deleteFrontImage);
    }

    public void clickDeletePostImage() {
        waitForVisible(deletePostImage, 21);
        click(deletePostImage);
    }


    //Details of the opposite
    public void selectYesVehiclePlateOptionDropDownMenu(){
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(vehiclePlateOption, 21);
            click(vehiclePlateOption);
            click(clickYesOption);
        }
        else
        {
            waitForVisible(vehiclePlateOption, 21);
            click(vehiclePlateOption);
            clickiOSButtonOKKeyboard();
        }
    }

    public void selectNoVehiclePlateOptionDropDownMenu(){
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(vehiclePlateOption, 21);
            click(vehiclePlateOption);
            Utilities.sleep(2000);
            click(clickNoOption);
        }
        else
        {
            waitForVisible(vehiclePlateOption, 21);
            click(vehiclePlateOption);
            HashMap<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("element", typePickerWheel.getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            clickiOSButtonOKKeyboard();
        }
    }

    public void insertVehiclePlateText(String plate) {
        waitForVisible(vehiclePlatesField, 20);
        click(vehiclePlatesField);
        driver.getKeyboard();
    sendKeys(vehiclePlatesField, plate);
    }

    public void selectYesInsuranceOptionDropDownMenu(){
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(insuranceOptions, 21);
            click(insuranceOptions);
            click(clickYesOption);
        }
        else
        {
            waitForVisible(insuranceOptions, 21);
            click(insuranceOptions);
            clickiOSButtonOKKeyboard();
        }
    }

    public void selectNoInsuranceOptionDropDownMenu(){
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(insuranceOptions, 21);
            click(insuranceOptions);
            click(clickNoOption);
        }
        else
        {
            waitForVisible(insuranceOptions, 21);
            click(insuranceOptions);
            HashMap<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("element", typePickerWheel.getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            clickiOSButtonOKKeyboard();
        }
    }

    public void selectMutuaInsuranceDropDownMenu() {

        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForVisible(insuranceSelector, 21);
            click(insuranceSelector);
            Utilities.sleep(2000);
            click(clickDesconocidaOption);
        }
        else
        {
            waitForVisible(insuranceSelector, 21);
            click(insuranceSelector);
            HashMap<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("element", typePickerWheel.getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            clickiOSButtonOKKeyboard();
        }
    }

    public void clickbuttonContinue() {
        waitForVisible(buttonContinue, 21);
        click(buttonContinue);
    }





    //Robos

    public String verify_Yes_Option_Is_Shown_For_Vehicle_Closed(){
        return getText(vehicleClosed);
    }
    public void clickbuttonContinueRobo() {
        waitForVisible(btnContinuarRobo, 21);
        click(btnContinuarRobo);
    }


}
