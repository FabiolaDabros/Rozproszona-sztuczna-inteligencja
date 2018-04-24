import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Klasa_2 extends Agent{

	protected void setup()
	{
		System.out.println("Startuje");
		
		addBehaviour(new OneShotBehaviour(this) {
		      public void action() {
		    	  System.out.println( "wykonuje");
		    	System.out.println("Zaraz sie usune");
		  		doDelete();
		      } 
		      
		    });
	}
		
}

