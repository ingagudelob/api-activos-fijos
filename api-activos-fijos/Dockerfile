FROM openjdk:11
VOLUME /tmp´
EXPOSE 9000
ADD ./target/api-activos-fijos-0.0.1-SNAPSHOT.jar activos.jar
ENTRYPOINT ["java", "-jar", "/activos.jar"]