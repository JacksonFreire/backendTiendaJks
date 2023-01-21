package com.tiendajks.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendajks.tienda.models.dao.IProductoDao;
import com.tiendajks.tienda.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public void save(Producto producto) {
		productoDao.save(producto);
		
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
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
