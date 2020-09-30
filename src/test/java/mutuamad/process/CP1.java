package mutuamad.process;

import com.atsistemas.appium.CreateExtetReport;
import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Process;
import com.aventstack.extentreports.ExtentTest;
import mutuamad.Utilities;
import mutuamad.screen.LoginScreen;
import mutuamad.screen.PrincipalScreen;
import org.testng.Assert;

public class CP1 extends Process {

    //Initialize variable
    private LoginScreen loginScreen;
    private PrincipalScreen principalScreen;

    ExtentTest node;

    public CP1(DriverManager driver)
    {
        super(driver);
        loginScreen = new LoginScreen(driver);
        principalScreen = new PrincipalScreen(driver);

    }

    public void execute2(String User) throws Exception
    {

        loginScreen.setTextLoginUsername(User);
        loginScreen.setTextPassword();
        loginScreen.clickButtonLogin();
        Utilities.sleep(30000);

    }

    public void execute(String User, ExtentTest test1) throws Exception
    {

        node = test1.createNode("Login");

        loginScreen.setTextLoginUsername(User);
        loginScreen.setTextPassword();
        loginScreen.clickButtonLogin();
        Utilities.sleep(3000);

        //Verifications login was successfull
        CreateExtetReport.stepsVerifications(!loginScreen.verificErrorMessaeIsShown(), node, "Login");
        Assert.assertTrue(!loginScreen.verificErrorMessaeIsShown(),"[debug] Mensaje de ERROR al iniciar sesión NO es mostrado");

    }

    public void iniciarSesionDespues() throws Exception
    {
        loginScreen.scrollDown();
        loginScreen.clickIniciarSesionDespues();
        //Verify notifications screen is shown
        Utilities.sleep(3000);
        loginScreen.closeNotificationsScreen();
        Utilities.sleep(3000);
    }
}
