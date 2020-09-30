package mutuamad.test;

import com.atsistemas.appium.CreateExtetReport;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import mutuamad.process.CP0;
import mutuamad.process.CP1;
import mutuamad.screen.ConfigurationScreen;
import mutuamad.screen.ContactDataScreen;
import mutuamad.screen.WelcomeScreen;
import org.testng.annotations.Test;


public class Test_15_02 extends CreateExtetReport {

    @Test
    public void Editar_Contacto_Telefono() throws Exception {

        //Test user
        String User_Standars= "AutoInsurance";

        //Initialize variables
        CP0 cp0 = new CP0(driverManager);
        CP1 cp1 = new CP1 (driverManager);
        WelcomeScreen welcomeScreen = new WelcomeScreen(driverManager);
        ContactDataScreen dataContact = new ContactDataScreen(driverManager);
        ConfigurationScreen configurationScreen = new ConfigurationScreen(driverManager);
        String mail;

        //Initialize report
        test1 = extent.createTest(this.getClass().getSimpleName(), "Editar datos de contacto telefono");
        test1.log(Status.INFO, "Starting test");

        //Cancel notifications and access to Login
        cp0.execute(test1);

        //Login
        cp1.execute(User_Standars, test1);

        //Create Node for Reports
        ExtentTest node2 = test1.createNode("Steps - Editar Contacto - Telefono");

        //TEST START .- Changing Phone Data Contac tMail Checked .- Going to the menu screen
        welcomeScreen.clickButtonMenu();
        // Going to the options setting
        welcomeScreen.clickOptionSettings();
        // Going to the data contact screen
        configurationScreen.clickButtonContactData();
        // Get the phone number
        mail = dataContact.getTextMail();
        // Clear mail field
        dataContact.ClearMailField();
        // Set the new mail
        dataContact.setTextMail("emailPruebas@hotmail.com");
        //  clicking on the save button
        dataContact.clickButtonSaveChanges();
        //Closing te modal window
        dataContact.clickCloseModalWindow();
        //Check the postal code or
        dataContact.verifiChecks();
        // Clear mail field
        System.out.println("Entra");
        dataContact.ClearMailField();
        // Set the older mail
        dataContact.setTextMail(mail);
        //  clicking on the save button
        dataContact.clickButtonSaveChanges();
        //Closing te modal window
        dataContact.clickCloseModalWindow();
        node2.log(Status.INFO, "Steps completely successfully");

    }
}
