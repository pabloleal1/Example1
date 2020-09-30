package com.atsistemas.appium;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.Platform;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class CreateExtetReport {

    protected static DriverManager driverManager;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    //public static ThreadLocal test = new ThreadLocal();
    public  ExtentTest test1;

    @BeforeClass
    public static void setup() throws Exception {
        driverManager = new DriverManager();
    }

    @BeforeMethod
    public static void initialiceExtentReport() {

        String folderName="src/test/resources/reports";
        new File(folderName).mkdir();
        File extentFile = new File(folderName, "extent_report.html");

        // start reporters
        if(htmlReporter == null)
        {
            htmlReporter = new ExtentHtmlReporter(extentFile);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setReportUsesManualConfiguration(true);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("MUTUA.com");
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName("Automation Report - Mutua Madrileña");
            htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss a");
        }
    }

    @AfterMethod
    public  void TearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE)
        {
            test1.log(Status.FAIL, MarkupHelper.createLabel("Ops! Something went wrong", ExtentColor.PINK));
            test1.log(Status.FAIL, result.getThrowable());
            test1.addScreenCaptureFromPath(Process.screenShot(driverManager.getDriver(), result.getName()),"Imagen");

        }
        else if (result.getStatus() == ITestResult.SKIP)
        {
            test1.log(Status.SKIP, MarkupHelper.createLabel("Test was ignored", ExtentColor.BLUE) );
        }
        else
        {
            test1.log(Status.PASS, MarkupHelper.createLabel("Test passed succesfully", ExtentColor.GREEN));
        }

        extent.flush(); //to write all the test logs to the report file
    }

    @AfterClass
    public static void TearDown_After_Class() throws Exception {
        if (driverManager != null)
        {
            driverManager.removeApp();
            driverManager.quit();
        }
        if(driverManager.getDriver().getCapabilities().getPlatform().is(Platform.LINUX)){
            try{
                Runtime.getRuntime().exec("adb kill-server");
                Runtime.getRuntime().exec("taskkill /F /IM adb.exe");
            } catch (Exception Ignored) {}
        }
    }

    @AfterSuite
    public static void sendMail()throws Exception {

        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("src/test/resources/reports/extent_report.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("extent_report.html");
        attachment.setName("extent_report.html");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthentication("AutomatizacionMutua@gmail.com","Mutua011.");
        email.setSSLOnConnect(true);
        email.addTo("jpleal@atsistemas.com");
        //email.addTo("kjiglesias@atsistemas.com");
        email.setFrom("AutomatizacionMutua@gmail.com");
        email.setSubject("Mutua Madrileña");
        email.setMsg("Here is the reporter you wanted");

        // add the attachment
        //email.attach(attachment);

        // Dropp a mail with the report
        //email.send();
    }

    // Error log reporter
    public static void stepsVerifications( boolean resultado, ExtentTest test1, String mensaje ) {

        if(!resultado)
        {
            test1.log(Status.FATAL, "WARNING.- Step: "+ mensaje);
        }
        else
        {
            test1.log(Status.PASS, "PASS.- Step: "+ mensaje);
        }
    }
    public static void steps_Node_Verifications( boolean resultado, ExtentTest node, String mensaje, ITestResult result ) {

        if(!resultado)
        {
            node.log(Status.FATAL, "WARNING.- Step: "+ mensaje);
        }
        else
        {
            node.log(Status.PASS, "PASS.- Step: "+ mensaje);
        }
    }
}
