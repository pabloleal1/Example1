package com.atsistemas.appium;

import com.atsistemas.appium.custom.ios.IPAInfo;
import com.atsistemas.appium.custom.ios.IPAReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteTouchScreen;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverManager implements HasTouchScreen {
    private final Properties p;
    private Context contextSelected;

    public enum Context {
        NATIVE, WEBVIEW
    }

     /**
     * The logger.
     */
    private Logger logger = Logger.getLogger(DriverManager.class.getName());

    public static int WAIT_SECONDS = 15;
    protected AppiumDriver driver;
    protected AppiumDriverLocalService service;
    private RemoteTouchScreen touch;
    private DeviceType type;
    private DesiredCapabilities configCapabilities = new DesiredCapabilities();

    private enum DeviceType {
        ANDROID, IOS;

        public Class getType() {
            switch (this) {
                case ANDROID:
                    return AndroidDriver.class;
                case IOS:
                    return IOSDriver.class;
                default:
                    return null;
            }
        }
    }

    public DriverManager() throws Exception {
        String urlConfig = System.getenv("config") != null ? System.getenv("config") : System.getProperty("config");
        if (urlConfig == null || urlConfig.isEmpty()) {
            throw new Exception("Configuración no realizada");
        }

        p = new Properties();
        p.load(new FileReader(urlConfig));
        p.stringPropertyNames();

        for (String keyCap : p.stringPropertyNames()) {
            if (keyCap.contains("capability.")) {
                String key = keyCap.replace("capability.", "");
                String value = p.getProperty(keyCap);
                if (key.equalsIgnoreCase("app")) {
                    value = new File(value).getAbsolutePath();

                }
                configCapabilities.setCapability(key, value);
            }
        }

        // Capabilities parameters
        String appiummIP = p.getProperty("appiumIP");
        String appiummPort = p.getProperty("appiumPort");
        String commandTimeout = p.getProperty("newCommandTimeout");
        if (commandTimeout.equals("")) commandTimeout = "60";

        DesiredCapabilities desiredAppiumCapabilities = new DesiredCapabilities();
        desiredAppiumCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Integer.valueOf(commandTimeout));

        configCapabilities = prepareCapabilities(configCapabilities);

        String udid = System.getProperty("udid");
        if (udid != null && !udid.equals("")) {
            configCapabilities.setCapability("udid", udid);
        }

        AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(desiredAppiumCapabilities)
                .withIPAddress(appiummIP)
                .usingPort(Integer.parseInt(appiummPort));
        service = builder.build();
        service.start();

        // Driver
        if (configCapabilities.getPlatform().is(Platform.LINUX)) {
            driver = new AndroidDriver(service.getUrl(), configCapabilities);
        } else  {
            driver = new IOSDriver(service.getUrl(), configCapabilities);
        }

        if (driver == null) {
            System.out.println("Driver could not be instantiated!");
            throw new Exception("Driver not instantiated");
        } else {
            System.out.println("Driver successfully instantiated.");
            touch = new RemoteTouchScreen(driver.getExecuteMethod());
        }
        driver.manage().timeouts().implicitlyWait(WAIT_SECONDS, TimeUnit.SECONDS);
    }

    private DesiredCapabilities prepareCapabilities(DesiredCapabilities capabilities) throws Exception {
        Map<String, ?> objectMap = capabilities.asMap();
        String platformName = (String) objectMap.get("platformName");
        String app = (String) objectMap.get("app");
        String browserName = (String) objectMap.get(MobileCapabilityType.BROWSER_NAME);

        if (platformName == null || platformName.isEmpty()) {
            if (app != null && !app.isEmpty()) {
                // Debemos obtener un apk, ipa o app
                if (app.endsWith("apk")) {
                    platformName = "Android";
                } else if (app.endsWith("ipa") || app.endsWith("app")) {
                    platformName = "iOS";
                }
                capabilities.setCapability("platformName", platformName);
            }
            if (platformName == null || platformName.isEmpty()) {
                throw new Exception("Se debe informar plataformName");
            }
        }

        type = DeviceType.valueOf(platformName.toUpperCase());
        if (type == DeviceType.ANDROID) {
            if (browserName == null || browserName.isEmpty()) {
                String appPackage = (String) objectMap.get("appPackage");
                String appActivity = (String) objectMap.get("appActivity");
                if (appPackage == null || appPackage.isEmpty()) {
                    try (ApkFile apkFile = new ApkFile(new File(app))) {
                        ApkMeta apkMeta = apkFile.getApkMeta();
                        capabilities.setCapability("appPackage", apkMeta.getPackageName());
                    }
                }
                if (appActivity == null || appActivity.isEmpty()) {
                    throw new Exception("No se ha informado appActivity");
                }
            } else {
                System.out.println("Configurado para lanzar navegador");
            }

        } else if (type == DeviceType.IOS) {
            if (browserName == null || browserName.isEmpty()) {
                if (app.endsWith("ipa")) {
                    IPAReader reader = new IPAReader(app);
                    IPAInfo info = reader.parse();
                    if (capabilities.getCapability("platformVersion") == null) {
                        capabilities.setCapability("platformVersion", info.getPlatformVersion());
                    }
                    if (capabilities.getCapability("bundleId") == null) {
                        capabilities.setCapability("bundleId", info.getBundleIdentifier());
                    }
                    logger.info("getBundleIdentifier " + info.getBundleIdentifier());

                    // udid necesario para dispositivo real
                }
                capabilities.setCapability("showXcodeLog", "true");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("useNewWDA", "true");

            } else {
                logger.info("Configurado para lanzar navegador");
            }
            Map<String, ?> d = capabilities.asMap();
            for (String key : d.keySet()) {
                System.out.println("Key [" + key + "] " + String.valueOf(d.get(key)));
            }
        }
        return capabilities;
    }

    /**
     * Metodo encargado de borrar la app del dispositivo despues de realizar los tests
     */
    public void removeApp() throws Exception {
        String bundleID = null;
        if (driver == null) {
            return;
        }

        // Log screenShot Recording
        if(System.getProperty("screenShotLog").equals("True")) {
            Thread.sleep(4000);
            Process.screenShot(getDriver(),"x");
        }

        //Stop screen recordig
        //stopScreenRecordig();

        Map<String, ?> cap = driver.getCapabilities().asMap();
        switch (type) {
            case ANDROID:
                bundleID = (String) cap.get("appPackage");
                break;
            case IOS:
                bundleID = (String) cap.get("bundleId");
                break;
        }
        if (bundleID != null) {
          driver.removeApp(bundleID);
          System.out.println("[Driver] Remove APP Appium");
        }
    }

    @Override
    public TouchScreen getTouch() {
        return touch;
    }

    @SuppressWarnings("rawtypes")
    public AppiumDriver getDriver() {
        return driver;
    }

    public void quit() throws IOException {
        if (driver != null) {
            driver.quit();
            System.out.println("[Driver] Quit driver Appium");
        }
        if(service.isRunning()){
            service.stop();
            System.out.println("[Service] Stop service Appium");
        }
    }

    public void startScreenRecordig() {
        if(!System.getProperty("recordingLog").equals("True")){
            return;
        }
        try {
            System.out.println("[debug] Start ScreenRecording");
            if (configCapabilities.getPlatform().is(Platform.LINUX)) {
                ((AndroidDriver) driver).startRecordingScreen();
            } else {
                ((IOSDriver) driver).startRecordingScreen();
            }
        } catch (WebDriverException e) {
            if (e.getMessage().toLowerCase().contains("emulator")) {
                System.out.println("[debug-error] Screen recording only works on real devices");
            }
        }
    }

    public void stopScreenRecordig() throws Exception {
        if(!System.getProperty("recordingLog").equals("True")){
            return;
        }

        String recordingPath = new File (".").getCanonicalPath()+"\\src\\test\\resources\\recordingLogs\\";
        new File(recordingPath).mkdir();

        Thread.sleep(2000);
        String recordingBase64 = "";
        if (configCapabilities.getPlatform().is(Platform.LINUX)) {
            recordingBase64 = ((AndroidDriver) driver).stopRecordingScreen();
        } else {
            recordingBase64 = ((IOSDriver) driver).stopRecordingScreen();
        }
        System.out.println("[debug] Stop ScreenRecording");
        byte[] recordingData = DatatypeConverter.parseBase64Binary(recordingBase64);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss");
        File recordingFile = new File(recordingPath+df.format(new Date())+".mp4");
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(recordingFile))) {
            outputStream.write(recordingData);
            System.out.println("[debug] Saved ScreenRecording");
        } catch (IOException e) {
            System.out.println("[debug-error] The ScreenRecording could not be saved");
            e.printStackTrace();
        }
    }
}

