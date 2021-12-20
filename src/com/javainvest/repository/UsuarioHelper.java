package com.javainvest.repository;

import java.util.ArrayList;
import java.util.List;

import com.javainvest.model.Usuario;

public class UsuarioHelper {
	
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void init() {
		usuarios.add(new Usuario(1,"Vladmir","vlad", 1234,100.0, 0.0));
		usuarios.add(new Usuario(2,"Mario","mario", 1234,2000.0, 0.0));
		usuarios.add(new Usuario(3,"Antonio","toninho",1234,3000.0, 0.0));
		usuarios.add(new Usuario(4,"Walter","valtinho",1234,222.0, 0.0));
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario findUsuarioPorLogin(String login) {
		init();
		for (Usuario index : usuarios) {
			if(index.getLogin().equals(login)) {
				return index;
			}
		}
		return null;
	}

	public Usuario newUsuario (Usuario input) {
		init();
		Usuario included = null;
		if (input != null) {
			input.setId(getUsuarios().size()+1);
			included = input;
			getUsuarios().add(input);
		}
		return included;
	}

}
