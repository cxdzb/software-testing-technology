package lab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;
import lab2.Reader;

import java.io.*;
import java.util.List;

public class SeleniumTest {
    public String userNumber;
    private String passWord;
    private WebDriver driver;
    private Reader reader;
    private List<List> data;

    @Before
    public void setUp() throws IndexOutOfBoundsException, BiffException, IOException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\cxdzb\\Desktop\\eclipse-workspace\\lab2\\resource\\chromedriver.exe");
        driver = new ChromeDriver();
	    reader = new Reader("C:\\Users\\cxdzb\\\\Desktop\\eclipse-workspace\\lab2\\resource\\Selenium Lab2020.xls");
	    data = reader.readExcel();
    }


    @Test
    public void testSelenium() throws InterruptedException{
        driver.get("http://103.120.226.190/selenium-demo/git-repo");
        for(List row: data){
            WebElement userNumber = driver.findElement(By.name("user_number"));
            WebElement passWord = driver.findElement(By.name("password"));
            WebElement query = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
            
            userNumber.sendKeys(row.get(0).toString());
            passWord.sendKeys(row.get(1).toString());
            query.submit();

            WebElement result = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
            System.out.println(result.getText());
            driver.navigate().refresh();
        }
    }

    @After
    public void release(){
        driver.close();
    }
}
