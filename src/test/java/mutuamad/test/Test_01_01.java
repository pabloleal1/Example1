package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.LoginScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_01_01 extends CreateExtetReport {

    @Test
    public void Login() throws Exception {

        //Test user
        String User_Incorrecto= "Incorrecto";
        String User_Valid= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        LoginScreen loginScreen = new LoginScreen(driverManager);


        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Login erroneo - Login correcto");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //cp0.notis(test1);

        //Login with an incorrect user
        cp1.execute2(User_Incorrecto);

        //Verify the error is shown
        ExtentTest  node2 = test1.createNode("Login was Un-successsfull");
        CreateExtetReport.stepsVerifications(loginScreen.verificErrorMessaeIsShown(), node2, "An error is shown after login with an incorrect user");
        Assert.assertTrue(loginScreen.verificErrorMessaeIsShown(),"[debug] Mensaje de ERROR al iniciar sesión NO es mostrado");

        //Login
        cp1.execute(User_Valid, test1);
        //Verify Home screen is shown after login
        ExtentTest node3 = test1.createNode("Login was successsfull");
        CreateExtetReport.stepsVerifications(welcomeScreen.verifyHolaIsShown(), node3, "Showing the correct screen after login");
        Assert.assertTrue(welcomeScreen.verifyHolaIsShown(),"Error - El login no se ha realizado correctamente");

    }
}
