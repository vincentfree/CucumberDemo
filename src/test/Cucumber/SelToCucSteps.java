import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vincent Free on 21-3-2015.
 */
public class SelToCucSteps {
    private final WebDriver driver = new ChromeDriver();

    @Given("^I am on the Google search page$")
    public void I_visit_google(){
        driver.get("http://www.google.com");

    }

    @When("^I search for \"([^\"]*)\"$")
    public void search_for(String query){
        WebElement element = driver.findElement(By.name("q"));
        //Enter something to search for
        element.sendKeys(query);
        //Submit the form. Webdriver finds the form from element
        element.submit();
    }

    @Then("^the page title should start with \"([^\"]*)\"$")
    public void checkTitle(final String title) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title);
            }
        });
        //assertThat(driver.getTitle(), startsWith(title));
    }
        @After()
        public void closeBrowser(){
            driver.quit();
        }
    }
