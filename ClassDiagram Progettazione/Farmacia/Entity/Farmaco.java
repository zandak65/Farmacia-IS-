package Farmacia.Entity;

import java.util.ArrayList;

public class Farmaco {
    private int codice = 0;
    private String nome;
    private Float prezzo;
    private int quantitàDisponibili;
    private ProvenienzaFarmaco provenienzaFarmaco;
    private boolean prescrivibile;
    private ArrayList<PrincipioAttivo> arrayPrincipioAttivo = new ArrayList<PrincipioAttivo>();

    public Farmaco(int codice, String nome, Float prezzo, int quantitàDisponibili, ProvenienzaFarmaco provenienzaFarmaco, boolean prescrivibile) {
    	this.codice++;
    	this.nome = nome;
    	this.prezzo = prezzo;
    	this.quantitàDisponibili = quantitàDisponibili;
    	this.provenienzaFarmaco = provenienzaFarmaco;
    	this.prescrivibile = prescrivibile;
    }
    
    public void aggiungiPrincipioAttivo(PrincipioAttivo principio) {
    	arrayPrincipioAttivo.add(principio);
    }
    
    public int getCodice() {
    	return codice;
    }

    public int getQuantitàDisponibili() {
    	return quantitàDisponibili;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public Float getPrezzo() {
    	return prezzo;
    }
    
    public Boolean getPrescrivibile() {
    	return prescrivibile;
    }
    
    public ProvenienzaFarmaco getProvenienzaFarmaco() {
    	return provenienzaFarmaco;
    }
    
    public void setQuantità(int quantitàDisponibili) {
    	this.quantitàDisponibili = quantitàDisponibili;
    }
    
    public String toString() {
    	return nome + ", " + prezzo + " Euro, " + quantitàDisponibili + " Disponibile/i , " + arrayPrincipioAttivo;
    }

}