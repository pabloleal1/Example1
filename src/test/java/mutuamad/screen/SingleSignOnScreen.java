package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.elements.SingleSignOnScreenElements;

public class SingleSignOnScreen extends SingleSignOnScreenElements {

    public SingleSignOnScreen(DriverManager driver) {
        super(driver);
    }


    public void clickClose() {
        waitForClick(buttonCloseSSO, 10);
        click(buttonCloseSSO);
    }

    public boolean verificViewPartsSSO() {
        return isEnabled(viewPartsSSO);
    }

    public void scrollViewSSO() {
         scrollTo(textTitleDiscount, textTitle);
    }

    public String getTextTittleFromSSo(){
        return textTitle.getText();
    }
}
