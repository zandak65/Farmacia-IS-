package Farmacia.Controller;

import java.util.ArrayList;
import Farmacia.Entity.Farmaco;

public class GestoreSistema {
	
	static ArrayList<Farmaco> arrayListaFarmaci;
	static ArrayList<Farmaco> arrayListaFarmaciDisponibili;
	
    public GestoreSistema() {
    	arrayListaFarmaci = new ArrayList<Farmaco>();
    	arrayListaFarmaciDisponibili = new ArrayList<Farmaco>();
    }

    public void inserireFarmaco(Farmaco farmaco) {
    	arrayListaFarmaci.add(farmaco);
    }

    public void modificareFarmaco(Farmaco farmaco, int quantitàDisponibili) {
    	farmaco.setQuantità(quantitàDisponibili);
        
    }

    public void rimuovereFarmaco(Farmaco farmaco) {
        arrayListaFarmaci.remove(farmaco);
    }

    public void inviaLista() {
        
    }

    public void registrazione() {
        
    }
    
    public ArrayList<Farmaco> visualizzareListaFarmaciDisponibili(){
    	for(Farmaco farmaco : arrayListaFarmaci) {
    		if(farmaco.getQuantitàDisponibili() > 0) {
    			arrayListaFarmaciDisponibili.add(farmaco);
    		}
    	}
    	return arrayListaFarmaciDisponibili;
    }
}