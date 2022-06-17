package com.idat.CompraBodega.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.CompraBodega.modelo.Bodega;


@Repository
public interface BodegaRepositorio extends JpaRepository<Bodega, Integer> {
	

}
