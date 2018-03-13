package MyException;
                                                                         // własna klasa swojego wyjątku
public class ClothAlreadyTryingOn extends Exception {                    // rozszerza Exception
    public ClothAlreadyTryingOn()
    {
       // System.out.println(" MyException related with trying something on ");     // zgłoszenie wyjątku
    }
}
