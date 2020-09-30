package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import mutuamad.Utilities;
import mutuamad.elements.MyInsuranceScreenElements;

public class MyInsuranceScreen extends MyInsuranceScreenElements {

    public MyInsuranceScreen(DriverManager driver) {
        super(driver);
    }


    public boolean verifyAmazonLogoIsShown() {
        boolean verify = false;
        Utilities.sleep(12000);

         try
         {
            while (!isPresent(amazonLogo))
            {
                if (!verify)
                {
                    click(secondInsurance);
                }
                else
                {
                    click(nextInsurance);
                }
                verify=true;
            }
        return true;
        }
         catch (Exception exe)
        {
            return false;
        }
    }

    public void clickButtonClose() {
        driver.navigate().back();
    }

}
