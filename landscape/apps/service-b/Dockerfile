FROM adoptopenjdk/openjdk11:latest

ADD target/service-b-thorntail.jar /opt/thorntail.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/thorntail.jar", "-Djava.net.preferIPv4Stack=true"]