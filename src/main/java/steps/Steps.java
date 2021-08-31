package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.time.Duration;

public class Steps {

    protected static WebDriver driver;


    @Given("Open IE and search for Selenium")
    public void openIEAndSearchForSelenium() {

        setupDriver();

        driver.get("http:\\\\www.google.pt");

        WebElement element = driver.findElement(By.name("q"));
        element.click();
        element.clear();
        element.sendKeys( "Selenium");

        element = driver.findElement(By.name("btnK"));
        element.click();
    }

    private void setupDriver(){
        System.setProperty("webdriver.ie.driver", "C:\\Selenium_google_test\\driver\\IEDriverServer.exe");

        final InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();

        internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.disableNativeEvents();
        internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        internetExplorerOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        internetExplorerOptions.waitForUploadDialogUpTo(Duration.ofSeconds(5));

        driver = new InternetExplorerDriver(internetExplorerOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }

}
