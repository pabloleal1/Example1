package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.CustomerSupportScreen;
import mutuamad.screen.EmmeScreen;
import mutuamad.screen.FrequentQuestionsScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_16_02 extends CreateExtetReport {

    @Test
    public void Preguntas_Frecuentes_Menu() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        CustomerSupportScreen customerSupportScreen = new CustomerSupportScreen(driverManager);
        EmmeScreen emmeScreen = new EmmeScreen(driverManager);
        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Contacto, (Falta ayuda) , escribe puntos en el buscador y abre las diferentes secciones");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);


        //TEST START .- Frequently questions
        welcomeScreen.clickButtonMenu();
        Utilities.sleep(5000);
        welcomeScreen.clickOptionCustomerSupport();
        customerSupportScreen.clickButtonPopupAlertAllow();
        Utilities.sleep(2000);
        welcomeScreen.clickOptionFrequentQuestions();

        //Verify elements for Eme are shown
        Utilities.sleep(2000);
        ExtentTest node3 = test1.createNode("Eme Elements are Shown");
        CreateExtetReport.stepsVerifications(emmeScreen.verify_Icon_Is_Shown(), node3, "Mostrar - Icono de Eme");
        Assert.assertTrue(emmeScreen.verify_Icon_Is_Shown(),"Mostrar - Icono de Eme");

        CreateExtetReport.stepsVerifications(emmeScreen.verify_Ask_Eme_Button_Is_Shown(), node3, "Mostrar - Boton de ver Eme");
        Assert.assertTrue(emmeScreen.verify_Ask_Eme_Button_Is_Shown(),"Mostrar - Boton de ver Eme");

        CreateExtetReport.stepsVerifications(emmeScreen.verify_watch_Eme_Video_Is_Shown(), node3, "Mostrar - Ver Video de Eme");
        Assert.assertTrue(emmeScreen.verify_watch_Eme_Video_Is_Shown(),"Mostrar - Ver Video de Eme");

        emmeScreen.click_On_Eme_Button();
        Utilities.sleep(4000);
        emmeScreen.clickOKDeviceLocationPopup();
        CreateExtetReport.stepsVerifications(emmeScreen.verify_Eme_Was_Open(), node3, "Se abrio Eme");
        Assert.assertTrue(emmeScreen.verify_Eme_Was_Open(),"Se abrio Eme");

        emmeScreen.clickCloseEmmeScreen();
        CreateExtetReport.stepsVerifications(emmeScreen.verify_Icon_Is_Shown(), node3, "Mostrar - Icono de Eme tras cerrar Eme");
        Assert.assertTrue(emmeScreen.verify_Icon_Is_Shown(),"Mostrar - Icono de Eme tras cerrar Eme");

        emmeScreen.click_On_Eme_Video();
        Utilities.sleep(4000);
        CreateExtetReport.stepsVerifications(emmeScreen.verify_play_Eme_Video_Is_Shown(), node3, "Mostrar - Boton de play rn video de Eme");
        Assert.assertTrue(emmeScreen.verify_play_Eme_Video_Is_Shown(),"Mostrar - Boton de play en video de Eme");
        emmeScreen.click_On_Play_Eme_Video();


    }
}

