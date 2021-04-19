package stepDefinitions;

import core.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.pages.PageObject;

import java.util.concurrent.TimeUnit;

public class Hooks extends PageObject {

    @Before
    public void initialization(Scenario scenario){
        ReportManager.setUpReport(scenario.getName());
        ReportManager.setupTest(scenario.getName());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
    }

    @After
    public void finalizarTest(Scenario scenario){
        if(scenario.isFailed()){
            ReportManager.test.fail("hubo un problema el escenario no paso.")
                    .addScreenCaptureFromPath(ReportManager.takeStepScreenshot(getDriver(),"failed",scenario.getName()));
        }else{
            ReportManager.test.pass("el test paso exitosamente.")
                    .addScreenCaptureFromPath(ReportManager.takeStepScreenshot(getDriver(),"successful",scenario.getName()));
        }
        ReportManager.extent.flush();
    }
}
