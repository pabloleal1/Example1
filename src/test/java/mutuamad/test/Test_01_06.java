package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.Status;
import mutuamad.Utilities;
import mutuamad.process.CP0;
import mutuamad.screen.GenericScreen;
import mutuamad.screen.LoginScreen;
import mutuamad.screen.PasswordLostScreen;
import mutuamad.screen.ServicesScreen;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_01_06 extends CreateExtetReport {

    @Test
    public void Olvidar_Password() throws Exception {

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        LoginScreen loginScreen = new LoginScreen(driverManager);
        PasswordLostScreen passwordLostScreen = new PasswordLostScreen(driverManager);
        GenericScreen genericScreen = new GenericScreen(driverManager);

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Olvide mi password");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //TEST START .- Forgot Password
        loginScreen.clickLostPasswordLink();
        passwordLostScreen.clickAllowDeviceSMSPopup();
        CreateExtetReport.stepsVerifications(passwordLostScreen.isHeadTitlePresent(), test1, "showing the title text");
        Assert.assertTrue(passwordLostScreen.isHeadTitlePresent(), "Error in showing the title text");

        //Check that the error message is displayed for a wrong DNI
        passwordLostScreen.sendNIFNumberWrong();
        passwordLostScreen.clickCheckConditions();
        passwordLostScreen.clickButtonContinuar();
        CreateExtetReport.stepsVerifications(passwordLostScreen.isOneErrorPresent(), test1, "showing the error message text");
        Assert.assertTrue(passwordLostScreen.isOneErrorPresent(), "Error in showing the error message text");

        //Check that the error message is displayed for a No register DNI
        passwordLostScreen.sendNIFNumberNotRegister();
        passwordLostScreen.clickButtonContinuar();
        CreateExtetReport.stepsVerifications(passwordLostScreen.isAllErrorsPresent(), test1, "showing the error message text");
        Assert.assertTrue(passwordLostScreen.isAllErrorsPresent(), "Error in showing the error message text");
        passwordLostScreen.clickButtonCerrar();
        loginScreen.clickLostPasswordLink();

        //Check that the phone number is displayed for a correct DNI
        passwordLostScreen.sendNIFNumberCorrect();
        passwordLostScreen.clickCheckConditions();
        passwordLostScreen.clickButtonContinuar();
        CreateExtetReport.stepsVerifications(passwordLostScreen.isPresentVerifyTelephoneNumber(), test1, "showing the text phone number");
        Assert.assertTrue(passwordLostScreen.isPresentVerifyTelephoneNumber(), "Error in showing the text phone number");
        passwordLostScreen.clickButtonContinuePhone();
        if(genericScreen.verifyPopUpIsShown()){
            genericScreen.clickUpdateButton();
        }
        //Check that the showing the input code SMS
        CreateExtetReport.stepsVerifications(passwordLostScreen.isPresentVerifyEnrollmentOtpCodeInput(), test1, "showing the input code SMS");
        Assert.assertTrue(passwordLostScreen.isPresentVerifyEnrollmentOtpCodeInput(), "Error in showing the input code SMS");
        passwordLostScreen.clickButtonBack();

        //Check that the error message is displayed for a phone number wrong
        passwordLostScreen.clickSendCodeAnotherTelephone();
        passwordLostScreen.sendTelephoneUserWrong();
        passwordLostScreen.clickButtonContinuePhone();

        CreateExtetReport.stepsVerifications(passwordLostScreen.isOneErrorPresent(), test1, "showing the error message text");
        Assert.assertTrue(passwordLostScreen.isOneErrorPresent(), "Error in showing the error message text");

        //Check that the Security Questions is displayed for a phone number correct
        passwordLostScreen.sendTelephoneUserValid();
        passwordLostScreen.clickButtonContinuePhone();
        CreateExtetReport.stepsVerifications(passwordLostScreen.isTextSecurityQuestionsPresent(), test1, "showing the Security Questions");
        Assert.assertTrue(passwordLostScreen.isTextSecurityQuestionsPresent(), "Error in showing the Security Questions");
        passwordLostScreen.clickButtonBack();

        //Check that the text phone number is displayed
        passwordLostScreen.clickLinkPhoneHelp();
        Utilities.sleep(4000);
        CreateExtetReport.stepsVerifications(passwordLostScreen.isPresentTextCallPhoneNumber(), test1, "showing the text phone number");
        Assert.assertTrue(passwordLostScreen.isPresentTextCallPhoneNumber(), "Error in showing the text phone number");

    }

}

