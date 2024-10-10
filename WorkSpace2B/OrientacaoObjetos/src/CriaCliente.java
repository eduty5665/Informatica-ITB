import javax.swing.JOptionPane;

public class CriaCliente {

	public static void main(String[] args) {
		int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID: "));
		String tel = JOptionPane.showInputDialog(null, "Telefone: ");
		String nome = JOptionPane.showInputDialog(null, "Nome: ");
		String cpf = JOptionPane.showInputDialog(null, "CPF: ");
		
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setTel(tel);
		
		Cliente cliente1 = new Cliente();
		
		JOptionPane.showMessageDialog(null, 
				"RM: " + cliente.getId() + "\n" +
				"Nome: " + cliente.getNome() + "\n" +
				"CPF: " + cliente.getCpf() + "\n" +
				"Telefone: " + cliente.getTel());

	}

}
