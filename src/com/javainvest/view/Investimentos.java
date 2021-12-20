package com.javainvest.view;

import java.util.Scanner;

import com.javainvest.model.services.UsuarioService;

public class Investimentos {
	
	private static Scanner read = new Scanner(System.in);
	
	public static void investir() {
		
		int resposta;
		do {		
			System.out.println("\nSelecione uma das op��es:\n1 - Tesouro Direto\n2 - Renda Fixa\n3 - Poupan�a\n4 - Cancelar Opera��o");
			resposta = read.nextInt();
			if (resposta < 1 || resposta > 4) {
				System.out.println("Voc� digitou um n�mero inv�lido. Tente novamente:");
			}
		} while(resposta < 1 || resposta > 4);
			
		switch(resposta) {
			case 1:
				TesouroDireto.menuTesouro();
				break;
			case 2:
				TelaRendaFixa.menuRendaFixa();
				break;
			case 3:
				UsuarioService.poupanca();
				break;
			case 4:
				System.out.println("Cancelando opera��o");
				MenuPrincipal.menuPrincipal();	
				break;
		}	
	}

}
