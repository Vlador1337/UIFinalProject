### Запуск тестов
```sh
mvn clean test
```

### Построение локального отчета
```sh
mvn allure:serve
```

### Входные данные
Логин и пароль для Jira заполнять в application.properties
или:
```sh
mvn clean test -Dlogin=LOGIN -Dpassword=PASSWORD
```