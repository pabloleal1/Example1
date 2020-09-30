package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.AdvantageScreen;
import mutuamad.screen.CustomerSupportScreen;
import mutuamad.screen.DrawScreen;
import mutuamad.screen.PrincipalScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_12_01 extends CreateExtetReport {

    @Test
    public void Sorteo() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        CustomerSupportScreen customerSupportScreen = new CustomerSupportScreen(driverManager);
        PrincipalScreen principalScreen = new PrincipalScreen(driverManager);
        AdvantageScreen advantageScreen = new AdvantageScreen(driverManager);
        DrawScreen drawScreen = new DrawScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Sorteo (Ventajas)");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //TEST START .-
        //User goes to the advantage screen
        principalScreen.clickAdvantageLink();
        advantageScreen.clickAllowDeviceLocationPopup();;
        //User goes to the month's draw
        advantageScreen.clickMonthsDrawAdvantage();
        customerSupportScreen.clickButtonPopupAlertAllow();
        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Steps - Sorteo");
        if(drawScreen.verifyShowMessageDraw()){
            //Verify the conditions was accepted and access the draw
            CreateExtetReport.stepsVerifications(drawScreen.verifyShowMessageDraw(), node2, "Draw messages accepted are not displayed");
            Assert.assertTrue(drawScreen.verifyShowMessageDraw(),"Error, No se muestra el mensaje de sorteo aceptado");

        }
        else {
            //Click on part now
            drawScreen.scrollDown();
            drawScreen.clickNowParticipate();
            Utilities.sleep(3000);
        //Create Node for Reports
        //Verify the conditions was accepted and access the draw
        CreateExtetReport.stepsVerifications(!drawScreen.verifyShowMessageDraw(), node2, "This user has already participated");
        Assert.assertTrue(!drawScreen.verifyShowMessageDraw(),"Error, This user has already participated");

        drawScreen.scrollDown();
        drawScreen.clickNowParticipate();
        Utilities.sleep(3000);


            //Verify the conditions was NOT accepted and access the draw
            CreateExtetReport.stepsVerifications(drawScreen.verifyAcceptConditionsIsShonw(), node2, "showing message (You must accept a terms of use");
            Assert.assertTrue(drawScreen.verifyAcceptConditionsIsShonw(), "El check de condiciones debe esta activado");

            //Click on the accept conditions button
            drawScreen.scrollDown();
            drawScreen.clickCheckConditions();
            //Click on part now
            drawScreen.scrollDown();
            drawScreen.clickNowParticipate();

            //Verify the conditions was accepted and access the draw
            CreateExtetReport.stepsVerifications(drawScreen.verifyShowMessageDraw(), node2, "Draw messages accepted are not displayed");
            Assert.assertTrue(drawScreen.verifyShowMessageDraw(), "Error, No se muestra el mensaje de sorteo aceptado");
        }
    }
}
