package servlet.form;

public class PruebaForm {
	private String dias;
	private String notificaciones; 
	private String cantidad;
	private String nombre;
	private String comentarios;
	private String oculto;
	
	public PruebaForm(String dias, String notificaciones, String cantidad, String nombre, String comentarios,
			String oculto) {
		super();
		this.dias = dias;
		this.notificaciones = notificaciones;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.comentarios = comentarios;
		this.oculto = oculto;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getNotificaciones() {
		return notificaciones;
	}
	public void setNotificaciones(String notificaciones) {
		this.notificaciones = notificaciones;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getOculto() {
		return oculto;
	}
	public void setOculto(String oculto) {
		this.oculto = oculto;
	}
	
	
}
