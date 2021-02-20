FROM openjdk:8-alpine

COPY target/uberjar/technetium.jar /technetium/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/technetium/app.jar"]
