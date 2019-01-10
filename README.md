# DropWizardDemo

This is a demonstration project to show how dropwizard can be used to craete a simple backend for WebApplications.

Run postgres with docker
---
`docker run --name ug-demo -p 5555:5432 -e POSTGRES_USER=demo -e POSTGRES_PASSWORD=demo -e POSTGRES_DB=demo -d postgres:9.6.2-alpine`

How to start the DropWizardDemo application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-demo-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
