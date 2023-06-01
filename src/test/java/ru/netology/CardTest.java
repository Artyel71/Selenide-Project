package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardTest {



    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    @Test
    void shouldTestSomething() {
        String planningDate = generateDate(3);

        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue("Джек Дэниэлс");
        $("[name='phone'").setValue("+73456789997");
        $("[data-test-id=agreement").click();
        $(byClassName("button")).click();
        $(withText("Встреча")).shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);

    }
}
