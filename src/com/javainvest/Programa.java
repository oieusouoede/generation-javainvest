package com.javainvest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {
	
	static Scanner read = new Scanner(System.in);
	static Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
	static Usuario loggedUser = null;

	public static void main(String[] args) {
					
		boasVindas();
		
		do {
			logon();
			if (loggedUser != null){
				menuPrincipal();
			}
		} while (loggedUser == null);
					
						
		read.close();
	}

	private static void logon() {
		
		int resposta;
			
		do {
			System.out.println("\nDigite 1 para fazer login, 2 para cadastrar novo usário ou 3 para encerrar");
			resposta = read.nextInt();
			
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
				System. exit(1);
				break;
		}
	}

	private static void register() {
		
		Usuario newUser;
		int confPassword;
		
		System.out.println("\nCrie sua conta: ");
		System.out.print("Digite seu login: ");
		String login = read.next();
		System.out.print("Digite sua senha(apenas números): ");
		int password = read.nextInt();	
		
		do{
			System.out.print("Confirmando senha: ");
			confPassword = read.nextInt();
			if (confPassword != password) {
				System.out.println("\nSenha incorreta!");
			}
		} while (confPassword != password);
		
		newUser = new Usuario(login, password);
		usuarios.put(login, newUser);
	}

	private static void menuPrincipal() {
		
		imprimeSaldo();
		int resposta;
				
		do {
			System.out.println("\nSelecione uma das opções:\n1 - Depositar\n2 - Sacar\n3 - Investir\n4 - Deslogar");
			resposta = read.nextInt();
			
			if(resposta < 1 || resposta > 4) {
				System.out.println("Você digitou um número inválido. Tente novamente:");
			}
		} while(resposta < 1 || resposta > 4);
		
		switch(resposta) {
			case 1:
				depositar();
				break;
			case 2:
				sacar();
				break;
			case 3:
				investir();
				break;
			case 4:
				loggedUser = null;
		}
	}

	private static void investir() {
		System.out.println("Investir");
		
		System.out.println("\nSelecione uma das opções:\n1 - Tesouro Direto\n2 - Fundo Imobiliário\n3 - Renda Variavél\n4 - Outros");
		int resposta = read.nextInt();
		
		while(resposta < 1 || resposta > 4) {
			System.out.println("Você digitou um número inválido. Tente novamente:");
			System.out.println("\nSelecione uma das opções:\n1 - Tesouro Direto\n2 - Fundo Imobiliário\n3 - Renda Variavél\n4 - Outros");
			resposta = read.nextInt();
		}
		while(resposta == 1 || resposta == 2 || resposta == 3 || resposta == 4) {
			
			if(resposta == 1) {
				
			}
			else if (resposta == 2) {
				
			}
			else if(resposta == 3) {
				
			}
			else if(resposta == 4) {
				
			}
			System.out.println("\nDeseja verificar mais alguma opção de investimento?(S/N)");
			char resp = read.next().charAt(0);
			
			if(resp == 's' || resp == 'S') {
			
				System.out.println("\n\nSelecione uma das opções:\n1 - Tesouro Direto\n2 - Fundo Imobiliário\n3 - Renda Variavél\n4 - Outros");
				resposta = read.nextInt();
			
				while(resposta < 1 || resposta > 4) {
					System.out.println("Você digitou um número inválido. Tente novamente:");
					System.out.println("\nSelecione uma das opções:\n1 - Tesouro Direto\n2 - Fundo Imobiliário\n3 - Renda Variavél\n4 - Outros");
					resposta = read.nextInt();
				}
			}
			else {
				resposta = 0;
			}
		}
		//??????????
	}

	private static void boasVindas() {
		
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
	
	private static void login() {
		String loginInserido;
		
		do {
			System.out.print("\nEntre na sua conta.\nLogin: ");
			loginInserido = read.next();
			
			if (!usuarios.containsKey(loginInserido)){
				System.out.println("Usuário não encontrado! Registre-se: ");
				break;
			}
			
		} while (!usuarios.containsKey(loginInserido));
					
		loggedUser = usuarios.get(loginInserido);
		
		if (loggedUser != null){
			int passwordInserido;
			do {
				System.out.print("Senha: ");
				passwordInserido = read.nextInt();
				
				if (passwordInserido != loggedUser.getPassword()) {
					System.out.println("\nSua senha está incorreta!\nTente novamente:");
				}
			} while(passwordInserido != loggedUser.getPassword());	
		}		
	}
	
	private static void imprimeSaldo() {
		
		System.out.printf("\nSeu saldo atual: R$%.2f", loggedUser.getSaldo());		
	}
	
	private static void depositar() {
		
		System.out.print("\nQuanto você deseja depositar: ");
		double valorDeposito = read.nextDouble();
		loggedUser.depositar(valorDeposito);
		menuPrincipal();
	}
	
	private static void sacar() {
		
		double saque;
			
		do {
			System.out.println("\nQuanto você deseja sacar: ");
			saque = read.nextDouble();
			if (saque > loggedUser.getSaldo() || saque < 0) {
				System.out.println("\nVocê está tentando sacar um valor inválido ou maior do que o seu saldo!\nTente de novo, por favor.");
			}		
		} while(saque > loggedUser.getSaldo());
		loggedUser.sacar(saque);
		menuPrincipal();
	}
}