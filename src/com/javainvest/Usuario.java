package com.javainvest;

public class Usuario {
	
	private Double saldo;
	private String login;
	private Integer password;
	

	public Usuario(String login, Integer password) {
		this.saldo = 0.0;
		this.login = login;
		this.password = password;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
	
	public void depositar(double valor) {
		setSaldo(saldo + valor);
	}
	
	public void sacar(double valor) {
		setSaldo(saldo - valor);
	}
	
	

}
