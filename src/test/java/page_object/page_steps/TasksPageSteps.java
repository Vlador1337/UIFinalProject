package page_object.page_steps;

import io.qameta.allure.Step;
import page_object.page_elements.JiraHeaderPageElem;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static page_object.page_elements.TasksPageElem.*;
import static page_object.page_elements.TestSelenium_bugPageElem.status;

public class TasksPageSteps extends JiraHeaderPageElem {

    @Step("Проверка наличия задач")
    public static void checkTasksNumber() {
        String number = tasksNumber.text();
        int tasksNumber = Integer.parseInt(number.substring(number.lastIndexOf(" ")).trim());
        assertTrue(0 < tasksNumber, "Задач не обнаружено");
    }

    @Step("Проверка статуса задачи - {taskStatus}")
    public static void checkChangeStatus(String taskStatus) {
        tasksButton.shouldBe(visible).click();
        openTasksButton.shouldBe(visible).click();
        assertEquals(taskStatus, status.shouldBe(visible).text(), "Статус отличается от ожидаемого");
    }

    @Step("Перевод задачи в статус В РАБОТЕ, затем в статус ВЫПОЛНЕНО")
    public static void changeStatus() {
        tasksButton.shouldBe(visible).click();
        reportedByMeTasks.shouldBe(visible).click();
        needToDoStatus.shouldBe(visible).click();
        inWorkStatus.shouldBe(visible).click();
        closedStatusDropdown.shouldBe(visible, Duration.ofSeconds(10)).click();
        closedStatus.shouldBe(visible, Duration.ofSeconds(10)).click();
    }
}
