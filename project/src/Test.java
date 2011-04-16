import dk.itu.infobus.ws.*;

import java.io.IOException;
import java.util.*;

import dk.itu.infobus.ws.ListenerToken;

public class Test {
	
	/* test main */
	public static void main(String[] args) throws Exception {
	
		/* Creating the eventbus and the SkipTillNextMatchListener with 
		 * a stream */
		EventBus eb = new EventBus("tiger.itu.dk",8004);
		
		eb.start();
		eb.addGenerator(new SampleGenerator());
		
		/* new pattern */
		PatternBuilder pb = new PatternBuilder()
			.addMatchAll("foo");
	
	
		/* Sequence test */
		SequenceTermBuilder foo_a = 
			new SequenceTermBuilder()
				.add("foo", PatternOperator.EQ, new Long(5));
		
		SequenceTermBuilder bar_a = 
			new SequenceTermBuilder()
				.add("bar", PatternOperator.EQ, 10);
						
		SequenceTermBuilder foo_b = 
			new SequenceTermBuilder()
				.add("foo", PatternOperator.EQ, 6);

		SequenceTermBuilder bar_b = 
			new SequenceTermBuilder()
				.add("bar", PatternOperator.EQ, 15);
		
		SequenceBuilder sequence = 
			new SequenceBuilder().and(foo_a);
		
		
		/* creates the 	SkipTillNextMatchListener */
		SkipTillNextMatchListener listener = 
			new SkipTillNextMatchListener(eb, pb.getPattern(), sequence) {
			
			/* user will mainly override this method */
			public void onMessage(Map<String, Object> msg) {
				//System.out.println("called inside the listener");
			    Util.traceEvent(msg);	
			}

		};
			
		
		
	
	
	}
	
	
}