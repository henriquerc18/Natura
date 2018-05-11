package natura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProdutosNat{
	
	private int paginaProd = 0;
	private long codigoProd = 0;
	private String descricaoProd = "";
	private Double precoProd = 0.00;
	
	private int indice = 0;
	
	private Scanner scan = Natura.scan;
	
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
	
	public ProdutosNat(int paginaProd, long codigoProd, String descricaoProd, Double precoProd){
		this.paginaProd = paginaProd;
		this.codigoProd = codigoProd;
		this.descricaoProd = descricaoProd;
		this.precoProd = precoProd;
	}
	
	public ProdutosNat(){
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