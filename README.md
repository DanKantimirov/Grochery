# Grochery

**База данных**  
Скрипт по накату БД: "CreateDatabaseScript.sql"  
Не забываем изменить настройки коннекта к БД в ws-product в файле application.properties  

**Сборка**  
Каталог в которм находится этот файл, будем называть GR_HOME  
cd GR_HOME  
mvn clean package  

**Запуск ws-eureka**  
У меня были проблемы с настройками фаервола ОС при запуске из IDEA, поэтому запускал из отдельной консоли  
cd GR_HOME/ws-eureka/target/  
java -jar ws-eureka-0.0.1-SNAPSHOT.jar  

или

java -jar GR_HOME/ws-eureka/target/ws-eureka-0.0.1-SNAPSHOT.jar  

**Консоль ws-eureka**  
http://localhost:8761/  

**Запуск ws-zuul**  
cd GR_HOME/ws-zuul/target/  
java -jar ws-zuul-0.0.1-SNAPSHOT.jar  

или

java -jar GR_HOME/ws-zuul/target/ws-zuul-0.0.1-SNAPSHOT.jar  

**Запуск ws-product**  
cd GR_HOME/ws-product/target/  
java -jar ws-product-0.0.1-SNAPSHOT.jar  

или

java -jar GR_HOME/ws-product/target/ws-product-0.0.1-SNAPSHOT.jar  

**Тест работы ws-product**  
http://localhost:9030/ws-product/product/getAllProducts/      (прямое обращение)  
http://localhost:9020/api/ws-product/product/getAllProducts/	   (обращение через zuul, после поднятия контура требуется некоторое время для регистрации)  

