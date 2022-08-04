package guru.qa;

import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestOnSiteGit {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://github.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }


    @Test
    public void checkCodeEntryJunit5(){

        //открываем страницу Selenide в Github
        open("/selenide/selenide");

        //переходим в раздел Wiki проекта
        $("#wiki-tab").click();

        //проверяем, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));

        //открываем страницу SoftAssertions, проверяем что внутри есть пример кода для JUnit5
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
