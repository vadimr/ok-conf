package ok;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.module.client.MuleClient;

public class OkFunctionalTestCase extends FunctionalTestCase {

	protected String getConfigResources() {
		return "./src/main/app/ok.xml";
	}

	@Test
	public void testCanReturnOk() throws Exception {
		MuleClient client = new MuleClient(muleContext);
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("http.method", "GET");
		
		MuleMessage result = client.send("http://localhost:3001/", "", props);
		assertEquals("ok", result.getPayloadAsString());
	}
}
