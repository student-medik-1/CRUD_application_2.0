# CRUD_application_2.0

<a href="https://www.codefactor.io/repository/github/yhtyyar/crud_application_2.0"><img src="https://www.codefactor.io/repository/github/yhtyyar/crud_application_2.0/badge" alt="CodeFactor" /></a>

Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:

Writer(id,  firstName,  lastName,  List<Post> posts,  Region region)

Post (id,  content,  created,  updated)

Region (id,  name)


# В качестве хранилища данных необходимо использовать MySQL:

writers.sql 
 
posts.sql 
 
regions.sql


# Пользователь в консоли должен иметь возможность:

-создания
 
-получения
 
-редактирования 
 
-удаления данных.


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

