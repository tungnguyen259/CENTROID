package actions.configure;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {
	
	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		
		//String textMsg = "About to begin executing following method : ";
		System.out.println("Execution beforeInvocation");
		//Reporter.log(textMsg, true);
 
	}
	
	// This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test
	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
 
		//String textMsg = "Completed executing following method : ";
		System.out.println("Execution afterInvocation");
		//Reporter.log(textMsg, true);
 
	}
}
