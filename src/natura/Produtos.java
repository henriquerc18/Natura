package natura;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Produtos{
	
	private int paginaProd = 0;
	private long codigoProd = 0;
	private String descricaoProd = "";
	private Double precoProd = 0.00;
	private int indice = 0;

	//Pedido - Produto
	private Pedidos pedidoProduto = null;
	
	//Produto - Estoque
	private ArrayList<Estoque> listaEstoque = new ArrayList<Estoque>();
	
	private Scanner scan = Natura.scan;
	
	//Gets
	public int getPaginaProd(){
		return paginaProd;
	}
	
	public long getCodigoProd(){
		return codigoProd;
	}
	
	public String getDescricaoProd(){
		return descricaoProd;
	}
	
	public Double getPrecoProd(){
		return precoProd;
	}
	
	public int getIndice(){
		return indice;
	}
	
	//Get Pedidos - Produtos
	public Pedidos getpedidoProduto() {
		return pedidoProduto;
	}
	
	//Get Produto - Estoque
	public List<Estoque> getListaEstoque() {
		return listaEstoque;
	}
	
	//Sets
	public void setPaginaProd(int paginaProd){
		this.paginaProd = paginaProd;
	}
	
	public void setCodigoProd(long codigoProd){
		this.codigoProd = codigoProd;
	}

	public void setDescricaoProd(String descricaoProd){
		this.descricaoProd = descricaoProd;
	}
	
	public void setPrecoProd(Double precoProd){
		this.precoProd = precoProd;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	//Set Pedido - Produto
	public void setPedidoProduto(Pedidos pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
	}
	
	//Set Produto - Estoque
	public void setListaEstoque(ArrayList<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}
	
	public Produtos(int paginaProd, long codigoProd, String descricaoProd, Double precoProd, Pedidos pedido){
		this.paginaProd = paginaProd;
		this.codigoProd = codigoProd;
		this.descricaoProd = descricaoProd;
		this.precoProd = precoProd;
		this.pedidoProduto = pedido;
	}
	
	public Produtos(Pedidos pedido){
		try{
			System.out.println("Página do Produto: ");
			this.paginaProd = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Código do Produto: ");
			this.codigoProd = scan.nextLong();
			scan.nextLine();
			pedidoProduto = pedido;
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();			
		}
		
		System.out.println("Descrição do Produto: ");
		this.descricaoProd = scan.nextLine();
		
		try{
			System.out.println("Preço do Produto: ");
			this.precoProd = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}		
	}
	
	public boolean save(){
		Natura.listaProdutos.add(this);
		return true;
	}
	
	public void updateProdutos(){
		try{
			System.out.println("Nova Página do Produto: ");
			this.paginaProd = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
		
		try{
			System.out.println("Novo Código do Produto: ");
			this.codigoProd = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();			
		}
		
		System.out.println("Nova Descrição do Produto: ");
		this.descricaoProd = scan.nextLine();
		
		try{
			System.out.println("Novo Preço do Produto: ");
			this.precoProd = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}		
	}
	
	public boolean update(){
		Natura.listaProdutos.set(this.getIndice(), this);
		return true;
	}
	
	public void mostraProduto(){
		System.out.println("Produto:");
		System.out.println("Página: " + this.paginaProd);
		System.out.println("Código: " + this.codigoProd);
		System.out.println("Descrição: " + this.descricaoProd);
		System.out.println("Preço: " + this.precoProd);
	}
}