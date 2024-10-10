import javax.swing.JOptionPane;

public class AreaDoTriangulo {

	public static void main(String[] args) {

		double base = Double.parseDouble(
		JOptionPane.showInputDialog(null, "Base:")); 
		
		double altura = Double.parseDouble(
		JOptionPane.showInputDialog(null, "Altura:")); 
		
		double area = (base * altura) / 2;
		
		JOptionPane.showMessageDialog(null,
				"Área do Triângulo" + "\n" +
				"Base = " + base + "\n" +
				"Altura = " + altura + "\n" +
				"Área = " + area);

	}

}
