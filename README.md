# URL Shortener

Pet project for learning Java & Spring Boot. CQRS-style split:

| Service | Path | Stack | Responsibility |
|---|---|---|---|
| Write service | `src/services/write-service` | Java 21, Spring Boot, Maven | Create / update / delete short links, owns DB schema |
| Read service | _planned_ | Go (TBD) | `GET /{code}` → redirect |

## Write service

```powershell
cd src/services/write-service
.\mvnw.cmd verify            # build + tests
.\mvnw.cmd spring-boot:run   # run
```

Health check: `GET /actuator/health`
