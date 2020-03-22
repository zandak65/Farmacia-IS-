package Farmacia.Entity;

import java.util.*;

public class ClienteRegistrato {

    private String nome;
    private String cognome;
    private Date dataDiNascita;
    private String codiceFiscale;
    private String tesseraSanitaria;
    private String cartaDiCredito;
    
    public ClienteRegistrato(String nome, String cognome, Date dataDiNascita, String codiceFiscale, String tesseraSanitaria, String cartaDiCredito) {
    	this.nome = nome;
    	this.cognome = cognome;
    	this.dataDiNascita = dataDiNascita;
    	this.codiceFiscale = codiceFiscale;
    	this.tesseraSanitaria = tesseraSanitaria;
    	this.cartaDiCredito = cartaDiCredito;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public String getCognome() {
    	return cognome;
    }
    
    public Date getDataDiNascita() {
    	return dataDiNascita;
    }
    
    public String getCodiceFiscale() {
    	return codiceFiscale;
    }
    
    public String getTesseraSanitaria() {
    	return tesseraSanitaria;
    }
    
    public String getCartaDicredito() {
    	return cartaDiCredito;
    }
}