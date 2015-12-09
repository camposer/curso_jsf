package jsf.bean;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="holaMundo")
//@RequestScoped
@SessionScoped
public class HolaMundoManagedBean {
	private String nombre = "María";
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
}
