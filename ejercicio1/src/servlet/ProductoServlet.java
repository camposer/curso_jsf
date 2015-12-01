package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductoService;
import service.ProductoServiceFactory;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoService productoService = ProductoServiceFactory.createProductoService();
		request.setAttribute("productos", productoService.obtenerTodos());
		getServletContext()
		.getRequestDispatcher("/WEB-INF/jsp/productos.jsp")
		.forward(request, response);
			
	}

}
