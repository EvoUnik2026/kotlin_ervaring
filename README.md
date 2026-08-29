# kotlin_ervaring

Kotlin training project with a ready-to-use Docker stack for web application development.

## Docker stack

The repository now includes:

- **Kotlin app container** (builds with Gradle + JDK 21)
- **PostgreSQL** (profile: `postgres`)
- **MariaDB** (profile: `mariadb`)
- **Adminer** for database inspection (`http://localhost:8081`)
- **Loki + Promtail + Grafana** for log aggregation/visualization

## Quick start

1. Copy env file:

```bash
cp .env.example .env
```

2. Start with PostgreSQL:

```bash
docker compose --profile postgres up -d postgres
docker compose --profile postgres up -d app-postgres adminer loki promtail grafana
```

Or start with MariaDB:

```bash
docker compose --profile mariadb up -d mariadb
docker compose --profile mariadb up -d app-mariadb adminer loki promtail grafana
```

3. Open:

- App: `http://localhost:8080`
- Adminer: `http://localhost:8081`
- Grafana: `http://localhost:3000` (default: `admin` / `admin`)
- Loki API: `http://localhost:3100`

## Notes

- App logs are written to container stdout and scraped by Promtail to Loki.
- Update `.env` values to match your application database settings.
- Start only one database profile (`postgres` or `mariadb`), which starts the matching app container with a health-checked dependency.
