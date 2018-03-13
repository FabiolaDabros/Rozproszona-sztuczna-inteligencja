package Clothes;


import java.util.Random;

public abstract class Gear implements Buying{      // klasa abstrakcyjna oraz użycie interfejsu
    int size;
    String kind;
    String color;
    short year;
    public abstract void trySthOn(int size) throws MyException.ClothAlreadyTryingOn;  // użycie klasy z innego pakietu bez importowania
                                                                                      // rzucenie własnego wyjątku
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
