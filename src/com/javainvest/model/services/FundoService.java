package com.javainvest.model.services;

import java.util.List;
import java.util.Scanner;

import com.javainvest.Programa;
import com.javainvest.model.Fundo;

public class FundoService {
	
	private static Scanner read = new Scanner(System.in);
	
	public Double simular(String nome, Double taxa, Double valor, Integer data) {
		
		Fundo fundo = new Fundo(nome, taxa, valor, data);
		
		return fundo.calcular(valor);
	}
	
	public void investir(String nome, Double taxa, Double valorMinimo, Integer data) {
			
		Double valor;
		
		do {	
			System.out.println("Digite o valor a ser investido (ou 0 para cancelar): ");
			valor = read.nextDouble();
			
			if (valor == 0) {
				break;
			}
			
			if (valor < valorMinimo || valor < 0) {
				System.out.println("Valor inválido, tente novamente:");	
			}
			
			if (valor > Programa.loggedUser.getSaldo()) {
				System.out.println("Saldo insuficiente, digite outro valor:");
			}
			
		} while (valor < valorMinimo || valor > Programa.loggedUser.getSaldo());
		
		if (valor > 0) {
			Fundo fundo = new Fundo(nome, taxa, valor, data);
			Programa.loggedUser.sacar(valor);
			Programa.loggedUser.addFundo(fundo);
		} else {
			System.out.println("Retornando...");
		}
	}
	
	public static void meusInvestimentos() {
		List <Fundo> fundos = Programa.loggedUser.getFundos();
		
		System.out.println("\nMeus investimentos:");
		
		if (!fundos.isEmpty()) {
			for (Fundo fundo : fundos) {
				System.out.println(fundo);
			}
		} else {
			System.out.println("Você ainda não possui investimentos!");
		}

	}
}
