package mutuamad.screen;

import com.atsistemas.appium.DriverManager;
import com.atsistemas.appium.JsonParseData;
import mutuamad.elements.FrequentQuestionsScreenElements;

public class FrequentQuestionsScreen extends FrequentQuestionsScreenElements {

    public FrequentQuestionsScreen(DriverManager driver) {
        super(driver);
    }


    public void sendTextQuestion() throws Exception {
        String questionText = JsonParseData.get("questions", "questionText");
        waitForVisible(editTextQuestion, 5);
        sendKeysWithEnter(editTextQuestion, questionText);
    }

    public void clicFirstQuestionText() {
        waitForClick(firstQuestionText, 10);
        click(firstQuestionText);
    }

    public void clicSecondQuestionText() {
        click(secondQuestionText);
    }

    public void clicThirdQuestionText() {
        click(thirdQuestionText);
    }

    public void clicFourthQuestionText() {
        click(fourthQuestionText);
    }

}
