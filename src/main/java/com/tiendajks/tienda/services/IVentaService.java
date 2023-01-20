package com.tiendajks.tienda.services;

import java.util.List;

import com.tiendajks.tienda.models.entity.Venta;

public interface IVentaService {
	
	public List<Venta> findAll();
	
	public void save(Venta venta);
	
	public Venta findById(Long id);
	
	public void delete(Venta venta);

}
