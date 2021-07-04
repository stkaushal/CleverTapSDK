package ScaleTest;

import java.io.IOException;
import java.time.Instant;

import Helper.ClevertapInstance;
import Helper.Enums.Region;

public class ThreadScale {
	public static void main(String[] args) throws IOException, InterruptedException {
		String Cid = "TEST-69W-8RW-5R6Z";
		String CPswd = "af0f2e63751341fca0c934a386f5eabe";
		ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.DEVELOPMENT);
		
		for(int i = 0; i < 1; i++)
		{
			ClientMultiThreaded thread = new ClientMultiThreaded(instance, i+1);
			thread.start();
			thread.join();
		}
		
	}

	
}
