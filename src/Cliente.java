
public class Cliente extends Usuario{
	private Long id;
	private String cpf;
	private String nome;
	private Integer idade;

	public Cliente(String cpf, String nome, Long id, String username, String senha, Integer idade) {
		super(username, senha);
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.id = id;
	}

	public Cliente(){}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
