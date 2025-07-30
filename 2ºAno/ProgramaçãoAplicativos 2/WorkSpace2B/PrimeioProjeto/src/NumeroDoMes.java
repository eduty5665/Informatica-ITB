import javax.swing.JOptionPane;

public class NumeroDoMes {
	
	public static void main(String[] args) {
		
		int numeroMes = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe um número entre 1 e 12"));
		String Mes = "";
		
		switch(numeroMes) {
		   case 1: Mes = "Janeiro"; break;
		   case 2: Mes = "Fevereiro"; break;
		   case 3: Mes = "Março"; break;
		   case 4: Mes = "Abril"; break;
		   case 5: Mes = "Maio"; break;
		   case 6: Mes = "Junho"; break;
		   case 7: Mes = "Julho"; break;
		   case 8: Mes = "Agosto"; break;
		   case 9: Mes = "Setembro"; break;
		   case 10: Mes = "Outubro"; break;
		   case 11: Mes = "Novembro"; break;
		   case 12: Mes = "Dezembro"; break;
		   default: Mes = "Inválido!"; break;
		}
		JOptionPane.showMessageDialog(null, Mes); 
	}

}
