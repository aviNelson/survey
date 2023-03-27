
 <br/>
<p align="center">
  <h3 align="left">Survey</h3>

  <p align="left">
    Приложение для создания и прохождения опросов.
    <br/>
    <br/>
  </p>
</p>

![Contributors](https://img.shields.io/github/contributors/AviNelson/microservices-project?color=dark-green) ![Issues](https://img.shields.io/github/issues/AviNelson/microservices-project) 

## Оглавление

* [О проекте](#о-проекте)
* [Стек](#стек)
* [Установка](#установка)
* [Пример использования](#пример-использования)

## О проекте

Приложение для создания и прохождения опросов.

## Стек

* Java 11
* Spring Boot
* Spring Data JPA
* Spring MVC
* Spring Security
* PostgreSQL
* SQL
* Docker compose
* Jib
* Gradle
* Liquibase
* Swagger

### Установка

1. Клонировать репозиторий

```sh
git clone https://github.com/aviNelson/survey.git
```

2. В корневой папке проекта запустить

```sh
docker compose up
```

3. После этого будут скачаны docker-image's с docker-hub и приложение запустится

## Пример использования


Админ может: создавать опрос, добавлять вопросы в опрос, добавлять варианты ответов в вопрос.
Пользователь может: зарегистрироваться и проходить опросы под своей учетной записью, получить сводку пройденых опросов с отображением по выбранным ответам.



