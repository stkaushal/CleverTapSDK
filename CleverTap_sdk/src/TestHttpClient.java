import java.io.IOException;

import Helper.ClevertapInstance;
import Payload.ProfilePayload;
import Response.Response;

public class TestHttpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
	   String Cid = "4R8-K98-8Z6Z";
	   String CPswd = "AOE-RUW-CHUL";
	   ProfilePayload payload = new ProfilePayload();
	   payload.setFBID("hshjksks");
	   ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd);
	   
	   Response res = instance.getProfileInstance().uploadUserProfile(payload);
	   System.out.println(res.getError());
	   
	   
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
        
//	   Profiles profile = new Profiles();
//	   
//	   ObjectMapper objectMapper = new ObjectMapper();
//	   objectMapper.setSerializationInclusion(Include.NON_NULL);
//	   JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
//	   System.out.println(json);
//	   
//	   Helper.Cursor x =  profile.getUserProfileCursor(payload, 50);
//	   System.out.println(x.getCursor());
//	   
//	   GetUserProfileResponse gg = profile.getUserProfileData(x);
//	   JSONObject jj = new JSONObject(objectMapper.writeValueAsString(gg));
//	   System.out.println(jj);
	   
    }
    
    
}