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

import com.idat.CompraBodega.dto.BodegaDTORequest;
import com.idat.CompraBodega.dto.BodegaDTOResponse;
import com.idat.CompraBodega.modelo.Bodega;
import com.idat.CompraBodega.servicio.BodegaServicio;

@RestController
@RequestMapping("/bodega/b1")
public class BodegaControlador {
	
	@Autowired
	private BodegaServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET )
	public ResponseEntity<List<BodegaDTOResponse>> listarBodegas(){
		
		return new ResponseEntity<List<BodegaDTOResponse>>(servicio.listarBodega(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody BodegaDTORequest bodega){
		servicio.guardarBodega(bodega);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<BodegaDTOResponse> listarporId(@PathVariable Integer id){
		
		BodegaDTOResponse b = servicio.obtenerBodegaId(id);
		if (b != null) 
			return new ResponseEntity<BodegaDTOResponse>(b, HttpStatus.OK);
		
		return new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody BodegaDTORequest bodega){
		
		BodegaDTOResponse b = servicio.obtenerBodegaId(bodega.getIdBodegaDTO());
		
		
		if (b != null) {
			servicio.editarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		BodegaDTOResponse b = servicio.obtenerBodegaId(id);
		if (b != null) {
			servicio.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	

}
