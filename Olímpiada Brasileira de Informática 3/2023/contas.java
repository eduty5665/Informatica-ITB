import java.util.Scanner;

public class contas {
   public static void main(String[] args) {
        try (Scanner tcd = new Scanner(System.in)) {
            int V = tcd.nextInt();
            int A = tcd.nextInt();
            int F = tcd.nextInt();
            int P = tcd.nextInt();
      
            if((V > A) && (V <= F) && (V <= P)){
                System.out.print("1");
                if((V > F) && (V <= A) && (V <= P)){
                    System.out.print("1");
                }else if((V > P) && (V <= A) && (V <= F)){
                    System.out.print("1");
                }
            }else if((V > (A + F)) && (V <= (F + P)) && (V <= (P + A))){
                System.out.print("2");
                if((V > (A + P)) && (V <= (F + P)) && (V <= (F + A))){
                    System.out.print("2");
                }else if((V > (P + F)) && (V <= (F + A)) && (V <= (P + A))){
                    System.out.print("2");
                }
            }else if(V > (A + F + P)){
                System.out.print("3");
            }else if((V < A) && (V < F) && (V < P)){
                System.out.print("0");
            }
        }
       
    }
}

