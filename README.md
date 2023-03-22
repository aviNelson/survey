Приложение для прохождения опросов.

Админ может: создавать опрос, добавлять вопросы в опрос, добавлять варианты ответов в вопрос.
Пользователь может: зарегистрироваться и проходить опросы под своей учетной записью, получить сводку пройденых опросов с отображением по выбранным ответам.

Стек:
 Java 11, Spring Boot, Spring Security, Spring MVC, Spring Data JPA, Docker compose, SQL(Postgresql), Liquibase, Swagger, Gradle.
 
В docker compose файле уже прописаны нужные docker image ,ничего дополнительно билдить не нужно, так как приложение собрано в docker image через Dockerfile.
Для запуска проекта требуется из корневой папки проекта запустить команду docker compose -up, будут загружены docker image из docker hub.
 