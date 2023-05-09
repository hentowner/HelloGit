package Produttore_Consumatore;

public class Semafori {
    private int s = 1; // variabile di stato   
    
    public Semafori() { // costruttore
    	
    }
    synchronized public void down() { // primitiva P()
        s--;
        if (s<0) {
            try{wait();} 
   catch(InterruptedException e) {};
        }        
    }    
    synchronized public void up(){ // primitiva V()
       s++;
       notify();
    }
}
