package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;
import service.ProductoService;
import service.ProductoServiceFactory;

@WebServlet("/productos-agregar")
public class ProductoAgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errores = new ArrayList<>();
		
		String nombre = request.getParameter("nombre");
		String sprecio = request.getParameter("precio");
		String operacion = request.getParameter("operacion");
		
		Producto producto = new Producto();
		
		// Validar
		try { // Nombre
			if (nombre.trim().length() < 3)
				throw new Exception();
			producto.setNombre(nombre);
		} catch(Exception e) {
			errores.add("Nombre inválido");
		}
	
		try { // Precio
			double precio = Double.parseDouble(sprecio);
			if (precio < 0)
				throw new Exception();
			producto.setPrecio(precio);
		} catch(Exception e) {
			errores.add("Precio inválido");
		}
		
		// Agregar
		if (errores.size() == 0) {
			ProductoService productoService =
					ProductoServiceFactory.createProductoService();
			productoService.agregar(producto);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errores", errores);
		}

		response.sendRedirect("/ejercicio1/productos"); //  URL válida para el navegador
	}

}
