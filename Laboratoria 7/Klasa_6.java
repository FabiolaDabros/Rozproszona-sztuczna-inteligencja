
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
public class Klasa_6 extends Agent {
	
	protected void setup(){
		System.out.println("Startuje");
		addBehaviour(new NumberBehaviour());
	}
}

class NumberBehaviour extends Behaviour{
	boolean finished = false;
	public void action()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj liczbe: ");
		int number = scanner.nextInt();
		if(number < 0) {
			System.out.println("Liczba ujemna.  Zachowanie agenta zostaje usuniête. ");
			finished = true;
		}
		else if(number == 0) {
			System.out.println("Zero.  Zachowanie agenta nie zostaje usuniête. ");
		}
		else {
			System.out.println("Liczba dodatnia.  Zachowanie agenta nie zastaje usuniete. ");
		}
	}	
	public boolean done()
	{
		return finished;
	}
}
