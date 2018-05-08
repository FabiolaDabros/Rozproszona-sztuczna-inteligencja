import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.Agent;

public class Klasa_2_5 extends Agent{
	protected void setup() {
		
		ParallelBehaviour par = new ParallelBehaviour();
		par.addSubBehaviour( new CyclicBehaviour()
		{
			public void action() {
				System.out.println( "cyclic 1" );
			}
		});
		
		par.addSubBehaviour( new CyclicBehaviour()
		{
			public void action() {
				System.out.println( "cyclic 2" );
			}
		});
		
		addBehaviour(par);
	}
}