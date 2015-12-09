package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

class ProductoServiceDummy implements ProductoService {
	private List<Producto> productos = new ArrayList<>();
	private long contador = 1;
	
	public ProductoServiceDummy() {
		init();
	}
	
	public void init() {
		agregar(new Producto("TV", 700.0));
		agregar(new Producto("Cámara", 150.0));
		agregar(new Producto("Portátil", 400.0));
	}
	
	private int buscarPos(Long id) {
		for (int i = 0; i < productos.size(); i++) {
			Producto p = productos.get(i);
			
			if (p.getId().equals(id))
				return i;
		}
		return -1;
	}
	
	@Override
	public void agregar(Producto p) {
		p.setId(contador++);
		productos.add(p);
	}

	@Override
	public void modificar(Producto p) {
		int pos = buscarPos(p.getId());
		if (pos >= 0)
			productos.set(pos, p);
	}

	@Override
	public void eliminar(Long id) {
		int pos = buscarPos(id);
		if (pos >= 0)
			productos.remove(pos);
	}

	@Override
	public Producto obtener(Long id) {
		int pos = buscarPos(id);
		if (pos >= 0)
			return productos.get(pos);
		else 
			return null;
	}

	@Override
	public List<Producto> obtenerTodos() {
		return productos;
	}

}
