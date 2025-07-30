import javax.swing.JOptionPane;

public class CriaTurma {

	public static void main(String[] args) {

		int id = 1;
		String nome = "INF2BM";
		String ano = "2022";
				
		Turma turma = new Turma();
		turma.setId(id);
		turma.setNomeTurma(nome);
		turma.setAno(ano);

	}

}
