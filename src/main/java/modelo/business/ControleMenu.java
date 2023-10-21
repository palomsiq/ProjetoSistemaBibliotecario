package modelo.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.dao.ConexaoBD;
import modelo.dao.LivroDao;
import modelo.entidades.Funcionario;
import modelo.entidades.Gerente;
import modelo.entidades.Livro;




public class ControleMenu {

	public static String ValidaSenha()
	{


		Map<String, String> mapLogin = new HashMap<String, String>();
		mapLogin.put("BIBLIOTECARIO","paloma123");
		mapLogin.put("GERENTE","gerente1345");

		String login = JOptionPane.showInputDialog("Bem vindo Digite seu Login");

		if (mapLogin.containsKey(login.toUpperCase()))
		{
			String senha = JOptionPane.showInputDialog("Digite sua senha");
			if (senha.equalsIgnoreCase(mapLogin.get(login.toUpperCase())))
			{
				JOptionPane.showMessageDialog(null, "Bem Vindo " + login);
				return login;
			}

			else 
			{
				return "Senha Invalida";	

			}

		}
		else 
		{
			return "Login Invalido";	


		}

	}



	public static void MenuBibliotecario()
	{
		String opcao = JOptionPane.showInputDialog("Digite a Opção Desejada \nCADASTRAR\nATUALIZAR\nEXCLUIR\nPESQUISAR\nLISTAR");
		switch (opcao.toUpperCase()) 
		{
		case "CADASTRAR": Funcionario.CadastraLivro();
		break;
		case "ATUALIZAR":
		{
			String identificador = JOptionPane.showInputDialog("Digite o id do livro que desejas Atualizar:");
			Funcionario.AtualizaLivro(identificador);
		}break;
		case "EXCLUIR": 
		{
			String identificador = JOptionPane.showInputDialog("Digite o id do livro que você deseja excluir:");
			Funcionario.ExcluiLivro(identificador);
		}break;
		case "PESQUISAR":
		{
			String identificador = JOptionPane.showInputDialog("Digite o id do livro que você deseja excluir:");
			Funcionario.pesquisaLivro(identificador);
		}
		case "LISTAR": Funcionario.ExibeLivro();
		break;

		default :  JOptionPane.showMessageDialog(null, "OpÃ§Ã£o invalida");

		}
	}
	public static void MenuGerente()
	{
		String opcao = JOptionPane.showInputDialog("Digite a Opção Desejada \nCADASTRAR\nATUALIZAR\nEXCLUIR\nPESQUISAR\nLISTAR");
		switch (opcao.toUpperCase()) 
		{
		case "CADASTRAR": Gerente.CadastraFuncionario();
		break;
		case "ATUALIZAR":
		{
			String cpf = JOptionPane.showInputDialog("Digite o cpf do Funcionario que você deseja Atualizar:");
			Gerente.AtualizaFuncionario(cpf);
		}break;
		case "EXCLUIR": 
		{
			String cpf = JOptionPane.showInputDialog("Digite o cpf do funcionario que você deseja excluir:");
			Gerente.ExcluiFuncionario(cpf);
		}break;
		case "PESQUISAR":
		{
			String cpf = JOptionPane.showInputDialog("Digite o cpf do funcionario  que você deseja pesquisar:");
			Gerente.pesquisaFuncionario(cpf);
		}
		case "LISTAR": Gerente.ExibeFuncionario();;
		break;

		default :  JOptionPane.showMessageDialog(null, "OpÃ§Ã£o invalida");


	}
	}
	

}
