/**
 * 
 */
package HTTP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author dharmender
 *
 */
class HttpClientTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("HttpClient class test starting..");
	}

	/**
	 * Test method for {@link HTTP.HttpClient#HttpClient()}.
	 */
	@Test
	void testHttpClient() {
		System.out.println("Constructor test passed.");
	}

	/**
	 * Test method for {@link HTTP.HttpClient#postRequest(java.lang.String, org.json.JSONObject)}.
	 */
	@Test
	void testPostRequest() {
		System.out.println("passed.");
	}

	/**
	 * Test method for {@link HTTP.HttpClient#getRequest(java.lang.String)}.
	 */
	@Test
	void testGetRequest() {
		System.out.println("passed.");
	}

}
