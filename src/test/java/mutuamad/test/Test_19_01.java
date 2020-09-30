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


public class Test_19_01 extends CreateExtetReport {

    @Test
    public void Amazon() throws Exception {

        //Test user
        String User_Amazon= "Amazon";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        InsuranceScreen myInsuranceScreen = new InsuranceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Amazon");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Amazon, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Steps - Amazon");

        //TEST START .- Going to the reports Screen
        welcomeScreen.clickTextWelcomeUser();
        // Verify the logo of Amazon is shown successfully
        Utilities.sleep(14000);
        CreateExtetReport.stepsVerifications(myInsuranceScreen.verifyAmazonLogoIsShown(), node2, "Showing Amazon");
        Assert.assertTrue(myInsuranceScreen.verifyAmazonLogoIsShown(),"Amazon is NOT available");

    }
}
