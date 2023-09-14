# restfull-api-springboot-example

To view JSON objects in the browser, install the JSON Viewer plugin or similar.

# Flyway - Migrations:
The Flyway plugin is configured in the Spring Boot project and the following commands can be executed to apply the migration scripts:

mvn clean package spring-boot:run
mvn clean package spring-boot:run -DskipTests
mvn flyway:migrate

# Swagger V3 API-DOCS:
http://localhost:8080/v3/api-docs

# Swagger UI:
http://localhost:8080/swagger-ui/index.html
