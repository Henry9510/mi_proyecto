package com.example.CollaboratePro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CollaboratePro.model.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado, Long> {


}