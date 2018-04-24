import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.core.behaviours.TickerBehaviour;
public class Klasa_8 extends Agent {
	
	protected void setup()
	{
		System.out.println("Startuje");
		
		// tick co 2 sekundy
		addBehaviour(new TickerBehaviour(this, 2000) {
		      protected void onTick() {
		        System.out.println("maly tick");
		      } 
		    });
		
		//tick co 5 sekund
		DuzyTick duzy = new DuzyTick(this,5000);
		addBehaviour(duzy);
		
		//usuniecie zachowania DuzyTick
		addBehaviour(new TickerBehaviour(this,50000)
				{
					protected void onTick()
					{
						removeBehaviour(duzy);
					}
				});
		 
		
		//usuniecie calego agenta
		addBehaviour(new WakerBehaviour(this, 100000) {
		      protected void handleElapsedTimeout() {
		        System.out.println("Agent "+myAgent.getLocalName()+": It's wakeup-time. Bye...");
		        myAgent.doDelete();
		      } 
		    });
	}
}

class DuzyTick extends TickerBehaviour
{
	public DuzyTick(Agent a, long period) {
		super(a, period);
	} 
	
	protected void onTick()
	{
		System.out.println("Duzy tick");
	}
}
