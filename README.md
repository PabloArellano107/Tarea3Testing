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



##Manual de Usuario

-Se utilizo JUnit con Maven para realizar las pruebas

-Para utilizar el programa normal tiene que estar ubicado en la carpeta src/main/java, abrir una terminal y ejecutar los siguientes comandos: 
  -javac com/example/*.java
  -java com.example.Main 

Para realizar los test tiene que estar ubicado en la carpeta raiz del proyecto, abrir una terminal y ejecutar el comnado :
  -mvn test

##Reporte de pruebas unitarias
