package com.idat.CompraBodega.servicio;

import java.util.List;

import com.idat.CompraBodega.dto.ProductosDTORequest;
import com.idat.CompraBodega.dto.ProductosDTOResponse;


public interface ProductoServicio {
	
	public void guardarProductos ( ProductosDTORequest productos);
	public void editarProductos (ProductosDTORequest productos);
	public void eliminarProductos (Integer id);
	public List<ProductosDTOResponse> listarProductos();
	public ProductosDTOResponse obtenerProductosId(Integer id);

}
