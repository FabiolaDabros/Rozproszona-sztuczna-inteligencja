import jade.core.Agent;

public class HelloWorldAgent extends Agent{

	 protected void setup()
	    {
	        System.out.println("Hello World.My name is "+ getLocalName());
		    this.main(null);
	    }
		
		public static void main(String[] args) {
	        System.out.println("Print from Main");
	    }
}

