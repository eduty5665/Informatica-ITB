package inf1btareaTrianguloisocelesVersao2;

import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Calculadora {
	
	public static boolean verificarExisteTriangulo(double base, double lado1, double lado2) {
        return base <= lado1+lado2;
    }

    public static void main(String[] args) {
        try {

            Scanner tcd = new Scanner(System.in);
            System.out.println("Programa Area Triângulo Isósceles");
            double base = -1;
            double lado = -1;
            //while(verificarExisteTriangulo(base, lado, lado)) {
                System.out.println("Informe os valores");
                while(base <=0) {
                    System.out.println("Qual valor da base?");
                    base = tcd.nextDouble();
                }
                while(lado <=0 ) {
                    System.out.println("Qual valor do lado?");
                    lado = tcd.nextDouble();
                }
            //}
                if(verificarExisteTriangulo(base, lado, lado)) {
                    double altura = Math.sqrt(Math.pow(lado, 2) - Math.pow((base/2), 2));
                    double area = base * altura / 2;
                    System.out.println( altura );
                    System.out.println( area );

                } else {
                	System.out.println("Não é um Triângulo Isósceles.");
                } 

        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
        }
    }
 
}
