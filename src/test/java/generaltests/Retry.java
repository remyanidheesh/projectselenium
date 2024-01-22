package generaltests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	private static final int MAX_Retry_Count=2;
	private int retryCount=0;
	
	public boolean retry(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			if(retryCount<MAX_Retry_Count)
			{
				retryCount++;
				return true;
				
			}
		}
		return false;
	}
	
}
