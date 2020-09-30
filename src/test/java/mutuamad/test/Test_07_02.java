package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.atsistemas.appium.JsonParseData;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.MailBoxScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_07_02 extends CreateExtetReport {

    @Test
    public void Mensajes_Eliminar() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        MailBoxScreen mailboxScreen = new MailBoxScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Eliminar mensajes");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Mensajes - Detalles");

        //TEST START .- MailBox. Delete
        welcomeScreen.clickButtonMenu();
        Utilities.sleep(5000);
        welcomeScreen.clickOptionMailBox();
        Utilities.sleep(5000);
        if (mailboxScreen.isBoxMailVisible())
        {
            if(JsonParseData.get("display", "recibo").equals("true"))
            {
                mailboxScreen.clickSearchMail();
                mailboxScreen.sendKeysSearchMail();
            }
            String titleAndDateDelete = mailboxScreen.getTextTitleMail()+ mailboxScreen.getTextDateMail();
            mailboxScreen.deleteFirstMail();
            Utilities.sleep(15000);
            String titleAndDate = mailboxScreen.getTextTitleMail()+ mailboxScreen.getTextDateMail();
            if(titleAndDateDelete.equals(titleAndDate))
            {
                node2.log(Status.FATAL, "WARNING.- Step Mail NO Deleted");
                Assert.fail("[MSJ] [Mail NO Deleted] [" + titleAndDateDelete + "] [" + titleAndDate + "]");

            }
            else
            {
                node2.log(Status.PASS, "PASS.- Step: Mail Deleted");
                Assert.assertTrue(true, "[MSJ] [Mail Deleted]");
            }
        }
        else
        {
            CreateExtetReport.stepsVerifications(mailboxScreen.isBoxMailVisible(), node2, "Usuario con mensajes");
            Assert.assertTrue(mailboxScreen.isBoxMailVisible(), "[ERROR] [Usuario sin mensajes]");
        }
    }
}

