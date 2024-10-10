import javax.swing.JOptionPane;

public class CriaVeiculo {

	public static void main(String[] args) {
		int idMarca = Integer.parseInt(JOptionPane.showInputDialog(null, "ID da Marca: "));
		String nomeMarca = JOptionPane.showInputDialog(null, "Marca: ");
		String nacionalidade = JOptionPane.showInputDialog(null, "Nacionalidade da Marca: ");
		
		Marca marca = new Marca();
		marca.setId(idMarca);
		marca.setNomeMarca(nomeMarca);
		marca.setNacionalidade(nacionalidade);
		
		int idVeiculo = Integer.parseInt(JOptionPane.showInputDialog(null, "ID do Veículo: "));
		String modelo = JOptionPane.showInputDialog(null, "Modelo: ");
		String cor = JOptionPane.showInputDialog(null, "Cor: ");
		String placa = JOptionPane.showInputDialog(null, "Placa: ");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setId(idVeiculo);
		veiculo.setModelo(modelo);
		veiculo.setCor(cor);
		veiculo.setPlaca(placa);
		veiculo.setMarca(marca);
		
		
		JOptionPane.showMessageDialog(null, 
				"Veículo Cadastrado" + "\n" + "\n" +
				"ID do Veículo: " + veiculo.getId() + "\n" +
				"Modelo do Veículo: " + veiculo.getModelo() + "\n" +
				"Cor do Veículo: " + veiculo.getCor() + "\n" +
				"Placa do Veículo: " + veiculo.getPlaca() + "\n" +
				"Marca do Veículo: " + veiculo.getMarca().getNomeMarca());
	}
}
