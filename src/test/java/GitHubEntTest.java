import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubEntTest {

    @BeforeAll
    static void setEnv() {
        baseUrl = ("https://github.com");
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void gitHubEntTest(){
        open(baseUrl);
        $(byText("Solutions")).hover();
        $("nav[aria-label='Global']")
                .findAll("a")
                .filterBy(text("Enterprises"))
                .first()
                .click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform"));


    }
}
