package com.javainvest.model.services;

import java.util.Scanner;

import com.javainvest.Programa;
import com.javainvest.view.MenuPrincipal;

public class UsuarioService {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void deposito() {
		
		System.out.print("\nQuanto você deseja depositar: ");
		double valorDeposito = in.nextDouble();
		if (valorDeposito > 0){
			Programa.loggedUser.depositar(valorDeposito);
		} else {
			System.out.println("Valor inválido!");
		}
		MenuPrincipal.menuPrincipal();	
	}
	
	public static void saque() {
		
		double saque;
			
		do {
			System.out.println("\nQuanto você deseja sacar: ");
			saque = in.nextDouble();
			if (saque > Programa.loggedUser.getSaldo() || saque < 0) {
				System.out.println("\nVocê está tentando sacar um valor inválido ou maior do que o seu saldo!\nTente de novo, por favor.");
			}		
		} while(saque > Programa.loggedUser.getSaldo());
		Programa.loggedUser.sacar(saque);
		MenuPrincipal.menuPrincipal();
	}

}
