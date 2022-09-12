package no.hvl.dat108;

import javax.swing.*;

public class Dialog implements Runnable{

    private Traad traad;

    public Dialog(Traad traad){
        this.traad = traad;
    }


    @Override
    public void run() {

        String input = traad.getMelding();

        while(!input.equals("quit")){

            input = JOptionPane.showInputDialog("");
            traad.setMelding(input);
        }
    }
}
