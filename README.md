# Práctica 2

**Nombre:** Irene Morales Pérez

**Curso:** 3º GITT+BA 

**Fecha:** 17/01/2026

---

## Especificaciones
### Objetivo de la práctica

l objetivo de esta práctica es introducir al alumnado en el diseño e implementación de un **servicio web REST** siguiendo el estilo arquitectónico **request/response** sobre HTTP. Se construirá una API mínima que permita realizar operaciones **CRUD (Create, Read, Update, Delete)** sobre un recurso “Carrito”, modelando un caso simplificado de e-commerce.

### Alcance funcional

Se implementará un recurso **Carrito** que representa el estado de una compra en curso con las siguientes propiedades:

- **idCarrito**: identificador único del carrito.
- **idArticulo**: identificador del artículo asociado al carrito.
- **descripcion**: texto descriptivo del artículo.
- **unidades**: número de unidades del artículo.
- **precioFinal**: importe final del carrito (para simplificar, se considera un campo proporcionado/calculado y se devuelve en las respuestas).
    
> Simplificación: **cada carrito solo puede contener un único producto** (no existe lista de líneas).

---

## Implementación
### 1. Creacion del proyecto
creamos un proyecto Spring Boot con el gestor de dependencias Maven
creamos un repositorio de github con el proyecto desde la carpeta mvn con los ficheros sus ficheros

### 2. Creacion del modelo de carrito
Creamos un modelo del recurso Carrito con las propiedades:
- idCarrito como int
- id Articulo como int
- descripcion como String
- unidades como int
- y precioFinal como Double
para cada propiedad del Carrito generamos su setter y getter para poder instanciarlo en la clase principal

### 3. Creacion del controlador del carrito
Creamos una clase ``ControladorCarrito`` donde implementamos los métodos que nos permitirán hacer las operaciones CRUD.
#### Leer lista de todos los carritos (Read --> get)
usamos la anotacion ``@GetMapping`` 
Demo del get:
![alt text](imagenes/cap1.png)

#### Crear carrito (Create --> put)
eliminamos demo y probamos a crear un carrito con la anotacion ``@PostMapping``
y Postman.
![alt text](imagenes/cap2.png)
con la anotacion estamos diciendo que el request body es de tipo carrito y spring va a mapear a un formato json las propiedades de carrito. para que funcione en Postman creamos nuestro body en dicho formato.
Ahora vemos que si hacemos un get, nos sale el carrito que hemos creado:
![alt text](imagenes/cap3.png)
#### Leer un solo carrito
implementamos un nuevo metodo con ``@GetMapping`` para obtener un carrito creado de nuestra lista de carritos mediante su ``idCarrito``
Para ver esto en Postman tenemos que hacer un POST de un carrito (porque no tenemos persistencia) y luego creando una nueva peticion GET obtenemos nuestro carrito creado. 
![alt text](imagenes/cap4.png)
#### Quitar carrito (Delete --> delete)
implementamos un nuevo metodo con ``@DeleteMapping`` que devuelva un carrito especifico indicado con el idCarrito.
Lo probamos en postman creando dos carritos y borrando uno de ellos.
#### Modificar cualquier cosa del carrito (Update --> put)
Hacemos un nuevo metodo con ``@PutMapping`` pero ahora el path recibe el id del carrito que se quiere modificar.



