import javax.swing.JOptionPane;

public class ClasseMath {

	public static void main(String[] args) {
		
		double valor1 = 8.0;
		double valor2 = 2.0;
		double valor3 = 6.8;
		
		double arredondaPraCima = Math.ceil(valor3);
		double arredondaPraBaixo = Math.floor(valor3); 
		double potencia = Math.pow(valor1, valor2);
		double raizQuadrada = Math.sqrt(valor1);
		double maiorValor = Math.max(valor2, valor1); 
		double menorValor = Math.min(valor2, valor1); 
		double valorDePI = Math.PI;
			
		JOptionPane.showMessageDialog(null,
		valor1 +" elevado a "+ valor2 +
				" é igual a " + potencia
		  +"\n"+"Valor de PI: " + valorDePI	);

	}

}
