import javax.swing.JOptionPane;

public class AreaDoCirculo {

	public static void main(String[] args) {

		double raio = Double.parseDouble(
		JOptionPane.showInputDialog(null, "Raio:")); 
		
		double area = Math.PI * Math.pow(raio, 2);
		
		JOptionPane.showMessageDialog(null,
				"�rea do C�rculo" + "\n" +
				"Raio = " + raio + "\n" +
				"�rea = " + area);

	}

}
