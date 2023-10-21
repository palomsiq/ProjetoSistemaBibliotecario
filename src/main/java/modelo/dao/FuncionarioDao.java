package modelo.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modelo.entidades.Funcionario;




public class FuncionarioDao implements InterfaceCrudDAO<Funcionario>{

	ConexaoBD conexaoBD;

	public FuncionarioDao (ConexaoBD conexaoBD){

		super();
		this.conexaoBD = conexaoBD;
	}

	public boolean insert(Funcionario b)
	{
		String sql = "";
		sql = "insert into tb_funcionarios (nome, idade, cpf, nomeFuncao)";
		sql += " values (?,?,?,?)";						

		PreparedStatement declaracaoPrep = this.conexaoBD.preparaDeclaracao(sql);		
		try {

			declaracaoPrep.setString(1, b.getNome());
			declaracaoPrep.setInt(2, b.getIdade());
			declaracaoPrep.setString(3, b.getCpf());
			declaracaoPrep.setString(4, b.getNomeFuncao());
			declaracaoPrep.executeUpdate();

			
			declaracaoPrep.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}


	public boolean update(Funcionario b) {
		String sql = "";
		sql = "update tb_funcionarios set nome = ?, idade = ?, nomeFuncao = ?";
		sql += " where  cpf = ?";					

		PreparedStatement declaracaoPrep = this.conexaoBD.preparaDeclaracao(sql);		

		try {
	
			declaracaoPrep.setString(1, b.getNome());
			declaracaoPrep.setInt(2, b.getIdade());
			declaracaoPrep.setString(3, b.getCpf());
			declaracaoPrep.setString(4, b.getNomeFuncao());
			declaracaoPrep.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}



	public boolean delete(Funcionario b) {
		String sql = "";

		sql = "delete from tb_funcionarios";
		sql += " where cpf = ?";		


		PreparedStatement declaracaoPrep = this.conexaoBD.preparaDeclaracao(sql);

		try {

			declaracaoPrep.setString(3,  b.getCpf());

			declaracaoPrep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}



	public List<Funcionario> recupera() {


		ResultSet dados = this.query(null);

		// se a consulta contiver erros 
		if (dados == null) 
			return null;


		try {

			if (!dados.first()) 
				return null;


			List<Funcionario> list = new ArrayList<Funcionario>();

			// inclui todos os registros provenientes do banco de dados
			//   na lista
			do {
				Funcionario b = new Funcionario("", 0, "", "");
				b.setNome(dados.getString("nome"));
				b.setIdade(dados.getInt("idade"));
				b.setCpf(dados.getString("cpf"));
				b.setNomeFuncao(dados.getString("nomeFuncao"));


				list.add(b);

			} while (dados.next());

			dados.close();

			return list;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;			
		}

	}

	public Funcionario recupera(String cpf)
	{

		ResultSet dados = this.query(" cpf = " + "'" + cpf + "'");

		Funcionario b = null;

		try
		{
			if (dados.first()) 
			{ 
				b = new Funcionario("", 0, "", "");
				b.setNome(dados.getString("nome"));
				b.setIdade(dados.getInt("idade"));
				b.setCpf(dados.getString("cpf"));
				b.setNomeFuncao(dados.getString("nomeFuncao"));

			}			
			dados.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;			
		}

		return b;
	}



	private ResultSet query(String cpf) {

		String sql = "Select * from tb_funcionarios";

		if (cpf != null) {
			sql += " where " + cpf;	
		}

		sql += " order by cpf";

		return this.conexaoBD.consulta(sql);		
	}




}



