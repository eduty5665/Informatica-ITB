import javax.swing.JOptionPane;

public class CriaConta {

	public static void main(String[] args) {
				
		Cliente cliente = novoCliente();
		Conta conta = novaConta(cliente);
		verConta(conta);
	}
	public static void verConta(Conta conta){
		JOptionPane.showMessageDialog(null, 
				"ID: " + conta.getId() + "\n" +
				"N° da Conta: " + conta.getNumConta() + "\n" +
				"Tipo: " + conta.getTipo() + "\n" +
				"Saldo: " + conta.getSaldo() + "\n" +
				"Cliente: " + conta.getCliente().getNome());
		
	}
	public static Conta novaConta(Cliente cliente) {
	
		int Id = Integer.parseInt(JOptionPane.showInputDialog(null, "Id do Cliente: "));
		String numConta = JOptionPane.showInputDialog(null, "Número da Conta: ");
		String tipo = JOptionPane.showInputDialog(null, "Tipo da Conta: ");
		double saldo = Double.parseDouble(JOptionPane.showInputDialog(null,"Saldo: "));

		Conta conta = new Conta();
		conta.setId(Id);
		conta.setNumConta(numConta);
		conta.setTipo(tipo);
		conta.setSaldo(saldo);
		conta.setCliente(cliente);
	
		return conta;
}
	public static Cliente novoCliente() {
		int id = 1; 
		String nome = "Godofredo Lemes";
		String cpf = "535.879.268-67";
		String telefone = "(11) 99913-2752";
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setTel(telefone);	
		
		return cliente;
	}
}