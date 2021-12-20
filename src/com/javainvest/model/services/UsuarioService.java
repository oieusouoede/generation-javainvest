package com.javainvest.model.services;

import java.util.Scanner;

import com.javainvest.Programa;
import com.javainvest.view.MenuPrincipal;

public class UsuarioService {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void deposito() {
		
		System.out.print("\nQuanto voc� deseja depositar: ");
		double valorDeposito = in.nextDouble();
		if (valorDeposito > 0){
			Programa.loggedUser.depositar(valorDeposito);
		} else {
			System.out.println("Valor inv�lido!");
		}
		MenuPrincipal.menuPrincipal();	
	}
	
	public static void saque() {
		
		double saque;
			
		do {
			System.out.println("\nQuanto voc� deseja sacar: ");
			saque = in.nextDouble();
			if (saque > Programa.loggedUser.getSaldo() || saque < 0) {
				System.out.println("\nVoc� est� tentando sacar um valor inv�lido ou maior do que o seu saldo!\nTente de novo, por favor.");
			}		
		} while(saque > Programa.loggedUser.getSaldo());
		Programa.loggedUser.sacar(saque);
		MenuPrincipal.menuPrincipal();
	}
	
	public static void poupanca() {
					
		System.out.println("\n          INVESTIMENTO POUPAN�A          \n");
		System.out.print("\nQuanto deseja investir? (Valor m�nimo R$50,00)");
		double valorInvestido = in.nextDouble();
		if (valorInvestido < 50){
			System.out.println("Valor inv�lido!");
		} else {
			Programa.loggedUser.investirPoupanca(valorInvestido);
		}
		MenuPrincipal.menuPrincipal();	
	}

}
