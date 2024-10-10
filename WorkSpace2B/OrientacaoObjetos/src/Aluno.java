
public class Aluno {
	private int rm;
	private String nome;
	private String cpf;
	private int Tel;
	
	
	
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(int rm, String nome, String cpf, int tel) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.cpf = cpf;
		Tel = tel;
	}

	public int getRm() {
		return rm;
	}
	
	public void setRm(int rm) {
		this.rm = rm;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getTel() {
		return Tel;
	}
	
	public void setTel(int Tel) {
		this.Tel = Tel;
	}
}
