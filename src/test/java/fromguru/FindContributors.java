package fromguru;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FindContributors {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void firstContributorShouldBeSolntsev(){
        open("https://github.com/selenide/selenide");
        $(".BorderGrid")
                .$(withText("Contributors"))
                .closest("div")
                .$("ul li").shouldBe(visible).hover();

        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

    }

}
