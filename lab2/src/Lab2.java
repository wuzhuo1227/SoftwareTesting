
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.io.*;
import java.util.NoSuchElementException;

@RunWith(Parameterized.class)
public class Lab2 {
    private String input1;
    private String input2;
    private String expected;

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public Lab2(String input1, String input2, String expected) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = expected;
    }

    //读取csv文件
    public static List<String> importCsv(File file){
        List<String> dataList=new ArrayList<String>();

        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://121.193.130.195:8080";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        List<Object[]> output = new ArrayList<>();
        List<String> dataList=importCsv(new File("/Users/wuzhuo/Desktop/inputgit.csv"));
        for(int i = 1 ; i < dataList.size(); i++) {
            String[] split = dataList.get(i).split(",");
            Object[] data = new Object[]{split[0], dataList.get(i).substring(4,10), split[2]};
            output.add(data);
            System.out.println(data);
        }
        return output;
    }

    @Test
    public void testLab2() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(this.input1);
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys(this.input2);
        //new Select(driver.findElement(By.id("gender"))).selectByVisibleText("男");
        driver.findElement(By.id("submit")).click();
        Object git1 = driver.findElement(By.xpath("//*[@id='table-main']/tr[3]/td[2]")).getText();
        //System.out.println(git1);
        //assertEquals(this.expected, git1);
        System.out.println(git1.toString());
        assertEquals(this.expected, git1.toString());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
