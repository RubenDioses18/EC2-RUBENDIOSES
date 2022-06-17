package com.idat.CompraBodega.servicio;

import java.util.List;

import com.idat.CompraBodega.dto.UsuarioDTORequest;
import com.idat.CompraBodega.dto.UsuarioDTOResponse;
import com.idat.CompraBodega.modelo.Usuario;

public interface UsuarioServicio {
	
	public void guardarUsuario (UsuarioDTORequest usuario);
	public void editarUsuario (UsuarioDTORequest usuario);
	public void eliminarUsuario (Integer id);
	public List<UsuarioDTOResponse> listarUsuario();
	public UsuarioDTOResponse obtenerUsuarioId(Integer id);


}
