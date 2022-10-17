package page_object.page_steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import page_object.page_elements.JiraHeaderPageElem;

import static com.codeborne.selenide.Condition.visible;

public class JiraHeaderPageSteps extends JiraHeaderPageElem {

    @Step("Открытие проекта")
    public static void openTestProject() {
        tasksButton.click();
        tasksSearchButton.shouldBe(visible).click();
    }

    @Step("Поиск задачи {task}")
    public static void searchTask(String task) {
        searchField.sendKeys(task + Keys.ENTER);
    }

    @Step("Открытие окна создания задачи и заполнение необходимых полей")
    public static void createTask() {
        createBugReportButton.shouldBe(visible).click();
        issueType.shouldBe(visible).click();
        issueType.sendKeys("Ошибка" + Keys.ENTER);
        summaryInput.shouldBe(visible).click();
        descriptionButton.shouldBe(visible).click();
        summaryInput.setValue("Тест");
        description.setValue("Описание");
        version.click();
        assignOnMe.click();
        createIssueSubmit.shouldBe(visible).click();
        tasksButton.shouldBe(visible).click();
        reportedByMeTasks.shouldBe(visible).click();
    }
}
