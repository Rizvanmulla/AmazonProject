package Maven1.Project1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersLogic implements ITestListener {
    public static WebDriver driver;

    Date TodaysDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
    String timestamp = sdf.format(TodaysDate);

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("TestCase is Passed");
        String testCaseName = result.getName();
        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("D:\\JAVA SELENIUM\\Screenshots\\Passed\\" + testCaseName + "_" + timestamp + ".png");
        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("TestCase is Failed");
        String testCaseName = result.getName();
        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("D:\\JAVA SELENIUM\\Screenshots\\Failed\\" + testCaseName + "_" + timestamp + ".png");
        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
