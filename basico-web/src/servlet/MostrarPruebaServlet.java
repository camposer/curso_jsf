package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.form.PruebaForm;

@WebServlet("/mostrar-prueba")
public class MostrarPruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errores = (List<String>)
				request.getAttribute("errores");
		PruebaForm pruebaForm = (PruebaForm)
				request.getAttribute("pruebaForm");
		
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
			pw.println("Días: " + pruebaForm.getDias() + "<br>");
			pw.println("Notiticaciones: " + pruebaForm.getNotificaciones() + "<br>");
			pw.println("Cantidad: " + pruebaForm.getCantidad() + "<br>");
			pw.println("Nombre: " + pruebaForm.getNombre() + "<br>");
			pw.println("Comentarios: " + pruebaForm.getComentarios() + "<br>");
			pw.println("Oculto: " + pruebaForm.getOculto() + "<br>");
		}

		pw.println("</body>");
		
		pw.println("</html>");

	}

}
