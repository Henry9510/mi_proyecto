/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.CollaboratePro.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CollaboratePro.model.Producto;



/**
 *
 * @author Henry
 */
@Repository
public interface ProductoRepository  extends JpaRepository <Producto, Long> {
    
}
