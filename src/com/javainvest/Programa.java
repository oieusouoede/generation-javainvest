package com.javainvest;

import java.util.Scanner;

import com.javainvest.model.Usuario;
import com.javainvest.view.Logon;
import com.javainvest.view.MenuPrincipal;

public class Programa {
	
	static Scanner read = new Scanner(System.in);
	public static Usuario loggedUser = null;

	public static void main(String[] args) {
					
		Logon.boasVindas();
		
		do {
			Logon.logon();
			if (loggedUser != null){
				MenuPrincipal.menuPrincipal();
				loggedUser = null;
			}
		} while (loggedUser == null);
									
		read.close();
	}
}