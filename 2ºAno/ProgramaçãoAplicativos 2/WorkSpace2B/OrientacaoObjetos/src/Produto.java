
public class Produto {

	private int id;
	private String nomeProd;
	private String codbarras;
	private double preco;
	
	private Tipo Tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getCodbarras() {
		return codbarras;
	}

	public void setCodbarras(String codbarras) {
		this.codbarras = codbarras;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Tipo getTipo() {
		return Tipo;
	}

	public void setTipo(Tipo tipo) {
		Tipo = tipo;
	}
	
	
}
