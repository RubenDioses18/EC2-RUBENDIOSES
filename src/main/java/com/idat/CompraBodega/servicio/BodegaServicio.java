package com.idat.CompraBodega.servicio;

import java.util.List;

import com.idat.CompraBodega.dto.BodegaDTORequest;
import com.idat.CompraBodega.dto.BodegaDTOResponse;


public interface BodegaServicio {
	
	public void guardarBodega ( BodegaDTORequest bodega);
	public void editarBodega (BodegaDTORequest bodega);
	public void eliminarBodega (Integer id);
	public List<BodegaDTOResponse> listarBodega();
	public BodegaDTOResponse obtenerBodegaId(Integer id);

}
