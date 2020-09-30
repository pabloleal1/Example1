package com.atsistemas.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Screen {

    protected Logger logger = Logger.getLogger(Screen.class.getName());
    protected static int WAIT_SECONDS = 15;
    protected AppiumDriver driver;
    private long startTimeBlock;
    private boolean showPath = false;

    protected Screen(DriverManager driver) {
        this.driver = driver.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver()), this);
    }

    // LOG -> [EVENT] [PATH] [TIME]
    public void click(MobileElement element) {
         element.click();
        System.out.println("[CLICK] [" + element.toString() + "] [0]");
    }

    /*  public void tap(By by) {
        driver.tap(1, driver.findElement(by), 100);
        System.out.println("Tapped: " + driver.findElement(by).toString());
    }*/

    public void tapElementCoordinates(MobileElement element) {
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        int eWidth = (int) (element.getSize().getWidth()*0.2);
        int eHeight = element.getSize().getHeight()/2;
        (new TouchAction(driver)).tap(PointOption.point(x+eWidth, y+eHeight)).perform();
        System.out.println("[TAP_COORDINATES] ["+ x +"::"+ y +"]");
    }

    public void sendKeys(MobileElement element, String text) {
        try {
            element.clear();
        }catch (Exception ex){}

        element.sendKeys(text);
        hideKeyboard();
        System.out.println("[SEND_TEXT] [" + text + "] [" + element.toString() + "]");
    }

    public void sendKeysWithEnter(MobileElement element, String text) {
        element.sendKeys(text + "\n");
        System.out.println("[SEND_TEXT] [" + text + "] [" + element.toString() + "]");
        //System.out.println("+ The text \"" + text + "\" was sent to " + driver.findElement(by).toString());
    }

    public void sendKeysElement(WebElement element, String text) {
        element.sendKeys(text);
        System.out.println("[SEND_TEXT_ELEMENT] [" + text + "] [" + element.toString() + "]");
    }

    public String getText(MobileElement element) {
        String text=element.getText();
        System.out.println("[GET_TEXT] [" +  text + "] [" + element.toString() + "]");
        return text;
    }

    public String getTextElement(WebElement element) {
        String text=element.getText();
        System.out.println("[GET_TEXT_ELEMENT] [" + text + "] [" + element.toString() + "]");
        return text;
    }

    public void loadUrl(String url) {
        driver.get(url);
    }

    public String text(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * Scroll down.
     */
    //public void scrollDown() {
        //Appium <1.6.3
//		No scroll
        //Appium >1.6.4
        //     driver.
    //}

    /**
     * Wait for visible.
     *
     * @param element  the element
     * @param waitTime the wait time
     */

    public void waitForVisible(MobileElement element, int waitTime) {
        long startTime = System.currentTimeMillis();
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception ex){ }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("[WAIT_VISIBLE] [" + element.toString() + "] [" + totalTime + "]");
    }

    /**
     * Wait for click.
     *  @param element  the element
     * @param waitTime the wait time
     */

    public void waitForClick(MobileElement element, int waitTime) {
        long startTime = System.currentTimeMillis();
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception ex){ }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("[WAIT_CLICK] [" + element.toString() + "] [" + totalTime + "]");
    }

    /**
     * Clear field.
     *
     * @param element the element
     */
    public void clearField(MobileElement element) {
        element.clear();
        System.out.println("[CLEAR_TEXT] Cleared text element: " + element.toString());
    }

    /**
     * Checks if is present.
     *
     * @param element the element
     * @return true, if is present
     */
    public boolean isPresent(MobileElement element) {
        try {
            boolean presence = element.isDisplayed();
            System.out.println("Checking presence of [" + element.toString() + "]. Is present: <" + presence + ">");
            return presence;
        }catch (Exception e){
            return false;
        }

    }

    /**
     * Checks if is enabled.
     *
     * @param element the element
     * @return true, if is present
     */
    public boolean isEnabled (MobileElement element) {
        try{
            boolean enabled = element.isEnabled();
            //System.out.println("Checking presence of [" + by.toString() + "]. Is present: <" + presence + ">");
            return enabled;
        } catch (Exception e){
            return false;
        }
    }

    // Device Farm screenshot functionality
    /**
     * Takes device screenshot. Configured for AWS Device Farm.
     * To use on local machine, you must provide local storage; for example: <code> screenshotDirectory = "C:\Desktop\screenshots" </code>
     *
     * @param name the name
     * @return true, if successful
     */

    public boolean takeScreenshot(String name) {
        String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }

    public void startTimeBlock() {
        //System.out.println("Inicio del contador");
        System.out.println("[BLOCK_START]");
        startTimeBlock = System.currentTimeMillis();
    }

    public void hideKeyboard() {
        try {
            if(driver.getCapabilities().getPlatform().is(Platform.LINUX)){
                driver.hideKeyboard();
            }else{
                click((MobileElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText[1]")));
                scrollHidenKeyBoard();
                click((MobileElement) driver.findElement(By.xpath("//XCUIElementTypeToolbar[@name='Toolbar']//XCUIElementTypeButton[last()]")));
                //click((MobileElement) driver.findElement(By.xpath("//XCUIElementTypeStaticText")));
            }
        } catch(Exception e) {}
    }

    public void endTimeBlock() {
        if (startTimeBlock == 0) {
            //System.err.println("No se puede calcular el tiempo, mira si se ha invocado startTimeBlock");
            System.out.println("[BLOCK_END] [-1]");
            return;
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTimeBlock;
        //System.out.println("endTimeBlock " + totalTime + " milisegundos");
        System.out.println("[BLOCK_END] [" + totalTime + "]");
    }

     /**
     * Slide page to the right
     *
     */
    public void slidePageRight() {
        TouchAction drag = new TouchAction(driver);
        drag.press(PointOption.point(770, 770));
        drag.moveTo(PointOption.point(-405, 25));
        drag.release();
        drag.perform();
        System.out.println("[SLIDE_PAGE_RIGHT]");
    }
    /**
     * Slide page to the Right
     *
     */
    public void scrollLeft() {
       // TouchAction tAction = new TouchAction(driver);
        Dimension size= driver.manage().window().getSize();
        int width_start=(int)(size.width*0.9);
        int width_end=(int)(size.width*0.01);
        int height=(size.height/2);

        //tAction.press(PointOption.point(width_start, height)).moveTo(PointOption.point(width_end, height)).release().perform();
        TouchAction tAction = new TouchAction(driver)
                .press(PointOption.point(width_start, height))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(width_end, height))
                .release();
        tAction.perform();

        System.out.println("[SCROLL_LEFT] ["+ width_start +"::"+ width_end +"::"+ height +"]");
    }
    /**
     * Slide page to the Down
     *
     */
    public void scrollDown() {
        Dimension size= driver.manage().window().getSize();
        int width=(size.width/2);
        int heightx=(int)(size.height*0.9);
        int heighty=(int)(size.height*0.1);
        TouchAction tAction = new TouchAction(driver)
                .press(PointOption.point(width, heightx))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(width, heighty))
                .release();
        tAction.perform();
        System.out.println("[SCROLL_DOWN] ["+ width +"::"+ heightx +"::::"+ heighty +"]");

    }
    /**
     * Slide page from hidenkeyboard iOS
     *
     */
    public void scrollHidenKeyBoard() {
        Dimension size= driver.manage().window().getSize();
        int width=(size.width/2);
        int heightx=(int)(size.height*0.2);
        int heighty=(int)(size.height*0.1);
        TouchAction tAction = new TouchAction(driver)
                .longPress(PointOption.point(width, heightx))
                .moveTo(PointOption.point(width, heighty))
                .release();
        tAction.perform();
        System.out.println("[SCROLL_HIDENKEYBOARD_IOS] ["+ width +"::"+ heightx +"::::"+ heighty +"]");

    }
    /**
     * Slide page to the Up
     *
     */
    public void scrollUp()  {
        Dimension size= driver.manage().window().getSize();
        int width=(size.width/2);
        int heightx=(int)(size.height*0.2);
        int heighty=(int)(size.height*0.9);
        TouchAction tAction = new TouchAction(driver)
                .press(PointOption.point(width, heightx))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(width, heighty))
                .release();
        tAction.perform();
        System.out.println("[SCROLL_UP] ["+ width +"::"+ heightx +"::"+ heighty +"]");
    }
    /**
     * Slide page to
     *
     */
    public void scrollTo(MobileElement elementpoint1, MobileElement elementpoint2) {
        TouchAction dragNDrop = new TouchAction(driver)
                .press(element(elementpoint1))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(element(elementpoint2))
                .release();
        dragNDrop.perform();
        System.out.println("[SCROLL_TO] ["+elementpoint1.toString()+"] ["+elementpoint2.toString()+"]");
    }
    /**
     * Slide element to right
     *
     */
    public void scrollElementToRight(MobileElement element) {
        TouchAction dragNDrop = new TouchAction(driver);

        int widthstart=(element.getLocation().x);
        int widthend=50;
        int height=(element.getLocation().y);
        dragNDrop.press(PointOption.point(widthstart, height))
                .waitAction()
                .moveTo(PointOption.point(widthend, height))
                .release().perform();
        System.out.println("[SCROLL_ELEMENT_TO_RIGHT] ["+widthstart+"] ["+widthend+"] ["+height+"]");
    }
    /**
     * Tap end element(by delete mailbox)
     *
     */
    public void tapStartElement(MobileElement element) {
        int width=element.getLocation().x;
        int medHeight=element.getSize().height/2;
        int height=element.getLocation().y;
        TouchAction tapAction = new TouchAction(driver);
        tapAction.tap(PointOption.point(width, height+medHeight)).perform();

        System.out.println("[TAP_START_ELEMENT] ["+width+"] ["+height+"] ["+medHeight+"]");
    }
    /**
     * Tap end element(by delete mailbox)
     *
     */
    public void tapEndElement(MobileElement element) {
        int width=element.getSize().width+10;
        int height=element.getLocation().y+10;
        TouchAction tapAction = new TouchAction(driver);
        tapAction.tap(PointOption.point(width, height)).perform();
        System.out.println("[TAP_END_ELEMENT] ["+width+"] ["+height+"]");
    }
    /**
     * Tap end screen
     *
     */
    public void tapEndScreen() {
        Dimension size= driver.manage().window().getSize();
        int width=size.width/2;
        int height=(int)(size.height*0.95);

        TouchAction tapAction = new TouchAction(driver);
        tapAction.tap(PointOption.point(width, height)).perform().release();

        System.out.println("[TAP_END_SCREEN] ["+width+"] ["+height+"]");
    }
    /**
     * Tap end screen
     *
     */
    public void tapStartScreen() {
        Dimension size= driver.manage().window().getSize();
        int width=size.width/2;
        int height=(int)(size.height-(size.height*0.95));

        TouchAction tapAction = new TouchAction(driver);
        tapAction.tap(PointOption.point(width, height)).perform().release();

        System.out.println("[TAP_START_SCREEN] ["+width+"] ["+height+"]");
    }
    /**
     * Tap Element Next To
     *
     */
    public void tapElementNextTo(MobileElement element) {
        int width=element.getLocation().x;
        int sizeWidth=element.getSize().width/2;
        int height=element.getLocation().y;
        int sizeHeight=element.getSize().height;
        sizeHeight= sizeHeight+ (sizeHeight/2);

        TouchAction tapAction = new TouchAction(driver);
        tapAction.tap(PointOption.point(width+sizeWidth, height+sizeHeight)).perform();

        System.out.println("[TAP_ELEMENT_NEXT_TO] ["+width+"] ["+height+"] ["+sizeWidth+"] ["+sizeHeight+"]");
    }
    /**
     * Slide page
     *
     */
    public void scrollPage() {
        TouchAction tAction = new TouchAction(driver);
        Dimension size= driver.manage().window().getSize();
        int width_start=(size.width/2);
        int height_start=(int)(size.height*0.9);
        int height_startneg=(int)(size.height*-0.7);
        tAction.longPress(PointOption.point(width_start, height_start)).waitAction().moveTo(PointOption.point(5, height_startneg)).perform().release();
        System.out.println("[SCROLL_PAGE] ["+width_start +"::"+ height_start+"]");
    }
    /**
     * Search selected item
     * Return next element
     */
    public WebElement searchNexElement(By byContainer, String TextSearch) {
        List rows = driver.findElements(byContainer);
        Iterator<WebElement> i = rows.iterator();
        WebElement row = null;
        while (i.hasNext()) {
            row = i.next();
            if (row.getText().equals(TextSearch)) {
                WebElement rownex = i.next();
                System.out.println("[SEARCH_NEX_ELEMENT] ["+ TextSearch +"] ["+ byContainer +"] [1]");
                return rownex;
            }
        }
        System.out.println("[SEARCH_NEX_ELEMENT] ["+ TextSearch +"] ["+ byContainer +"] [2]");
        return row;
    }
    /**
     * Search Text No Clickable
     *
     */
    public void searchTextWithoutClick(String textsearch){
        driver.findElement(By.xpath("//*[@text='"+ textsearch +"']"));
    }

    /**
     * Search Contains Text Clikable
     *
     */
    public void searchText(String textsearch){
        driver.findElement(By.xpath("//*[@text='"+ textsearch +"']")).click();
    }

    /**
     * Take Screen Shot
     *
     */
    public void takeScreenShot(){
        try {
            String folder_name="./src/test/resources/screenshot";
            File src = driver.getScreenshotAs(OutputType.FILE);
            SimpleDateFormat df = new  SimpleDateFormat("dd-MM-yyyy_hh-mm-ssaa");
            new File(folder_name).mkdir();
            String file_name=df.format(new Date())+".png";

            FileUtils.copyFile(src, new File(folder_name + "/" + file_name));
            System.out.println("[SCREEN_SHOT] [" + file_name + "]");
        } catch (IOException e) {
            System.out.println("[SCREEN_SHOT] [ERROR] [" + e + "]");
        }
    }

    /**
     * Click on the first element of a webElement list
     * @param element
     */

    public void clickFirstElementList(MobileElement element, String text) {
        System.out.println("[clickFirstElementList]");
        WebElement option;
        boolean found = false;
        List<WebElement> list = (List<WebElement>) element;

        for (int i=0; i<list.size() && !found ;i++) {
            option = list.get(i);
            if (option.getText().contains(text)) {
                found = true;
                option.click();
                System.out.println("[CLICK_FIRST_ELEMENT] [" + option.toString() + "]");
            }
        }
    }

    public void clickElementPresent(By by) {
        WebElement element;
        boolean found = false;
        List<WebElement> list = driver.findElements(by);

        for (int i=0; i<list.size() && !found ;i++) {
            element = list.get(i);
            System.out.println(">>>>>>>>>>>>>>> ELEMENT INDEX : " + i + " ------ IS_DISPLAYED : " + element.isDisplayed() + "----- IS_ENABLED : " + element.isEnabled());
            if (element.isEnabled()) {
                found =  true;
                element.click();
            }
        }
    }

    public Integer countElementsList(List<MobileElement> elements) {
        return elements.size();
    }

}
