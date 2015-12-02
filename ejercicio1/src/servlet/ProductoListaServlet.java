package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

@WebServlet("/producto-lista")
public class ProductoListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("	<meta charset='UTF-8'>");
		pw.println("	<title>Productos</title>");
		pw.println("	<style>");
		pw.println("		h1 {");
		pw.println("			text-align: center;");
		pw.println("		}");
		pw.println("		");
		pw.println("		table.tabla-centrada {");
		pw.println("			margin-left: auto;");
		pw.println("			margin-right: auto;");
		pw.println("		}		");
		pw.println("		");
		pw.println("		table.tabla-datos th {");
		pw.println("			background-color: gray;");
		pw.println("		}");
		pw.println("");
		pw.println("		table.tabla-datos tr:nth-child(odd) td {");
		pw.println("			background-color: lightgray;");
		pw.println("		}");
		pw.println("");
		pw.println("		table.tabla-datos tr:nth-child(even) td {");
		pw.println("			background-color: darkgray;");
		pw.println("		}");
		pw.println("		");
		pw.println("		#tabla-productos {");
		pw.println("			width: 80%;");
		pw.println("		}");
		pw.println("");
		pw.println("		#tabla-productos td:nth-child(1),");
		pw.println("		#tabla-productos td:nth-child(3) {");
		pw.println("			text-align: center;");
		pw.println("		}");
		pw.println("");
		pw.println("		#tabla-form tr:last-child td {");
		pw.println("			text-align: center;");
		pw.println("		}");
		pw.println("		");
		pw.println("		#tabla-form input[type=text],");
		pw.println("		#tabla-form input[type=number] {");
		pw.println("			width: 200px;");
		pw.println("		}");
		pw.println("		");
		pw.println("		.errores {");
		pw.println("			text-align: center;");
		pw.println("			background-color: red;");
		pw.println("		}");
		pw.println("	</style>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("	<h1>Productos</h1>");
		pw.println("	");

		HttpSession session = request.getSession();
		List<String> errores = (List<String>)
				session.getAttribute("errores");
		if (errores != null && errores.size() > 0) {

			pw.println("		<ul class='errores'>");

			for (String e : errores) {
				pw.println("			<li>" + e + "</li>");
			}
			
			pw.println("		</ul>");
			session.removeAttribute("errores");
		}
		pw.println("	");
		pw.println("	<form action='productos-agregar' method='post' novalidate>");
		pw.println("		<table id='tabla-form' class='tabla-centrada'>");
		pw.println("			<tr>");
		pw.println("				<td>Nombre</td>");
		pw.println("				<td><input type='text' name='nombre'>");
		pw.println("			</tr>");
		pw.println("			<tr>");
		pw.println("				<td>Precio</td>");
		pw.println("				<td><input type='number' name='precio'>");
		pw.println("			</tr>");
		pw.println("			<tr>");
		pw.println("				<td colspan='2'>");
		pw.println("					<input type='submit' name='operacion' value='Modificar'>");
		pw.println("					<input type='submit' name='operacion' value='Agregar'>");
		pw.println("				</td>");
		pw.println("			</tr>");
		pw.println("		</table>");
		pw.println("	</form>");
		pw.println("	");
		pw.println("	<br>");
		pw.println("		");
		pw.println("	<table id='tabla-productos' class='tabla-centrada tabla-datos'>");
		pw.println("		<tr>");
		pw.println("			<th>Id</th>");
		pw.println("			<th>Nombre</th>");
		pw.println("			<th>Precio</th>");
		pw.println("		</tr>	");

		List<Producto> productos =
				(List<Producto>)request.getAttribute("productos");
		if (productos != null) for (Producto p : productos) {
			pw.println("	<!-- Esto es un comentario -->");
			pw.println("		<tr>");
			pw.println("			<td>" +  p.getId() + "</td>");
			pw.println("			<td>" + p.getNombre() + "</td>");
			pw.println("			<td>" + p.getPrecio() + "</td>");
			pw.println("		</tr>");
		}

		pw.println("	</table>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
