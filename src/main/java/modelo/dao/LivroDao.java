package modelo.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Livro;



public class LivroDao implements InterfaceCrudDAO<Livro>{

	ConexaoBD conexaoBD;

	public LivroDao (ConexaoBD conexaoBD){

		super();
		this.conexaoBD = conexaoBD;
	}



	public boolean insert(Livro l)
	{
		String sql = "";
		sql = "insert into tb_livros (identificador, titulo, autorLivro, palavraChave, generoLivro)";
		sql += " values (?,?,?,?,?)";						

		PreparedStatement declaracaoPrep = this.conexaoBD.preparaDeclaracao(sql);		
		try {

			declaracaoPrep.setString(1, l.getIdentificador());
			declaracaoPrep.setString(2, l.getTitulo());
			declaracaoPrep.setString(3, l.getAutorLivro());
			declaracaoPrep.setString(4, l.getPalavraChave());
			declaracaoPrep.setString(5, l.getGeneroLivro());
			declaracaoPrep.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}


	public boolean update(Livro l) {
		String sql = "";
		sql = "update tb_livros set  titulo = ?, autorLivro = ?, palavraChave = ?, generoLivro = ?";
		sql += " where  identificador = ?";					

		PreparedStatement declaracaoPrep = this.conexaoBD.preparaDeclaracao(sql);		

		try {
	
			declaracaoPrep.setString(1, l.getTitulo());
			declaracaoPrep.setString(2, l.getAutorLivro());
			declaracaoPrep.setString(3, l.getPalavraChave());
			declaracaoPrep.setString(4, l.getGeneroLivro());
			declaracaoPrep.setString(5, l.getIdentificador());
			declaracaoPrep.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}



	public boolean delete(Livro l) {
		String sql = "";

		sql = "delete from tb_livros";
		sql += " where identificador = ?";		


		PreparedStatement declaracaoPrep = this.conexaoBD.preparaDeclaracao(sql);

		try {

			declaracaoPrep.setString(1,  l.getIdentificador());

			declaracaoPrep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}



	public List<Livro> recupera() {


		ResultSet dados = this.query(null);

		// se a consulta contiver erros 
		if (dados == null) 
			return null;


		try {

			if (!dados.first()) 
				return null;


			List<Livro> list = new ArrayList<Livro>();

			// inclui todos os registros provenientes do banco de dados
			//   na lista
			do {
				Livro l = new Livro("", "", "", "", "");
				l.setIdentificador(dados.getString("identificador"));
				l.setTitulo(dados.getString("titulo"));
				l.setAutorLivro(dados.getString("autorLivro"));
				l.setPalavraChave(dados.getString("palavraChave"));
				l.setGeneroLivro(dados.getString("generoLivro"));

				list.add(l);

			} while (dados.next());

			dados.close();

			return list;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;			
		}

	}

	public Livro recupera(String identificador)
	{

		ResultSet dados = this.query(" identificador = " + "'" + identificador + "'");

		Livro l = null;

		try
		{
			if (dados.first()) 
			{ 
				l = new Livro("", "", "", "", "");
				l.setIdentificador(dados.getString("identificador"));
				l.setTitulo(dados.getString("titulo"));
				l.setAutorLivro(dados.getString("autorLivro"));
				l.setPalavraChave(dados.getString("palavraChave"));
				l.setGeneroLivro(dados.getString("generoLivro"));

			}			
			dados.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;			
		}

		return l;
	}



	private ResultSet query(String identificador) {

		String sql = "Select * from tb_livros";

		if (identificador != null) {
			sql += " where " + identificador;	
		}

		sql += " order by identificador";

		return this.conexaoBD.consulta(sql);		
	}




}



