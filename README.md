# neoristest

Se realiza **Prueba Técnica Arquitectura Microservicio (Nivel Intermedio)**

## Docker

En la raiz del proyecto estan los archivos **Dockerfile** y **docker-compose** para desplegar la solucion en docker. 

luego de crearla solo es necesario usar el comando :

> docker-compose up

## Base de datos

posterior a esto se puede ingresar al contenedor de la base de datos con el comando:

 > docker exec -it {NUMEROcONTENEDOR} psql -U postgres postgrescli
 
 ya estando en el contedor se pueden crear los elementos de la base de datos del archivo BaseDatos.sql.
 
 ## Postman
 
 ya con los elementos creados, se puede abrir el archivo postman **test NEORIS.postman_collection** en el cual se encuentran los endpoints y meotdos de cada uno.
 
 Con esto el sistema queda preparado para ser probado.
