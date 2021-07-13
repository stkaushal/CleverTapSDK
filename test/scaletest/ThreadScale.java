package scaletest;

import java.io.IOException;
import event.Event;
import helper.ClevertapInstance;
import helper.enums.Region;
import profile.Profiles;

public class ThreadScale {
	public static void main(String[] args) throws IOException, InterruptedException {
		String clevertapID = "TEST-69W-8RW-5R6Z";
		String clevertapPassword = "af0f2e63751341fca0c934a386f5eabe";
		ClevertapInstance instance  = new ClevertapInstance(clevertapID, clevertapPassword, Region.DEVELOPMENT);
		Profiles profileInstance = instance.getProfileInstance();
		Event eventInstance = instance.getEventInstance();
		
		ClientMultiThreaded thread1 = new ClientMultiThreaded(profileInstance, 1);
		ClientMultiThreaded thread2 = new ClientMultiThreaded(profileInstance, 2);
		ClientMultiThreaded thread3 = new ClientMultiThreaded(profileInstance, 3);
		ClientMultiThreaded thread4 = new ClientMultiThreaded(profileInstance, 4);
		ClientMultiThreaded thread5 = new ClientMultiThreaded(profileInstance, 5);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();	
	}
}
