Este proyecto es una aplicación de backend para gestionar los datos de empresas registradas mediante su RUC, integrando Spring Boot y Spring Cloud OpenFeign para consumir una API externa. La información obtenida se almacena en una base de datos con campos de auditoría para registrar creación y actualización de datos.

## Características

- **Consulta de RUC**: Utiliza el API de SUNAT para obtener datos detallados de empresas peruanas a partir de su número de RUC.
- **Auditoría**: Cada registro almacena información de creación y actualización automática.
- **Manejo de Errores**: Gestiona y maneja errores provenientes de la API externa con respuestas adecuadas.


## Consideraciones
- Tener en cuenta el lado de las properties:
Ya que se modifico la contraseña y el token (puede colocar el suyo para poder validar de manera correcta).


