package com.idat.CompraBodega.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.CompraBodega.modelo.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {	

}
