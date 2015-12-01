package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/HolaMundoServlet", "/hola-mundo" })
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Método que se va a ejecutar cuando la petición venga por GET Para
	 * ejecutar: 
	 * 1.- Ir a la vista Servers -> Start Server 
	 * 2.- Abrir en el navegador la siguiente URL: 
	 * http://localhost:8080/basico-web/
	 * 	hola-mundo?nombre=Juan&apellido=Jaimes
	 * http://localhost:8080/basico-web/HolaMundoServlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");

		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hola mundo</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("Hoy es " + new Date() + "<br>");

		if (nombre != null && apellido != null) {
			pw.println("Hola " + nombre + " " + apellido + "<br>");
		} else {
			pw.println("<form>");
			pw.println("Nombre: <input type='text' name='nombre'><br>");
			pw.println("Apellido: <input type='text' name='apellido'><br>");
			pw.println("<input type='submit' value='enviar'><br>");
			pw.println("</form>");
		}
		
		pw.println("</body>");
		pw.println("</html>");
	}

}
