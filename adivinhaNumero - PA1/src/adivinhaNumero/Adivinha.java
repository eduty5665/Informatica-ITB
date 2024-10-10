package adivinhaNumero;
import java.util.Scanner;

public class Adivinha {
	public static void main(String[] args) {
		Scanner tcd = new Scanner(System.in);
		int numeroSecreto;
		int numeroDigitado;
		int quantTentativas = 0;
		boolean isCorrect = false;
		numeroSecreto = (int)  (Math.random()*100);
		
		while( !isCorrect ) {
			quantTentativas++;
			System.out.println("Digite seu palpite (entre 0 e 99)");
			numeroDigitado = tcd.nextInt();
			
			if(numeroDigitado == numeroSecreto) {
				System.out.println("Parabéns!");
				isCorrect=true;
				
			} else if(numeroDigitado < numeroSecreto ) {
				System.out.println("Tente um número mais alto!");
				
			}else {
               System.out.println("Tente um mais baixo!");                       	
			
		}
	}
		System.out.println("Você acertou " + quantTentativas + " vezes");

}}
