import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Vincent on 23-3-2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/",
        plugin = {"html:target/cukes"})
public class Run_Cucumber {
/*
    public static void Main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vincent\\Downloads\\chromedriver_win32\\chromedriver.exe");
    }*/

    //SeleniumToCucumber.feature
}
