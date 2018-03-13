package recordReading;

import Clothes.Gear;             // użycie klasy z innego pakietu z importowaniem
import java.io.*;

public class File implements Serializable {

    private String filePath;
    public void readFile(String filePath) throws IOException{                      // odczyt z pliku tekstowego
        FileReader fileReader =new FileReader(filePath);                           // umożliwia odczyt kolejnych znakow z pliku tekstowego
        BufferedReader bufferedReader = new BufferedReader(fileReader);            // umożliwia odczyt liniami
        try{
            String clothes = bufferedReader.readLine();
            do {                                                                   // odczytanie wszytskich linijek
                System.out.println(clothes);
                clothes=bufferedReader.readLine();
            } while(clothes != null);
        }
        finally {
            bufferedReader.close();                                                // zamkniecie strumienia danych
        }
    }

    public void seriaDeseria(Gear gear){
                                                                                   // serializacja
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("Object.ser"));
                                                                                   // tworzymy strumień do zapisu i w konstruktorze przekazujemy adres do pliku ;
                                                                                   // obiekt FileOutputStream łączy się z plikiem, a w razie potrzeby tworzy go
            objectOutputStream.writeObject(gear);                                 // zapisanie obiektu
            objectOutputStream.close();                                           // zamkniecie strumienia
            System.out.printf("Serialized data is saved in 'Object.ser'");
        } catch (Exception ex) {
            ex.printStackTrace();
        }                                                                         // deserializacja
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("Object.ser"));
            Gear obj = (Gear) objectInputStream.readObject();                    // odczyt obiektu ze strumienia
            objectInputStream.close();                                           // wyswietlenia zawartosci pliku
            System.out.println("\nDeserialization : " + " Kind: " + obj.getKind() + " Size: " + obj.getSize() + " Color: " + obj.getColor() + " Year: " + obj.getYear() +"\n"); // wyświetlamy zawartość pliku
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
