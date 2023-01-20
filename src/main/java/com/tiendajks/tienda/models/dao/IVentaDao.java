package com.tiendajks.tienda.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.tiendajks.tienda.models.entity.Venta;

public interface IVentaDao extends CrudRepository<Venta, Long> {

}
