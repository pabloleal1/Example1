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


public class Test_18_02 extends CreateExtetReport {

    @Test
    public void Single_Sign_On_Partes() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        InsuranceScreen insuranceScreen = new InsuranceScreen(driverManager);
        SingleSignOnScreen singleSignOnScreen = new SingleSignOnScreen(driverManager);
        ServicesScreen servicesScreen = new ServicesScreen(driverManager);


        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "single sign on partes");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("SSO - Partes");

        //TEST START .-
        //Going to the my insurance screen
        welcomeScreen.clickTextWelcomeUser();
        Utilities.sleep(5000);
        //Click on the button "Give And Manage Parts"
        insuranceScreen.clickButtonGiveAndManageParts();
        //Click on the first part
        Utilities.sleep(15000);
        insuranceScreen.clickSelectFisrtPartinGiveAndManageParts();
        Utilities.sleep(8000);

        //Verify report history and evolution data is shown
        CreateExtetReport.stepsVerifications(insuranceScreen.verificTextEvolutionReport(), node2, "muestra datos evolutivo");
        Assert.assertTrue(insuranceScreen.verificTextEvolutionReport(),"[debug] Verificar muestra datos evolutivo");

        //Verify historical report is shown
        CreateExtetReport.stepsVerifications(insuranceScreen.verificTextDetailReportTracing(), node2, "Mostrar historial del parte");
        Assert.assertTrue(insuranceScreen.verificTextDetailReportTracing(),"[debug] Verificar muestra historial del parte");

        //Click on the first part "More Info Detail Report"
        insuranceScreen.clickButtonMoreInfoDetailReport();
        //Verify SSO report details is shown
        Utilities.sleep(25000);

        //Make sure captcha is NOT shown
        CreateExtetReport.stepsVerifications(!servicesScreen.captchaIsShown(), node2, "Captcha is shown or Access Denied");
        Assert.assertFalse(servicesScreen.captchaIsShown(),"Captcha is shown or Access Denied");

        //Verify SSO screen is shown
        CreateExtetReport.stepsVerifications(singleSignOnScreen.verificViewPartsSSO(), node2, "Vista del SSO Detalles del parte");
        Assert.assertTrue(singleSignOnScreen.verificViewPartsSSO(),"[debug] Vista del SSO Detalles del parte correcta");

    }
}
