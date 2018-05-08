import jade.core.behaviours.SequentialBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.Agent;
public class Klasa_2_4 extends Agent{
	protected void setup() {
		System.out.println("startuje");

		SequentialBehaviour threeStepBehaviour = new SequentialBehaviour();
		threeStepBehaviour.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "krok pierwszy" );
			}
		});

		threeStepBehaviour.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "krok drugi" );
			}
		});
		
		threeStepBehaviour.addSubBehaviour( new OneShotBehaviour()
		{
			public void action() {
				System.out.println( "krok trzeci" );
				removeBehaviour(threeStepBehaviour);
				System.out.println( "usuwam" );
			}
		});
		addBehaviour(threeStepBehaviour);
	}
}