package com.idat.CompraBodega.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.CompraBodega.dto.ProductosDTORequest;
import com.idat.CompraBodega.dto.ProductosDTOResponse;
import com.idat.CompraBodega.dto.UsuarioDTOResponse;
import com.idat.CompraBodega.modelo.Productos;
import com.idat.CompraBodega.modelo.Usuario;
import com.idat.CompraBodega.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImpl implements ProductoServicio {
	
	@Autowired
	public ProductoRepositorio repositorio;

	@Override
	public void guardarProductos(ProductosDTORequest productos) {
		
		Productos p = new Productos();
		p.setDescripcion(productos.getDescripcionDTO());
		p.setIdProducto(productos.getIdProductoDTO());
		p.setPrecio(productos.getPrecioDTO());
		p.setProducto(productos.getProductoDTO());
		p.setStock(productos.getStockDTO());
		
		repositorio.save(p);
	}

	@Override
	public void editarProductos(ProductosDTORequest productos) {
		Productos p = new Productos();
		p.setDescripcion(productos.getDescripcionDTO());
		p.setIdProducto(productos.getIdProductoDTO());
		p.setPrecio(productos.getPrecioDTO());
		p.setProducto(productos.getProductoDTO());
		p.setStock(productos.getStockDTO());
		repositorio.saveAndFlush(p);
	}

	@Override
	public void eliminarProductos(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<ProductosDTOResponse> listarProductos() {
		List<ProductosDTOResponse> lista = new  ArrayList<ProductosDTOResponse>();
		ProductosDTOResponse p = null;
		
		for (Productos producto : repositorio.findAll()) {
			p = new ProductosDTOResponse();
			
			p.setDescripcionDTO(producto.getDescripcion());
			p.setIdProductoDTO(producto.getIdProducto());
			p.setPrecioDTO(producto.getPrecio());
			p.setProductoDTO(producto.getProducto());
			p.setStockDTO(producto.getStock());
			
			lista.add(p);
		}
		
		return lista;
	}

	@Override
	public ProductosDTOResponse obtenerProductosId(Integer id) {
		Productos producto = repositorio.findById(id).orElse(null);
		
		ProductosDTOResponse p = new ProductosDTOResponse();
		
		p.setDescripcionDTO(producto.getDescripcion());
		p.setIdProductoDTO(producto.getIdProducto());
		p.setPrecioDTO(producto.getPrecio());
		p.setProductoDTO(producto.getProducto());
		p.setStockDTO(producto.getStock());
		
		return p;
	}

}
