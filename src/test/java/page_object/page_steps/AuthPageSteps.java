package page_object.page_steps;

import io.qameta.allure.Step;
import page_object.page_elements.AuthPageElem;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthPageSteps extends AuthPageElem {

    @Step("Открытие страницы с адресом {url}")
    public static void openUrl(String url) {
        open(url);
    }

    @Step("Авторизация пользователя с логином {login} и паролем {password}")
    public static void auth(String login, String password) {
        loginInput.shouldBe(visible).sendKeys(login);
        passInput.shouldBe(visible).sendKeys(password);
        logInButton.shouldBe(visible).click();
        profileLogo.shouldBe(visible);
    }

    @Step("Проверка видимости иконки пользовательского профиля")
    public static void checkProfileLogo() {
        assertNotNull(profileLogo.shouldBe(visible), "Отсутствует иконка пользовательского профиля");
    }
}