import java.util.Iterator;

import javax.swing.JOptionPane;

public class MontaFrase {

	public static void main(String[] args) {
		String[] nome = {"Jack Careca", "Fernando Bolado", "Garoto de Programa", "Super Marc�o"};
		String[] elogio = {"legal" , "Gente Fina", "Doid�o", "10/10", "Corinthiano", "Gostosin"};		
		String frase = "";
		
		for (int i = 0; i < 4; i++) {
			int n = (int) (Math.random() * nome.length);
			int e = (int) (Math.random() * elogio.length);
		
		frase += nome[n] + " � " + elogio[e] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, frase);

	}

}
