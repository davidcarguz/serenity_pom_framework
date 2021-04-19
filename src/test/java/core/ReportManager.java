package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ReportManager {

    public static ExtentReports extent;
    public static ExtentTest test;
    public static String scenarioName;

    public static void setUpReport(String scenario_name){
        reportFactory();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/Reporte.html");
        extent.attachReporter(spark);
        scenarioName = scenario_name;
    }

    public static void setupTest(String testName){
        test = extent.createTest(testName);
    }

    private static void reportFactory(){
        if(extent == null){
            extent = new ExtentReports();
        }
    }

    public static String takeStepScreenshot(WebDriver driver, String filename, String testName) {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcImage = screenshot.getScreenshotAs(OutputType.FILE);
        String filepath = "reports\\"+testName+"\\"+filename+".png";
        File destFile = new File(filepath);
        try {
            FileUtils.copyFile(srcImage, destFile);
        }catch (Exception e){
            e.printStackTrace();
        }
        String imagePath = testName+"\\"+filename+".png";
        return imagePath;
    }
}
