# mi-servicio

Microservicio Spring Boot de ejemplo con pipeline CI/CD en GitHub Actions.

## Endpoints
- `GET /api/hola?nombre=Ana` → `{"mensaje":"¡Hola, Ana!"}`
- `GET /actuator/health` → estado del servicio

## Correr localmente (requiere Java 21)
```bash
./mvnw spring-boot:run      # levantar
./mvnw verify               # tests + cobertura
```

## Pipeline
- PR a `main`: build, tests, cobertura, escaneo de seguridad, build de imagen.
- Push a `main`: además publica la imagen en GHCR (pestaña Packages).
- Deploy a Kubernetes: se activa creando la variable de repositorio `DEPLOY_ENABLED=true`
  y configurando los environments `staging` y `production`.
