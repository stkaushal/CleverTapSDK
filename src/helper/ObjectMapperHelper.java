package helper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The singleton Class ObjectMapperHelper.
 */
public class ObjectMapperHelper {
	
	/** The object mapper. */
	private ObjectMapper objectMapper;

	/**
	 * Instantiates a new object mapper helper.
	 */
	private ObjectMapperHelper() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	/** The helper mapper. */
	private static ObjectMapperHelper helperMapper = null;
	
	/**
	 * Object mapper helper instance.
	 *
	 * @return the object mapper helper
	 */
	public static ObjectMapperHelper ObjectMapperHelperInstance() {
		if(helperMapper==null)
		{
			helperMapper = new ObjectMapperHelper();
		}
		return helperMapper;
	}

	/**
	 * Gets the object mapper.
	 *
	 * @return the object mapper
	 */
	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
	
}
