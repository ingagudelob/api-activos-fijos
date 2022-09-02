# Proyecto: API - Activos fijos

Los activos fijos de una empresa son los bienes materiales, son necesarios para el
funcionamiento de la empresa y no se destinan para la venta, ejemplos de estos son: bienes
inmuebles, maquinaria, material de oficina, etc.
Estos activos fijos tienen características comunes entre todas como son: nombre, descripción,
tipo, serial, numero interno de inventario, peso, alto, ancho, largo, valor compra, fecha de
compra.
Los activos se pueden asignar a un área o persona, si es a un área esta se encuentra en una
ciudad (diferentes áreas se encuentran en diferentes ciudades).

**DEVELOPER**

- **Jaime Agudelo Bentham** - [LinkedIn](https://www.linkedin.com/in/jaime-agudelo-bentham/) - [GitHub](https://github.com/ingagudelob)

### Objetivo

Diseñar una API RESTFul1 que permite administrar los activos, esta debería permitir:
• Buscar los activos por: tipo, fecha de compra, serial.
• Crear nuevos activos.
• Actualizar activos.

### Herramientas utilizadas

- 👉 Java y Spring Boot
- 👉 Tecnología REST
- 👉 Maven

### Repositorio - GitHub

- 👉 [Github](https://github.com/ingagudelob/api-activos-fijos.git)

### Para ejecutar la API 👇🏻

- Descargar el proyecto o clonarlo.
- Abrir la consola e ir a la carpeta del proyecto.
- Ejecute estos comandos: `mvn clean install` y luego `mvn spring-boot:run` .

## Requerimientos técnicos

## 1. Modelado de Base de Datos

Se utiliza base de datos relacinal para el proyecto y como gestor se utilizó MySQL.

**Asset:** deberá tener:

     - assetNumber
     - name
     - description
     - width
     - height
     - weight
     - length
     - type
     - purchasePrice
     - purchaseDate
     - dependency
     - serial

**Area:** deberá tener:

    - codArea
    - nameArea
    - city

**Employe:** deberá tener:

    - codEmploye
    - nameEmploye

## 2. Role Admin

### PATHS habilitados para la adminstración de los Activos fijos:

| METHOD | PATH                                                 |
| ------ | ---------------------------------------------------- |
| POST   | http://localhost:9000/api/asset/add                  |
| PUT    | http://localhost:9000/api/asset/update               |
| GET    | http://localhost:9000/api/asset/{numberAsset}        |
| GET    | http://localhost:9000/api/asset/serial/?serial=      |
| GET    | http://localhost:9000/api/asset/type/?type=          |
| GET    | http://localhost:9000/api/asset/date/?purchase_date= |

## 2.1 Crear nuevos Activos

### POST (add)

    http://localhost:9000/api/asset/add

Ejemplo:
{
"name": "Monitor",
"description": "Samsung 19' S19B300 " ,
"type": "Equipos de oficina",
"serial": "SN32131",
"weight": 8.9,
"height": 70.5,
"width": 60.30,
"length": 50.0,
"purchasePrice": 280000,
"purchaseDate":"2022-05-03",
"dependency": "Jaime Agudelo"
}

### PUT (Update)

Este metodo recibe todo el Modelo e internamente existe la validación para identificacion de numberAsset. Criterio para actualización:

    http://localhost:9000/api/asset/update

Ejemplo:
{  
 "assetNumber": 4,
"name": "Escritorio",
"serial":"SN1234",
"type": "Equipos de oficina",
"description": "Mueble en L de 3 piezas - Gerencial",
"purchasePrice": 382000
}

### GET (Find by Serial)

Este metodo recibe como parametro un valor numérico. En caso de recibir un valor diferente vamos a obtener como respuesta un Status 404. NOY_FOUND.

    http://localhost:9000/api/asset/serial/

Respuesta: Devuelve un modelo unico

### GET (Find by Serial)

    http://localhost:9000/api/asset/serial/?serial=SN1234

Respuesta: Devuelve un modelo unico
{
"assetNumber": 4,
"name": "Escritorio",
"description": "Mueble en L de 3 piezas - Gerencial",
"type": "Equipos de oficina",
"serial": "SN1234",
"weight": 8.9,
"height": 70.5,
"width": 60.3,
"length": 1.5,
"dependency": "Santa Marta",
"purchasePrice": 382000.0,
"purchaseDate": "2022-05-02"
}

### GET (Find by Type)

    http://localhost:9000/api/asset/type/?type=Equipo de oficina

Respuesta: Devuelve una Lista

    [
    {
        "assetNumber": 1,
        "name": "Portail",
        "description": "ASUS de 14 pulgadas 8th Gn",
        "type": "Equipos de oficina",
        "serial": "SNL9071",
        "weight": 0.1,
        "height": 0.15,
        "width": 0.3,
        "length": 0.3,
        "dependency": "Jaime Agudelo",
        "purchasePrice": 1350000.0,
        "purchaseDate": "2022-07-01"
    },
    {
        "assetNumber": 4,
        "name": "Escritorio",
        "description": "Mueble en L de 3 piezas - Gerencial",
        "type": "Equipos de oficina",
        "serial": "SN1234",
        "weight": 8.9,
        "height": 70.5,
        "width": 60.3,
        "length": 1.5,
        "dependency": "Santa Marta",
        "purchasePrice": 382000.0,
        "purchaseDate": "2022-05-02"
    },
    {
        "assetNumber": 5,
        "name": "Monitor",
        "description": "Samsung 19' S19B300 ",
        "type": "Equipos de oficina",
        "serial": "SN32131",
        "weight": 8.9,
        "height": 70.5,
        "width": 60.3,
        "length": 50.0,
        "dependency": "Medellín",
        "purchasePrice": 280000.0,
        "purchaseDate": "2022-05-02"
    }

]

### GET (Find by Date)

    http://localhost:9000/api/asset/date/?purchase_date=2022-05-02

Respuesta: Devuelve una Lista

    [
    {
        "assetNumber": 4,
        "name": "Escritorio",
        "description": "Mueble en L de 3 piezas - Gerencial",
        "type": "Equipos de oficina",
        "serial": "SN1234",
        "weight": 8.9,
        "height": 70.5,
        "width": 60.3,
        "length": 1.5,
        "dependency": "Santa Marta",
        "purchasePrice": 382000.0,
        "purchaseDate": "2022-05-02"
    },
    {
        "assetNumber": 5,
        "name": "Monitor",
        "description": "Samsung 19' S19B300 ",
        "type": "Equipos de oficina",
        "serial": "SN32131",
        "weight": 8.9,
        "height": 70.5,
        "width": 60.3,
        "length": 50.0,
        "dependency": "Medellín",
        "purchasePrice": 280000.0,
        "purchaseDate": "2022-05-02"
    }

]

## 3. Reglas

### Las respuestas HTTP de la API estan estandarizadas así:

    - 200 Por consultas exitosas
    - 400 Para reportar datos faltantes al crear o actualizar un activo.
    - 404 para búsquedas sin resultados.
    - 500 Para errores que pasen en la capa de backend.
    - Todas las respuestas deben contener una descripción o resumen de lo ocurrido.
