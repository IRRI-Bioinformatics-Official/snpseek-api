# SNPSeek API

A RESTful API for querying rice genomics data including varieties, phenotypes, genotypes, and genomic information.

## Tech Stack
- Spring Boot 3.2.1
- Java 17
- PostgreSQL
- Spring Data JPA
- SpringDoc OpenAPI (Swagger)

## Running Locally

This section shows how to get the application running on a development machine.

### Prerequisites
- Java 17 (OpenJDK or Oracle JDK)
- Maven 3.6+
- PostgreSQL (or a reachable Postgres server)
- (Optional) Docker if you prefer container runs

Verify Java and Maven are available:

```bash
java -version
mvn -version
```

### Database setup
The application expects a PostgreSQL database. Create a database and a user for the application. Example SQL (run in psql or a DB admin tool):

```sql
CREATE DATABASE snpseek_api;
CREATE USER snpseek_user WITH PASSWORD 'change_me';
GRANT ALL PRIVILEGES ON DATABASE snpseek_api TO snpseek_user;
```

Apply any schema migrations you use in this project (if there are SQL migration scripts or Flyway/Liquibase configs, run them). If no migrations are provided, you can run the application with Hibernate's DDL enabled for development, but be careful — that may modify your schema.

### Configuration (application.yml)
Configure database connection and port in `src/main/resources/application.yml` or via environment variables. Minimal example for `application.yml`:

```yaml
server:
  port: 5555

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/snpseek_api
    username: snpseek_user
    password: change_me
  jpa:
    hibernate:
      ddl-auto: none # use 'update' or 'create' only for dev/testing if you understand the consequences
    show-sql: true

# optional: logging level
logging:
  level:
    org.irri.snpseek: DEBUG
```

You can also supply the same values using environment variables (useful for Docker or CI):
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- SERVER_PORT

### Run with Maven (development)
Start the app directly from the source using Maven (recommended for local development):

```bash
# from project root
mvn spring-boot:run
```

By default the app listens on port 5555 (see `application.yml`). Once running, open the Swagger UI at:

```
http://localhost:5555/swagger-ui/index.html
```

### Build an executable JAR and run it
To build a packaged JAR:

```bash
mvn clean package -DskipTests
```

The runnable JAR will be in `target/` (name depends on the module's artifactId and version). Run it with:

```bash
java -jar target/snpseek-api-<version>.jar
```

You can pass Spring properties on the command line or via env vars, for example:

```bash
java -jar target/snpseek-api-<version>.jar --spring.datasource.url=jdbc:postgresql://db:5432/snpseek_api --spring.datasource.username=snpseek_user --spring.datasource.password=secret
```

### Run with Docker (optional)
If you prefer Docker, build an image and run the container. If a Dockerfile exists in this module, use it; otherwise the following is a generic approach:

```bash
# build an image (replace tag as desired)
docker build -t snpseek-api:latest .

# run the container (example linking to a local postgres container)
docker run --rm -p 5555:5555 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/snpseek_api \
  -e SPRING_DATASOURCE_USERNAME=snpseek_user \
  -e SPRING_DATASOURCE_PASSWORD=change_me \
  snpseek-api:latest
```

Note: `host.docker.internal` works on Docker Desktop to reach host services. Alternatively run Postgres in its own container and connect containers on a Docker network.

### Run tests
To run unit and integration tests (if present):

```bash
mvn test
```

### Logs & troubleshooting
- If Maven reports `java: invalid source release: 17` or similar, confirm `JAVA_HOME` points to a Java 17 installation.
- `psql: could not connect to server` — ensure Postgres is running and connection details are correct.
- `org.springframework.jdbc.CannotGetJdbcConnectionException` — check JDBC URL, username, password and that the DB accepts remote connections.
- If Hibernate tries to drop or create tables and you didn't expect that, check `spring.jpa.hibernate.ddl-auto` in `application.yml`.

To get more verbose Spring boot startup logs:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--debug"
```

or for the packaged JAR:

```bash
java -jar target/snpseek-api-<version>.jar --debug
```

### Common commands summary

```bash
# run dev server
mvn spring-boot:run

# build jar
mvn clean package -DskipTests

# run jar
java -jar target/snpseek-api-<version>.jar

# run tests
mvn test
```

## API Endpoints

- `/variety` - Variety queries
- `/genotype/gettable` - Genotype data
- `/blast/getblast` - BLAST search
- `/variety/phenotypes` - Phenotype data

## Documentation

Full API documentation available at `/swagger-ui/index.html` when running.

## New use cases (added endpoints)

I added three new API areas (ReferenceSequence, PassportAttributes, GenotypeRuns). Below are the endpoints and quick examples to try them locally (default server port 5555).

IMPORTANT: the API uses existing entity/view types. Some IDs in the DB are represented as BigDecimal in the entity views; you can pass numeric values. If you see decimal IDs, pass them exactly (or change the DTO/service to convert types as you prefer).

### 1) Reference sequences
Base path: `/reference-sequence`

Endpoints:
- `GET /reference-sequence` — list all reference sequences
- `GET /reference-sequence/{id}` — get a reference sequence by feature id
- `GET /reference-sequence/by-organism/{organismId}` — list sequences for an organism
- `GET /reference-sequence/search?q=<name-fragment>` — search by name fragment

Examples:

```bash
# list all
curl -sS http://localhost:5555/reference-sequence | jq '.'

# get by id (example id: 12345)
curl -sS http://localhost:5555/reference-sequence/12345 | jq '.'

# by organism (example organism id: 1)
curl -sS http://localhost:5555/reference-sequence/by-organism/1 | jq '.'

# search by name fragment
curl -sS "http://localhost:5555/reference-sequence/search?q=chr1" | jq '.'
```

Notes:
- `organismId` and `featureId` may be stored as numeric/BigDecimal in the database views — pass numeric IDs that match your DB.
- The DTO exposes fields: featureId, name, uniquename, seqlen, organismId, commonName, typeId, type.

### 2) Passport attributes (renamed from VCVPassport)
Base path: `/passport-attributes`

Endpoints:
- `GET /passport-attributes/dataset/{dataset}` — list passport attributes for a dataset
- `GET /passport-attributes/{cvTermId}/{dataset}` — get a single passport attribute by cvTermId & dataset
- `GET /passport-attributes/search/name?q=...&dataset=...` — search by name
- `GET /passport-attributes/search/definition?q=...&dataset=...` — search by definition

Examples:

```bash
# list all passport attributes for dataset 'irri'
curl -sS http://localhost:5555/passport-attributes/dataset/irri | jq '.'

# get specific CV term (example cvTermId: 200, dataset: irri)
curl -sS http://localhost:5555/passport-attributes/200/irri | jq '.'

# search by name fragment in dataset
curl -sS "http://localhost:5555/passport-attributes/search/name?q=seed&dataset=irri" | jq '.'
```

Notes:
- The legacy endpoints under `/passport` are preserved for backward compatibility; they delegate to the new implementation.
- DTO fields: cvTermId, name, definition, dataset.

### 3) Genotype runs
Base path: `/genotype-runs`

Endpoints:
- `GET /genotype-runs` — list all genotype runs
- `GET /genotype-runs/{id}` — get a genotype run by id
- `GET /genotype-runs/by-dataset/{dataset}` — list runs for a dataset name
- `GET /genotype-runs/by-variant-type?type=...` — list runs for a variant type

Examples:

```bash
# list all genotype runs
curl -sS http://localhost:5555/genotype-runs | jq '.'

# get run by id
curl -sS http://localhost:5555/genotype-runs/10 | jq '.'

# runs by dataset
curl -sS http://localhost:5555/genotype-runs/by-dataset/irri | jq '.'

# runs by variant type
curl -sS "http://localhost:5555/genotype-runs/by-variant-type?type=SNP" | jq '.'
```

DTO fields (GenotypeRunDTO): genotypeRunId, datePerformed, dataLocation, platformId, variantsetId, variantset, vsDescription, variantTypeId, datasetId, dataset, commonName, dsDescription, method, variantType.

## Quick API checklist (how to try)
1. Start PostgreSQL and ensure the database and user from the configuration exist.
2. Start the app using `mvn spring-boot:run` (or run the packaged JAR).
3. Open the Swagger UI at `http://localhost:5555/swagger-ui/index.html` to explore and test endpoints interactively.
4. Use the curl examples above for quick smoke tests.

## Notes & Next steps
- Consider adding pagination (Spring Data `Pageable`) to endpoints that return large lists.
- If you want `commonName` or other related fields populated from other entities (for example to resolve type names), I can update services to join the appropriate tables.
- If you prefer different DTO types (use Long instead of BigDecimal for some IDs), I can update DTOs and mapping logic.
- I can add unit tests for the new service and controller, or add a small `docker-compose.yml` to run Postgres + API quickly.

If you'd like, I can run a full build of the module and post the build output here, or add tests and a docker-compose example — tell me which and I'll implement it next.