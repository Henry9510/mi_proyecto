package com.example.CollaboratePro.Servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.CollaboratePro.controller.dto.UsuarioRegistroDTO;
import com.example.CollaboratePro.model.Usuario;




public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
