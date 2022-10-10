import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		// SIMULANDO BANCO DE DADOS

		Set<Produto> carrinho = new HashSet<>();
		List<Venda> vendas = new ArrayList<>();

		Usuario admin = new Admin("admin", "1234", "Fulano", 1L);
		Usuario empresa1 = new Empresa("empresa", "1234", 1L, "SafeWay Padaria", "30021423000159", 0.15, 0.0);
		Usuario cliente1 = new Cliente("07221134049", "Allan da Silva", 1L, "cliente", "1234", 20);
		Usuario cliente2 = new Cliente("72840700050", "Samuel da Silva", 2L, "cliente2", "1234", 24);
		Usuario empresa2 = new Empresa("empresa2", "1234", 2L, "Level Varejo", "53239160000154", 0.05, 0.0);
		Usuario empresa3 = new Empresa("empresa3", "1234", 3L, "SafeWay Restaurante", "41361511000116", 0.20, 0.0);

		Produto produto = new Produto(1L, "Pão Frances", 5, 3.50, (Empresa) empresa1);
		Produto produto2 = new Produto(2L, "Coturno", 10, 400.0, (Empresa) empresa2);
		Produto produto3 = new Produto(3L, "Jaqueta Jeans", 15, 150.0, (Empresa) empresa2);
		Produto produto4 = new Produto(4L, "Calça Sarja", 15, 150.0, (Empresa) empresa2);
		Produto produto5 = new Produto(5L, "Prato feito - Frango", 10, 25.0, (Empresa) empresa3);
		Produto produto6 = new Produto(6L, "Prato feito - Carne", 10, 25.0, (Empresa) empresa3);
		Produto produto7 = new Produto(7L, "Suco Natural", 30, 10.0, (Empresa) empresa3);
		Produto produto8 = new Produto(8L, "Sonho", 5, 8.50, (Empresa) empresa1);
		Produto produto9 = new Produto(9L, "Croissant", 7, 6.50, (Empresa) empresa1);
		Produto produto10 = new Produto(10L, "Ché Gelado", 4, 5.50, (Empresa) empresa1);

		Set<Usuario> usuarios = Set.of(admin, empresa1, cliente1, cliente2, empresa2, empresa3);
		Set<Produto> produtos = Set.of(produto, produto2, produto3, produto4, produto5, produto6, produto7,
				produto8, produto9, produto10);
		executar(usuarios, produtos, carrinho, vendas);
	}

	public static void executar(Set<Usuario> usuarios, Set<Produto> produtos, Set<Produto> carrinho,
			List<Venda> vendas) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com seu usuário e senha:");
		System.out.print("Usuário: ");
		String username = sc.next();
		System.out.print("Senha: ");
		String senha = sc.next();

		Set<Usuario> usuariosSearch = usuarios.stream().filter(x -> x.getUsername().equals(username))
				.collect(Collectors.toSet());
		if (usuariosSearch.size() > 0) {
			Usuario usuarioLogado = usuariosSearch.toArray(new Usuario[usuariosSearch.size()])[0];
			if ((usuarioLogado.getSenha().equals(senha))) {

				System.out.println("Escolha uma opção para iniciar");
				if (usuarioLogado instanceof Empresa empresa) {
					System.out.println("1 - Listar vendas");
					System.out.println("2 - Ver produtos");
					System.out.println("0 - Deslogar");
					Integer escolha = sc.nextInt();

					switch (escolha) {
						case 1: {
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
							System.out.println("Saldo Empresa: " + empresa.getSaldo());
							System.out.println("************************************************************");

							executar(usuarios, produtos, carrinho, vendas);
						}
						case 2: {
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
							System.out.println("Saldo Empresa: " + empresa.getSaldo());
							System.out.println("************************************************************");

							executar(usuarios, produtos, carrinho, vendas);
						}
						case 0: {
							executar(usuarios, produtos, carrinho, vendas);
						}
					}

				} else {
					System.out.println("1 - Relizar Compras");
					System.out.println("2 - Ver Compras");
					System.out.println("0 - Deslogar");
					Integer escolha = sc.nextInt();
					switch (escolha) {
						case 1: {
							System.out.println("Para realizar uma compra, escolha a empresa onde deseja comprar: ");
							usuarios.stream().filter(x -> x instanceof Empresa).forEach(System.out::println);
							Long escolhaEmpresa = sc.nextLong();
							Long escolhaProduto = -1L;
							do {
								System.out.println("Escolha os seus produtos: ");
								produtos.stream().forEach(x -> {
									if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
										System.out.println(x.getId() + " - " + x.getNome());
									}
								});
								System.out.println("0 - Finalizar compra");
								escolhaProduto = sc.nextLong();
								for (Produto produtoSearch : produtos) {
									if (produtoSearch.getId().equals(escolhaProduto))
										carrinho.add(produtoSearch);
								}
							} while (escolhaProduto != 0);
							System.out.println("************************************************************");
							System.out.println("Resumo da compra: ");
							carrinho.stream().forEach(x -> {
								if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
									System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
								}
							});
							Set<Usuario> empresas = usuarios.stream().filter(x -> x instanceof Empresa)
									.collect(Collectors.toSet());
							Empresa empresaEscolhida = new Empresa();
							;
							for (Usuario empresa : empresas) {
								Empresa parsedEmpresa = (Empresa) empresa;
								if (parsedEmpresa.getId().equals(escolhaEmpresa)) {
									empresaEscolhida = parsedEmpresa;
									break;
								}
							}
							Set<Usuario> clientes = usuarios.stream().filter(x -> x instanceof Cliente)
									.collect(Collectors.toSet());
							Cliente clienteLogado = new Cliente();
							for (Usuario cliente : clientes) {
								Cliente parsedCliente = (Cliente) cliente;
								if (cliente.getUsername().equals(usuarioLogado.getUsername())) {
									clienteLogado = parsedCliente;
									break;
								}
							}
							Venda venda = criarVenda(carrinho, empresaEscolhida, clienteLogado, vendas);
							System.out.println("Total: R$" + venda.getValor());
							System.out.println("************************************************************");
							carrinho.clear();
							executar(usuarios, produtos, carrinho, vendas);
						}
						case 2: {
							System.out.println();
							System.out.println("************************************************************");
							System.out.println("COMPRAS EFETUADAS");
							vendas.stream().forEach(venda -> {
								if (venda.getCliente().getUsername().equals(usuarioLogado.getUsername())) {
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

							executar(usuarios, produtos, carrinho, vendas);
						}
						case 0: {
							executar(usuarios, produtos, carrinho, vendas);

						}

					}
				}

			} else
				System.out.println("Senha incorreta");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}

	public static Venda criarVenda(Set<Produto> carrinho, Empresa empresa, Cliente cliente, List<Venda> vendas) {
		Double total = carrinho.stream().mapToDouble(Produto::getPreco).sum();
		Double comissaoSistema = total * empresa.getTaxa();
		int idVenda = vendas.isEmpty() ? 1 : vendas.get(vendas.size() - 1).getCódigo() + 1;
		Venda venda = new Venda(idVenda, carrinho.stream().toList(), total, comissaoSistema, empresa, cliente);
		empresa.setSaldo(empresa.getSaldo() + (total - comissaoSistema));
		vendas.add(venda);
		return venda;
	}
}
