# Cómo configurar el proyecto

## Pre-requisitos

- JDK 8+ (descargar e instalar)
- Eclipse Mars (descargar, descomprimir y ejecutar)
- Apache Tomcat 8 (descargar y descomprimir)

## Configuración

Dentro de la perspectiva JEE:

- Abrir la vista Servers
	- Add new server
	- Seleccionar Apache Tomcat 8
	- Especificar carpeta donde se decomprimió el Apache Tomcat
- Descargar el código del repositorio (Download ZIP)
- Crear librería de usuario
	- Clic en Windows -> Preferences -> User Libraries
	- Añadir nueva librería: `jsf_libs`
	- Seleccionar "Add external JARS" y añadir todos los JARS contenidos en la carpeta `jsf_libs`
- Clic en File -> Import -> General -> Existing projects into Workspace
	- Seleccionar el ZIP descargado de Github
- Verificar que el proyecto se encuentra asociado al Servidor
	- Clic derecho en el servidor Tomcat dentro de la vista Servers -> Add and remove
- Iniciar servidor 
