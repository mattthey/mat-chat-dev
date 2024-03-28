# mat chat DB

## DEV environment

В целях локальной разработки реализованы скрипты для запуска и инициализации БД в формате Docker-контейнера:

1. Выполнить запуск [docker-compose.yml](docker%2Fdocker-compose.yml) для создания Docker-контейнера PostgreSQL
   и первичной инициализации базы данных:
   `docker-compose -f ./docker/docker-compose.yml up`
2. В рамках текущего модуля запустите скрипт миграции схемы данных Liquibase:
   `./gradlew :mat-chat-db:update`.

> Параметры подключения Liquibase для локального экземпляра БД расположены в файле:
[liquibase.properties](liquibase%2Fconfig%2Fliquibase.properties) и ДОЛЖНЫ соответствовать параметрам,
> указанным в рамках скриптов первичной инициализации БД: [init.sql](docker%2Finit%2Finit.sql)

При необходимости отката схемы данных, запустите, в рамках текущего модуля, скрипт отката миграции до тэга
необходимой версии. Например, откат версии `1.0.0`:
`./gradlew :mat-chat-db:rollback -PliquibaseCommandValue=rollback-1.0.0`

## Правила написания миграций

- В каждом changelog файле обязательно должен быть указан [logicalFilePath](https://docs.liquibase.com/concepts/changelogs/attributes/logicalfilepath.html).
  В качестве значения - путь от директории liquibase.
