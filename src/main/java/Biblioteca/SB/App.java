package Biblioteca.SB;


import javax.swing.JOptionPane;

import modelo.business.ControleMenu;
import modelo.dao.ConexaoBD;
import modelo.entidades.Funcionario;

public class App { 	

	public static void main(String[] args) {
		
		ConexaoBD conexaoBD = new ConexaoBD();
		if(!conexaoBD.conecta()){
			return;
		}
		String login = ControleMenu.ValidaSenha();
		switch (login.toUpperCase())		
		{
		case "BIBLIOTECARIO" : ControleMenu.MenuBibliotecario();
		break;
		case "GERENTE" : ControleMenu.MenuGerente();
		break;
		}
	}


}