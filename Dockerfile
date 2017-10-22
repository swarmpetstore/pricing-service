FROM fabric8/java-jboss-openjdk8-jdk:1.0.13

ENV AB_OFF true
EXPOSE 8080

RUN mvn clean package
ADD target/pricing-service-1.0-swarm.jar /app/

ENV JAVA_APP_JAR pricing-service-1.0-swarm.jar

