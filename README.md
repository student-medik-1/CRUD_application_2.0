# CRUD_application_2.0

<a href="https://www.codefactor.io/repository/github/yhtyyar/crud_application_2.0"><img src="https://www.codefactor.io/repository/github/yhtyyar/crud_application_2.0/badge" alt="CodeFactor" /></a>

Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:

Writer(id,  firstName,  lastName,  List<Post> posts,  Region region)

Post (id,  content,  created,  updated)

Region (id,  name)


# Пользователь в консоли должен иметь возможность:

-создания
 
-получения
 
-редактирования 
 
-удаления данных.
 
 # В качестве хранилища данных необходимо использовать MySQL

# Требования:

1.	Придерживаться шаблона MVC (пакеты model, repository, service, controller, view)

2.	Для миграции БД использовать https://www.liquibase.org/

3.	Сервисный слой приложения должен быть покрыт юнит тестами (junit + mockito).

4.	Для импорта библиотек использовать Maven
 

Результатом выполнения задания должен быть отдельный репозиторий 
который содержит описание задачи, проекта и инструкции запуска 
приложения через командную строку.


# Технологии: 

Java, MySQL, JDBC, Maven, Liquibase, JUnit, Mockito
 
 
 # Инструкция по запуску

    1. Скачать приложение

    2. Распаковать архив

    3. Открыть проект в любом IDE у которого есть JDK 8 (IntelliJ IDEA)

    4. Подключить свою базу данных и убедитесь что все схемы совпадают (Просмотрите пакет repository/jdbc перед запуском)
    
    5. Первым делом запустите файл db.changelog.master.mysql.sql (после создания таблиц переходите на след. пункт) 
 
    6. Запустить класс Runner

