package mutuamad.process;

import com.atsistemas.appium.CreateExtetReport;
import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.Process;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import mutuamad.Utilities;
import mutuamad.screen.LoginScreen;
import mutuamad.screen.PrincipalScreen;
import org.openqa.selenium.Platform;
import org.testng.Assert;


public class CP0 extends Process {

    private PrincipalScreen principalScreen;
    private LoginScreen loginScreen;
    ExtentTest node;

    public CP0(DriverManager driver) {
        super(driver);
        principalScreen = new PrincipalScreen(driver);
        loginScreen = new LoginScreen(driver);
    }


    public void execute(ExtentTest test1) throws Exception {

        node = test1.createNode("Tutorial - Notifications");

        System.out.println("[Quit Tutorial and Close the notifications screen]");
        driver.startScreenRecordig();
        Utilities.sleep(35000);

        principalScreen.closeStartingPopUp();
        CreateExtetReport.stepsVerifications(principalScreen.verifyViewFlipperTutorial(), node, "Se muestra la ventana de Bienvenida");
        Assert.assertTrue(principalScreen.verifyViewFlipperTutorial(), "NO se muestra la ventana de Bienvenida");
        principalScreen.scrollLeft();
        loginScreen.clickClose();

        CreateExtetReport.stepsVerifications(loginScreen.verificNotificationScreenIsShown(), node, "Se muestra la ventana de Notificaciones");
        Assert.assertTrue(loginScreen.verificNotificationScreenIsShown(), "NO se muestra la ventana de Notificaciones");
        loginScreen.closeNotificationsScreen();

        CreateExtetReport.stepsVerifications(loginScreen.verificWeTakeCareOfYouTitleLabel(), node, "Se muestra la ventana de Cuidamos de ti");
        Assert.assertTrue(loginScreen.verificWeTakeCareOfYouTitleLabel(), "NO se muestra la ventana de Cuidamos de ti");
        principalScreen.scrollLeft();

        CreateExtetReport.stepsVerifications(loginScreen.verificCardTitleLabel(), node, "Se muestra la ventana de Tarjeta");
        Assert.assertTrue(loginScreen.verificCardTitleLabel(), "NO se muestra la ventana de Tarjeta");
        principalScreen.scrollLeft();

        //Open Login after clicking on the Menu
        principalScreen.clickLinkMenu();
        Utilities.sleep(5000);
        principalScreen.clickLinkOptionLoginMenu();
        System.out.println("HOLA");
    }
}
