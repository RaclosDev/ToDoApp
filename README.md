# ToDo API :clipboard:

API RESTful para una aplicación de gestión de tareas.

## Descripción

Este es un proyecto personal que implementa una API RESTful para una aplicación de gestión de tareas. Utiliza Spring Boot como framework y una base de datos en memoria H2.

### Base URL :computer:

http://localhost:8080/

### Endpoints :dart:

- `GET /tasks`: devuelve todas las tareas registradas.
- `POST /tasks`: crea una nueva tarea.
- `DELETE /tasks/{id}`: elimina una tarea por su ID.
- `PATCH /tasks/mark_as_finished/{id}`: marca una tarea como finalizada.
- `GET /tasks/status/{status}`: devuelve todas las tareas con el estado especificado.

### Modelos :page_with_curl:

- `Task`: modelo de tarea que contiene ID, título, descripción, estado, fecha de creación y fecha de finalización estimada.
- `TaskInDTO`: objeto utilizado para crear una nueva tarea con título, descripción y fecha de finalización estimada.

### Agradecimientos :pray:

Gracias por utilizar mi API. Si tienes alguna pregunta o sugerencia, por favor no dudes en contactarme a través de mi perfil de GitHub.
