package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.EcoMutuaScreenElements;

public class EcoMutuaScreen extends EcoMutuaScreenElements {

    public EcoMutuaScreen(DriverManager driver) {
        super(driver);
    }

    //////////////////
    //Policy selector/
    //////////////////

    public boolean verifySelectorTitlePresents(){ return isEnabled(selectorTitle); }

    public void clickFirstPolicy(){
        waitForVisible(firstPolicy, 10);
        click(firstPolicy);
    }

    ///////////////////////
    //License plate detail/
    ///////////////////////

    public void clickButtonBack(){
        waitForVisible(buttonBack, 10);
        click(buttonBack);
    }

    public boolean verifyEcoMutuaLogoPresents(){
        scrollUp();
        return isEnabled(ecoMutuaLogo);
    }

    public boolean verifyVehiclePlatePresents(){
        return isPresent(vehiclePlate);
    }

    public boolean verifyVehicleTypeLogoPresents(){
        return isEnabled(vehicleType);
    }

    public boolean verifyVehicleLogoPresents(){
        return isEnabled(vehicleLogo);
    }

    public boolean verifyEcoMutuaInfoPresents(){
        return isPresent(ecoMutuaInfo);
    }

    public boolean verifyEcoMoreInfoLinkPresents(){
        return isPresent(ecoMoreInfoLink);
    }

    public boolean verifySearchAnotherPlateBtn(){
        scrollDown();
        return isPresent(ecoSearchOthePlate);
    }

    public void clickSearchAnotherPlateBtn(){
        scrollDown();
        waitForVisible(ecoSearchOthePlate, 10);
        click(ecoSearchOthePlate);
    }

    public void clickSearchAnotherPlatePolicyListing(){
        scrollDown();
        waitForVisible(ecoSearchOthePlatePolicyList, 10);
        click(ecoSearchOthePlatePolicyList);
    }

    public boolean verifyEcoMutuaBannerISShown(){
        scrollDown();
        return isPresent(ecoMutuaBanner);
    }

    //////////////////
    //Pop-up Methods//
    //////////////////

    public void insertAnotherPlate(String vehiclePlate) {
        if (isPresent(OtherPlatePopUpField))
        {
            click(OtherPlatePopUpField);
        }
        sendKeys(OtherPlatePopUpField, vehiclePlate);
    }

    public void clickAcpetarBtnPopUP(){
        waitForVisible(OtherPlatePopUpBTNAceptar, 10);
        click(OtherPlatePopUpBTNAceptar);
    }

}
