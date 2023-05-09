package Produttore_Consumatore;

import java.time.LocalDate;
import java.util.Random;

/*
 * Pujatti Elena Sofia
 * 4BIA
 */

public class Produttore extends Thread {

	public int name;								//nome thread
	
	//Costruttore 
	public Produttore(int nome) {
		this.name = nome;
	}
	
	
	public void run() {	
		while(Data.azioni > 0) {
			//Sincronizzazione thread
			Data.SProd.down();
			if((Data.IN + 1) % Data.N != Data.OUT) {
				//Inserimento prodotto
				int num = 1 + new Random().nextInt(1000);
				Data.buffer[Data.IN] = num;					
				System.out.println("Produttore "+ this.name + " ha prodotto: " + Data.IN + " = " + Data.buffer[Data.IN]);
				Data.IN = (Data.IN + 1) % Data.N;
			}else {
				//Buffer pieno
				System.out.println("Buffer pieno "+ this.name);
			}   
			Data.azioni--;
			Data.SProd.up();
			try {
				Thread.sleep(Data.min + new Random().nextInt(Data.max - Data.min));
			} catch (InterruptedException e) {					
				e.printStackTrace();
			}	
		}		
	}

}
