package mutuamad.elements;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Screen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CarWorkshopScreenElements extends Screen {

    public CarWorkshopScreenElements(DriverManager driver) {
        super(driver);
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Seleccionar']/preceding-sibling::*[1]")
    @AndroidFindBy(id = "spinner_vehicles")
    public MobileElement vehicleType;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Coche']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Coche']")
    public MobileElement optionCar;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Moto']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Moto']")
    public MobileElement optionBike;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
    @AndroidFindBy(id = "sc_enable_car_filters")
    public MobileElement enableCarFilters;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='filterWindscreenOff']")
    @AndroidFindBy(id = "tb_lunas")
    public MobileElement carLunasFilter;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='filterBodyworkOff']")
    @AndroidFindBy(id = "tb_carbody")
    public MobileElement carBodyFilter;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='filterWarrantyOff']")
    @AndroidFindBy(id = "tb_garantie")
    public MobileElement carGarantieFilter;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='¿Dónde?'])[1]/preceding-sibling::*[1]")
    @AndroidFindBy(id = "tv_where")
    public MobileElement locationSendAssistanceText;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Introduce la dirección']")
    @AndroidFindBy(id = "et_address")
    public MobileElement locationSendAssistanceAddress;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.mutua.mutua:id/item_address']")
    public MobileElement locationSendAssistanceAutoSuggest;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='VER LISTADO']")
    @AndroidFindBy(id = "tv_view_list")
    public MobileElement carWorkshopsListButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    public MobileElement firstCarWorkshopFromList;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='LOCALÍZAME']/following::*)[2]")
    @AndroidFindBy(id = "tv_number_garages_map")
    public MobileElement numberShops;

    @iOSXCUITFindBy(xpath = "//")
    @AndroidFindBy(id = "alertTitle")
    public MobileElement alertPopUp;

}
