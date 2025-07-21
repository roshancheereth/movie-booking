# MovieSearch

MovieSearch is a simple Spring Boot service that demonstrates how to search for movie shows stored in a MySQL database. It exposes a single REST endpoint that allows filtering shows by city, movie title, language, and start time.

## Features

- Spring Boot 3 application built with Gradle
- JPA/Hibernate persistence with MySQL
- Basic search API returning show details
- Custom HTML error pages for common HTTP errors

## Getting Started

### Prerequisites

- Java 23 or later
- A running MySQL instance

### Database Setup

Create the schema using `src/main/resources/schema-mysql.sql` and optionally load sample data from `src/main/resources/demo-data.sql`.

```
mysql -u <user> -p < database_name> < src/main/resources/schema-mysql.sql
mysql -u <user> -p < database_name> < src/main/resources/demo-data.sql
```

Update the database connection properties if necessary in `src/main/resources/application.yml`.

### Running the Application

Use the Gradle wrapper to start the service:

```
./gradlew bootRun
```

The service will start on port `8081`.

### Frontend UI

With the backend running, open `http://localhost:8081/index.html` in your
browser to load the simple React interface. The page is served directly from the
`src/main/resources/static` directory.

### API Usage

The search endpoint is available at:

```
GET /api/v1/search
```

Query parameters:

- `city` – filter shows by city
- `title` – filter by movie title (partial match)
- `language` – filter by movie language
- `after` – ISO date-time to return shows starting after the given time

Example request:

```
GET http://localhost:8081/api/v1/search?city=Bangalore&title=Time
```

### Running Tests

```
./gradlew test
```

## Project Structure

- `api/` – REST controller
- `domain/` – JPA entities (`Movie`, `Show_`)
- `repository/` – Spring Data repository and specifications
- `service/` – Search service and criteria
- `dto/` – Data transfer object for results

## License

This repository does not contain an explicit license.

