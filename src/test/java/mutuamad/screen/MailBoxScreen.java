package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.JsonParseData;
import mutuamad.Utilities;
import mutuamad.elements.MailBoxScreenElements;

public class MailBoxScreen extends MailBoxScreenElements {

    public MailBoxScreen(DriverManager driver) {
        super(driver);
    }


    public boolean isTotalMailVisible() {
        return isPresent(totalMailText);
    }

    public void clickSettings() {
        waitForVisible(buttonSettings, 10);
        click(buttonSettings);
    }

    public void clickSearchMail() {
        waitForVisible(searchInput, 10);
        click(searchInput);
    }

    public void sendKeysSearchMail() throws Exception {
        String mail = JsonParseData.get("user", "mail");
        waitForVisible(searchInput, 10);
        sendKeys(searchInput, mail);
        hideKeyboard();
    }

    public void clickSearchCloser() {
        waitForVisible(searchClose, 10);
        click(searchClose);
    }

    public void clickFisrtMail() {
        waitForClick(firstBoxMailBox, 10);
        click(firstBoxMailBox);
    }

    public boolean verifyMoreThanOneUnreadMessage() {
        return isPresent(firstBoxMailBox);
    }

    public boolean isBoxMailVisible() {
        return isPresent(boxMailBox);
    }

    //List Mails
    public boolean isTabAllMessagesVisible() {
        return isPresent(tabAllMessages);
    }

    public boolean isTabnotReadVisible() {
        return isPresent(tabnotRead);
    }

    public boolean isIconMailReadVisible() { return isPresent(iconMailRead); }

    public boolean isImageMailVisible() {
        return isPresent(imageMail);
    }

    public boolean isLabelDateMailVisible() {
        return isPresent(labelDateMail);
    }

    public boolean isLabelTittleMailVisible() {
        return isPresent(labelTittleMail);
    }

    public boolean isLabelSubtittleMailVisible() {
        return isPresent(labelSubtittleMail);
    }



    public void clickTabAll() {
        //waitForClick(tabAll, 10);
        click(tabAllMessages);
    }

    public void clickTabnotRead() {
        waitForClick(tabnotRead, 10);
        click(tabnotRead);
    }

    public String getTextNumMessages() {
        waitForVisible(tabAllMessages, 10);
        return getText(tabAllMessages);
    }

    public String getTextTitleMail() {
        waitForVisible(labelTittleMail, 10);
        return getText(labelTittleMail);
    }

    public String getTextDateMail() {
        waitForVisible(labelDateMail, 10);
        return getText(labelDateMail);
    }

    public void deleteFirstMail() {
        scrollElementToRight(firstBoxMailBox);
        Utilities.sleep(2000);
        tapEndElement(firstBoxMailBox);
    }

    //Cross Sell
    public boolean isBoxPropensitylVisible() {
        return isPresent(boxPropensity);
    }
    public boolean isLabelPropensityTitleVisible() {
        return isPresent(labelPropensityTitle);
    }
    public boolean isLabelPropensityDescriptionVisible() {
        return isPresent(labelPropensityDescription);
    }
    public boolean isLabelPropensityActionVisible() {
        return isPresent(labelPropensityAction);
    }


    //Detail Mail
    public boolean isLabelTitleDetailVisible() { return isPresent(labelTitleDetail); }
    public boolean isLabelDetailImageVisible() { return isEnabled(labelDetailImage); }
    public boolean isLabelDetailDateTextVisible() { return isPresent(labelDetailDate); }
    public boolean isLabelDetailTitleTextVisible() { return isPresent(labelDetailTitle); }
    public boolean isLabelDetailSubtitleTextVisible() { return isEnabled(labelDetailSubtitleText); }
    public boolean isLabelDetailTextVisible() { return isPresent(labelDetailText); }

    public void clickButtonMail() {
        waitForClick(buttonDetailMail, 10);
        click(buttonDetailMail);
    }

    public String getTextTitleDetail() {
        waitForVisible(labelTitleDetail, 10);
        return getText(labelTitleDetail);
    }

    //Part
    public boolean isTitlePolicyVisible() {
        return isPresent(partTitlePolicyText);
    }
    public boolean isIconVisible() {
        return isPresent(partIcon);
    }
    public boolean isPartDetailVisible() {
        return isPresent(partDetailText);
    }
    public boolean isPartHistoryVisible() {
        return isPresent(partHistory);
    }
    public boolean isPartButtonMoreInfoVisible() {
        return isPresent(partButtonMoreInfo);
    }

    public void clickAddDocumentation() {
        waitForClick(partButtonMoreInfo, 10);
        click(partButtonMoreInfo);
    }

}
