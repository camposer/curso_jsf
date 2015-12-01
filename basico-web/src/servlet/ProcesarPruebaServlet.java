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

import servlet.form.PruebaForm;

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
		
		// Llenado de form
		PruebaForm pruebaForm = 
				new PruebaForm(dias, notificaciones, 
				cantidad, nombre, comentarios, oculto);
		
		// Validaciones
		validarDias(pruebaForm.getDias(), errores);
		validarNotificaciones(pruebaForm.getNotificaciones(), errores);
		validarCantidad(pruebaForm.getCantidad(), errores);
		validarNombre(pruebaForm.getNombre(), errores);
		validarComentarios(pruebaForm.getComentarios(), errores);
		validarOculto(pruebaForm.getOculto(), errores);

		// Redirección
		// Atributos para la redirección
		request.setAttribute("errores", errores);
		request.setAttribute("pruebaForm", pruebaForm);
		
		getServletContext()
			.getRequestDispatcher("/mostrar-prueba") // mapping válido del lado del servidor
			.forward(request, response);
	}

	private void validarOculto(String oculto, List<String> errores) {
		try {
			oculto.trim();
		} catch(Exception e) {
			errores.add("Oculto inválido");
		}
	}

	private void validarComentarios(String comentarios, List<String> errores) {
		try {
			comentarios.trim();
		} catch(Exception e) {
			errores.add("Comentarios inválidos");
		}
	}

	private void validarNombre(String nombre, List<String> errores) {
		try {
			nombre.trim();
			if (nombre.length() == 0)
				throw new Exception();
		} catch(Exception e) {
			errores.add("Nombre inválido");
		}
	}

	private void validarCantidad(String cantidad, List<String> errores) {
		try {
			int icantidad = Integer.parseInt(cantidad);
			if (icantidad < 0)
				throw new Exception();
		} catch(Exception e) {
			errores.add("Cantidad inválida");
		}
		
	}

	private void validarNotificaciones(String notificaciones, List<String> errores) {
		try {
			Boolean.parseBoolean(notificaciones);
		} catch(Exception e) {
			errores.add("Notificación inválida");
		}
	}

	private void validarDias(String dias, List<String> errores) {
		try { 
			Integer idias = Integer.parseInt(dias);
			if (idias < 1 || idias > 3)
				throw new Exception();
		} catch(Exception e) {
			errores.add("Días inválidos");
		}
	}

}
