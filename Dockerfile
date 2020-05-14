FROM openjdk:13

EXPOSE 3000

WORKDIR /opt/app

COPY target/*.jar /opt/app

CMD [ "java", "-jar", "guest-book-0.0.1-SNAPSHOT.jar" ]