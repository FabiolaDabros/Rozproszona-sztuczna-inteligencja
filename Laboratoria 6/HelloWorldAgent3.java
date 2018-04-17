
import jade.core.Agent;

public class HelloWorldAgent extends Agent {

  int added;
	
	protected void setup() {
		
	    System.out.println("Agent "+getLocalName()+" started.");
		Object[] args = getArguments();
		added = Integer.parseInt(args[0].toString());
		System.out.println("Argument = "+added);
		for(int i=0;i<added;i++)
			System.out.println("Hello World! My name is " +getLocalName() +"argument: "+i);
	  } 
}

