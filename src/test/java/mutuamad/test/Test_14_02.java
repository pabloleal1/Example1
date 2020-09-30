package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_14_02 extends CreateExtetReport {

    @Test
    public void Calcular_tu_Seguro_mas_de_6_polizas() throws Exception {

        //Test user
        String User_Mas_Seis_Polizas= "MoreThan6Policy";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Usuario mas de 6 polizas, menu, calcular tu seguro");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login using a globalis user
        cp1.execute(User_Mas_Seis_Polizas, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Mostrar Calcuar Seguro");

        //TEST START .- Calcular tu seguro is shown
        welcomeScreen.clickButtonMenu();
        CreateExtetReport.stepsVerifications(!welcomeScreen.verifyCalculaTuSeguroIsShown(), node2, "Showing Calcula tu seguro");
        Assert.assertTrue(!welcomeScreen.verifyCalculaTuSeguroIsShown(),"Calcula tu seguro SE muestra en el menu para usuario con mas de 6 polizas");

    }
}

