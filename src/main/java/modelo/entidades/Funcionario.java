package modelo.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.dao.ConexaoBD;
import modelo.dao.LivroDao;


public class Funcionario extends Pessoa{

	String nomeFuncao;
	public Funcionario(String nome, int idade, String cpf, String nomeFuncao) {
		super(nome, idade, cpf);
		this.nomeFuncao = nomeFuncao;
		// TODO Auto-generated constructor stub
	}
	static ConexaoBD conexaoBD = new ConexaoBD();
	static List<Livro> listaLivro = new ArrayList<Livro>();
	static LivroDao livroDao = new LivroDao(conexaoBD);
	static Livro l = new Livro("", "", "", "", "");
	
	
	


	/**
	 * @return the nomeFuncao
	 */
	public String getNomeFuncao() {
		return nomeFuncao;
	}


	/**
	 * @param nomeFuncao the nomeFuncao to set
	 */
	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}


		public static void CadastraLivro() {
		if(!conexaoBD.conecta()){
			return;
		}
		int verificar = 0;
		do {
			l.setIdentificador(JOptionPane.showInputDialog("Digite o id do Livro "));
			l.setTitulo(JOptionPane.showInputDialog("Digite o Titulo do Livro "));
			l.setAutorLivro(JOptionPane.showInputDialog("Digite o Autor correspondente"));
			l.setPalavraChave(JOptionPane.showInputDialog("Digite a palavra chave "));
			l.setGeneroLivro(JOptionPane.showInputDialog("Digite o genero a qual pertence o livro "));
			listaLivro.add(l);
			livroDao.insert(l);

			verificar = JOptionPane.showConfirmDialog(null, "Você deseja cadastrar um novo Livro?");

		}while (verificar == 0);
		return;
	}

	public static void ExibeLivro(){
		if(!conexaoBD.conecta()){
			return;
		}
		LivroDao livroDao = new LivroDao(conexaoBD);
		List<Livro> listaLivro = livroDao.recupera();
		JOptionPane.showMessageDialog(null, "Click em ok para ver a lista de livros"); 
		String print = null;
		for(int x = 0; x < listaLivro.size(); x++) {

			print += "ID: " + listaLivro.get(x).getIdentificador()+ "\nTitulo: " + listaLivro.get(x).getTitulo() + "\nPalavra Chave  " + listaLivro.get(x).getPalavraChave() + "\nGenero: " + listaLivro.get(x).getGeneroLivro()+ "\n\n";
		}
		JOptionPane.showMessageDialog(null, print);

	}

	public static void AtualizaLivro(String identificador) {
		if(!conexaoBD.conecta()){
			return;
		}
		LivroDao livroDao = new LivroDao(conexaoBD);
		Livro l = livroDao.recupera(identificador);

		l.setIdentificador(JOptionPane.showInputDialog("Digite o  id do Livro "));
		l.setTitulo(JOptionPane.showInputDialog("Digite o  Titulo do Livro "));
		l.setAutorLivro(JOptionPane.showInputDialog("Digite o Autor correspondente"));
		l.setPalavraChave(JOptionPane.showInputDialog("Digite a palavra chave "));
		l.setGeneroLivro(JOptionPane.showInputDialog("Digite o genero a qual pertence o livro "));
		listaLivro.add(l);
	

		livroDao.update(l);
	}
	public static void ExcluiLivro(String identificador) {
		if(!conexaoBD.conecta()){
			return;
		}
		LivroDao livroDao = new LivroDao(conexaoBD);
		Livro l = livroDao.recupera(identificador);
		livroDao.delete(l);



	}
	public static void pesquisaLivro(String identificador) {
		if(!conexaoBD.conecta()){
			return;
		}
		LivroDao livroDao = new LivroDao(conexaoBD);
		Livro l = livroDao.recupera(identificador);
		JOptionPane.showMessageDialog(null, "ID: " + l.getIdentificador() + "\nTitulo: " + l.getTitulo() + "\nPalavra Chave  " + l.getPalavraChave() + "\nGenero: " + l.getGeneroLivro()+ "\n\n");

	}




}

