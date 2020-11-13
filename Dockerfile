# Build Application
FROM gradle:jre15-hotspot AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src
RUN gradle build

# Start Application
FROM adoptopenjdk:14-jre-hotspot

COPY --from=build /home/gradle/src/build/libs/*.jar /opt/app/app.jar

WORKDIR /opt/app
CMD ["java", "-jar", "app.jar"]
