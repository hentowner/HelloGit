package Produttore_Consumatore;

import java.time.LocalDate;
import java.util.Random;

/*
 * Pujatti Elena Sofia
 * 4BIA
 */

public class Consumatore extends Thread {

	public int nome;								//Nome consumatore
	
	//Costruttore
	public Consumatore( int nome) {		
		this.nome = nome;				
	}
	
	public void run() {
		while(Data.azioni >0) {
			//Sincronizzazione thread
			Data.SCons.down();
			if(Data.IN != Data.OUT) {	
				//Lettura prodotto
				System.out.println("Consumatore " + this.nome + " ha consumato " + Data.buffer[Data.OUT] + " = " + Data.OUT);
				Data.buffer[Data.OUT] = 0;
				Data.OUT = (Data.OUT + 1) % Data.N;
			}else {
				//Buffer vuoto
				System.out.println("Buffer vuoto 1");
			}
			Data.azioni--;
			Data.SCons.up();
			try {
				Thread.sleep(Data.min + new Random().nextInt(Data.max - Data.min));
			} catch (InterruptedException e) {					
				e.printStackTrace();
			}
		}
		
		
	}
}
