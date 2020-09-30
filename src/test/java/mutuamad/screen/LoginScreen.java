package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.JsonParseData;
import mutuamad.Utilities;
import mutuamad.elements.LoginScreenElements;

public class LoginScreen extends LoginScreenElements {

    public LoginScreen(DriverManager driver) {
        super(driver);
    }

    public void clickClose(){
        click(iconClose);
    }

    public void setTextLoginUsername(String tipo) throws Exception{
        String user = JsonParseData.get("user", "nif_nie_"+tipo);
        waitForVisible(textLoginUsername, 5);
        sendKeys(textLoginUsername, user);
        Utilities.sleep(2000);
    }

    public void setTextPassword () throws Exception {
        String password = JsonParseData.get("user", "password");
        waitForVisible(textPassword, 5);
        sendKeys(textPassword, password);
        Utilities.sleep(2000);
    }

    public void clickButtonLogin() {
        waitForClick(btnLogin, 10);
        click(btnLogin);
    }

    public void clickLostPasswordLink() {
        waitForClick(lostPassword, 10);
        isPresent(lostPassword);
        click(lostPassword);
    }

    public boolean verificErrorMessaeIsShown(){
        return isPresent(errorMessageTittle);
    }

    public void clickAceptarButton(){
        click(btnAceptar);
    }
    public void clickIniciarSesionDespues(){
        click(iniciarSesioDespues);
    }

    //Notifications
    public boolean verificNotificationScreenIsShown(){
        return isPresent(notificationsLabel);
    }
    public void closeNotificationsScreen(){
        click(ahoraNoNotification);
    }

    //Cuidamos de ti
    public boolean verificWeTakeCareOfYouTitleLabel(){
        return isPresent(weTakeCareOfYouTitleLabel);
    }

    //Tarjeta
    public boolean verificCardTitleLabel(){
        return isPresent(cardTitleLabel);
    }

}
