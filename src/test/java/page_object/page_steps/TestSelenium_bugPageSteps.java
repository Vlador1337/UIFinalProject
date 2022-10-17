package page_object.page_steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static page_object.page_elements.TestSelenium_bugPageElem.status;
import static page_object.page_elements.TestSelenium_bugPageElem.versionsAffected;

public class TestSelenium_bugPageSteps {

    @Step("Проверка статуса в задаче TestSelenium_bug")
    public static void checkStatusTask() {
        String statusTask = status.shouldBe(visible).text();
        assertEquals("СДЕЛАТЬ", statusTask, "Статус отличается от ожидаемого");
    }

    @Step("Проверка версии в задаче TestSelenium_bug")
    public static void checkVersionsAffected() {
        String versionTask = versionsAffected.shouldBe(visible).text();
        assertEquals("Version 2.0", versionTask, "Версия отличается от ожидаемой");
    }
}
