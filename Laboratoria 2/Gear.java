package Clothes;


import java.util.Random;

public class Gear implements Buying{
    int size;
    String kind;
    String color;
    short year;
    boolean purchased;
    double price;

    public Gear() {
        this.size = 36;
        this.kind = "trousers";
        this.color ="Black" ;
        this.year = 2018;
    }
    public Gear( String kind, int size, String color, short year) {
        this.kind = kind;
        this.size = size;
        this.color = color;
        this.year = year;
    }

    public int getSize() {
        return size;
    }
    public String getKind() {
        return kind;
    }
    public String getColor() {
        return color;
    }
    public short getYear() {
        return year;
    }

    @Override
    public double buy(double kilometer)throws IllegalArgumentException {     // rzucenie wyjątku
        if (kilometer <0)
            throw new IllegalArgumentException("Kilometer must be >= 0");
        else
            return this.price + kilometer;

    public void randomCode(){
        Random los = new Random ();
        int [][] code = new int [2][4];
        System.out.println("Your code:");
        for (int w = 0; w < code.length; w++){
            for (int k = 0; k < code[w].length; k++){
                code[w][k] = los.nextInt(9);
                System.out.print((code[w][k]));
            }
            System.out.println();
        }
    }
}
