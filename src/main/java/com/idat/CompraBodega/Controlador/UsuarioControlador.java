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

import com.idat.CompraBodega.dto.UsuarioDTORequest;
import com.idat.CompraBodega.dto.UsuarioDTOResponse;
import com.idat.CompraBodega.modelo.Usuario;
import com.idat.CompraBodega.servicio.UsuarioServicio;

@RestController
@RequestMapping("/Usuario/u1")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET )
	public ResponseEntity<List<UsuarioDTOResponse>> listarUsuario(){
		
		return new ResponseEntity<List<UsuarioDTOResponse>>(servicio.listarUsuario(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioDTORequest usuario){
		servicio.guardarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<UsuarioDTOResponse> listarporId(@PathVariable Integer id){
		
		UsuarioDTOResponse u = servicio.obtenerUsuarioId(id);
		if (u != null) 
			return new ResponseEntity<UsuarioDTOResponse>(u, HttpStatus.OK);
		
		return new ResponseEntity<UsuarioDTOResponse>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody UsuarioDTORequest usuario){
		
		UsuarioDTOResponse u = servicio.obtenerUsuarioId(usuario.getIdUsuarioDTO());
		
		
		if (u != null) {
			servicio.editarUsuario(usuario);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UsuarioDTOResponse u = servicio.obtenerUsuarioId(id);
		if (u != null) {
			servicio.eliminarUsuario(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	


}
