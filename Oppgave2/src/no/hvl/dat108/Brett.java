package no.hvl.dat108;

import java.util.Arrays;

public class Brett {

    private final int KAPASITET;
    private Hamburger[] brett;
    private int teller;

    public Brett(int KAPASITET){
        this.KAPASITET = KAPASITET;
        brett = new Hamburger[KAPASITET];
        teller = 0;
    }

    public synchronized void leggTil(Hamburger hamburger) throws InterruptedException{

        while(erFull()){
            System.out.println(Thread.currentThread().getName() + " klar med hamburger, men brett er fullt. Venter!");
            wait();
        }

            brett[teller] = hamburger;
            teller++;

            System.out.println(Thread.currentThread().getName() + " legger på hamburger [" + hamburger + "]. " + "Brett: ["+ Arrays.toString(brett) + " ]");


    }

    public synchronized Hamburger hentHamburger() throws InterruptedException{

        while(erTom()){

            System.out.println(Thread.currentThread().getName() + " ønsker å ta hamburger, men brettet er tomt. Venter!");
            wait();
        }

        Hamburger hamburger = brett[0];
        teller--;

        for (int i = 0; i < teller; i++) {
            brett[i] = brett[i + 1];
        }
        brett[teller] = null;

        System.out.print(Thread.currentThread().getName() + " tar av hamburger " + hamburger + ". ");


        return hamburger;
    }

    public boolean erFull() {

        return brett[KAPASITET-1] != null;
    }

    public boolean erTom() {

        return brett[0] == null;
    }
}
