package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Estoque{
	
	private int paginaProd = 0;
	private long codigoProd = 0;
	private String descricaoProd = "";
	private Double precoProd = 0.00;
	private int qtdEstoque = 0;
	private int indice = 0;
	
	//Produto - Estoque
	private Produtos produtoEstoque = null;
	
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
	
	public int getQtdEstoque(){
		return qtdEstoque;
	}
	
	public int getIndice(){
		return indice;
	}
	
	//Get Produto - Estoque
	public Produtos getProdutoEstoque() {
		return produtoEstoque;
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
	
	public void setQtdEstoque(int qtdEstoque){
		this.qtdEstoque = qtdEstoque;
	}
	
	public void setIndice(int indice){
		this.indice = indice;
	}
	
	//Set Produto - Estoque
	public void setProdutoEstoque(Produtos produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}
	
	public Estoque(int paginaProd, long codigoProd, String descricaoProd, Double precoProd, int qtdEstoque, Produtos prod){
		this.paginaProd = paginaProd;
		this.codigoProd = codigoProd;
		this.descricaoProd = descricaoProd;
		this.precoProd = precoProd;
		this.qtdEstoque = qtdEstoque;
		this.produtoEstoque = prod;
	}
	
	public Estoque(Produtos prod){
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
			produtoEstoque = prod;
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
		try{
			System.out.println("Quantidade em Estoque: ");
			this.qtdEstoque = scan.nextInt();
			scan.nextLine();
			produtoEstoque = prod;
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
	}
	
	public void updateEstoque(){
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
		
		try{
			System.out.println("Nova Quantidade em Estoque: ");
			this.qtdEstoque = scan.nextInt();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Erro! Digite somente números!");
			scan.nextLine();
		}
	}
	
	public boolean update(){
		Natura.listaEstoque.set(this.getIndice(), this);
		return true;
	}
	
	public boolean save(){
		Natura.listaEstoque.add(this);
		return true;
	}
	
	public void mostraEstoque(){
		System.out.println("Estoque:");
		System.out.println("Página: " + this.paginaProd);
		System.out.println("Código: " + this.codigoProd);
		System.out.println("Descrição: " + this.descricaoProd);
		System.out.println("Preço: " + this.precoProd);
		System.out.println("Quantidade em Estoque: " + this.qtdEstoque);
	}	
}