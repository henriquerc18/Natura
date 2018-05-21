package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vendas{
	
	private long codVenda = 0;
	private int quantidade = 0;
	private Double precoTotal = 0.00;
	private String dataVenda = "";
	private int indice = 0;
	
	//Cliente - Venda
	private Clientes clienteVenda = null;
	
	private Scanner scan = Natura.scan;
	
	//Gets
	public long getNumNotaFisc(){
		return getCodVenda();
	}

	public long getCodVenda(){
		return codVenda;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public Double getPrecoTotal(){
		return precoTotal;
	}
	
	public String dataVenda(){
		return dataVenda;
	}
	
	public int getIndice(){
		return indice;
	}
	
	//Get Cliente - Venda
	public Clientes getClienteVenda() {
		return clienteVenda;
	}
	
	//Sets
	public void setCodVenda(long codVenda){
		this.codVenda = codVenda;
	}
	
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	
	public void setPrecoTotal(Double precoTotal){
		this.precoTotal = precoTotal;
	}
	
	public void setDataVenda(String dataVenda){
		this.dataVenda = dataVenda;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	//Set Cliente - Venda
	public void setClienteVenda(Clientes clienteVenda) {
		this.clienteVenda = clienteVenda;
	}
	
	public Vendas(long codVenda, int quantidade, Double precoTotal, String dataVenda, Clientes cli){
		this.codVenda = codVenda;
		this.quantidade = quantidade;
		this.precoTotal = precoTotal;
		this.dataVenda = dataVenda;
		this.clienteVenda = cli;
	}
	
	public Vendas(Clientes cli){
		try{
			System.out.println("Código da Venda: ");
			this.codVenda = scan.nextLong();
			scan.nextLine();
			clienteVenda = cli;
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Quantidade: ");
			this.quantidade = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Preço Total: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Data da Venda: ");
		this.dataVenda = scan.nextLine();
	}
	
	public void updateVendas(){
		try{
			System.out.println("Novo Código da Venda: ");
			this.codVenda = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Nova Quantidade: ");
			this.quantidade = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Novo Preço Total: ");
			this.precoTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		System.out.println("Nova Data da Venda: ");
		this.dataVenda = scan.nextLine();
	}
	
	public boolean update(){
		Natura.listaVendas.set(this.getIndice(), this);
		return true;
	}
	
	public boolean save(){
		Natura.listaVendas.add(this);
		return true;
	}
	
	public void mostraVenda(){
		System.out.println("Venda:");
		System.out.println("Cliente: " + clienteVenda.getNomeCliente());
		System.out.println("Código: " + this.codVenda);
		System.out.println("Quantidade: " + this.quantidade);
		System.out.println("Preço Total: " + this.precoTotal);
		System.out.println("Data da Venda: " + this.dataVenda);
	}
}