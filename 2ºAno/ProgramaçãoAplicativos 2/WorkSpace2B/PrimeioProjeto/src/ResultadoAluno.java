import javax.swing.JOptionPane;

public class ResultadoAluno {

	public static void main(String[] args) {

		double n1 = Double.parseDouble(JOptionPane.    
				showInputDialog(null, "Nota 1:"));
		
		double n2 = Double.parseDouble(JOptionPane.
				showInputDialog(null, "Nota 2:"));
		
		double n3 = Double.parseDouble(JOptionPane.
				showInputDialog(null, "Nota 3:"));
		
		double media = (n1 + n2 + n3) / 3;
		
		if ( media >= 6.0 ) {
		 JOptionPane.showMessageDialog(null,"Aprovado!" );     
		} else {
		 JOptionPane.showMessageDialog(null,"Reprovado!"); 
		}

	}

}
