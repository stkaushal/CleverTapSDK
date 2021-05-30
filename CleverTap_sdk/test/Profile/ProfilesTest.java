/**
 * 
 */
package Profile;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author dharmender
 *
 */
class ProfilesTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Test starting..");
	}


	/**
	 * Test method for {@link Profile.Profiles#Profiles()}.
	 */
	@Test
	void testProfiles() {
		
		System.out.println("Test Profile passed.");
	}

	/**
	 * Test method for {@link Profile.Profiles#uploadUserProfile(Payload.ProfilePayload)}.
	 */
	@Test
	void testUploadUserProfile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#getUserProfileCursor(Payload.ProfilePayload, int)}.
	 */
	@Test
	void testGetUserProfileCursor() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#getUserProfileData(Helper.Cursor)}.
	 */
	@Test
	void testGetUserProfileData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#getUserProfileById(java.lang.String)}.
	 */
	@Test
	void testGetUserProfileById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#uploadDeviceTokens(Payload.ProfilePayload[])}.
	 */
	@Test
	void testUploadDeviceTokens() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#getProfileCount(Payload.ProfilePayload)}.
	 */
	@Test
	void testGetProfileCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#deleteUserProfile(Payload.ProfilePayload)}.
	 */
	@Test
	void testDeleteUserProfile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#demergeUserProfile(Payload.ProfilePayload)}.
	 */
	@Test
	void testDemergeUserProfile() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#subscribe(Payload.ProfilePayload[])}.
	 */
	@Test
	void testSubscribe() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Profile.Profiles#dissociate(Payload.ProfilePayload)}.
	 */
	@Test
	void testDissociate() {
		fail("Not yet implemented");
	}

}
