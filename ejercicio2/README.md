# Ejercicio 2

1.- Refactorizar el CRUD de Producto implementado en el ejercicio 1 para que ahora utilice JSF. Orden sugerido:
- Listar
- Agregar
- Eliminar
- Mostrar
- Modificar

NOTAS/TIPS:
- La nueva URL de ejecución es: http://localhost:8080/ejercicio2/productos
- Deberá cambiar la URL por algo del tipo: http://localhost:8080/ejercicio2/productos.jsf
	- Esto requiere un nuevo fichero productos.xhtml basado en el productos.jsp inicial
	- La lógica de los servlets deberá llevarla a uno o varios Managed Beans (Ej. jsf.bean.ProductoBean)

2.- Añadir validaciones y conversores al CRUD de Producto. La idea es transformar la clase ProductoForm para que ahora maneje los tipos adecuados.

3.- Siguiendo el código de `basico-web` y el tutorial [JSF 2 internationalization example](http://www.mkyong.com/jsf2/jsf-2-internationalization-example/) añadir un *drop-down list* que permita cambiar el idioma en que se muestra la aplicación.
