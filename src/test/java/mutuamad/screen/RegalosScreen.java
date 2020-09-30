package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import io.appium.java_client.MobileElement;
import mutuamad.elements.AdvantageScreenElements;
import mutuamad.elements.RegalosScreenElements;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;

public class RegalosScreen extends RegalosScreenElements {

    public RegalosScreen(DriverManager driver) {
        super(driver);
    }


    //Ventaja
    public String ventaja_Tittle_Text() {
        return getText(titulo_Ventaja);
    }

    public void click_Btn_Ventaja() {
        click(btn_Ventaja);
    }

    //Mis seguros - Regalos
    public boolean verify_cintillo_Is_Shown() {
        return isPresent(cintillo);
    }


}
