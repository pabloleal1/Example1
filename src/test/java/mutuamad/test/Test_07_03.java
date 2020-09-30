package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.MailBoxScreen;
import mutuamad.screen.PrincipalScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_07_03 extends CreateExtetReport {

    @Test
    public void Mensajes_NO_Leidos() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        MailBoxScreen mailboxScreen = new MailBoxScreen(driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Mensajes NO leidos");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Mensajes - Detalles");

        //TEST START .- MailBox. Unread
        welcomeScreen.clickButtonMenu();
        Utilities.sleep(5000);
        welcomeScreen.clickOptionMailBox();
        Utilities.sleep(5000);

        //how many unread message
        CreateExtetReport.stepsVerifications(mailboxScreen.isTotalMailVisible(), node2, "Tener mensajes NO leidos");
        Assert.assertTrue(mailboxScreen.isTotalMailVisible(),"[ERROR] [Usuario sin mensajes sin leer]");

        //Click on the unread messages tab
        mailboxScreen.clickTabnotRead();

        //Get the unread messages number
        String verification = mailboxScreen.getTextNumMessages();
        node2.log(Status.INFO, "getting the number of unread messages");
        Assert.assertTrue(mailboxScreen.verifyMoreThanOneUnreadMessage(), "No Unread Message shown");

        //Select the first unread message
        mailboxScreen.clickFisrtMail();

        //Go back to the unread message folder
        principalScreen.clickBack();

        //Verify the unread messages number

        Assert.assertNotEquals("[MSJ] [No Read Message]", mailboxScreen.getTextNumMessages(), verification);
        test1.log(Status.PASS, "After open an unread messages, the number of unread message is falling");

    }
}

