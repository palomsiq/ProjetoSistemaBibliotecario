package modelo.entidades;

public final class Livro {
	
	private String identificador;
	private String titulo;
	private String autorLivro;
	private String palavraChave;
	private String generoLivro;
	
	
	public Livro(String id, String nomeLivro, String autor,
			String palavraChave, String genero) {
		super();
		this.identificador = id;
		this.titulo = nomeLivro;
		this.autorLivro = autor;
		this.palavraChave = palavraChave;
		this.generoLivro = genero;
	}


	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}


	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return the autorLivro
	 */
	public String getAutorLivro() {
		return autorLivro;
	}


	/**
	 * @param autorLivro the autorLivro to set
	 */
	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}


	/**
	 * @return the palavraChave
	 */
	public String getPalavraChave() {
		return palavraChave;
	}


	/**
	 * @param palavraChave the palavraChave to set
	 */
	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}


	/**
	 * @return the generoLivro
	 */
	public String getGeneroLivro() {
		return generoLivro;
	}


	/**
	 * @param generoLivro the generoLivro to set
	 */
	public void setGeneroLivro(String generoLivro) {
		this.generoLivro = generoLivro;
	}

	
}

