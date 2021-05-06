import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jna.platform.unix.X11.Cursor;

import Payload.ProfilePayload;
import Profile.Profiles;
import Response.GetUserProfileResponse;
import Response.Response;

public class TestHttpClient {
    public static void main(String[] args) throws IOException {
        
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
	   System.out.println(x.getCur());
	   
	   GetUserProfileResponse gg = profile.getUserProfileData(x);
	   JSONObject jj = new JSONObject(objectMapper.writeValueAsString(gg));
	   System.out.println(jj);
    }
    
    
}