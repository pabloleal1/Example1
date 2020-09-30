package com.atsistemas.appium;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.ArrayList;

public class Process {

    protected DriverManager driver;
    private ArrayList<Exception> errors = new ArrayList<>();

    protected Process(DriverManager driver) {
        this.driver = driver;
    }

    public void addError(Exception e){
        errors.add(e);
    }

    public void resetErrors(){
        errors.clear();
    }

    public void finish(){
        if(!errors.isEmpty()){
            for(Exception e : errors){
                e.printStackTrace();
            }

        }
    }

    static String screenShot(AppiumDriver driver, String name) throws Exception {
        try{
            System.out.println("[ScreenShot]");
            String folderName="src/test/resources/screenShot";
            String fileName = name+".png";
            String pathName =   "../screenShot/" + fileName;
            File fileScreenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            new File(folderName).mkdir();
            FileUtils.copyFile(fileScreenShots, new File(folderName + "/" + fileName));
            return pathName;
        } catch (Exception ex){
            return "./";
        }

    }




}
