package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Producto;

@WebServlet("/producto-lista")
public class ProductoListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> productos = (List<Producto>)
			request.getAttribute("productos");

		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("	<meta charset='UTF-8'>");
		pw.println("	<title>Productos</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("	<h1>Listado de Productos</h1>");
		pw.println("	<table>");
		pw.println("		<tr>");
		pw.println("			<th>Id</th>");
		pw.println("			<th>Nombre</th>");
		pw.println("			<th>Precio</th>");
		pw.println("		</tr>	");

		if (productos != null) for (Producto p : productos) {
			pw.println("	<tr>");
			pw.println("		<td>" +  p.getId() + "</td>");
			pw.println("		<td>" + p.getNombre() + "</td>");
			pw.println("		<td>" + p.getPrecio() + "</td>");
			pw.println("	</tr>");
		}

		pw.println("	</table>");
		pw.println("	");
		pw.println("</body>");
		pw.println("</html>");
	
	}

}
