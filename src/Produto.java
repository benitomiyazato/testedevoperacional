import java.util.List;
import java.util.Set;

public class Produto {
	private Long id;
	private String nome;
	private Integer quantidade;
	private Double preco;
	private Empresa empresa;

	public static void imprimirProdutosPorEmpresaId(long empresaId, List<Produto> produtos) {
		System.out.println("Escolha os seus produtos: ");
		produtos.stream().forEach(x -> {
			if (x.getEmpresa().getId().equals(empresaId)) {
				System.out.println(x);
			}
		});
	}

	@Override
	public String toString() {
		return id + "-" + nome;
	}

	public Produto(Long id, String nome, Integer quantidade, Double preco, Empresa empresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.empresa = empresa;
	}

	public Produto() {
		super();
	}

	public static void imprimirProdutosPorEmpresa(Empresa empresa, List<Produto> produtos) {
		System.out.println();
		System.out.println("************************************************************");
		System.out.println("MEUS PRODUTOS");
		produtos.stream().forEach(produto -> {
			if (produto.getEmpresa().getId().equals(empresa.getId())) {
				System.out.println("************************************************************");
				System.out.println("Código: " + produto.getId());
				System.out.println("Produto: " + produto.getNome());
				System.out.println("Quantidade em estoque: " + produto.getQuantidade());
				System.out.println("Valor: R$" + produto.getPreco());
				System.out.println("************************************************************");
			}
		});
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
