package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_02_04 extends CreateExtetReport {

    @Test
    public void Solo_poliza_Hogar () throws Exception {

        //Test user
        String User_Only_Home = "Hogar";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1(driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);


        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Usuario solo poliza Hogar");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login using a correct user
        cp1.execute(User_Only_Home, test1);

        //TEST START .-
        // Verifying Buscador talleres is not shown
        ExtentTest node2 = test1.createNode("Home, Only Policy - Hogar");
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyCarWorkShopIsShown(), node2, "Car work shop is shown from home screen");
        Assert.assertFalse(welcomeScreen.verifyCarWorkShopIsShown(), "Car work shop is shown from home screen");

        //Goign to the menu
        ExtentTest node3 = test1.createNode("Menu, Only Policy - Hogar");
        welcomeScreen.clickButtonMenu();

        // Verifying Buscador talleres is not shown on the Menu screen
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyMenuookingForCarShopIsShown(), node3, "Car work shop is shown from menu screen");
        Assert.assertFalse(welcomeScreen.verifyMenuookingForCarShopIsShown(), "Car work shop is shown from menu screen");

    }
}
