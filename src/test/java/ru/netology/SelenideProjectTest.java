package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideProjectTest {


    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
       // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
      //  ChromeOptions options = new ChromeOptions();
       // options.addArguments("--disable-dev-shm-usage");
      //  options.addArguments("--no-sandbox");
      //  options.addArguments("--headless");
       // driver = new ChromeDriver(options);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestForm() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE));
        $("[data-test-id=date] input").setValue("15.06.2023");
        $("[data-test-id=name] input").setValue("Тарусов Иван");
        $("[data-test-id=phone] input").setValue("+78966554432");
        $("[data-test-id=agreement]").click();
        $(byClassName("button")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }
}

