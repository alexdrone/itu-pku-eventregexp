import java.util.*;
import dk.itu.infobus.ws.*;

public class SampleGenerator extends GeneratorAdapter {
		
	public SampleGenerator() {
		super("sample-alx.generator", "foo", "bar");
	}
	
	protected void onStarted() throws Exception {
    	
		/* when it start, it creates a thread */
		Thread thread = new Thread() {
		
			@Override
			public void run() {
				
				/* test A */
				//int[] foos = {1,  2,  3,  4,  5,  6,  5,  8,  8, 10};
				//int[] bars = {5, 10, 10, 15, 25, 30, 35, 40, 40, 40};
				
				
				/* test B */
				//int[] foos = {5, 0,  0,  5,   0,  0, 0};
				//int[] bars = {0, 60, 60, 60, 60, 40, 40};
				
				/* test C */
				int[] foos = {5,  0,  0,  0,  0,  0, 5, 0, 10, 0};
				int[] bars = {0, 60, 60, 60, 60,  1, 0, 1, 40, 40};
				
				
				/* test NOT */
				//int[] foos = {1, 3, 3};
				//int[] bars = {0, 0, 0};
				
				
				/* the EventBuilder class is a utility class that wraps a 
				 * Map<String,Object>, its use is to create quickly maps 
				 * using chaining */
				EventBuilder eb = new EventBuilder();
				
				/* infinite loop to generate the events */
				int i = 0;
				for (;;) {
					
					/* discard the current Event (Map) */
					eb.reset();
					
					try {
						Thread.sleep(500);
						publish(eb
							.put("foo", foos[i])
							.put("bar", bars[i])
							.getEvent());
					
					} catch (Exception e) { /* handle */ }
					
					i = (i+1) % foos.length;
				}
			}
		};
		
		thread.start();
	}
}