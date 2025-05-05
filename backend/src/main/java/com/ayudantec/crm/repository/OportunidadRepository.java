package com.ayudantec.crm.repository;

import com.ayudantec.crm.model.Cliente;
import com.ayudantec.crm.model.Oportunidad;
import com.ayudantec.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Long> {
    List<Oportunidad> findByUsuario(User usuario);
    List<Oportunidad> findByCliente(Cliente cliente);
    List<Oportunidad> findByEtapa(Oportunidad.Etapa etapa);
    List<Oportunidad> findByFechaCierreBetween(LocalDate inicio, LocalDate fin);
}