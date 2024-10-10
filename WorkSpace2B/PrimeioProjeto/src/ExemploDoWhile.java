import javax.swing.JOptionPane;

public class ExemploDoWhile {
	public static void main(String[] args) {
		double nota = 0.0;
		
		do {
			nota = Double.parseDouble(JOptionPane.showInputDialog(null, "Nota: "));
			if (nota > 10 || nota < 0) {
				JOptionPane.showMessageDialog(null, "Nota Inválida!!!");
			}
		} while (nota > 10 || nota < 0);
		JOptionPane.showMessageDialog(null, "Nota: " + nota);
	}

}
