# morbidity
REST-сервис возвращающий данные со статистикой заболеваемости по федеральным округам в формате json.

- Позволяет получать данные за последний месяц (по умолчанию)
- Получать данные по выбранному федеральному округу за определенный месяц.

## Сборка проекта
Для сборки проекта, нужно установить [maven](https://maven.apache.org/download.cgi#) и выполнить команду ```mvn clean install```.

## Используемые библиотеки и технологии
* [Postgres](https://www.postgresql.org)
* [Resteasy](http://resteasy.jboss.org)
* [Hibernate](https://mvnrepository.com/artifact/org.hibernate/hibernate-core)

## Сервер приложений
[wildfly](http://wildfly.org)
