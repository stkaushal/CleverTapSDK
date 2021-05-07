import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.SetCredentials;
import Payload.ProfilePayload;
import Profile.Profiles;
import Response.GetUserProfileResponse;

public class TestHttpClient {
    public static void main(String[] args) throws IOException {
	   String Cid = "4R8-K98-8Z6Z";
	   String CPswd = "AOE-RUW-CHUL";
	   SetCredentials cred  = new SetCredentials();
	   cred.setId(Cid);
	   cred.setPassword(CPswd);
        
	   Profiles profile = new Profiles();
	   ProfilePayload payload = new ProfilePayload();
	   payload.setEvent_name("App Launched");
	   payload.setFrom(20171201);
	   payload.setTo(20171201);
	   ObjectMapper objectMapper = new ObjectMapper();
	   objectMapper.setSerializationInclusion(Include.NON_NULL);
	   JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
	   System.out.println(json);
	   
	   Helper.Cursor x =  profile.getUserProfileCursor(payload, 50);
	   System.out.println(x.getCursor());
	   
	   GetUserProfileResponse gg = profile.getUserProfileData(x);
	   JSONObject jj = new JSONObject(objectMapper.writeValueAsString(gg));
	   System.out.println(jj);
	   
    }
    
    
}