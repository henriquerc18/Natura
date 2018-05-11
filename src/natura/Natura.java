package natura;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Natura{
	
	public static ArrayList<ClienteNat> listaClientes = new ArrayList<ClienteNat>();
	public static ArrayList<PedidosNat> listaPedidos = new ArrayList<PedidosNat>();
	public static ArrayList<ProdutosNat> listaProdutos = new ArrayList<ProdutosNat>();
	public static ArrayList<EstoqueNat> listaEstoque = new ArrayList<EstoqueNat>();
	public static ArrayList<VendasNat> listaVendas = new ArrayList<VendasNat>();
	
	public static List<String> opsMenuPrincipal = Arrays.asList("Clientes", "Pedidos", "Produtos", "Estoque", "Vendas");
	public static List<String> opsMenuClientes = Arrays.asList("Cadastrar Clientes", "Consultar Clientes", "Listar Clientes");
	public static List<String> opsMenuPedidos = Arrays.asList("Registrar Pedidos", "Consultar Pedidos", "Listar Pedidos");
	public static List<String> opsMenuProdutos = Arrays.asList("Cadastrar Produtos", "Consultar Produtos", "Listar Produtos");
	public static List<String> opsMenuEstoque = Arrays.asList("Registrar Produtos no Estoque", "Consultar Produtos do Estoque", "Listar Produtos do Estoque");
	public static List<String> opsMenuVendas = Arrays.asList("Registrar Vendas", "Consultar Vendas", "Listar Vendas");
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]){
		
		System.out.println("Bem-vindo à  Natura!");
		
		Menu menu = new Menu("Menu Principal", opsMenuPrincipal);
		menu.show();
		
		int op = menu.getOption();
		do{
			switch(op){
			case 0:
				Menu menuClientes = new Menu("Clientes", opsMenuClientes);
				menuClientes.show();
				
				int opClientes = menuClientes.getOption();
				do{
					switch(opClientes){
					case 0:
						cadastroClientes();
						break;
					case 1:
						ClienteNat cli = consultaClientes();
						if(cli != null && cli.getTelefoneCliente() != 0){
							System.out.println("--------------------------------");
							System.out.println("Cliente encontrado!");
							System.out.println("--------------------------------");
							cli.mostraCliente();
							System.out.println("--------------------------------");
							cli.updateCliente();
							cli.update();
						}else{
							System.out.println("---------------------------------");
    						System.out.println("ERRO: Cliente não encontrado!");
    						System.out.println("---------------------------------");
						}
						break;
					case 2:
						listaClientes();
						break;
					case 99:
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
					menuClientes.show();
					opClientes = menuClientes.getOption();
				}while(opClientes != 99);
				break;
			case 1:
				Menu menuPedidos = new Menu("Pedidos", opsMenuPedidos);
				menuPedidos.show();
				
				int opPedidos = menuPedidos.getOption();
				do{
					switch(opPedidos){
					case 0:
						registroPedidos(consultaClientes());
						break;
					case 1:
						PedidosNat ped = consultaPedidos();
						if(ped != null && ped.getCodigoPedido() != 0){
							System.out.println("--------------------------------");
							System.out.println("Pedido encontrado!");
							System.out.println("--------------------------------");
							ped.mostraPedido();
							System.out.println("--------------------------------");
							ped.updatePedidos();
							ped.update();
						}else{
							System.out.println("---------------------------------");
    						System.out.println("ERRO: Pedido não encontrado!");
    						System.out.println("---------------------------------");
						}
						break;
					case 2:
						listaPedidos();
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
					menuPedidos.show();
					opPedidos = menuPedidos.getOption();
				}while(opPedidos != 99);
				break;
			case 2:
				Menu menuProdutos = new Menu("Produtos", opsMenuProdutos);
				menuProdutos.show();
				
				int opProdutos = menuProdutos.getOption();
				do{
					switch(opProdutos){
					case 0:
						cadastroProdutos();
						break;
					case 1:
						ProdutosNat prod = consultaProdutos();
						if(prod != null && prod.getCodigoProd() != 0){
							System.out.println("--------------------------------");
							System.out.println("Produto encontrado!");
							System.out.println("--------------------------------");
							prod.mostraProduto();
							System.out.println("--------------------------------");
							prod.updateProdutos();
							prod.update();
						}else{
							System.out.println("---------------------------------");
    						System.out.println("ERRO: Produto não encontrado!");
    						System.out.println("---------------------------------");
						}
						break;
					case 2:
						listaProdutos();
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
					menuProdutos.show();
					opProdutos = menuProdutos.getOption();
				}while(opProdutos != 99);
				break;
			case 3:
				Menu menuEstoque = new Menu("Estoque", opsMenuEstoque);
				menuEstoque.show();
				
				int opEstoque = menuEstoque.getOption();
				do{
					switch(opEstoque){
					case 0:
						registroEstoque();
						break;
					case 1:
						EstoqueNat est = consultaEstoque();
						if(est != null && est.getCodigoProd() != 0){
							System.out.println("--------------------------------");
							System.out.println("Produto encontrado no estoque!");
							System.out.println("--------------------------------");
							est.mostraEstoque();
							System.out.println("--------------------------------");
							est.updateEstoque();
							est.update();
						}else{
							System.out.println("---------------------------------");
    						System.out.println("ERRO: Produto não encontrado no estoque!");
    						System.out.println("---------------------------------");
						}
						break;
					case 2:
						listaEstoque();
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
					menuEstoque.show();
					opEstoque = menuEstoque.getOption();
				}while(opEstoque != 99);
				break;
			case 4:
				Menu menuVendas = new Menu("Vendas", opsMenuVendas);
				menuVendas.show();
				
				int opVendas = menuVendas.getOption();
				do{
					switch(opVendas){
					case 0:
						registroVendas();
						break;
					case 1:
						VendasNat vend = consultaVendas();
						if(vend != null && vend.getNumNotaFisc() != 0){
							System.out.println("--------------------------------");
							System.out.println("Venda encontrada!");
							System.out.println("--------------------------------");
							vend.mostraVenda();
							System.out.println("--------------------------------");
							vend.updateVendas();
							vend.update();
						}else{
							System.out.println("---------------------------------");
    						System.out.println("ERRO: Venda não encontrada!");
    						System.out.println("---------------------------------");
						}
						break;
					case 2:
						listaVendas();
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
					menuVendas.show();
					opVendas = menuVendas.getOption();
				}while(opVendas != 99);
				break;
			case 99:
				System.out.println("Tchau!");
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
			menu.show();
			op = menu.getOption();
		}while (op != 99);
	}
	
		public static void cadastroClientes(){
			ClienteNat cliente = new ClienteNat();
			if(cliente != null && cliente.getTelefoneCliente() != 0){
				cliente.save();
				System.out.println("---------------------------------");
				System.out.println("Cliente cadastrado com sucesso!");
				System.out.println("---------------------------------");
				cliente.mostraCliente();
				System.out.println("---------------------------------");
			}else{
				System.out.println("---------------------------------");
				System.out.println("Falha no cadastro do cliente!");
				System.out.println("---------------------------------");
			}
		}
		
		public static void registroPedidos(ClienteNat cli){
			PedidosNat pedidos = new PedidosNat(cli);
			if(pedidos != null && pedidos.getCodigoPedido() != 0){
				pedidos.save();
				System.out.println("---------------------------------");
				System.out.println("Pedido registrado com sucesso!");
				System.out.println("---------------------------------");
				pedidos.mostraPedido();
				System.out.println("---------------------------------");
			}else{
				System.out.println("---------------------------------");
				System.out.println("Falha no registro do pedido!");
				System.out.println("---------------------------------");
			}
		}
		
		public static void cadastroProdutos(){
			ProdutosNat produtos = new ProdutosNat();
			if(produtos != null && produtos.getCodigoProd() != 0){
				produtos.save();
				System.out.println("---------------------------------");
				System.out.println("Produto cadastrado com sucesso!");
				System.out.println("---------------------------------");
				produtos.mostraProduto();
				System.out.println("---------------------------------");
			}else{
				System.out.println("---------------------------------");
				System.out.println("Falha no cadastro do produto!");
				System.out.println("---------------------------------");
			}
		}
		
		public static void registroEstoque(){
			EstoqueNat estoque = new EstoqueNat();
			if(estoque != null && estoque.getCodigoProd() != 0){
				estoque.save();
				System.out.println("---------------------------------");
				System.out.println("Produto registrado no estoque com sucesso!");
				System.out.println("---------------------------------");
				estoque.mostraEstoque();
				System.out.println("---------------------------------");
			}else{
				System.out.println("---------------------------------");
				System.out.println("Falha no registro do produto no estoque!");
				System.out.println("---------------------------------");
			}
		}
		
		public static void registroVendas(){
			VendasNat vendas = new VendasNat();
			if(vendas != null && vendas.getNumNotaFisc() != 0){
				vendas.save();
				System.out.println("---------------------------------");
				System.out.println("Venda registrada com sucesso!");
				System.out.println("---------------------------------");
				vendas.mostraVenda();
				System.out.println("---------------------------------");
			}else{
				System.out.println("---------------------------------");
				System.out.println("Falha no registro da venda!");
				System.out.println("---------------------------------");
			}
		}
		
		public static ClienteNat consultaClientes(){
			long pesquisa = 0;
    		System.out.println("Telefone do Cliente: ");
        	pesquisa = scan.nextLong();
        	scan.nextLine();
        	for (ClienteNat cli : listaClientes) {
        		if (cli.getTelefoneCliente() == pesquisa){               
        			cli.setIndice(listaClientes.indexOf(cli));  
        			return cli;
        		}
        	}   	
        	return null;
		}
		
		public static PedidosNat consultaPedidos(){
			long pesquisa = 0;
    		System.out.println("Código do Pedido: ");
        	pesquisa = scan.nextLong();
        	scan.nextLine();
        	for (PedidosNat ped : listaPedidos) {
        		if (ped.getCodigoPedido() == pesquisa){               
        			ped.setIndice(listaPedidos.indexOf(ped));  
        			return ped;
        		}
        	}   	
        	return null;
		}
		
		public static ProdutosNat consultaProdutos(){
			long pesquisa = 0;
    		System.out.println("Código do Produto: ");
        	pesquisa = scan.nextLong();
        	scan.nextLine();
        	for (ProdutosNat prod : listaProdutos) {
        		if (prod.getCodigoProd() == pesquisa){               
        			prod.setIndice(listaProdutos.indexOf(prod));  
        			return prod;
        		}
        	}   	
        	return null;
		}
		
		public static EstoqueNat consultaEstoque(){
			long pesquisa = 0;
    		System.out.println("Código do Produto: ");
        	pesquisa = scan.nextLong();
        	scan.nextLine();
        	for (EstoqueNat est : listaEstoque) {
        		if (est.getCodigoProd() == pesquisa){               
        			est.setIndice(listaEstoque.indexOf(est));  
        			return est;
        		}
        	}   	
        	return null;
		}
		
		public static VendasNat consultaVendas(){
			long pesquisa = 0;
    		System.out.println("Nº da Nota Fiscal: ");
        	pesquisa = scan.nextLong();
        	scan.nextLine();
        	for (VendasNat vend : listaVendas) {
        		if (vend.getNumNotaFisc() == pesquisa){               
        			vend.setIndice(listaVendas.indexOf(vend));  
        			return vend;
        		}
        	}   	
        	return null;
		}
		
		public static void listaClientes(){
    		System.out.println("Dados dos Clientes:");
    		System.out.println("---------------------------------");
    		int pos = 0;
    		for (ClienteNat cliente : listaClientes){
    			pos += 1;
    			System.out.println("Número: " + pos);
    			cliente.mostraCliente();
    			System.out.println("---------------------------------");    		
    		}
    	}
		
		public static void listaPedidos(){
    		System.out.println("Dados dos Pedidos:");
    		System.out.println("---------------------------------");
    		int pos = 0;
    		for (PedidosNat pedidos : listaPedidos){
    			pos += 1;
    			System.out.println("Número: " + pos);
    			pedidos.mostraPedido();
    			System.out.println("---------------------------------");    		
    		}
    	}
		
		public static void listaProdutos(){
    		System.out.println("Dados dos Produtos:");
    		System.out.println("---------------------------------");
    		int pos = 0;
    		for (ProdutosNat produtos : listaProdutos){
    			pos += 1;
    			System.out.println("Número: " + pos);
    			produtos.mostraProduto();
    			System.out.println("---------------------------------");    		
    		}
    	}
		
		public static void listaEstoque(){
    		System.out.println("Dados dos Produtos em Estoque:");
    		System.out.println("---------------------------------");
    		int pos = 0;
    		for (EstoqueNat estoque : listaEstoque){
    			pos += 1;
    			System.out.println("Número: " + pos);
    			estoque.mostraEstoque();
    			System.out.println("---------------------------------");    		
    		}
    	}
		
		public static void listaVendas(){
    		System.out.println("Dados das Vendas:");
    		System.out.println("---------------------------------");
    		int pos = 0;
    		for (VendasNat vendas : listaVendas){
    			pos += 1;
    			System.out.println("Número: " + pos);
    			vendas.mostraVenda();
    			System.out.println("---------------------------------");   		
    		}
    	}	
}