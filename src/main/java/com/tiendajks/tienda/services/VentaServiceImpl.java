package com.tiendajks.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendajks.tienda.models.dao.IVentaDao;
import com.tiendajks.tienda.models.entity.Venta;

@Service
public class VentaServiceImpl implements IVentaService{
	
	@Autowired
	private IVentaDao ventaDao;

	@Override
	public List<Venta> findAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	public void save(Venta venta) {
		venta.setPrecioTotal(venta.getCantidad() * venta.getPrecio());
		ventaDao.save(venta);
		
	}

	@Override
	public Venta findById(Long id) {
		return ventaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Venta venta) {
		ventaDao.delete(venta);
		
	}

}
