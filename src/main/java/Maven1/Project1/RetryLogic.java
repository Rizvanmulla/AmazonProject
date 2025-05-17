package Maven1.Project1;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	int initialcount = 0;
	int retrycount = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (initialcount < retrycount) {
			initialcount++;
			return true;
		}
		return false;
	}
}
