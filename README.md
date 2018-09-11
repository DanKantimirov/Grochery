# Grochery

********************Сборка**********************
Каталог в которм находится этот файл, будем называть GR_HOME
cd GR_HOME
mvn clean package


*******************Запуск ws-eureka*************
У меня были проблемы с настройками фаервола ОС при запуске из IDEA, поэтому запускал из отдельной консоли

cd GR_HOME/ws-eureka/target/
java -jar ws-eureka-0.0.1-SNAPSHOT.jar

или

java -jar GR_HOME/ws-eureka/target/ws-eureka-0.0.1-SNAPSHOT.jar
*******************Консоль ws-eureka*************
http://localhost:8761/


*******************Запуск ws-zuul*************
cd GR_HOME/ws-zuul/target/
java -jar ws-zuul-0.0.1-SNAPSHOT.jar

или

java -jar GR_HOME/ws-zuul/target/ws-zuul-0.0.1-SNAPSHOT.jar

*******************Консоль ws-eureka*************
http://localhost:9020/actuator/info


*******************Запуск ws-product*************
cd GR_HOME/ws-product/target/
java -jar ws-product-0.0.1-SNAPSHOT.jar

или

java -jar GR_HOME/ws-product/target/ws-product-0.0.1-SNAPSHOT.jar

*******************Тест работы ws-product*************

http://localhost:9020/ws-product/getProductHello		(обращаемся на порт с zuul)

