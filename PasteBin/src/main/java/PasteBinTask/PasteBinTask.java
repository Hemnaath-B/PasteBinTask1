package PasteBinTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinTask {

    WebDriverWait wait;
    WebDriver driver;
    String endpoint = "https://zerobin.org/";

    @FindBy(id = "message")
    WebElement pasteArea;

    @FindBy(id = "pasteExpiration")
    WebElement pasteExpiry;

    @FindBy(xpath = "//option[@value='2hour']")
    WebElement expiryOption;

    @FindBy(id="sendbutton")
    WebElement createButton;

    PasteBinTask(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public PasteBinTask enterText() {
        pasteArea.sendKeys("Hello from WebDriver");
        return this;
    }

    public PasteBinTask setExpiry() {

       pasteExpiry.click();
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='2hour']")));
       expiryOption.click();
       return this;
    }

    public PasteBinTask clickCreate(){
        createButton.click();
        return this;

    }



}
