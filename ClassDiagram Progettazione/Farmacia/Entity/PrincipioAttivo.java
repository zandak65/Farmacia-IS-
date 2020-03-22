package Farmacia.Entity;

public class PrincipioAttivo {

   private int codice = 0;
   private String nome;
   private String tipo;
   private int quantitàResidua;
   
    public PrincipioAttivo(int codice, String nome, String tipo, int quantitàResidua) {
    	this.codice++;
    	this.nome = nome;
    	this.tipo = tipo;
    	this.quantitàResidua = quantitàResidua;
    }
    
    public int getCodice() {
    	return codice;
    }
    
    public String getNome() {
    	return nome;
    }

    public String getTipo() {
    	return tipo;
    }
    
    public int getQuantitàResidua() {
    	return quantitàResidua;
    }
    
    public String toString() {
    	return nome;
    }
}