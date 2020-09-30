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


public class Test_07_01 extends CreateExtetReport {

    @Test
    public void Mensajes_Acceso_MailBox() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        MailBoxScreen mailboxScreen = new MailBoxScreen(driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Mensajes acceder al mailbox");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Mensajes - Detalles");

        //TEST START .- MailBox. Access
        welcomeScreen.clickButtonMenu();
        Utilities.sleep(5000);
        welcomeScreen.clickOptionMailBox();
        Utilities.sleep(5000);
        CreateExtetReport.stepsVerifications(mailboxScreen.getTextTitleDetail().equals("MIS MENSAJES"), node2, "Mostar: Titulo - Mis mensajes");
        Assert.assertEquals(mailboxScreen.getTextTitleDetail(), "MIS MENSAJES");

        CreateExtetReport.stepsVerifications(mailboxScreen.isTabAllMessagesVisible(), node2, "Mostar: Tab - Todos los mensajes");
        Assert.assertTrue(mailboxScreen.isTabAllMessagesVisible());

        CreateExtetReport.stepsVerifications(mailboxScreen.isTabnotReadVisible(), node2, "Mostar: Tab - Mensajes NO leidos");
        Assert.assertTrue(mailboxScreen.isTabnotReadVisible());

        Assert.assertTrue(mailboxScreen.isBoxMailVisible());
        //Select first mail received
        mailboxScreen.clickFisrtMail();

        CreateExtetReport.stepsVerifications(mailboxScreen.isLabelTitleDetailVisible(), node2, "Mostar: Titulo en mensaje");
        Assert.assertTrue(mailboxScreen.isLabelTitleDetailVisible());

        CreateExtetReport.stepsVerifications(mailboxScreen.isLabelDetailImageVisible(), node2, "Mostrar: Logo/Detalle en mensaje");
        Assert.assertTrue(mailboxScreen.isLabelDetailImageVisible());

        CreateExtetReport.stepsVerifications(mailboxScreen.isLabelDetailDateTextVisible(), node2, "Mostrar: Fecha del mensaje");
        Assert.assertTrue(mailboxScreen.isLabelDetailDateTextVisible());

        CreateExtetReport.stepsVerifications(mailboxScreen.isLabelDetailTitleTextVisible(), node2, "Mostrar: Titulo - Bienvenido a tu bandeja de entrada");
        Assert.assertTrue(mailboxScreen.isLabelDetailTitleTextVisible());

        CreateExtetReport.stepsVerifications(mailboxScreen.isLabelDetailSubtitleTextVisible(), node2, "Mostrar: Titulo - Mutua te lo pone Facil");
        Assert.assertTrue(mailboxScreen.isLabelDetailSubtitleTextVisible());

        CreateExtetReport.stepsVerifications(mailboxScreen.isLabelDetailTextVisible(), node2, "Mostrar: Detalles del mensaje");
        Assert.assertTrue(mailboxScreen.isLabelDetailTextVisible());
        //User goes back to the mailbox screen
        principalScreen.clickBack();
        Utilities.sleep(5000);

        CreateExtetReport.stepsVerifications(mailboxScreen.isTabAllMessagesVisible(), node2, "Mostar: Tab - Todos los mensajes");
        Assert.assertTrue(mailboxScreen.isTabAllMessagesVisible());

        CreateExtetReport.stepsVerifications(mailboxScreen.getTextTitleDetail().equals("MIS MENSAJES"), node2, "Mostar: Titulo - Mis mensajes");
        Assert.assertEquals("MIS MENSAJES", mailboxScreen.getTextTitleDetail());
    }
}

