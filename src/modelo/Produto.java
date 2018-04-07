package modelo;

public class Produto {

	// Classe produto contendo todos os atributos de um produto e os gets e
	// sets.

	private int id;
	private double preco;
	private String nome;
	private String descricao;
	private int estoque;

	public Produto(int id, double preco, String nome, String descricao, int estoque) {
		super();
		this.id = id;
		this.preco = preco;
		this.nome = nome;
		this.descricao = descricao;
		this.estoque = estoque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEstoque() {
		return estoque;
	}

	// Métodos para incrementar e decrementar o estoque, sendo void e publicos.

	public void incrementaEstoque(int estoque) {
		this.estoque++;
	}

	public void decrementaEstoque(int quantidade) {

		if (this.estoque == 0) {
		
		} else {
			if (quantidade <= this.estoque) {
				this.estoque -= quantidade;
			}

		}

	}

}
