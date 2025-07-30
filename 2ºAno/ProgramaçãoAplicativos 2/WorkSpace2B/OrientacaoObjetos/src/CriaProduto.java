import javax.swing.JOptionPane;

public class CriaProduto {

	public static void main(String[] args) {
		
		Tipo tipo01 = new Tipo();
		tipo01.setId(1);
		tipo01.setNomeTipo("Bebidas e Sucos");
		
		Produto produto01 = novoProduto(tipo01);
		verProduto(produto01);
		
		Produto produto02 = novoProduto(tipo01);
		verProduto(produto02);
	}
	public static void verProduto(Produto produto) {
		JOptionPane.showMessageDialog(null,
		"ID: " + produto.getId() + "\n" +
		"Produto: " + produto.getNomeProd() + "\n" +
		"C�digo de Barras: " + produto.getCodbarras() + "\n" +
		"Pre�o: " + produto.getPreco() + "\n" +
		"Tipo: " + produto.getTipo().getNomeTipo());
		
}
	public static Produto novoProduto(Tipo tipo) {
		int Id = Integer.parseInt(JOptionPane.showInputDialog(null, "Id do produto: "));

		String nome = JOptionPane.showInputDialog(null, "Nome: ");

		String codBarras = JOptionPane.showInputDialog(null, "Codigo de Barras: ");

		double preco = Double.parseDouble(JOptionPane.showInputDialog(null,"Pre�o: "));




		Produto produto = new Produto();
		produto.setId(Id);
		produto.setNomeProd(nome);
		produto.setCodbarras(codBarras);
		produto.setPreco(preco);

		produto.setTipo(tipo);
		
		return produto;
		
	}
	
	
}
