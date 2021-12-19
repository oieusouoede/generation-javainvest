package com.javainvest.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String login;
	private Integer password;
	private Double saldo;
	private List <Fundo> fundos = new ArrayList<>();
	
	public Usuario(Integer id, String nome, String login, Integer password, Double saldo) {

		this.id = id;
		this.nome = nome;
		this.login = login;
		this.password = password;
		this.saldo = saldo;
	}
	
	public Usuario(String nome, String login, Integer password) {

		this.nome = nome;
		this.login = login;
		this.password = password;
		this.saldo = 0.0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double valor) {
		setSaldo(saldo + valor);
	}
	
	public void sacar(double valor) {
		setSaldo(saldo - valor);
	}

	public void addFundo(Fundo fundo) {
		fundos.add(fundo);		
	}
	
	public List<Fundo> getFundos(){
		return fundos;
	}
	
}
