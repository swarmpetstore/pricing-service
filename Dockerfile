FROM fabric8/java-jboss-openjdk8-jdk:1.0.13

ENV JAVA_APP_JAR pricing-service-1.0-swarm.jar
ENV AB_OFF true

EXPOSE 8080

ADD target/pricing-service-1.0-swarm.jar /app/
