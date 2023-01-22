package com.tiendajks.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendajks.tienda.models.dao.IProductoDao;
import com.tiendajks.tienda.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	public void save(Producto producto) {
		productoDao.save(producto);
		
	}

	@Override
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> findProductsByTerm(String term) {
		 return productoDao.findByNombreContainingIgnoreCase(term);
	}

	@Override
	public void delete(Producto producto) {
		productoDao.delete(producto);	
	}

}
