package calcularAlcance;
import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class CalculaDistancia {
	public static void main(String[] args) {
		
		double g, anguloRadianos, d;
		double anguloLancamentoGraus;
		double veloc;  // m/s
		g = 9.8;
		
		Scanner tcd = new Scanner(System.in);
		
		System.out.println("Digite o ângulo do lançamento: ");
		anguloLancamentoGraus = tcd.nextDouble();
		
		System.out.println("Digite a velocidade de lançamento:");
		veloc = tcd.nextDouble();
		
		anguloRadianos = anguloLancamentoGraus * Math.PI / 180;
		
		d = 2 * veloc * veloc *
				Math.sin(anguloRadianos) *
				Math.cos(anguloRadianos) / g;
		
		NumberFormat nf = new DecimalFormat("#,##0.00");
		
		System.out.println("Distância " + nf.format(d) + " metros.");
		
		for(int i = 0; i <= 180; i = i +10) {
			anguloRadianos = i * Math.PI / 180;
			
			d = 2 * veloc * veloc *
					Math.sin(anguloRadianos) *
					Math.cos(anguloRadianos) / g;
			
			System.out.println("Ângulo " + i + "° Distância " + nf.format(d) + " metros.");
		}
		
	}

}
