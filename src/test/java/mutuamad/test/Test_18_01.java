package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_18_01 extends CreateExtetReport {

    @Test
    public void Single_Sign_On_Ventajas() throws Exception{

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        AdvantageScreen advantageScreen = new AdvantageScreen(driverManager);
        CustomerSupportScreen customerSupportScreen = new CustomerSupportScreen(driverManager);
        SingleSignOnScreen singleSignOnScreen = new SingleSignOnScreen(driverManager);
        ServicesScreen servicesScreen = new ServicesScreen(driverManager);


        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "single sign on ventajas");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("SSO - Ventajas");

        //TEST START .-
        //User goes to the advantage screen
        principalScreen.clickAdvantageLink();
        customerSupportScreen.clickButtonPopupAlertAllow();

        //Search -- Chofer Advantaje
        //User set 'chofer' on the search fields
        advantageScreen.searchAdvantage("chófer");
        if(advantageScreen.verifyChoferItvIsShown()){
            advantageScreen.clickChoferAdvantage();
        }
        customerSupportScreen.clickButtonPopupAlertAllow();
        //Scroll to press the button
        Utilities.sleep(2000);
        singleSignOnScreen.scrollViewSSO();
        //Press the access button to SSO
        Utilities.sleep(2000);
        advantageScreen.clickActionAdvantage();
        //Make sure captcha is NOT shown for CHOFER advantage
        CreateExtetReport.stepsVerifications(!servicesScreen.captchaIsShown(), node2, "Captcha is shown or Access Denied");
        Assert.assertFalse(servicesScreen.captchaIsShown(),"Captcha is shown or Access Denied");
        servicesScreen.quitCaptcha();
        //Verify access to the view SSO
        Utilities.sleep(15000);
        CreateExtetReport.stepsVerifications(singleSignOnScreen.getTextTittleFromSSo().equals("CHÓFER ITV"), node2, "Vista del SSO Traslado ITV");
        Assert.assertTrue(singleSignOnScreen.getTextTittleFromSSo().equals("CHÓFER ITV"),"[debug] [Vista del SSO Traslado ITV incorrecta]");
        //Close view SSO
        singleSignOnScreen.clickClose();
        advantageScreen.clickButtonBack();

        //Search -- Renova Advantaje
        //User set 'renovacion' on the search fields
        advantageScreen.searchAdvantage("carné");
        Utilities.sleep(2000);
        customerSupportScreen.clickButtonPopupAlertAllow();
        //Scroll to press the button
        singleSignOnScreen.scrollViewSSO();
        //Press the access button to SSO
        Utilities.sleep(2000);
        advantageScreen.clickActionAdvantage();
        //Close view SSO
        Utilities.sleep(20000);
        //Make sure captcha is NOT shown for RENOVA advantage
        Assert.assertTrue(!servicesScreen.captchaIsShown(),"Captcha is shown");
        //Verify access to the view SSO
        CreateExtetReport.stepsVerifications(singleSignOnScreen.getTextTittleFromSSo().equals("RENOVACION DE CARNÉ"), node2, "Vista del SSO Renovacion");
        Assert.assertTrue(singleSignOnScreen.getTextTittleFromSSo().equals("RENOVACION DE CARNÉ"),"[debug] Vista del SSO Renovación carné incorrecta");

    }
}
