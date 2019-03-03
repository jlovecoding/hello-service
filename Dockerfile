FROM openjdk:8-jdk-alpine
RUN apk update && apk add bash
VOLUME /tmp
ADD target/*.jar /

ENV JAVA_OPTS=""
ENV SPRING_PROFILE="default"

ENTRYPOINT exec java $JAVA_OPTS \
 -Djava.security.egd=file:/dev/./urandom \
 -Dspring.profiles.active=$SPRING_PROFILE \
 -jar hello-service-0.0.1-SNAPSHOT.jar
