import hooks.WebHooks;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static page_object.page_steps.AuthPageSteps.*;
import static page_object.page_steps.JiraHeaderPageSteps.*;
import static page_object.page_steps.TasksPageSteps.*;
import static page_object.page_steps.TestSelenium_bugPageSteps.*;
import static utils.Configuration.getConfigurationValue;
import static utils.Const.*;

@Epic("Jira")
public class JiraTests extends WebHooks {

    @BeforeEach
    public void start() {
        openUrl(getConfigurationValue(JIRA_URL));
        auth(getConfigurationValue(LOGIN), getConfigurationValue(PASSWORD));
    }

    @Feature(value = "Авторизация")
    @Test
    @DisplayName("Авторизация")
    public void loginTest() {
        checkProfileLogo();
    }

    @Feature(value = "Проверка на наличие задач")
    @Test
    @DisplayName("Проверка на наличие задач")
    public void tasksNumberCheckTest() {
        openTestProject();
        checkTasksNumber();
    }

    @Feature(value = "Проверка статуса задачи " + TASK_NAME)
    @Test
    @DisplayName("Проверка статуса задачи " + TASK_NAME)
    public void statusTaskTest() {
        searchTask(TASK_NAME);
        checkStatusTask();
    }

    @Feature(value = "Проверка версии задачи " + TASK_NAME)
    @Test
    @DisplayName("Проверка версии задачи " + TASK_NAME)
    public void versionsAffectedTaskTest() {
        searchTask(TASK_NAME);
        checkVersionsAffected();
    }

    @Feature(value = "Создание ошибки")
    @Test
    @DisplayName("Создание ошибки")
    public void createTaskTest() {
        createTask();
        checkChangeStatus("СДЕЛАТЬ");
    }

    @Feature(value = "Создание ошибки и перевод по статусам")
    @Test
    @DisplayName("Создание ошибки и перевод по статусам")
    public void changeTaskStatusTest() {
        createTask();
        changeStatus();
        checkChangeStatus("ГОТОВО");
    }
}