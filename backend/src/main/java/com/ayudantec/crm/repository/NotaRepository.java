package com.ayudantec.crm.repository;

import com.ayudantec.crm.model.Cliente;
import com.ayudantec.crm.model.Nota;
import com.ayudantec.crm.model.Oportunidad;
import com.ayudantec.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByUsuario(User usuario);
    List<Nota> findByCliente(Cliente cliente);
    List<Nota> findByOportunidad(Oportunidad oportunidad);
}