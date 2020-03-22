package Farmacia.Controller;

import java.util.ArrayList;

import Farmacia.Entity.Farmaco;
import Farmacia.Entity.Ordine;
import Farmacia.Entity.Stato;


public class GestoreAcquisti {
	
	ArrayList<Farmaco> listaFarmaciDisponibili;

    public GestoreAcquisti() {
    	listaFarmaciDisponibili = new ArrayList<Farmaco>();
    }

    public Ordine acquistaFarmaco(int codiceRicettaMedica, Farmaco[] farmaco, int[] quantitàFarmaco) {
        Ordine ordine = new Ordine(codiceRicettaMedica, farmaco, quantitàFarmaco);
        autorizzaAcquisto(ordine);
        return ordine;
    }

    public void autorizzaAcquisto(Ordine ordine) {
        ordine.setStato(Stato.Autorizzato);
    }

    public void generaReport() {
    }
}