package service;

import java.util.List;

import model.Producto;

public interface ProductoService {
	void agregar(Producto p);
	void modificar(Producto p);
	void eliminar(Long id);
	Producto obtener(Long id);
	List<Producto> obtenerTodos();
}
