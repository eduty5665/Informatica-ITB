import javax.swing.JOptionPane;

public class CriaAluno {

	public static void main(String[] args) {
		
		int rm = Integer.parseInt(JOptionPane.showInputDialog(null, "RM: "));
		int tel = Integer.parseInt(JOptionPane.showInputDialog(null, "Telefone: "));
		String nome = JOptionPane.showInputDialog(null, "Nome: ");
		String cpf = JOptionPane.showInputDialog(null, "CPF: ");
		
		Aluno aluno = new Aluno();
		aluno.setRm(rm);
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setTel(tel);
		
		Aluno aluno2 = new Aluno(rm, nome, cpf, tel);
		
		JOptionPane.showMessageDialog(null, 
				"RM: " + aluno.getRm() + "\n" +
				"Nome: " + aluno.getNome() + "\n" +
				"CPF: " + aluno.getCpf() + "\n" +
				"Telefone: " + aluno.getTel());

	}

}
