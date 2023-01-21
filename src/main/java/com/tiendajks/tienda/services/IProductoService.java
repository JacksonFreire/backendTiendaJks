package com.tiendajks.tienda.services;

import java.util.List;

import com.tiendajks.tienda.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public void save(Producto producto);
	
	public Producto findById(Long id);
	
	public List<Producto> findProductsByTerm(String term);
	
	public void delete(Producto producto);

}
