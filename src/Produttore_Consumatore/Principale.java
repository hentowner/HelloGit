package Produttore_Consumatore;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Pujatti Elena Sofia
 * 4BIA
 */
public class Principale {
	
	public static int c; 
	public static int p;	
	public static ArrayList<Produttore> Produttori = new ArrayList<Produttore>();
	public static ArrayList<Consumatore> Consumatori = new ArrayList<Consumatore>();
	
	public static void main (String[] args) {
		//Inserimento azioni, sleep minimo e massimo da tastiera
		Scanner s = new Scanner(System.in);
		//Il tempo di sleep minimo deve essere maggiore di 1 millisecondo
		do {
			System.out.println("Inserire il tempo minimo di attesa: ");
			Data.min = s.nextInt();
		}while(Data.min<1);
		//Il tempo di sleep massimo deve essere minore di 3 secondi 
		do {
			System.out.println("Inserire il tempo massimo di attesa: ");
			Data.max = s.nextInt();
		}while(Data.max>3000);
		//Il numero di azioni deve essere compreso tra 10 e 150
		do {
			System.out.println("Inserire il numero di azioni da compiere: ");
			Data.azioni = s.nextInt();
		}while((Data.azioni > 150) || (Data.azioni < 10));
		//Inserimento numero produtti
		do {
			System.out.println("Inserire il numero di produttori: ");
			p = s.nextInt();
		}while(p<0);
		//Inserimento numero consumatori
		do {
			System.out.println("Inserire il numero di consumatori: ");
			c = s.nextInt();
		}while(c<0);
		
		
		for(int i =0; i<p; i++) {
			Produttore p = new Produttore(i+1);
			Produttori.add(p);
			Produttori.get(i).start();
		}

		for(int i =0; i<c; i++) {
			Consumatore c = new Consumatore(i+1);
			Consumatori.add(c);
			Consumatori.get(i).start();
		}
	}

	
}
