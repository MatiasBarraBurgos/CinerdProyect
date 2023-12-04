# CinerdProyect

## Descripción
CinerdProyect es una aplicación de gestión de reservas de boletos para cine. Este repositorio contiene el código fuente de la aplicación.

## Estructura del Proyecto
- `src/`
  - `login.java`: Gestiona la funcionalidad de inicio de sesión.
  - `Registro.java`: Archivo relacionado con el proceso de registro.
  - `Cartelera.java`: Clase que gestiona la información de la cartelera de películas.
  - `SeleccionDeAsientos.java`: Clase encargada de la selección de asientos para las funciones.
  - `MetodoDePago.java`: Clase que gestiona los métodos de pago para la compra de boletos.
  - `Factura.java`: Clase que genera la factura para las compras realizadas.
  - `Conex.java`: Clase que establece la conexión con la base de datos.

## Requisitos
- Java
- [XAMPP](https://www.apachefriends.org/es/index.html) (incluye MySQL)

## Configuración
1. Inicia XAMPP y asegúrate de que el servidor MySQL esté en ejecución.
2. Utiliza la clase `Conex.java` para establecer la conexión con la base de datos. Ajusta las configuraciones de conexión según tu entorno (ver `Conex.java`).
3. Ejecuta el script SQL proporcionado (`script.sql`) para crear la estructura de la base de datos y las tablas necesarias.

## Uso

### 1. Registro e Inicio de Sesión
1. Compila y ejecuta `login.java` para iniciar la aplicación.
2. Regístrate proporcionando tu nombre, apellido, correo electrónico, contraseña y selecciona el tipo de usuario (cliente).
3. Inicia sesión con el correo y la contraseña registrados.

### 2. Exploración de Cartelera
1. Después de iniciar sesión, se mostrará la cartelera. Haz clic en el botón "Películas" para desbloquearlas.
2. Selecciona una película y, si lo deseas, consulta la sinopsis.

### 3. Reserva de Boletos
1. Selecciona un horario y una sala (2D, 3D, 3D XD).
2. Si decides cancelar la reserva, puedes hacerlo; de lo contrario, procede a la selección de asientos.

### 4. Selección de Asientos
1. En la ventana de selección de asientos, marca los asientos disponibles (marcados en verde). La información del monto y la película reservada se actualiza automáticamente.

### 5. Método de Pago
1. Continúa al método de pago, donde puedes pagar con tarjeta de crédito, débito o en efectivo. Puedes proseguir o cancelar la compra en cada opción.

### 6. Generación de Factura
1. Después del pago, serás redirigido a la ventana de factura, donde se mostrarán los detalles de la compra.
