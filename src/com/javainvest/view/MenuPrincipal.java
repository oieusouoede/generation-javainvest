package com.javainvest.view;

import java.util.Scanner;

import com.javainvest.Programa;
import com.javainvest.model.services.FundoService;
import com.javainvest.model.services.UsuarioService;

public class MenuPrincipal {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void menuPrincipal() {
		
		System.out.printf("\nBem vindo, %s!\n", Programa.loggedUser.getNome());
				
		imprimeSaldo();
		FundoService.meusInvestimentos();
				
		int resposta;
				
		do {
			System.out.println("\nSelecione uma das opções:\n1 - Depositar\n2 - Sacar\n3 - Investir\n4 - Deslogar");
			resposta = in.nextInt();
			
			if(resposta < 1 || resposta > 4) {
				System.out.println("Você digitou um número inválido. Tente novamente:");
			}
		} while(resposta < 1 || resposta > 4);
		
		switch(resposta) {
			case 1:
				UsuarioService.deposito();
				break;
			case 2:
				UsuarioService.saque();
				break;
			case 3:
				Investimentos.investir();
				break;
			case 4:
				System.out.println("\nDeslogando...");
				break;
		}
	}

	private static void imprimeSaldo() {
		
		System.out.println("\nMeu saldo:");
		System.out.printf("Seu saldo atual: R$%.2f", Programa.loggedUser.getSaldo());		
	
		System.out.println("\nPoupança:");
		System.out.printf("Saldo da poupança: R$%.2f, rendimento em 12 meses: R$%.2f", Programa.loggedUser.getSaldoPoupanca(), Programa.loggedUser.getRendimento());
	}

}
