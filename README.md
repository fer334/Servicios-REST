# Servicios-REST
Tarea sobre servicios rest para la materia de Sistemas Distribuidos.
# Uso
clonar este repositorio
```sh
git clone https://github.com/fer334/Servicios-REST/
```
crear el build de maven, el archivo .war
```sh
mvn clean install
```
correr el servidor wildfly y luego deployar el archivo movil.war

Una vez que el servidor se encuentre corriendo, se debe abrir el index.html que se encuentra en la carpeta cliente con cualquier navegador.

# Capturas
Se muestra la pagina principal del cliente
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-48-50.png?raw=true "Optional Title") 
Al presionar el boton registrar movil se muestra el form para registrar un movil
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-51-31.png?raw=true "Optional Title") 
Alert que confirma el registro del movil 201
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-53-16.png?raw=true "Optional Title") 
Al presionar el boton Ubicar movil se muestra el respectivo form
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-54-24.png?raw=true "Optional Title") 
El cliente hace una peticion al servidor para mostrar todos los vehiculos, al recibir la respuesta lo muestra mediante el componente seleccion
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-54-26.png?raw=true "Optional Title") 
Se muestra los logs del servidor, se confirma la creacion del movil de la segunda captura y el servidor muestra la lista de moviles registrados
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-54-56.png?raw=true "Optional Title") 
Se llena los datos para registrar una ubicacion
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-55-24.png?raw=true "Optional Title") 
Alert que nos confirma el registro de la ubicacion 
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-56-00.png?raw=true "Optional Title") 
El ultimo mensaje del log del servidor corresponde al registro de la ubicacion
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-56-06.png?raw=true "Optional Title") 
Menu para listar los moviles cercanos a una ubicacion
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-57-15.png?raw=true "Optional Title") 
Al darle al boton listar se muestra una tabla con los moviles cercanos a la ubicacion dada
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-58-15.png?raw=true "Optional Title") 
El servidor muestra el log correspondiente a la peticion del cliente
![Alt text](capturas/Captura&#32;de&#32;pantalla&#32;de&#32;2020-10-13&#32;01-58-19.png?raw=true "Optional Title")
