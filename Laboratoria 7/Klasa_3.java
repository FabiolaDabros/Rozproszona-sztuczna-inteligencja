
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
public class Klasa_3 extends Agent{
	protected void setup()
	{
		System.out.println("Startuje");
		
	addBehaviour(new CyclicBehaviour(this) {
	      public void action() {
	        System.out.println("wykonuje");
	      } 
	    });
}}


