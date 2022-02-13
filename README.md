# Тестовое задание на позицию Java Junior Developer


## Техническое задание
> Создать REST API которое позволяет создавать, удалять и управлять тасками.
### Details
> ●	Creating a task.

> ●	Getting a task by its identifier. In the response we get a complete description of the task.

> ●	Change task data by its identifier. In the response we get an updated full description of the task.

> ●	You cannot change task id.

> ●	You cannot delete task attributes.

> ●	All changes to tasks must occur atomically. That is, if we change the name of the task, then we should not get an intermediate state during concurrent reading.

> ●	Deleting a task. We can delete the task by its identifier.

> ●	Getting a list of tasks. In the response we get a list of all tasks sorted by modification date.

### Requirements
●	The API must conform to the REST architecture.

●	Do only the server side, you don’t need to do visualization.

●	It should be a Spring Boot application.

●	Maven or Gradle should be used as a build tool.

●	Data should only be stored in memory. You can use any classes of the standard Java library to organize storage. It is not allowed to use any external repositories and databases.

●	At least 30% of the code should be covered by tests (preferably the presence of both unit and integration tests).

●	Submit sources via a public git repository.


## Стек проекта
- Java 11
- Spring Boot 2.6.3
- Gradle
- Docker

## Основные URL
В проекте используется порт 8080, поэтому URL будет такой:
`http://localhost:8080/task/`
### GET запросы
`/task/list` - Выводит массив со всеми созданными тасками в порядке уменьшения ID

`/task/get?id={ID нужной таски}` - Выводит таску по запрашиваемому ID.
> ID - Обязательный параметр

`/task/edit?id={ID нужной таски&name={Новое имя}&description={Новое описание}` - Позволяет по ID таски изменить её имя или описание.
> ID - Обязательный параметр

> Name - Необязательный параметр

> Description - Необязательный параметр

`/task/create?name={Нужное имя}&description={нужное описание}` - Создает таску с указанным именем и описанием
> Name - Необязательный параметр

> Description - Необязательный параметр

`/task/delete?id={ID нужной таски}` - Удаляет таску по ID
> ID - Обязательный параметр
## Установка и запуск
## Docker
### Создать локально образ
Необходимо в корневой папке с проектом написать:
`docker build -t task:manager .`
И после запустить данной командой:
`docker run -p 8080:8080 task:manager`
### Получить образ с hub.docker.com
Для этого необходимо написать:
`docker pull jesterlol/task:latest`
И после запустить данной командой:
`docker run -p 8080:8080 --name task jesterlol/task:latest`
## Запуск через Java .jar
В корневой папке проекта написать:
`./gradlew build`
`java -jar build/libs/TaskManager-1.0.jar`