import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.Agent;

public class Klasa_2_3 extends Agent{
	protected void setup() {
		
		System.out.println("startuje");
	
	
	
		ParallelBehaviour par = new ParallelBehaviour();
		par.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "krok pierwszy" );
			}
		});

		par.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "krok drugi" );
			}
		});
		
		par.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "krok trzeci" );
				removeBehaviour(par);
				System.out.println( "usuwam" );
			}
		});
		addBehaviour( par );
	}
}