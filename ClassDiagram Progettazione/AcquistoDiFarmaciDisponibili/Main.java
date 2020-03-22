package AcquistoDiFarmaciDisponibili;

import java.util.ArrayList;
import java.util.Scanner;
import Farmacia.Controller.*;
import Farmacia.Entity.*;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
		GestoreSistema gestoreSistema = new GestoreSistema();
		GestoreAcquisti gestoreAcquisti = new GestoreAcquisti();
		
		int codice = 1;
		String nome = "Colecalciferolo";
		int quantitàResidua = 20;
		String tipo = "";
		
		PrincipioAttivo principioAttivo = new PrincipioAttivo(codice, nome, tipo, quantitàResidua);
		
		codice = 2;
		nome = "Lansoprazolo";
		quantitàResidua = 4;
		tipo = "";
		
		PrincipioAttivo principioAttivo2 = new PrincipioAttivo(codice, nome, tipo, quantitàResidua);
		
		codice = 3;
		nome = "Mesalazina";
		quantitàResidua = 30;
		tipo = "";
		
		PrincipioAttivo principioAttivo3 = new PrincipioAttivo(codice, nome, tipo, quantitàResidua);
		
		codice = 4;
		nome = "Ramipril";
		quantitàResidua = 17;
		tipo = "";
		
		PrincipioAttivo principioAttivo4 = new PrincipioAttivo(codice, nome, tipo, quantitàResidua);
		
		int codiceFarmaco = 1;
		String nomeFarmaco = "OKI";
		float prezzo = (float) 20.00;
		int quantitàDisponibili = 10;
		boolean prescrivibile = false;
		ProvenienzaFarmaco provenienzaFarmaco = ProvenienzaFarmaco.commerciali;
		
		Farmaco farmaco = new Farmaco(codiceFarmaco, nomeFarmaco, prezzo, quantitàDisponibili, provenienzaFarmaco, prescrivibile);
		farmaco.aggiungiPrincipioAttivo(principioAttivo);
		farmaco.aggiungiPrincipioAttivo(principioAttivo2);
		gestoreSistema.inserireFarmaco(farmaco);
		
	    codiceFarmaco = 2;
		nomeFarmaco = "Abelcet";
		prezzo = (float) 10.00;
		quantitàDisponibili = 3;
		prescrivibile = true;
		provenienzaFarmaco = ProvenienzaFarmaco.galenici;
		
		Farmaco farmaco2 = new Farmaco(codiceFarmaco, nomeFarmaco, prezzo, quantitàDisponibili, provenienzaFarmaco, prescrivibile);
		farmaco2.aggiungiPrincipioAttivo(principioAttivo2);
		farmaco2.aggiungiPrincipioAttivo(principioAttivo3);
		gestoreSistema.inserireFarmaco(farmaco2);
		
	    codiceFarmaco = 3;
		nomeFarmaco = "Tachipirina";
		prezzo = (float) 15.00;
		quantitàDisponibili = 30;
		prescrivibile = false;
		provenienzaFarmaco = ProvenienzaFarmaco.commerciali;
		
		Farmaco farmaco3 = new Farmaco(codiceFarmaco, nomeFarmaco, prezzo, quantitàDisponibili, provenienzaFarmaco, prescrivibile);
		farmaco3.aggiungiPrincipioAttivo(principioAttivo4);
		farmaco3.aggiungiPrincipioAttivo(principioAttivo);
		gestoreSistema.inserireFarmaco(farmaco3);
		
		ArrayList<Farmaco> ArrayDisponibili = gestoreSistema.visualizzareListaFarmaciDisponibili();
		
		System.out.println("Farmaci disponibili:\n");
		
		for(Farmaco farmacoDisponibile: ArrayDisponibili) {
			System.out.println("Farmaco ==> " + farmacoDisponibile + "\n");
		}
		
		scan = new Scanner(System.in);
		ArrayList<Farmaco> acquisti2 = new ArrayList<Farmaco>();
		ArrayList<Integer> quantitàOrdine2 = new ArrayList<Integer>();
		int i = 0;
		Boolean fine = false;
		while(fine == false) {
			System.out.println("Inserisci il nome del " + (i + 1)+ " Farmaco:");
			String nomeFarmacoAcquisto = scan.next();
			if(nomeFarmacoAcquisto.contentEquals("OKI")){
				acquisti2.add(farmaco);
			}
			else if(nomeFarmacoAcquisto.contentEquals("Abelcet")){
				acquisti2.add(farmaco2);
			}
			else if(nomeFarmacoAcquisto.contentEquals("Tachipirina")){
				acquisti2.add(farmaco3);
			}
			System.out.println("Quanti ne vuoi ordinare?");
			int quantitàDaAcquistare = scan.nextInt();
			quantitàOrdine2.add(quantitàDaAcquistare);
			System.out.println("Vuoi inserire un altro farmaco? (si/no)");
			String risposta = scan.next();
			if(risposta.contentEquals("no")) {
				fine = true;
			}
			i++;
		}
		Farmaco[] acquisti = new Farmaco[acquisti2.size()];
		int[] quantitàOrdine = new int[quantitàOrdine2.size()];
		acquisti2.toArray(acquisti);
		for(int b = 0; b < quantitàOrdine2.size(); b++) {
			quantitàOrdine[b] = quantitàOrdine2.get(b);
		}
		Boolean ricettaInserita = false;
		int codiceRicettaMedica = 0;
		for(int c = 0; c<quantitàOrdine.length; c++) {
			if(acquisti[c].getPrescrivibile() == true && ricettaInserita == false) {
				System.out.println("Introduci il codice ricetta:");
				codiceRicettaMedica = scan.nextInt();
				ricettaInserita = true;
			}
			if(quantitàOrdine[c] <= acquisti[c].getQuantitàDisponibili()) {
				if(c == quantitàOrdine.length - 1) {
					Ordine ordine = gestoreAcquisti.acquistaFarmaco(codiceRicettaMedica, acquisti, quantitàOrdine);
					System.out.println("------------\n" + ordine);
				}
			}
			else {
				System.out.println("------------\nLa quantità di Farmaci che stai provando ad ordinare non è disponibile. Prova ad ordinarne di meno");
				System.exit(1);
			}
		}
	}
}