package Helper;

import Profile.Profiles;

public class ClevertapInstance {
	static String id;
	static String password;
	Profiles ProfileInstance;

	public ClevertapInstance(String id, String password)
	{
		ClevertapInstance.id = id;
		ClevertapInstance.password = password;
	}
	
	public static String getId() {
		return id;
	}
	public static String getPassword() {
		return password;
	}
	public Profiles getProfileInstance() {
		ProfileInstance = new Profiles();
		return ProfileInstance;
	}
}
