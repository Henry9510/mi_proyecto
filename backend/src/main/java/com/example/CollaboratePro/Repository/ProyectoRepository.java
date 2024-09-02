package com.example.CollaboratePro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CollaboratePro.model.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {

}
