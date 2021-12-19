package com.javainvest.view;

import java.util.Scanner;

import com.javainvest.model.services.FundoService;


public class TesouroDireto {
	
	private static Scanner read = new Scanner(System.in);
	private static FundoService fundoService = new FundoService();
	
	public static void menuTesouro() {
		FundoService.meusInvestimentos();
		simuladorTesouro();
		investirTesouro();
	}
			
	public static void simuladorTesouro() {
		Double simulacao;
		
		System.out.println("\nTESOURO DIRETO\n\nSimulador de investimento:\n");
		
		simulacao = fundoService.simular("Tesouro Selic 2024", 0.0775, 1000.0, 2024);
		System.out.printf("1 - Tesouro Selic 2024: 7,75%% a.a - Investindo R$1000,00 seu dinheiro renderia R$%.2f até o ano 2024", simulacao);
		
		simulacao = fundoService.simular("Tesouro Selic 2027", 0.0775, 1000.0, 2027);
		System.out.printf("\n2 - Tesouro Selic 2027: 7,75%% a.a - Investindo R$1000,00 seu dinheiro renderia R$%.2f até o ano 2027", simulacao);
		
		simulacao = fundoService.simular("Tesouro IPCA+ 2026", (0.0455 + 0.0526), 1000.0, 2026);
		System.out.printf("\n3 - Tesouro IPCA+ 2026: IPCA + 5,26%% (Inflação 4,55%% a.a) - Investindo R$1000,00 seu dinheiro renderia R$%.2f até o ano 2026", simulacao);
		
		simulacao = fundoService.simular("Tesouro IPCA+ 2029", (0.0455 + 0.0526), 1000.0, 2029);
		System.out.printf("\n4 - Tesouro IPCA+ 2029: IPCA + 8,75%% (Inflação 4,55%% a.a) - Investindo R$1000,00 seu dinheiro renderia R$%.2f até o ano 2029", simulacao);
	}
		
	public static void investirTesouro () {		
		int resposta;
		
		do {		
			System.out.println("\n\nSelecione uma das opções (ou 5 para retornar):");
			resposta = read.nextInt();
			if (resposta < 1 || resposta > 5) {
				System.out.println("Você digitou um número inválido. Tente novamente:");
			}
		} while(resposta < 1 || resposta > 5);
			
		switch(resposta) {
			case 1:
				fundoService.investir("Tesouro Selic 2024", 0.0775, 50.0, 2024);	
				break;
			case 2:
				fundoService.investir("Tesouro Selic 2027", 0.0775, 100.0, 2027);
				break;	
			case 3:
				fundoService.investir("Tesouro IPCA+ 2026", (0.0455 + 0.0526), 120.0, 2026);
				break;
			case 4:
				fundoService.investir("Tesouro IPCA+ 2029", (0.0455 + 0.0875), 200.0, 2029);
				break;
			case 5:
				System.out.println("\nCancelando operação...");
				Investimentos.investir();
				break;
		}
		MenuPrincipal.menuPrincipal();		
	}
		
}
