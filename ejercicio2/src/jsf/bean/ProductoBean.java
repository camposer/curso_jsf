package jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jsf.form.ProductoForm;
import model.Producto;
import service.ProductoService;
import service.ProductoServiceFactory;

@ManagedBean // name = productoBean
@SessionScoped
public class ProductoBean {
	private ProductoService productoService;
	private ProductoForm productoForm;
	private List<String> errores;
	
	// Ejecutar http://localhost:8080/ejercicio2/productos.jsf
	public ProductoBean() {
		productoService = 
				ProductoServiceFactory.createProductoService();
		productoForm = new ProductoForm();
		errores = new ArrayList<>();
	}
	
	public String guardar() {
		errores = new ArrayList<>();
		Producto producto = new Producto();
		
		// Validar
		try { // Id
			long id = Long.parseLong(productoForm.getId());
			producto.setId(id);
		} catch(Exception e) {
			e.printStackTrace();
		}

		try { // Nombre
			String nombre = productoForm.getNombre();
			if (nombre.trim().length() < 3)
				throw new Exception();
			producto.setNombre(nombre);
		} catch(Exception e) {
			e.printStackTrace();
			errores.add("Nombre inválido");
		}
	
		try { // Precio
			double precio = 
					Double.parseDouble(productoForm.getPrecio());
			if (precio < 0)
				throw new Exception();
			producto.setPrecio(precio);
		} catch(Exception e) {
			e.printStackTrace();
			errores.add("Precio inválido");
		}
		
		if (errores.size() == 0) {
			ProductoService productoService =
					ProductoServiceFactory.createProductoService();

			if (producto.getId() == null)
				productoService.agregar(producto);
			else {
				productoService.modificar(producto);
				productoForm = new ProductoForm();
			}
		} 

		return "productos?faces-redirect=true"; 
		
	}
	
	public List<Producto> getProductos() {
		return productoService.obtenerTodos();
	}

	public ProductoForm getProductoForm() {
		return productoForm;
	}

	public void setProductoForm(ProductoForm productoForm) {
		this.productoForm = productoForm;
	}

	public List<String> getErrores() {
		return errores;
	}

	public void setErrores(List<String> errores) {
		this.errores = errores;
	}
		
}