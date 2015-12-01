package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/procesar-prueba")
public class ProcesarPruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errores = new ArrayList<>();
		
		// Captura de datos
		String dias = request.getParameter("dias");
		String notificaciones = request.getParameter("notificaciones");
		String cantidad = request.getParameter("cantidad");
		String nombre = request.getParameter("nombre");
		String comentarios = request.getParameter("comentarios");
		String oculto = request.getParameter("oculto");

		// Validaciones
		// Días
		try { 
			Integer idias = Integer.parseInt(dias);
			if (idias < 1 || idias > 3)
				throw new Exception();
		} catch(Exception e) {
			errores.add("Días inválidos");
		}
		
		// Notificaciones
		try {
			Boolean.parseBoolean(notificaciones);
		} catch(Exception e) {
			errores.add("Notificación inválida");
		}
		
		// Cantidad
		try {
			int icantidad = Integer.parseInt(cantidad);
			if (icantidad < 0)
				throw new Exception();
		} catch(Exception e) {
			errores.add("Cantidad inválida");
		}
		
		// Nombre
		try {
			nombre.trim();
			if (nombre.length() == 0)
				throw new Exception();
		} catch(Exception e) {
			errores.add("Nombre inválido");
		}
		
		// Comentarios
		try {
			comentarios.trim();
		} catch(Exception e) {
			errores.add("Comentarios inválidos");
		}

		// Oculto
		try {
			oculto.trim();
		} catch(Exception e) {
			errores.add("Oculto inválido");
		}
		
		// Impresión
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>Resultado de pruebas</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		if (errores.size() > 0) {
			pw.println("<ul>");
			for (String e : errores)
				pw.println("<li>" + e + "</li>");
			pw.println("</ul>");
		} else {
			pw.println("Días: " + dias + "<br>");
			pw.println("Notiticaciones: " + notificaciones + "<br>");
			pw.println("Cantidad: " + cantidad + "<br>");
			pw.println("Nombre: " + nombre + "<br>");
			pw.println("Comentarios: " + comentarios + "<br>");
			pw.println("Oculto: " + oculto + "<br>");
		}

		pw.println("</body>");
		
		pw.println("</html>");
	}

}
