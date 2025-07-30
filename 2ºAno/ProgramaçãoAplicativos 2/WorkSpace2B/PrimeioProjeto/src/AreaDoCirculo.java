import javax.swing.JOptionPane;

public class AreaDoCirculo {

	public static void main(String[] args) {

		double raio = Double.parseDouble(
		JOptionPane.showInputDialog(null, "Raio:")); 
		
		double area = Math.PI * Math.pow(raio, 2);
		
		JOptionPane.showMessageDialog(null,
				"Área do Círculo" + "\n" +
				"Raio = " + raio + "\n" +
				"Área = " + area);

	}

}
