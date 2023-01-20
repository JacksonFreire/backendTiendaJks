package com.tiendajks.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendajks.tienda.models.dao.IVentaDao;
import com.tiendajks.tienda.models.entity.Venta;

@Service
public class VentaServiceImpl implements IVentaService{
	
	@Autowired
	private IVentaDao ventaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Venta> findAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public void save(Venta venta) {
		ventaDao.save(venta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Venta findById(Long id) {
		return ventaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public void delete(Venta venta) {
		ventaDao.delete(venta);
		
	}

}
