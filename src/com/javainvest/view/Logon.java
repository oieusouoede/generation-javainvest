package com.javainvest.view;

import java.util.Scanner;

import com.javainvest.Programa;
import com.javainvest.model.Usuario;
import com.javainvest.repository.UsuarioHelper;

public class Logon {
	
	private static Scanner in = new Scanner(System.in);
	private static UsuarioHelper usuariosHelper = new UsuarioHelper();
	
	public static void boasVindas() {
		
		System.out.println("              BEM VINDO AO \n");		
		System.out.println("          |||||JAVAINVESTE|||||");
		System.out.println("                   |||         ");
		System.out.println("                   |||         ");
		System.out.println("                   |||         ");
		System.out.println("                   |||         ");
		System.out.println("                   |||         ");
		System.out.println("                   |||         ");
		System.out.println("                   |||         ");
		System.out.println("          |||||JAVAINVESTE|||||");				
		System.out.println("\nSimule quanto seu investimento irá render AQUI!!!");
		
	}
	
	public static void logon() {
			
		int resposta;
		
		do {
			System.out.println("\nDigite 1 para fazer login, 2 para cadastrar novo usário ou 3 para encerrar");
			resposta = in.nextInt();
			
			if(resposta < 1 || resposta > 3) {
				System.out.println("Você digitou um número inválido. Tente novamente:");
			}
		} while(resposta < 1 || resposta > 3);
		
		switch(resposta) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				System.out.println("Programa encerrado");
				System.exit(1);
				break;
		}
	}
	
	private static void login() {
		String loginInserido;
		Usuario usuario;
				
		do {
			System.out.print("\nEntre na sua conta.\nLogin: ");
			loginInserido = in.next();
			
			usuario = usuariosHelper.findUsuarioPorLogin(loginInserido);
			
			if (usuario == null){
				System.out.println("Usuário não encontrado! Registre-se: ");
				break;
			}
			
		} while (usuariosHelper.getUsuarios() == null);
				
		Programa.loggedUser = usuario;
		
		if (Programa.loggedUser != null){
			int passwordInserido;
			do {
				System.out.print("Senha: ");
				passwordInserido = in.nextInt();
				
				if (passwordInserido != Programa.loggedUser.getPassword()) {
					System.out.println("\nSua senha está incorreta!\nTente novamente:");
				}
			} while(passwordInserido != Programa.loggedUser.getPassword());	
		}		
	}
	
	private static void register() {
		
		Usuario novoUsuario;
		int confPassword;
		
		System.out.println("\nCrie sua conta: ");
		System.out.print("Digite seu Nome: ");
		String nome = in.next();
		System.out.print("Digite seu login: ");
		String login = in.next();
		System.out.print("Digite sua senha(apenas números): ");
		int password = in.nextInt();	
		
		do{
			System.out.print("Confirmando senha: ");
			confPassword = in.nextInt();
			if (confPassword != password) {
				System.out.println("\nSenha incorreta!");
			}
		} while (confPassword != password);
		
		novoUsuario = new Usuario(nome, login, password);
		usuariosHelper.newUsuario(novoUsuario);
	}
}
