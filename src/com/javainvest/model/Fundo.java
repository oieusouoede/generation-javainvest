package com.javainvest.model;

import java.time.Year;

public class Fundo {
	
	private String nome;
	private Double taxaRendimento;
	private Double valorInvestido;
	private Integer data;
	
	public Fundo(String nome, Double taxaRendimento, Double valorInvestido, Integer data) {
		
		this.nome = nome;
		this.taxaRendimento = taxaRendimento;
		this.valorInvestido = valorInvestido;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(Double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public Double getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(Double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}
	
	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Double calcular(Double valor) {
		Integer anoAtual = Year.now().getValue();
		Double rendimento = (data - anoAtual) * (valor * getTaxaRendimento());
		return rendimento;
	}

	@Override
	public String toString() {
		return "Fundo: " + nome
				+ ", Rendimento: " + String.format("%.2f", getTaxaRendimento())
				+ " a.a., Total Investido: R$" + String.format("%.2f", valorInvestido)
				+ ", Rendimento até " + data
				+ ": R$" + String.format("%.2f", calcular(valorInvestido));
	}
}
