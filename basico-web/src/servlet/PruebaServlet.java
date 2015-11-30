package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prueba")
public class PruebaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("	<meta charset='UTF-8'>");
		pw.println("	<title>Prueba</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("	<form>");
		pw.println("		<table border='1'>");
		pw.println("			<tr>");
		pw.println("				<td>Días necesarios:</td>");
		pw.println("				<td>");
		
		for (int i = 0; i < 10; i++) {
			pw.println("					" + i 
					+ "<input type='radio' name='dias' "
					+ "value='" + i + "'>");
		}
		
		pw.println("				</td>");
		pw.println("			</tr>");
		pw.println("			<tr>");
		pw.println("				<td>Enviar notificaciones:</td>");
		pw.println("				<td>");
		pw.println("					<input ");
		pw.println("						type='checkbox' ");
		pw.println("						name='notificaciones'");
		pw.println("						checked='checked'>");
		pw.println("				</td>");
		pw.println("			</tr>");
		pw.println("			<tr>");
		pw.println("				<td>Nombre:</td>");
		pw.println("				<td><input type='text' name='nombre' value='Daniel'></td>");
		pw.println("			</tr>");
		pw.println("			<tr>");
		pw.println("				<td>Comentarios:</td>");
		pw.println("				<td>");
		pw.println("					<textarea name='comentarios'>Ninguno</textarea>");
		pw.println("				</td>");
		pw.println("			</tr>");
		pw.println("			<tr>");
		pw.println("				<td>Cantidad:</td>");
		pw.println("				<td>");
		pw.println("					<select name='cantidad'>");
		pw.println("						<option value='1'>Uno</option>");
		pw.println("						<option value='2'>Dos</option>");
		pw.println("						<option value='3' selected='selected'>Tres</option>");
		pw.println("					</select>");
		pw.println("				</td>");
		pw.println("			</tr>");
		pw.println("			<tr>");
		pw.println("				<td colspan='2' align='center'>");
		pw.println("					<input type='button' value='Botón'>");
		pw.println("					<input type='reset' value='Reestablecer'>");
		pw.println("					<input type='submit' value='Enviar'>");
		pw.println("				</td>");
		pw.println("			</tr>");
		pw.println("		</table>");
		pw.println("		<input type='hidden' name='oculto' value='valoroculto'>");
		pw.println("	</form>");
		pw.println("</body>");
		pw.println("</html>");

	
	}

}
