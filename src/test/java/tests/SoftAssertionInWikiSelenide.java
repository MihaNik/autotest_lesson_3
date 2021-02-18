package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionInWikiSelenide {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertionShouldContainJunit5(){
        open("https://github.com/selenide/selenide");
        $("li a[data-tab-item='i4wiki-tab']").click();
        $$("div#wiki-pages-box li a").findBy(text("SoftAssertions")).click();
        $x("//li[text()='Using JUnit5 extend test class:']//parent::ol")
                .sibling(0)
                .shouldHave(cssClass("highlight-source-java"));
    }
}
