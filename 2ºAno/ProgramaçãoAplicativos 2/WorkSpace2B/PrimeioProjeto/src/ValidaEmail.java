import javax.swing.JOptionPane;

public class ValidaEmail {

	public static void main(String[] args) {
		String email = "";
		
		do {
			email = JOptionPane.showInputDialog(null, "Email: ");
			if (email.indexOf("@") == -1
					&& email.indexOf(".") == -1) {
				JOptionPane.showMessageDialog(null, "Email Inválido!!!");
			}
		} while (email.indexOf("@") == -1
				&& email.indexOf(".") == -1);
			JOptionPane.showMessageDialog(null, "Email: " + email);
	}

}
