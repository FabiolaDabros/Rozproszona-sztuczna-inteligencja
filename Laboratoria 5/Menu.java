import Clothes.ManGear;
import Clothes.WomanGear;
import recordReading.File;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {                         // proba odczytu pliku ktory nie istanieje , // do serializacji
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scanner;
        int n=0, f=0, x=0, g=0,h=0;
        String info[] = {"great", "nice", "I don't like it"};

        System.out.println("\n CLOTHES SHOP");
        while(true) {
            System.out.println(" \n Please make a choice. Choose for who you want to buy a clothes. \n");
            System.out.println(" 1.Women \n 2.Men \n 3.Exit. \n");
            scanner = new Scanner(System.in);
            try {
                n = scanner.nextInt();
            }
            catch(InputMismatchException ime) {
                System.out.println(" You have to enter a number. ");
                continue;
            }

            switch (n) {
                case 1:
                    System.out.println(" Available products for women:");
                    try {
                        recordReading.File file = new File();                            // wczytanie z pliku txt
                        file.readFile("C:\\Users\\dfabi\\Desktop\\ClothesShop\\src\\ClothesForWomen.txt");
                    }catch(IOException e)
                    {
                        System.out.println(" We could'nt find a path ");
                    }

                    System.out.println(" \n Do you want to buy something or exit? ");
                    System.out.println(" 1. I want to buy. \n 2. Exit. ");
                    try {
                        f = scanner.nextInt();
                    } catch(InputMismatchException ime) {
                        System.out.println(" You have to enter a number. ");
                        continue;
                    }
                    switch (f) {
                        case 1:
                            System.out.println(" Please enter all information about your clothes. \n");
                                   System.out.println(" Enter kind. Enter size. Enter color. Enter price. Enter year. ");
                                                                         // wczytywanie danych z klawiatury
                                   String kind = new String();
                                   scanner.nextLine();
                                   kind = scanner.nextLine();
                                   int size = scanner.nextInt();
                                   String color = new String();
                                   scanner.nextLine();
                                   color = scanner.nextLine();
                                   double price = scanner.nextDouble();
                                   short year = scanner.nextShort();

                            WomanGear userGear = new WomanGear(kind,size,color,price,year);

                            File fileSeria = new File();              // serializacja oraz deserializacja
                            fileSeria.seriaDeseria(userGear);

                            System.out.println(" Do you want to print receipt and pay for product or exit? ");
                            System.out.println(" 1.Print receipt and pay. \n 2.Exit. ");

                            try {
                                g = scanner.nextInt();
                            } catch(InputMismatchException ime) {
                                System.out.println(" You have to enter a number. ");
                                continue;
                            }
                            switch (g) {
                                case 1:
                                    System.out.println("\n Please remember you have to pay for delivery. The price depends on your distance in kilometers from Cracow.  ");
                                    System.out.println(" Please put a kilometers");
                                    double kilometer = scanner.nextDouble();
                                    userGear.buy(kilometer);
                                    System.out.println("Your delivery cost is: " + kilometer );

                                    PrintWriter saving = new PrintWriter("Receipt.txt");            // zapis danych do txt
                                    saving.println("RECEIPT");
                                    saving.println(" Kind of cloth: " + userGear.getKind());
                                    saving.println(" Size: " + userGear.getSize());
                                    saving.println(" Color: " + userGear.getColor());
                                    saving.println(" Total price: " +  userGear.buy(kilometer));
                                    saving.println(" Year of production: " + userGear.getYear());
                                    saving.close();
                                    System.out.println("Your receipt has been saved to 'Receipt.txt' ");
                                    userGear.setPurchased(true);
                                    System.out.println("Your status of purchase is: " + userGear.isPurchased());

                                    userGear.randomCode();                                                  // wygenerwonie kodu z tablicy dwuwymiarowej

                                    Date currentDate = new Date();                                          // pobranie aktualnej daty i godziny
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                    String dateString = dateFormat.format(currentDate);
                                    System.out.println("\n Today is: " + dateString);
                                    System.out.println(" You have to wait one day for your delivery. Let's wait together! ");
                                    TimeUnit.SECONDS.sleep(30);

                                    System.out.println("\n Incredible! You have already get your product! Do you want to try it on? ");
                                    System.out.println( " 1. Of course. \n 2. Exit. ");
                                    try {
                                        h = scanner.nextInt();
                                    } catch(InputMismatchException ime) {
                                        System.out.println(" You have to enter a number. ");
                                        continue;
                                    }
                                    switch (h) {
                                        case 1:
                                            userGear.trySthOn(size);                                // wywolanie funkcji rzucajacej wlasny wyjatek
                                            break;
                                        case 2:
                                            System.exit(0);
                                            break;
                                        default:
                                            System.out.println(" There is no other option. ");
                                            break;
                                    }
                                case 2:
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println(" There is no other option. ");
                                    break;
                            }
                            break;
                        case 2:
                            System.exit(0);
                            break;
                        default:
                            System.out.println(" There is no other option. ");
                            break;
                    }
                    break;
                case 2:
                    System.out.println(" Available products for men:");
                    try {
                        recordReading.File file = new File();                            // wczytanie z pliku txt
                        file.readFile("C:\\Users\\dfabi\\Desktop\\ClothesShop\\src\\ClothesForMen.txt");
                    }catch(IOException e)
                    {
                        System.out.println(" We could'nt find a path ");
                    }
                    System.out.println(" \n Do you want to buy something or exit? ");
                    System.out.println(" 1. I want to buy. \n 2. Exit. ");
                    try {
                        f = scanner.nextInt();
                    } catch(InputMismatchException ime) {
                        System.out.println(" You have to enter a number. ");
                        continue;
                    }
                    switch (f) {
                        case 1:
                            System.out.println(" Please enter all information about your clothes. \n");
                            System.out.println(" Enter kind. Enter size. Enter color. Enter price. Enter year. ");
                            // wczytywanie danych z klawiatury
                            String kind = new String();
                            scanner.nextLine();
                            kind = scanner.nextLine();
                            int size = scanner.nextInt();
                            String color = new String();
                            scanner.nextLine();
                            color = scanner.nextLine();
                            double price = scanner.nextDouble();
                            short year = scanner.nextShort();

                            ManGear userGear = new ManGear(kind,size,color,price,year);

                            File fileSeria = new File();              // serializacja oraz deserializacja
                            fileSeria.seriaDeseria(userGear);

                            System.out.println(" Do you want to print receipt and pay for product or exit? ");
                            System.out.println(" 1.Print receipt and pay. \n 2.Exit. ");

                            try {
                                g = scanner.nextInt();
                            } catch(InputMismatchException ime) {
                                System.out.println(" You have to enter a number. ");
                                continue;
                            }
                            switch (g) {
                                case 1:
                                    System.out.println("\n Please remember you have to pay for delivery. The price depends on your distance in kilometers from Cracow.  ");
                                    System.out.println(" Please put a kilometers");
                                    double kilometer = scanner.nextDouble();
                                    userGear.buy(kilometer);
                                    System.out.println("Your delivery cost is: " + kilometer );
                                    PrintWriter saving = new PrintWriter("Receipt.txt");            // zapis danych do txt
                                    saving.println("RECEIPT");
                                    saving.println(" Kind of cloth: " + userGear.getKind());
                                    saving.println(" Size: " + userGear.getSize());
                                    saving.println(" Color: " + userGear.getColor());
                                    saving.println(" Total price: " +  userGear.buy(kilometer));
                                    saving.println(" Year of production: " + userGear.getYear());
                                    saving.close();
                                    System.out.println("Your receipt has been saved to 'Receipt.txt' ");
                                    userGear.setPurchased(true);
                                    System.out.println("Your status of purchase is: " + userGear.isPurchased());

                                    userGear.randomCode();                                                  // wygenerowanie kodu z tablicy 2wymiarowej

                                    Date currentDate = new Date();                                          // pobranie aktualnej daty i godziny
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                    String dateString = dateFormat.format(currentDate);
                                    System.out.println("\n Today is: " + dateString);
                                    System.out.println(" You have to wait one day for your delivery. Let's wait together! ");
                                    TimeUnit.SECONDS.sleep(15);

                                    System.out.println("\n Incredible! You have already get your product! Do you want to try it on? ");
                                    System.out.println( " 1. Of course. \n 2. Exit. ");
                                    try {
                                        h = scanner.nextInt();
                                    } catch(InputMismatchException ime) {
                                        System.out.println(" You have to enter a number. ");
                                        continue;
                                    }
                                    switch (h) {
                                        case 1:
                                            userGear.trySthOn(size);                               // wywolanie funkcji rzucajacej wlasny wyjatek
                                            break;
                                        case 2:
                                            System.exit(0);
                                            break;
                                        default:
                                            System.out.println(" There is no other option! ");
                                            break;
                                    }
                                case 2:
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println(" There is no other option. ");
                                    break;
                            }
                            break;
                        case 2:
                            System.exit(0);
                            break;
                        default:
                            System.out.println(" There is no other option. ");
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println(" There is no other option. ");
                    break;
            }
        }
    }
}
