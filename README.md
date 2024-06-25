## Estructura del Programa

### Clases Principales:

- **Usuario:** Representa un usuario con atributos como ID, nombre, departamento y rol.
- **Sala:** Representa una sala con atributos como código, nombre, ubicación y estado de reserva.
- **Reserva:** Representa una reserva con atributos como código de sala, ID de usuario, fecha y detalle de reserva.

### Managers:

- **UsuarioManager:** Gestiona las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para usuarios.
- **SalaManager:** Gestiona las operaciones CRUD para salas, incluyendo la gestión de duplicados y validaciones.
- **ReservaManager:** Gestiona las operaciones CRUD para reservas, integrando la lógica con los managers de sala y usuario para garantizar la integridad referencial.

### Main Class:

- **Main:** Clase principal que proporciona un menú interactivo para gestionar usuarios, salas y reservas. Utiliza un bucle `while` para mostrar opciones al usuario y ejecutar las operaciones correspondientes según la selección.

### Pruebas Unitarias:

- **UsuarioManagerTest:** Contiene pruebas para verificar las operaciones CRUD del `UsuarioManager`.
- **SalaManagerTest:** Contiene pruebas para verificar las operaciones CRUD del `SalaManager`, incluyendo manejo de salas duplicadas.
- **ReservaManagerTest:** Contiene pruebas para verificar las operaciones CRUD del `ReservaManager`, asegurando la correcta creación, actualización y eliminación de reservas.



## Manual de Usuario

- Se utilizo JUnit con Maven para realizar las pruebas

- Para utilizar el programa normal tiene que estar ubicado en la carpeta src/main/java, abrir una terminal y ejecutar los siguientes comandos: 
  - javac com/example/*.java
  - java com.example.Main 

Para realizar los test tiene que estar ubicado en la carpeta raiz del proyecto, abrir una terminal y ejecutar el comnado :
  - mvn test

## Reporte de Pruebas Unitarias

### 1. UsuarioManagerTest

#### Test Agregar Usuario
- **Descripción:** Verifica la funcionalidad de agregar un usuario al `UsuarioManager`.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Actualizar Usuario
- **Descripción:** Verifica la funcionalidad de actualizar los datos de un usuario existente.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Eliminar Usuario
- **Descripción:** Verifica la funcionalidad de eliminar un usuario del `UsuarioManager`.
- **Resultado:** La prueba pasó satisfactoriamente.

### 2. SalaManagerTest

#### Test Agregar Sala
- **Descripción:** Verifica la funcionalidad de agregar una sala al `SalaManager`.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Actualizar Sala
- **Descripción:** Verifica la funcionalidad de actualizar los datos de una sala existente.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Eliminar Sala
- **Descripción:** Verifica la funcionalidad de eliminar una sala del `SalaManager`.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Agregar Sala Duplicada
- **Descripción:** Verifica que no se pueda agregar una sala con un código duplicado.
- **Resultado:** La prueba falló porque no se lanzó la excepción `IllegalArgumentException` esperada.

### 3. ReservaManagerTest

#### Test Agregar Reserva
- **Descripción:** Verifica la funcionalidad de agregar una reserva al `ReservaManager`.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Actualizar Reserva
- **Descripción:** Verifica la funcionalidad de actualizar los datos de una reserva existente.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Eliminar Reserva
- **Descripción:** Verifica la funcionalidad de eliminar una reserva del `ReservaManager`.
- **Resultado:** La prueba pasó satisfactoriamente.

#### Test Reserva Sobreposición Usuario
- **Descripción:** Verifica que no se pueda agregar una reserva que se superponga con otra existente para el mismo usuario.
- **Resultado:** La prueba falló porque no se lanzó la excepción `IllegalArgumentException` esperada.

### Conclusiones
- **Total de Pruebas:** 13 pruebas ejecutadas.
- **Éxito:** 11 pruebas pasaron satisfactoriamente.
- **Fallas:** 2 pruebas fallaron debido a que no se lanzaron las excepciones esperadas.


