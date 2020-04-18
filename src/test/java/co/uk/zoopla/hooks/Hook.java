package co.uk.zoopla.hooks;

import co.uk.zoopla.common.Browsers;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Hook extends Browsers {

    public Scenario scenario;

    @Before
    public void setUp(Scenario scenario)
    {
        this.scenario = scenario;
        launchBrowser("Chrome");
    }

    @After
    public void tearDown()
    {
        String dateNow = new SimpleDateFormat("ddMMyyyy")
                .format(new GregorianCalendar().getTime());
        String timeNow = new SimpleDateFormat("HHmmss")
                .format(new GregorianCalendar().getTime());
        String filename = String.format("./Screenshots/%s/screenshot_%s.png", dateNow, timeNow);

        if(scenario.isFailed())
        {
            try{
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, filename);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }


        closeBrowser();
    }
}
