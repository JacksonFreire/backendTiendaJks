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

import com.tiendajks.tienda.models.entity.Producto;
import com.tiendajks.tienda.services.IProductoService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/administrar")
public class AdministracionController {

	@Autowired
	private IProductoService productoService;

	@GetMapping("/productos")
	public List<Producto> index() {
		return productoService.findAll();
	}

	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return this.productoService.findById(id);
	}

	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		producto.setCreateAt(new Date());
		this.productoService.save(producto);
		return producto;
	}

	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto currentProducto = this.productoService.findById(id);

		currentProducto.setNombre(producto.getNombre());
		currentProducto.setMarca(producto.getMarca());
		currentProducto.setPrecio(producto.getPrecio());
		currentProducto.setDetalles(producto.getDetalles());
		currentProducto.setCantidad(producto.getCantidad());

		this.productoService.save(currentProducto);
		return currentProducto;
	}

	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Producto currentProducto = this.productoService.findById(id);
		this.productoService.delete(currentProducto);
	}

	@GetMapping("/filtrar-productos/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> filtrarProductos(@PathVariable String term) {
		return productoService.findProductsByTerm(term);
	}

}
