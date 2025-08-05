package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class test {
    @Test
    public void a() throws InterruptedException {
        Configuration.holdBrowserOpen=true;
        open("https://www.google.com");
        // Locate and interact
        $("[name='q']").setValue("Selenide").pressEnter();
        Thread.sleep(15000);
        $("#search").shouldHave(text("selenide.org"));

    }

    @Test
    public void googletitieltest(){
        Configuration.browser="chrome";
  //      Configuration.holdBrowserOpen=true;
        open("https://www.google.com");

        String expectedTitle="Google";
        String actualTitle=title();

        assert actualTitle.equals(expectedTitle):"title mismatched";
       Selenide.closeWebDriver();
    }

    @Test
    public void searchbuttontext(){
        Configuration.browser="chrome";
        open("https://www.google.com");

        $("input[name='btnK']").shouldHave(attribute("value","Google Search"));

    }
    @Test
    public void countresults(){
        Configuration.browser="chrome";
    Configuration.holdBrowserOpen=true;
        open("https://www.google.com");

        $("#APjFqb").setValue("Selenide automation").pressEnter();

        $$("h3").shouldHave(sizeGreaterThan(5));
    }
}
