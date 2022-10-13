import java.util.List;

public class Venda {
	private Integer código;
	private List<Produto> itens;
	private Double valor;
	private Double comissaoSistema;
	private Empresa empresa;
	private Cliente cliente;

	public Venda(Integer código, List<Produto> itens, Double valor, Double comissaoSistema, Empresa empresa, Cliente cliente) {
		super();
		this.código = código;
		this.itens = itens;
		this.valor = valor;
		this.comissaoSistema = comissaoSistema;
		this.empresa = empresa;
		this.cliente = cliente;
	}

	public Venda() {
		super();
	}

	public static void imprimirVendasEfetuadasPorEmpresa(Empresa empresa, List<Venda> vendas) {
		System.out.println();
		System.out.println("************************************************************");
		System.out.println("VENDAS EFETUADAS");
		vendas.stream().forEach(venda -> {
			if (venda.getEmpresa().getId().equals(empresa.getId())) {
				System.out.println("************************************************************");
				System.out.println("Venda de código: " + venda.getCódigo() + " no CPF "
						+ venda.getCliente().getCpf() + ": ");
				venda.getItens().stream().forEach(x -> {
					System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
				});
				System.out.println("Total Venda: R$" + venda.getValor());
				System.out.println("Total Taxa a ser paga: R$" + venda.getComissaoSistema());
				System.out.println("Total Líquido  para empresa"
						+ (venda.getValor() - venda.getComissaoSistema()));
				System.out.println("************************************************************");
			}
		});
	}

	public static void imprimirComprasEfetuadasPorUsername(List<Venda> vendas, String username) {
		vendas.stream().forEach(venda -> {
			if (venda.getCliente().getUsername().equals(username)) {
				System.out.println("************************************************************");
				System.out.println("Compra de código: " + venda.getCódigo() + " na empresa "
						+ venda.getEmpresa().getNome() + ": ");
				venda.getItens().stream().forEach(x -> {
					System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
				});
				System.out.println("Total: R$" + venda.getValor());
				System.out.println("************************************************************");
			}
		});
	}

	public Integer getCódigo() {
		return código;
	}
	
	

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setCódigo(Integer código) {
		this.código = código;
	}

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getComissaoSistema() {
		return comissaoSistema;
	}

	public void setComissaoSistema(Double comissaoSistema) {
		this.comissaoSistema = comissaoSistema;
	}

}
