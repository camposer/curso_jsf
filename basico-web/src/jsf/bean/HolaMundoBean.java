package jsf.bean;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name="holaMundo")
//@RequestScoped
@SessionScoped
public class HolaMundoBean {
	private String nombre = "María";
	private Integer edad = 18;
	private List<String> numeros = 
		Arrays.asList(new String[]{ "uno", "dos", "tres" });

	public String enviar() {
		nombre += " ...";
		//return "mostrar"; // forward: mostrar.jsf
		return "mostrar?faces-redirect=true"; // redirect: mostrar.jsf
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<String> numeros) {
		this.numeros = numeros;
	}
	
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void validarNombre(FacesContext ctx,
			UIComponent component, Object valor) {
		
		ResourceBundle bundle = 
				ResourceBundle.getBundle("jsf.i18n.messages", 
				ctx.getViewRoot().getLocale());
	    
		String nombre = (String)valor;
		if (nombre.trim().length() < 3) {
			FacesMessage mensaje = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"nombre",
					bundle.getString("input.nombre.error.longitudInvalida"));
			throw new ValidatorException(mensaje);
		}
	}
	
	public String getSaludo() {
		if (edad >= 18)
			return "Felicitaciones " + nombre + ", tienes edad para conducir";
		else
			return "Lo siento " + nombre + ", aún no tienes edad para conducir";
	}
}
