package com.idat.CompraBodega.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.CompraBodega.dto.BodegaDTORequest;
import com.idat.CompraBodega.dto.BodegaDTOResponse;
import com.idat.CompraBodega.dto.UsuarioDTOResponse;
import com.idat.CompraBodega.modelo.Bodega;
import com.idat.CompraBodega.modelo.Usuario;
import com.idat.CompraBodega.repositorio.BodegaRepositorio;

@Service
public class BodegaServicioImpl implements BodegaServicio {
	
	@Autowired
	public BodegaRepositorio repositorio;

	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		
		Bodega b = new Bodega();
		b.setDireccion(bodega.getDireccionDTO());
		b.setIdBodega(bodega.getIdBodegaDTO());
		b.setNombre(bodega.getNombreDTO());
		
		repositorio.save(b);
	}

	@Override
	public void editarBodega(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		b.setDireccion(bodega.getDireccionDTO());
		b.setIdBodega(bodega.getIdBodegaDTO());
		b.setNombre(bodega.getNombreDTO());
		
		repositorio.saveAndFlush(b);
	}

	@Override
	public void eliminarBodega(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {
		List<BodegaDTOResponse> lista = new  ArrayList<BodegaDTOResponse>();
		BodegaDTOResponse b = null;
		
		for (Bodega bodega : repositorio.findAll()) {
			b = new BodegaDTOResponse();
			
			b.setDireccionDTO(bodega.getDireccion());
			b.setIdBodegaDTO(bodega.getIdBodega());
			b.setNombreDTO(bodega.getNombre());
			lista.add(b);
		}
		
		return lista;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		Bodega bodega = repositorio.findById(id).orElse(null);
		
		BodegaDTOResponse b = new BodegaDTOResponse();
		
		b.setDireccionDTO(bodega.getDireccion());
		b.setIdBodegaDTO(bodega.getIdBodega());
		b.setNombreDTO(bodega.getNombre());
		
		return b;

	}
}
