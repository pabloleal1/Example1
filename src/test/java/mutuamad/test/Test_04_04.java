package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.AssistanceScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_04_04 extends CreateExtetReport {

    @Test
    public void Asistencia_Averia_Mecanico() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        AssistanceScreen assistanceScreen = new AssistanceScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Asistencia por averia(mecanico)");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //TEST START .- Assistance Car Mechanic
        welcomeScreen.clickButtonAssistance();
        Utilities.sleep(5000);

        //Verify that you have policies to register assistance
        int verifyNumberOfPolicy = assistanceScreen.allInsuranceXSize("COCHE");

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Available Reports");

        if(!assistanceScreen.verifyAssistanceTittleStartProcessIsShown() && verifyNumberOfPolicy<=0)
            node2.log(Status.FATAL,"NO report available");
        Assert.assertFalse(!assistanceScreen.verifyAssistanceTittleStartProcessIsShown() && verifyNumberOfPolicy<=0, "NO Assistance available");

        if(verifyNumberOfPolicy>0) {
            for (int x = 1; x <= verifyNumberOfPolicy; x++) {
                assistanceScreen.clickAssistanceCar(x);
                if (assistanceScreen.verifyAssistanceTittleStartProcessIsShown())
                    break;
                if (x == verifyNumberOfPolicy) {
                    node2.log(Status.FAIL, "NO Assistance available");
                    Assert.fail("NO Assistance available");
                }
                assistanceScreen.closeAsisstance();
                welcomeScreen.clickButtonAssistance();
            }
        }
        node2.log(Status.PASS,"Report available");

        Utilities.sleep(2000);
        ExtentTest node3 = test1.createNode("Steps - Request Assitance");
        assistanceScreen.clickResponseYesAssistance();
        Utilities.sleep(5000);
        assistanceScreen.clickCarAssistanceMechanic();
        assistanceScreen.clickAllowDeviceLocationPopup();
        Utilities.sleep(5000);

        //Verify show if your device doesn't have installed Google Play services
        CreateExtetReport.stepsVerifications(!assistanceScreen.getTextGoogleLocationMap().contains("without Google Play"), node3, "[WARNING : Your device doesn't have installed Google Play services]");
        Assert.assertFalse(assistanceScreen.getTextGoogleLocationMap().contains("without Google Play"),"[WARNING : Your device doesn't have installed Google Play services]");

        assistanceScreen.clickLocationSendAssistanceText();
        Utilities.sleep(5000);
        assistanceScreen.sendLocationSendAssistanceAddress();
        Utilities.sleep(5000);
        assistanceScreen.selectLocationSendAssistanceAutoSuggest();
        Utilities.sleep(5000);
        assistanceScreen.clickButtonContinue();
        Utilities.sleep(2000);
        assistanceScreen.clickCarAssistanceSuperficie();
        Utilities.sleep(2000);
        assistanceScreen.clickCarassistanceCarColorDarkGray();
        assistanceScreen.clickButtonContinue();
        Utilities.sleep(2000);
        assistanceScreen.clickButtonContinue();
        Utilities.sleep(2000);
        assistanceScreen.setTelephoneAssistanceUser();
        assistanceScreen.clickButtonConfirm();
        Utilities.sleep(2000);
        assistanceScreen.clickButtonAcceptAssistance();
        Utilities.sleep(2000);
        node3.log(Status.PASS, "Assitance - Steps Completly successfully");

    }
}

