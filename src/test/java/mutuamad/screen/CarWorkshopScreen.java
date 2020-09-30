package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.JsonParseData;
import mutuamad.elements.CarWorkshopScreenElements;

public class CarWorkshopScreen extends CarWorkshopScreenElements {

    public CarWorkshopScreen(DriverManager driver) {
        super(driver);
    }


    public boolean verifyAlertIsShown() {
        return isPresent(alertPopUp);
    }

    public void clickVehicleType() {
        waitForVisible(vehicleType, 10);
        click(vehicleType);
    }

    public void clickOptionCar() {
        waitForVisible(optionCar, 10);
        click(optionCar);
    }

    public void clickOptionBike() {
        waitForVisible(optionBike, 10);
        click(optionBike);
    }

    public void clickEnableCarFilters() {
        waitForVisible(enableCarFilters, 10);
        click(enableCarFilters);
    }

    public void clickCarLunasFilter() {
        waitForVisible(carLunasFilter, 10);
        click(carLunasFilter);
    }

    public void clickCarBodyFilter() {
        waitForVisible(carBodyFilter, 10);
        click(carBodyFilter);
    }

    public void clickCarGarantieFilter() {
        waitForVisible(carGarantieFilter, 10);
        click(carGarantieFilter);
    }

    public void clickLocationSendAssistanceText() {
        click(locationSendAssistanceText);
    }

    public void sendLocationSendAssistanceAddress() throws Exception {
        String address = JsonParseData.get("user", "addressAssistance");
        waitForVisible(locationSendAssistanceAddress, 5);
        sendKeys(locationSendAssistanceAddress, address);
    }

    public void selectLocationSendAssistanceAutoSuggest() {
        click(locationSendAssistanceAutoSuggest);
    }

    public void clickCarWorkshopsListButton() {
        click(carWorkshopsListButton);
    }

    public void clickFirstCarWorkshopFromList() {
        click(firstCarWorkshopFromList);
    }

    public String verify_Number_Of_Shops (){
        return getText(numberShops);
    }
}
