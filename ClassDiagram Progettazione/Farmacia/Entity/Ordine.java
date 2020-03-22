package Farmacia.Entity;

import java.util.ArrayList;

public class Ordine {
	
    private int codiceRicettaMedica;
    private Boolean ordineAutorizzato;
    private int id;
    private Stato stato = Stato.Attendi;
    
    public ClienteRegistrato proprietario;
    
    private ArrayList<OrdineFarmaco> arrayQuantitàOrdine = new ArrayList<OrdineFarmaco>();


    public Ordine(int codiceRicettaMedica, Farmaco[] farmaco, int[] quantitàOrdine) {
    	this.id++;
    	this.codiceRicettaMedica = codiceRicettaMedica;
    			
    	for(int i = 0; i<farmaco.length; i++) {
    		arrayQuantitàOrdine.add(new OrdineFarmaco(quantitàOrdine[i], farmaco[i]));
    	}
    }
    
    public ArrayList<OrdineFarmaco> getFarmaco(){
    	return arrayQuantitàOrdine;
    }
    
    public Stato getStato() {
    	return stato;
    }
    
    public void setStato(Stato stato) {
    	this.stato = stato;
    }
    
    public void getCodiceRicettaMedica(int ricettaMedica) {
    	this.codiceRicettaMedica = ricettaMedica;
    }
    
    public int getId() {
    	return id;
    }
    
    public Boolean getOrdineAutorizzato() {
    	return ordineAutorizzato;
    }
    
    public int getCodiceRicettaMedica() {
    	return codiceRicettaMedica;
    }
    
    public String toString() {
    	return "Ricetta: " + codiceRicettaMedica + " | Ordine ==>  " + arrayQuantitàOrdine;
    }
}