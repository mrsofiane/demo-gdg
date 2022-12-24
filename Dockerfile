FROM openjdk:17-jdk-slim
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN ./mvnw clean
CMD ./mvnw spring-boot:run