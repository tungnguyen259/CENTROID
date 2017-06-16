package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;

public class AbstractTest extends BrowserManage {

	public void verifyTrue(boolean result) {

		if (result)
			log.info("===PASSED===");
		else
			log.info("===FAILED===");
		Assert.assertTrue(result);
	}

	public void verifyFalse(boolean result) {
		if (!result) {
			log.info("===PASSED===");
		} else {
			log.info("===FAILED===");
		}
		Assert.assertFalse(result);
	}

	public Log log = LogFactory.getLog(getClass());
}