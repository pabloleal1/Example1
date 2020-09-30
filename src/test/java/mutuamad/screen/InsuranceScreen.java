package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import io.appium.java_client.MobileElement;
import mutuamad.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import mutuamad.elements.InsuranceScreenElements;

public class InsuranceScreen extends InsuranceScreenElements {

    public InsuranceScreen(DriverManager driver) {
        super(driver);
    }


    public void clickButtonViewInsuranceDetails() {
        waitForClick(linkOptionSeeAndManageMyPolicy, 30);
        click(linkOptionSeeAndManageMyPolicy);
    }

    public void clickButtonGiveAndManageParts() {
        waitForClick(linkOptionGetAndGestionParts, 30);
        click(linkOptionGetAndGestionParts);
    }

    public boolean verifyShowGetAndGestionParts() {
        return isPresent(linkOptionGetAndGestionParts);
    }

    public void clickSelectFisrtPartinGiveAndManageParts() {
        //waitForClick(firstPartsInList, 30);
        click(firstPartsInList);
    }

    public void clickModifyBankAccount() {
        waitForClick(modifyBankAccountLink, 30);
        click(modifyBankAccountLink);
    }

    public void clickButtonOptionDetailsCoverage() {
        waitForClick(buttonOptionsDetailsCoverage, 30);
        click(buttonOptionsDetailsCoverage);
    }

    public void clickButtonSecondInsurance() {
        waitForClick(buttonSecondInsurance, 30);
        click(buttonSecondInsurance);
    }

    public void clickButtonOptionDetailsPeople() {
        waitForClick(buttonOptionsDetailsPeople, 30);
        click(buttonOptionsDetailsPeople);
    }

    public void clickButtonOptionDetailsPeopleLive(Integer searchInsurance) {
        if(driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            waitForClick(buttonOptionsDetailsPeople, 30);
            click(buttonOptionsDetailsPeople);
        }
        else
        {
            waitForClick((MobileElement) driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='VER Y GESTIONAR MI PÓLIZA'])["+searchInsurance+"]")), 10);
            click((MobileElement) driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='VER Y GESTIONAR MI PÓLIZA'])["+searchInsurance+"]")));
        }
    }

    public void clickButtonOptionDetailsManage() {
        waitForClick(buttonOptionsDetailsManage, 30);
        click(buttonOptionsDetailsManage);
    }

    public boolean verifyShowOptionsDetailsManage(){
        return isPresent(buttonOptionsDetailsManage);
    }

    public void clickButtonPeopleInsuranceOwner() {
        waitForClick(buttonPeopleInsuranceOwner, 30);
        click(buttonPeopleInsuranceOwner);
    }

    public void clickButtonbuttonPeopleInsuranceDriver() {
        waitForClick(buttonPeopleInsuranceDriver, 30);
        click(buttonPeopleInsuranceDriver);
    }

    public void clickbuttonPeopleInsuranceCarOwner() {
        waitForClick(buttonPeopleInsuranceCarOwner, 30);
        click(buttonPeopleInsuranceCarOwner);
    }

    public boolean verifyShowPeopleInsuranceCarOwner(){
        return isPresent(buttonPeopleInsuranceCarOwner);
    }

    public void clickButtonEditData() {
        click(buttonEditData);
    }

    public void clickButtonEditCoverageData() {
        click(buttonEditCoverageData);
    }

    public void clicButtonSaveData(){
        click(buttonSaveData);
    }

    public void clickButtonModifyDriver() {
        click(buttonModifyDriver);
    }

    public void clickButtonModifyCarOwner() {
        click(buttonModifyCarOwner);
    }

    public void clickButtonModifyInfo() {
        click(buttonModifyInfo);
    }

    public boolean checkButtonModifyInfo() {
        return isEnabled(buttonModifyInfo);
    }

    public void clickButtonAccessories() {
        click(buttonAccessories);
    }

    public void clickButtonFrecuencyManages() {
        click(buttonFrecuencyManages);
    }


    public void clickOptionFrecuencyAddModifyCoverages() {
        click(optionFrecuencyAddModifyCoverages);
    }

    public void clickOptionFrecuencyNewAccessories() {
        click(optionFrecuencyNewAccessories);
    }

    public void clickOptionFrecuencyModifyBankAccount() {
        click(optionFrecuencyModifyBankAccount);
    }

    public void clickOptionTransferInsurancePolicy() {
        click(optionTransferInsurancePolicy);
    }

    public void clickButtonClose() {
        click(buttonClose);
    }

    public void clickButtonBack() {
        click(buttonBack);
    }

    public void clickButtonEditBankAccount() {
        click(buttonEditBankAccount);
    }

    public void clickButtonViewPayments() {
        waitForClick(linkOptionSeeReceipts, 30);
        click(linkOptionSeeReceipts);
    }

    public void clickViewFirstPayment() {
        try
        {
            waitForClick(viewFirstPayment,10);
            click(viewFirstPayment);
        }
        catch (Exception e)
        {
            System.out.println(">> WARNING << This user has not any payments");
        }
    }

    public boolean verificTextEvolutionReport(){
      return isPresent(textEvolutionReport);
    }

    public boolean verificTextDetailReportTracing(){
        return isPresent(textDetailReportTracing);
    }

    public void clickButtonMoreInfoDetailReport() {
        waitForClick(buttonMoreInfoDetailReport, 10);
        click(buttonMoreInfoDetailReport);
    }

    public String getCallCenterText() {
        return getText(textCallCenter);
    }

    public String getTitlePayment() {
        return getText(textTitlePayment);
    }

    public void doScrollDown() {
        scrollDown();
    }

    public String getTextSaveDates() {
        return getText(textSaveDates);
    }

    public void clickButtonAccept() {
        waitForClick(buttonAccept, 10);
        click(buttonAccept);
    }

    //Obtener campos editables Tomador
    public String getPersonStreet() {
        return getText(editPersonStreet);
    }

    public String getPersonCP() {
        return getText(editPersonCP);
    }

    public String getPersonCity() {
        return getText(editPersonCity);
    }

    public String getPersonProvince() {
        return getText(editPersonProvince);
    }

    public String getPersonPhoneNumber() {
        return getText(editPersonPhoneNumber);
    }

    public String getPersonMobileNumber() {
        return getText(editPersonMobileNumber);
    }

    public String getPersonEmail() {
        return getText(editPersonEmail);
    }

    //Editar campos Tomador
    public void setPersonStreet(String text) {
        click(editPersonStreet);
        sendKeys(editPersonStreet, text);
    }

    public void setPersonCP(String text) {
        click(editPersonCP);
        sendKeys(editPersonCP, text);
    }

    public void setPersonCity(String text) {
        click(editPersonCity);
        sendKeys(editPersonCity, text);
    }

    public void setPersonProvince(String text) {
        click(editPersonProvince);
        sendKeys(editPersonProvince, text);
    }

    public void setPersonPhoneNumber(String text) {
        click(editPersonPhoneNumber);
        sendKeys(editPersonPhoneNumber, text);
    }

    public void setPersonMobileNumber(String text) {
        click(editPersonMobileNumber);
        sendKeys(editPersonMobileNumber, text);
    }

    public void setPersonEmail(String text) {
        click(editPersonEmail);
        sendKeys(editPersonEmail, text);
    }

    public Integer findInsurance(String textFind){
        Boolean verify = false;
        Integer num = 1;
        MobileElement element = textTitleDetailsInsurance;
        if (!driver.getCapabilities().getPlatform().is(Platform.LINUX))
        {
            element = (MobileElement) driver.findElement(By.xpath("(//XCUIElementTypeImage[contains (@name,'imgInsurance')][1])["+num+"]/preceding-sibling::*"));
        }
        try
        {

            while (!getText(element).contains(textFind))
            {
                if (verify == false)
                {
                    click(nextInsurance);
                }
                else
                {
                    click(nextMoreInsurance);
                }
                verify = true;
                num++;
                if (!driver.getCapabilities().getPlatform().is(Platform.LINUX))
                {
                    element = (MobileElement) driver.findElement(By.xpath("(//XCUIElementTypeImage[contains (@name,'imgInsurance')][1])["+num+"]/preceding-sibling::*"));
                }
            }
            return num;
        }
        catch (Exception exe)
        {
            return 0;
        }
    }

    public Integer countOptionsDetailInsurance(){
        return countElementsList(driver.findElements(OptionsDetailInsurance));
    }


    // Sections from My insurance Screen
    public boolean VerifyVerRecibosIsShown(){
        return isPresent(linkOptionSeeReceipts);
    }

    //Verifications
    public boolean verifyAmazonLogoIsShown() {
        Boolean verify = false;
        Utilities.sleep(12000);

        try {
            while (!isEnabled(amazonLogo)){
                if (verify==false){
                    click(buttonSecondInsurance);
                } else {
                    click(nextInsuranceFromInsuranceScreen);
                }
                verify=true;
            }
            return true;

        } catch (Exception exe){
            return false;
        }


    }

    public boolean verify_Mis_Seguros_Is_Shown() {
        return isPresent(textTitlePayment);
    }


}


