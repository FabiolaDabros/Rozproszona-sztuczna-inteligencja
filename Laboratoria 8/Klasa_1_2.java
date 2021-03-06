import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class Klasa_1_2 extends Agent{

	//nazwy stan�w
	private static final String STATE_A = "A";
	private static final String STATE_B = "B";
	private static final String STATE_C = "C";
	private static final String STATE_D = "D";
	private static final String STATE_E = "E";
	
	protected void setup() {
		FSMBehaviour fsm = new FSMBehaviour(this) {
			public int onEnd() {
				System.out.println("FSM behaviour completed.");
				myAgent.doDelete();
				return super.onEnd();
			}
		};
		//rejestracja pojedynczego zachowania jako stan pocz�tkowy
		fsm.registerFirstState(new NamePrinter(),  STATE_A);
		//rejestracja jako stany po�rednie
		fsm.registerState(new RandomGenerator(1),  STATE_B);
		fsm.registerState(new NamePrinter(),  STATE_C);
		fsm.registerState(new RandomGenerator(1),  STATE_D);
		//rejestracja jako stan ko�cowy
		fsm.registerLastState(new NamePrinter(),  STATE_E);
		
		//przej�cie ze stanu do stanu niezale�nie od 
		//zdarzenia zako�czenia stanu �r�d�owego
		fsm.registerDefaultTransition( STATE_A,  STATE_B);
		fsm.registerTransition( STATE_B,  STATE_C, 1);
		fsm.registerTransition( STATE_B,  STATE_D, 0);
		fsm.registerDefaultTransition( STATE_C,  STATE_D);
		fsm.registerTransition( STATE_D, STATE_E, 0);
		fsm.registerTransition( STATE_D,  STATE_A, 1);
		
		addBehaviour(fsm);
		
	}
	private class NamePrinter extends OneShotBehaviour{
		public void action() {
			System.out.println("State name: " + getBehaviourName());
		}
	}
	private class RandomGenerator extends NamePrinter{
		private int maxExitValue;
		private int exitValue;
		
		private RandomGenerator(int max) {
			super();
			maxExitValue = max;
		}
		public void action() {
			super.action();
			exitValue = (int)(Math.round(Math.random())*maxExitValue);
			System.out.println("\tExit value is: "+exitValue);
		}
		public int onEnd() {
			return exitValue;
		}
	}
}