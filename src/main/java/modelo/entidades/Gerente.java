package modelo.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.dao.FuncionarioDao;
import modelo.dao.ConexaoBD;
import modelo.dao.LivroDao;

public final class Gerente extends Pessoa{

	
	
	public Gerente(String nome, int idade, String cpf) {
		super(nome, idade, cpf);
		// TODO Auto-generated constructor stub
	}
	static ConexaoBD conexaoBD = new ConexaoBD();
	static List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	static FuncionarioDao funcionarioDao = new FuncionarioDao(conexaoBD);
	static Funcionario b = new Funcionario("", 0, "","");
	
	public static void CadastraFuncionario() { 
		if(!conexaoBD.conecta()){
			return;
		}
		int verificar = 0;
		do {
			b.setNome(JOptionPane.showInputDialog("Digite o nome do funcionario "));
			b.setIdade(Integer.parseInt((JOptionPane.showInputDialog("Digite a idade do mesmo"))));
			b.setCpf(JOptionPane.showInputDialog("Digite o cpf"));
			b.setNomeFuncao(JOptionPane.showInputDialog("Digite a sua funcao"));
			listaFuncionario.add(b);
			funcionarioDao.insert(b);

			verificar = JOptionPane.showConfirmDialog(null, "Você deseja cadastrar um novo Funcionario?");

		}while (verificar == 0);
		return;
	}

	public static void ExibeFuncionario(){
		if(!conexaoBD.conecta()){
			return;
		}
		FuncionarioDao funcionarioDao = new FuncionarioDao(conexaoBD);
		List<Funcionario> listaFuncionario = funcionarioDao.recupera();
		JOptionPane.showMessageDialog(null, "Click em ok para ver os Funcionarios"); 
		String print = null;
		for(int x = 0; x < listaFuncionario.size(); x++) {

			print += "CPF " + listaFuncionario.get(x).getCpf()+ "\nNome: " + listaFuncionario.get(x).getNome() + "\nFuncao  " + listaFuncionario.get(x).getNomeFuncao() + "\nIdade: " + listaFuncionario.get(x).getIdade()+ "\n\n";
		}
		JOptionPane.showMessageDialog(null, print);

	}

	public static void AtualizaFuncionario(String cpf) {
		if(!conexaoBD.conecta()){
			return;
		}
		FuncionarioDao funcionarioDao = new FuncionarioDao(conexaoBD);
		Funcionario b = funcionarioDao.recupera(cpf);

		b.setNome(JOptionPane.showInputDialog("Digite o nome do funcionario "));
		b.setIdade(Integer.parseInt((JOptionPane.showInputDialog("Digite a idade do mesmo"))));
		b.setCpf(JOptionPane.showInputDialog("Digite o cpf"));
		b.setNomeFuncao(JOptionPane.showInputDialog("Digite a sua funcao"));
		listaFuncionario.add(b);
		funcionarioDao.update(b);
	}
	public static void ExcluiFuncionario(String cpf) {
		if(!conexaoBD.conecta()){
			return;
		}
		FuncionarioDao funcionarioDao = new FuncionarioDao(conexaoBD);
		Funcionario b = funcionarioDao.recupera(cpf); 
		funcionarioDao.delete(b);
		



	}
	public static void pesquisaFuncionario(String cpf) {
		if(!conexaoBD.conecta()){
			return;
		}
		FuncionarioDao funcionarioDao = new FuncionarioDao(conexaoBD);
		Funcionario b = funcionarioDao.recupera(cpf); 
		JOptionPane.showMessageDialog(null, "CPF: " + b.getCpf() + "\nNome: " + b.getNome() + "\nFuncao:  " + b.getNomeFuncao() + "\nIdade: " + b.getIdade()+ "\n\n");

	}





}
