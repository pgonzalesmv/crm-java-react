package com.ayudantec.crm.repository;

import com.ayudantec.crm.model.Cliente;
import com.ayudantec.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByUsuario(User usuario);
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    List<Cliente> findByEmpresaContainingIgnoreCase(String empresa);
}