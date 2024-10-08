package com.tiendajks.tienda.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tiendajks.tienda.models.entity.Venta;
import com.tiendajks.tienda.services.IVentaService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	private IVentaService ventaService;

	@GetMapping("/ventas")
	public List<Venta> index() {
		return ventaService.findAll();
	}

	@GetMapping("/ventas/{id}")
	public Venta show(@PathVariable Long id) {
		return this.ventaService.findById(id);
	}

	@PostMapping("/ventas")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta create(@RequestBody Venta venta) {
		venta.setCreateAt(new Date());
		this.ventaService.save(venta);
		return venta;
	}

	@PutMapping("/ventas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta update(@RequestBody Venta venta, @PathVariable Long id) {
		Venta currentVenta = this.ventaService.findById(id);
		//realizar un control con los id antes de modificar
		currentVenta.setCantidad(venta.getCantidad());
		currentVenta.setColor(venta.getColor());
		currentVenta.setPrecio(venta.getPrecio());
		currentVenta.setProducto(venta.getProducto());
		currentVenta.setPrecioTotal(venta.getCantidad() * venta.getPrecio());

		this.ventaService.save(currentVenta);
		return currentVenta;
	}

	@DeleteMapping("/ventas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Venta currentVenta = this.ventaService.findById(id);
		this.ventaService.delete(currentVenta);
	}

}
