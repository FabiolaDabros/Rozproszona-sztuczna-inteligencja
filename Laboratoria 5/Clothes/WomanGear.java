package Clothes;

import MyException.ClothAlreadyTryingOn;  // użycie klasy z innego pakietu z importowaniem ; jest to klasa z własnym wyjątkiem
import java.util.Scanner;

public class WomanGear extends Gear  {                   // dziedziczenie
    boolean purchased;
    double price;

    public WomanGear( String kind, int size, String color, double price, short year) {
        super(kind,size,color,year);
        this.purchased=false;
        this.price=price;
    }

    public boolean isPurchased() {
        return purchased;
    }
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    @Override
    public double buy(double kilometer)throws IllegalArgumentException {     // rzucenie wyjątku
        if (kilometer <0)
            throw new IllegalArgumentException("Kilometer must be >= 0");
        else
        return this.price + kilometer;
    }

    @Override
    public void trySthOn(int size) {
        try {                                                                  // obsługa własnego wyjątku
            System.out.println("Please give me your size in a number. ");
            Scanner scanner = new Scanner(System.in);
            int userSize = scanner.nextInt();
                    if(this.size == userSize)
                        System.out.println(" It is perfect for you! ");
                    else
                        throw new ClothAlreadyTryingOn();
        } catch (ClothAlreadyTryingOn clothAlreadyTryingOn) {                  // wylapuje wyjatek i go obsluguje
            System.out.println(" You have bought a wrong size! It's: " + size + "\n I'm so sorry. It does'nt suit you. ");
        }
    }

}
