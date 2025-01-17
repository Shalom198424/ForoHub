# 🌱 Foro Hub 🌿

Bienvenido a Foro Hub, una API REST moderna desarrollada con Spring Boot, diseñada para gestionar foros centrados en huertas urbanas. Este proyecto combina tecnología y pasión por la sostenibilidad, permitiendo la creación, administración y exploración de tópicos relacionados con la horticultura agroecologica urbana.


# 📊 Características principales

- CRUD completo de cursos: Crea, lee, actualiza y elimina tópicos de forma fácil y eficiente.

- Paginación integrada: Explora los tópicos organizados para una mejor experiencia de usuario.

- Validaciones robustas: Asegura la consistencia y validez de los datos enviados.

- Autenticación y seguridad: Implementa un sistema basado en tokens Bearer para proteger las rutas.

- Swagger integrado: Documentación interactiva para explorar y probar la API.


# 🤖 Tecnologías utilizadas

- Java 17: Lenguaje principal para el desarrollo de la API.

- Spring Boot 3.x: Framework principal para la construcción del backend.

- Hibernate: Manejo de la persistencia de datos.

- Spring Security: Protección de las rutas con autenticación JWT.

- Swagger/OpenAPI: Documentación interactiva para facilitar la integración.

- Base de datos H2: Para pruebas iniciales, con posibilidad de migrar a MySQL o PostgreSQL.

- Insomnia.


# 🛠️ Configuración inicial

## Requisitos previos

1. Java 17 o superior instalado.

2. Maven configurado en tu entorno.

3. (Opcional) Un cliente para probar la API, como Postman o Insomnia.

## Pasos para ejecutar

1. Clona el repositorio:
    ```bash
    git clone https://github.com/usuario/foro-hub.git

2. Accede al directorio del proyecto:
    ```bash
    cd foro-hub

3. Ejecuta la aplicación:
    ```bash
    ./mvnw spring-boot:run

4. Accede a la documentación Swagger en:
    ```bash
    http://localhost:8080/swagger-ui.html


# 🔍 Endpoints principales

## Cursos

1. Crear un curso

- POST /cursos

- Body:
  ```bash
  {
  "titulo": "Introducción a las huertas urbanas",
  "mensaje": "Aprende a cultivar en espacios pequeños.",
  "autor": "María López",
  "estado": "ABIERTO",
  "curso": "Huertas Urbanas"
  }

2. Listar cursos

- GET /cursos

3. Actualizar un curso

- PUT /cursos

- Body:
  ```bash
  {
  "id": 1,
  "titulo": "Huertas Urbanas Avanzadas",
  "mensaje": "Técnicas avanzadas para maximizar el espacio.",
  "autor": "María López",
  "estado": "CERRADO"
  }

4. Eliminar un curso

- DELETE /cursos/{id}

5. Obtener detalles de un curso

- GET /cursos/{id}


# 🔒 Autenticación

La API utiliza un sistema de autenticación basado en JWT (JSON Web Tokens). Para acceder a las rutas protegidas, es necesario incluir el token en los headers de las solicitudes:

Authorization: Bearer <tu-token>


# 🔍 Contribución

Nos encanta la colaboración y las ideas frescas. Si tienes una propuesta o deseas contribuir al proyecto:

1. Crea un fork del repositorio.

2. Realiza tus cambios en una rama separada.

3. Envía un pull request con una descripción detallada.


# 🔧 Próximas mejoras

Implementación de notificaciones en tiempo real.

Sistema de roles y permisos más avanzado.

Panel de administración para moderadores del foro.


# 🎉 Contacto

Si tienes dudas o comentarios, no dudes en ponerte en contacto:

Email: sandravelacuenca@gmail.com

¡Gracias por apoyar esta iniciativa de Agroecologia Urbana! 🌿
