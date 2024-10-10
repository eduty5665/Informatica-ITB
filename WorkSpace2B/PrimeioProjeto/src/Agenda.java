import javax.swing.JOptionPane;

public class Agenda {

	public static void main(String[] args) {
		
		String nome = JOptionPane
				.showInputDialog(null, "Nome:");
		String telefone = JOptionPane
				.showInputDialog(null, "Telefone:");
		String email = JOptionPane
				.showInputDialog(null, "Email:");
				
		JOptionPane.showMessageDialog(null,
				"Nome: " + nome + "\n" +
				"Telefone: " + telefone + "\n" +
				"Email: " + email );

	}

}
