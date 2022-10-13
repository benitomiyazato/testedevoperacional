
public class Empresa extends Usuario{
	private Long id;
	private String nome;
	private String cnpj;
	private Double taxa;
	private Double saldo;

	public Empresa(String username, String senha, Long id, String nome, String cnpj, Double taxa, Double saldo) {
		super(username, senha);
		this.nome = nome;
		this.cnpj = cnpj;
		this.taxa = taxa;
		this.saldo = saldo;
		this.id = id;
	}

	public Empresa(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "-" + nome;
	}

    public void imprimirSaldo() {
		System.out.println("Saldo Empresa: " + saldo);
		System.out.println("************************************************************");
    }
}
