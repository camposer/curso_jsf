package service;

public abstract class ProductoServiceFactory {
	private static ProductoService INSTANCE = new ProductoServiceDummy();
	
	public static ProductoService createProductoService() {
		return INSTANCE;
	}
}
