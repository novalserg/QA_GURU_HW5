import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.actions;

public class DragNDropTest {

    @BeforeAll
    static void setEnv() {
        baseUrl = ("https://the-internet.herokuapp.com/drag_and_drop");
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragNDropByActionsTest(){ //проверяем через actions
        open(baseUrl);
        WebElement columnA = $("#column-a");
        actions().clickAndHold(columnA).moveByOffset(200, 0).release().perform();
        $$(".column").first().shouldHave(text("B"));


    }

  /*  @Test
    void dragNDropTest() {
        open(baseUrl);
        WebElement columnB = $("#column-b");
        $("column-a").dragAndDropTo(columnB);
        $$(".column").first().shouldHave(text("B"));
    } Работоспособности добиться не удалось*/

}