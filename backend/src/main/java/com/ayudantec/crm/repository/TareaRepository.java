package com.ayudantec.crm.repository;

import com.ayudantec.crm.model.Cliente;
import com.ayudantec.crm.model.Oportunidad;
import com.ayudantec.crm.model.Tarea;
import com.ayudantec.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByUsuario(User usuario);
    List<Tarea> findByCliente(Cliente cliente);
    List<Tarea> findByOportunidad(Oportunidad oportunidad);
    List<Tarea> findByCompletada(boolean completada);
    List<Tarea> findByFechaVencimientoBefore(LocalDateTime fecha);
    List<Tarea> findByUsuarioAndCompletada(User usuario, boolean completada);
}