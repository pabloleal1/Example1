package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.ReportsScreen;
import mutuamad.screen.ServicesScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_03_13 extends CreateExtetReport {

    @Test
    public void Dar_Parte_Moto_Golpe_Con_Mas_Vehiculos() throws Exception {

        //Test user
        String User_Poliza_Moto= "MotoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ReportsScreen reportsScreen = new ReportsScreen(driverManager);
        ServicesScreen servicesScreen = new ServicesScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Dar parte, moto, tiene un golpe roce o impacto, con mas de un vehiculo");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login using a correct user
        cp1.execute(User_Poliza_Moto, test1);

        //TEST START .- Open new MotorBike report
        welcomeScreen.clickButtonReports();
        Utilities.sleep(2000);

        //Verify that you have policies to register parts
        int verifyNumberOfPolicy = reportsScreen.allInsuranceXSize("MOTO");

        System.out.println("N Poli"+verifyNumberOfPolicy);


        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Available Reports");


        if(reportsScreen.verifyTeHaOcurridoScreenISShown() && verifyNumberOfPolicy<=0)
            node2.log(Status.FATAL,"NO report available");
        Assert.assertFalse(reportsScreen.verifyTeHaOcurridoScreenISShown() && verifyNumberOfPolicy<=0,"Este usuario no tiene permisos para dar este tipo de partes");

        if(verifyNumberOfPolicy>0) {
            for (int x = 1; x <= verifyNumberOfPolicy; x++) {
                //Select first policy
                reportsScreen.clickPolicyX("MOTO", x);
                if (!reportsScreen.verifyTeHaOcurridoScreenISShown()) {
                    break;
                }

                //Verify any of those policies you can send reports
                CreateExtetReport.stepsVerifications(x-1 == verifyNumberOfPolicy, node2, "NO report available");
                Assert.assertNotEquals(verifyNumberOfPolicy, x - 1, "NO report available");

                //Reload the policies
                reportsScreen.closeReportScreen();
                Utilities.sleep(2000);
                welcomeScreen.clickButtonReports();
            }
        }
        node2.log(Status.PASS,"Report available");

        Utilities.sleep(2000);
        ExtentTest node3 = test1.createNode("Steps - Create Report");
        CreateExtetReport.stepsVerifications(reportsScreen.verifyVehicleHitOptionIsShown(), node3, "Choosing the correct claim from a range of options");
        Assert.assertTrue(reportsScreen.verifyVehicleHitOptionIsShown(), "Este usuario no tiene permisos para dar este tipo de partes");
        reportsScreen.clickVehicleHit();
        Utilities.sleep(2000);
        reportsScreen.clickmorethanOneVehicle();
        Utilities.sleep(2000);

        //Verify the Webview is shown
        CreateExtetReport.stepsVerifications(reportsScreen.verifyImprovingExperienceScreenISShown(), node3, "showing the improve your experience screen");
        Assert.assertTrue(reportsScreen.verifyImprovingExperienceScreenISShown(),"No se muestra la imagen del call center de Robo de elementos" );

        CreateExtetReport.stepsVerifications(!servicesScreen.captchaIsShown(), test1, "Captcha is shown or Access Denied");
        Assert.assertFalse(servicesScreen.captchaIsShown(),"Captcha is shown or Access Denied");

        reportsScreen.clickcontinueButtonfromImprovingExperienceScreen();
        CreateExtetReport.stepsVerifications(reportsScreen.verifyTextWebviewGivePart(), node3, "showing the the webview");
        Assert.assertTrue(reportsScreen.verifyTextWebviewGivePart(), "No se muestra el contenido del Webview");


    }
}

