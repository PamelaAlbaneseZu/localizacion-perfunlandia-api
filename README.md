# localizacion-perfunlandia-api
# API de Gestión de Localización - Perfunlandia

Esta API maneja la información de localización (regiones, ciudades, comunas y direcciones) para el proyecto Perfunlandia.

## 🚀 Características

- **HATEOAS**: Enlaces hipermedia para navegación entre recursos
- **Swagger/OpenAPI**: Documentación automática de la API
- **Spring Boot 3.4.0**: Versión estable y actualizada
- **MariaDB**: Base de datos relacional
- **JPA/Hibernate**: Persistencia de datos

## 📋 Endpoints Disponibles

### Regiones
- `GET /api/regiones` - Listar todas las regiones

### Ciudades
- `GET /api/ciudades/por-region?nombreRegion={nombre}` - Listar ciudades por región

### Comunas
- `GET /api/comunas/por-ciudad?nombreCiudad={nombre}` - Listar comunas por ciudad

### Direcciones
- `GET /api/direcciones` - Listar todas las direcciones
- `POST /api/direcciones` - Crear nueva dirección
- `GET /api/direcciones/sucursales/{id}/existe` - Verificar si existe una dirección

## 🔧 Configuración

### Requisitos
- Java 17
- Maven
- MariaDB

### Instalación
1. Clona el repositorio
2. Configura la base de datos en `application.properties`
3. Ejecuta: `mvn spring-boot:run`

## 📖 Documentación

Una vez que la aplicación esté corriendo, puedes acceder a:
- **Swagger UI**: `http://localhost:8083/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8083/v3/api-docs`

## 🔗 Enlaces HATEOAS

Todos los endpoints incluyen enlaces HATEOAS que apuntan al API Gateway:
- `http://localhost:8888/api-gateway/regiones`
- `http://localhost:8888/api-gateway/ciudades`
- `http://localhost:8888/api-gateway/comunas`
- `http://localhost:8888/api-gateway/direcciones`

## 🏗️ Estructura del Proyecto

```
src/main/java/com/perfunlandia/gestionlocalizacionapi/
├── controller/     # Controladores REST
├── dto/           # Objetos de transferencia de datos
├── models/        # Entidades JPA
├── repositories/  # Repositorios de datos
└── services/      # Lógica de negocio
```

## 🚀 Ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

La API estará disponible en `http://localhost:8083` 
