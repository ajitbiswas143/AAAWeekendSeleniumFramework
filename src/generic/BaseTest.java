package generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest implements IAutoConstant{
	public WebDriver driver;
	static{
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
	}
	@BeforeMethod
	public void openApplication(){
		driver = new FirefoxDriver();
		String url = Lib.getPropertyValue("URL");
		driver.get(url);
		
	}
	@AfterMethod
	public void closeApplication(ITestResult res){
		if (ITestResult.FAILURE==res.getStatus()) {
			Lib.captureScreenshot(driver, res.getName());
		}
		driver.close();
	}
}