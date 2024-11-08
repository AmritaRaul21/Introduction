import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='DEL'] ")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("its not enabled");
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        System.out.println( driver.findElement(By.id("divpaxinfo")).getText());
        for (int i = 1;i<5;i++)
        {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println( driver.findElement(By.id("divpaxinfo")).getText());

        WebElement staticDropdown =  driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
