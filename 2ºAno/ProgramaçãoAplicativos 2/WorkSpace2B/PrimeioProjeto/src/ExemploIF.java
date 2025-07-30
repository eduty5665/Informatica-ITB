import javax.swing.JOptionPane;

public class ExemploIF {

	public static void main(String[] args) {

		int x = 10;
		int y = 5;
		
		if ( x > y) {
			JOptionPane.showMessageDialog(null,
					x + " é maior que " + y);
		} else if ( x < y) {
			JOptionPane.showMessageDialog(null,
					x + " é menor que " + y);
		} else {
			JOptionPane.showMessageDialog(null,
					x + " é igual a " + y);
		}

	}

}
