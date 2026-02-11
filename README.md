# SNPSeek API

A RESTful API for querying rice genomics data including varieties, phenotypes, genotypes, and genomic information.

## Tech Stack
- Spring Boot 3.2.1
- Java 17
- PostgreSQL
- Spring Data JPA
- SpringDoc OpenAPI (Swagger)

## Running Locally

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL

### Setup
1. Clone the repository
```bash
git clone git@github.com:IRRI-Bioinformatics-Official/snpseek-api.git
cd snpseek-api
```

2. Configure database in `application.yml`

3. Run the application
```bash
mvn spring-boot:run
```

4. Access Swagger UI
```
http://localhost:5555/swagger-ui/index.html
```

## API Endpoints

- `/api/v1/variety` - Variety queries
- `/api/v1/genotype/gettable` - Genotype data
- `/api/v1/blast/getblast` - BLAST search
- `/api/v1/variety/phenotypes` - Phenotype data

## Documentation

Full API documentation available at `/swagger-ui/index.html` when running.
EOF

git add README.md
git commit -m "Add README"
git push