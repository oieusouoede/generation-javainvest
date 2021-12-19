package com.javainvest.view;

import java.util.Scanner;

import com.javainvest.model.services.FundoService;

public class TelaRendaFixa {
	
	private static Scanner read = new Scanner(System.in);
	public static FundoService fundoService = new FundoService();
	
	public static void menuRendaFixa() {
		FundoService.meusInvestimentos();
		simuladorRendaFixa();
		investirRendaFixa();
	}
	
	public static void meusInvestimentos() {	
			
		FundoService.meusInvestimentos();
		
	}
	
	public static void simuladorRendaFixa() {
		Double simulacao;
		
		System.out.println("\nRENDA FIXA\nSimulador de investimento:");
		
		simulacao = fundoService.simular("CDB BMG 2023", 0.1155, 1000.0, 2023);
		System.out.printf("\n1 - CDB BMG 2023: 11,55%% a.a - Investindo R$1000,00 seu dinheiro renderia R$%.2faté o ano 2023", simulacao);
		
		simulacao = fundoService.simular("CDB BANCO MASTER S/A 2026", 0.1310, 1000.0, 2026);
		System.out.printf("\n2 - CDB BANCO MASTER S/A 2026: 13,10%% a.a - Investindo R$1000,00 seu dinheiro renderia R$%.2f até o ano 2026", simulacao);
		
		simulacao = fundoService.simular("CDB BANCO ABC 2022", 0.1165, 10000.0, 2022);
		System.out.printf("\n3 - CDB BANCO ABC 2022: 11,65%% a.a - Investindo R$10000,00 seu dinheiro renderia R$%.2f até o ano 2022", simulacao);
		
		simulacao = fundoService.simular("CDB BANCO ABC 2022", 0.1165, 1000.0, 2024);
		System.out.printf("\n4 - CDB Modal 2024: 11,65%% a.a - Investindo R$1000,00 seu dinheiro renderia R$%.2f até o ano 2024", simulacao);
	}
	
	public static void investirRendaFixa () {		
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
				fundoService.investir("CDB BMG 2023", 0.1155, 1000.0, 2023);	
				break;
			case 2:
				fundoService.investir("CDB BANCO MASTER S/A 2026", 0.1310, 1000.0, 2026);
				break;	
			case 3:
				fundoService.investir("CDB BANCO ABC 2022", 0.1165, 10000.0, 2022);
				break;
			case 4:
				fundoService.investir("CDB BANCO ABC 2022", 0.1165, 1000.0, 2024);
				break;
			case 5:
				System.out.println("\nCancelando operação...");
				Investimentos.investir();
				break;
		}
		MenuPrincipal.menuPrincipal();			
	}
	
}
