import javax.swing.JOptionPane;

public class DiaDaSemana {

	public static void main(String[] args) {
		
		int numeroDia = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe um n�mero entre 1 e 7"));
		String diaSemana = "";
		
		switch(numeroDia) {
		   case 1: diaSemana = "Domingo"; break;
		   case 2: diaSemana = "Segunda"; break;
		   case 3: diaSemana = "Ter�a"; break;
		   case 4: diaSemana = "Quarta"; break;
		   case 5: diaSemana = "Quinta"; break;
		   case 6: diaSemana = "Sexta"; break;
		   case 7: diaSemana = "S�bado"; break;
		   default: diaSemana = "Inv�lido!"; break;
		}
		JOptionPane.showMessageDialog(null, diaSemana);

	}

}
