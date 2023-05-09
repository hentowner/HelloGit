package Produttore_Consumatore;

/*
 * Pujatti Elena Sofia
 * 4BIA
 */

//Classe Data per i dati condivisi da tutti i thread
public class Data {
	
	public static final int N = 10;												//Dimensione buffer
	public static volatile int[] buffer = new  int[N];							//Buffer
	public static volatile int IN = 0; 											//Indice produttori
	public static volatile int OUT = 0;											//Indice consumatori
	public static int min;														//Minimo tempo di sleep
	public static int max;														//Massimo tempo di sleep
	public static int azioni;													//Numero di azioni
	public static volatile Semafori SCons = new Semafori();
	public static volatile Semafori SProd = new Semafori();
}
