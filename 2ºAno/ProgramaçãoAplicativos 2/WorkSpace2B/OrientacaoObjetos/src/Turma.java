
public class Turma {
	
	private int id;
	private String nomeTurma;
	private String ano;
	
	public Turma() {
		super();
		
	}
	public Turma(int id, String nomeTurma, String ano) {
		super();
		this.id = id;
		this.nomeTurma = nomeTurma;
		this.ano = ano;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	

}
