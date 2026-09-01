# courseflow

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

Then fill required blank values in `.env`.

2. Start with PostgreSQL:

```bash
docker compose --profile postgres up -d
```

Or start with MariaDB:

```bash
docker compose --profile mariadb up -d
```

3. Open:

- App: `http://localhost:8080`
- Adminer: `http://localhost:8081`
- Grafana: `http://localhost:3000` (credentials from `.env`)
- Loki API: `http://localhost:3100`

## Notes

- App logs are written to container stdout and scraped by Promtail to Loki.
- Loki runs with its default local config (`/etc/loki/local-config.yaml`).
- Promtail reads host Docker JSON logs from `/var/lib/docker/containers` (host-level read access for log shipping).
- Update `.env` values to match your application database settings.
- `DB_HOST`/`DB_PORT` are profile-specific by default (`postgres:5432`, `mariadb:3306`); only override if needed.
- Start only one database profile (`postgres` or `mariadb`), which starts the matching app container with a health-checked dependency.
- Set `DB_PASSWORD`, `MARIADB_ROOT_PASSWORD`, and `GF_SECURITY_ADMIN_PASSWORD` in `.env` before startup.
