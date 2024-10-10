import javax.swing.JOptionPane;

public class CriaUsuario {

	public static void main(String[] args) { 
		
		int rm = Integer.parseInt(JOptionPane
			.showInputDialog(null, "RM:"));
		
		String nome = JOptionPane
			.showInputDialog(null, "Nome:");
		
		String dominio = "estudante.fieb.edu.br";
		String username = nome+"_"+rm;
		String useremail = "rm"+rm+"@"+dominio;
		
		JOptionPane.showMessageDialog(null,
			"RM: " + rm + "\n" +
			"Nome: " + nome + "\n" +
			"Usuário: " + username + "\n" +
			"Email: " + useremail );

	}

}
