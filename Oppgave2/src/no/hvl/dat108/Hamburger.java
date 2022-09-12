package no.hvl.dat108;

public class Hamburger {

    private int id;
    private static int nummer = 1;

    public Hamburger(){
        this.id = nummer++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[" + id + "]";
    }
}
