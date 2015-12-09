package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductoService;
import service.ProductoServiceFactory;

@WebServlet("/productos-eliminar")
public class ProductoEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errores = new ArrayList<>();
		String sid = request.getParameter("id");
		long id = -1L;
		
		try {
			id = Integer.parseInt(sid);
			if (id < 0)
				throw new Exception();
		} catch(Exception e) {
			e.printStackTrace();
			errores.add("Id inválido");
		}
		
		if (errores.size() == 0) {
			ProductoService productoService = 
					ProductoServiceFactory.createProductoService();
			productoService.eliminar(id);
		} else {
			request.getSession().setAttribute("errores", errores);
		}
		
		response.sendRedirect("productos"); // URL válida para el Navegadors
	}

}
