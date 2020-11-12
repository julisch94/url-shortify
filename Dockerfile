FROM adoptopenjdk:14-jre-hotspot

ARG JAR_FILE=build/libs/url-shortify-0.0.1.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "app.jar"]
