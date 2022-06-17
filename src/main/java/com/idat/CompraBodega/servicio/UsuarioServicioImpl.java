package com.idat.CompraBodega.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.CompraBodega.dto.UsuarioDTORequest;
import com.idat.CompraBodega.dto.UsuarioDTOResponse;
import com.idat.CompraBodega.modelo.Usuario;
import com.idat.CompraBodega.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	public UsuarioRepositorio repositorio;

	@Override
	public void guardarUsuario(UsuarioDTORequest usuario) {

		Usuario u = new Usuario();
		u.setIdUsuario(usuario.getIdUsuarioDTO());
		u.setPassword(usuario.getPasswordDTO());
		u.setRol(usuario.getRolDTO());
		u.setUsuario(usuario.getUsuarioDTO());
		
		repositorio.save(u);
	}

	@Override
	public void editarUsuario(UsuarioDTORequest usuario) {
		Usuario u = new Usuario();
		u.setIdUsuario(usuario.getIdUsuarioDTO());
		u.setPassword(usuario.getPasswordDTO());
		u.setRol(usuario.getRolDTO());
		u.setUsuario(usuario.getUsuarioDTO());
		repositorio.saveAndFlush(u);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuario() {
		
		List<UsuarioDTOResponse> lista = new  ArrayList<UsuarioDTOResponse>();
		UsuarioDTOResponse u = null;
		
		for (Usuario usuario : repositorio.findAll()) {
			u = new UsuarioDTOResponse();
			
			u.setIdUsuarioDTO(usuario.getIdUsuario());
			u.setPasswordDTO(usuario.getPassword());
			u.setRolDTO(usuario.getRol());
			u.setUsuarioDTO(usuario.getUsuario());
			
			lista.add(u);
		}
		
		return lista;
		
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {

		Usuario usuario = repositorio.findById(id).orElse(null);
		
		UsuarioDTOResponse u = new UsuarioDTOResponse();
		
		u.setIdUsuarioDTO(usuario.getIdUsuario());
		u.setPasswordDTO(usuario.getPassword());
		u.setRolDTO(usuario.getRol());
		u.setUsuarioDTO(usuario.getUsuario());
		
		return u;
	}

}
