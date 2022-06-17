package com.idat.CompraBodega.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.CompraBodega.dto.ClienteDTORequest;
import com.idat.CompraBodega.dto.ClienteDTOResponse;
import com.idat.CompraBodega.dto.UsuarioDTOResponse;
import com.idat.CompraBodega.modelo.Bodega;
import com.idat.CompraBodega.modelo.Cliente;
import com.idat.CompraBodega.modelo.Usuario;
import com.idat.CompraBodega.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired
	public ClienteRepositorio repositorio;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setNombre(cliente.getNombreDTO());
		
		repositorio.save(c);
	}

	@Override
	public void editarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setNombre(cliente.getNombreDTO());
		repositorio.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarCliente() {
		List<ClienteDTOResponse> lista = new  ArrayList<ClienteDTOResponse>();
		ClienteDTOResponse c = null;
		
		for (Cliente cliente : repositorio.findAll()) {
			c = new ClienteDTOResponse();
			
			c.setDireccionDTO(cliente.getDireccion());
			c.setDniDTO(cliente.getDni());
			c.setIdClienteDTO(cliente.getIdCliente());
			c.setNombreDTO(cliente.getNombre());
			
			lista.add(c);
		}
		
		return lista;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		Cliente cliente = repositorio.findById(id).orElse(null);
		
		ClienteDTOResponse c = new ClienteDTOResponse();
		
		c.setDireccionDTO(cliente.getDireccion());
		c.setDniDTO(cliente.getDni());
		c.setIdClienteDTO(cliente.getIdCliente());
		c.setNombreDTO(cliente.getNombre());
		
		return c;
	}

}
