package com.idat.CompraBodega.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.CompraBodega.dto.ProductosDTORequest;
import com.idat.CompraBodega.dto.ProductosDTOResponse;
import com.idat.CompraBodega.modelo.Productos;
import com.idat.CompraBodega.servicio.ProductoServicio;

@RestController
@RequestMapping("/producto/p1")
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET )
	public ResponseEntity<List<ProductosDTOResponse>> listarProductos(){
		
		return new ResponseEntity<List<ProductosDTOResponse>>(servicio.listarProductos(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductosDTORequest productos){
		servicio.guardarProductos(productos);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ProductosDTOResponse> listarporId(@PathVariable Integer id){
		
		ProductosDTOResponse p = servicio.obtenerProductosId(id);
		if (p != null) 
			return new ResponseEntity<ProductosDTOResponse>(p, HttpStatus.OK);
		
		return new ResponseEntity<ProductosDTOResponse>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody ProductosDTORequest productos){
		
		ProductosDTOResponse p = servicio.obtenerProductosId(productos.getIdProductoDTO());		
		
		if (p != null) {
			servicio.editarProductos(productos);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProductosDTOResponse p = servicio.obtenerProductosId(id);
		if (p != null) {
			servicio.eliminarProductos(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	

	

}
