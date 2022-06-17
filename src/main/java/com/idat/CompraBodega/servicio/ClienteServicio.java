package com.idat.CompraBodega.servicio;

import java.util.List;

import com.idat.CompraBodega.dto.ClienteDTORequest;
import com.idat.CompraBodega.dto.ClienteDTOResponse;


public interface ClienteServicio {
	
	public void guardarCliente ( ClienteDTORequest cliente);
	public void editarCliente (ClienteDTORequest cliente);
	public void eliminarCliente (Integer id);
	public List<ClienteDTOResponse> listarCliente();
	public ClienteDTOResponse obtenerClienteId(Integer id);

}
