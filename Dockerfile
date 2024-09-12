FROM gradle:8.10-jdk22 AS build

WORKDIR /usr/src/app

COPY src /usr/src/app/src
COPY build.gradle.kts /usr/src/app
COPY settings.gradle.kts /usr/src/app

RUN gradle bootJar --no-daemon

FROM openjdk:22-jdk
COPY --from=build /usr/src/app/build/libs/Shortener-0.0.1-SNAPSHOT.jar /usr/src/app/Shortener-api-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/Shortener-api-0.0.1-SNAPSHOT.jar"]