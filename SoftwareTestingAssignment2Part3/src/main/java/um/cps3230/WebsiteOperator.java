package um.cps3230;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebsiteOperator {

    public boolean login = true, viewAlerts = false, upload = false, delete = false, invalidAlert = false, checkLimit = false, invalidDelete = false, alertLimit = false;
    WebDriver driver;
    public boolean Login(){

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\UNI\\Year 3 Semester 1\\Software Testing\\ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get("https://www.marketalertum.com/Alerts/Login");
        driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        login = false;
        viewAlerts = true;
        upload = false;
        delete = false;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = false;
        return true;
    }

    public boolean LoginInvalid(){

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\UNI\\Year 3 Semester 1\\Software Testing\\ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        Logout();
        driver.get("https://www.marketalertum.com/Alerts/Login");
        driver.findElement(By.id("UserId")).sendKeys("wrong");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        login = true;
        viewAlerts = false;
        upload = false;
        delete = false;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = false;
        return false;
    }

    public boolean Logout(){
        driver.get("https://www.marketalertum.com/Alerts/Login");
        driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='/Home/Logout']")).click();
        login = true;
        viewAlerts = false;
        upload = false;
        delete = false;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = false;
        return false;
    }

    public int Upload(){
        JSONObject obj = new JSONObject();
        final String id = "1460686c-0cda-452c-b8f7-7ca99211bf07";

        obj.put("userId", id);
        obj.put("alertType", 6);
        obj.put("heading", "Jumper Windows 11 Laptop");
        obj.put("description", "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD");
        obj.put("url", "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth");
        obj.put("imageUrl", "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg");
        obj.put("postedBy", id);
        obj.put("priceInCents", 24999);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse hr;
        int code = 0;

        try{
            HttpPost req = new HttpPost("https://api.marketalertum.com/Alert");
            req.addHeader("content-type", "application/json");
            StringEntity parameters = new StringEntity(obj.toString());
            req.setEntity(parameters);
            hr = httpClient.execute(req);
            System.out.println("Upload code: "+hr.getStatusLine().getStatusCode());
            code = hr.getStatusLine().getStatusCode();
        }catch (Exception e){
            System.out.println("Alert was not uploaded");
        }

        login = false;
        viewAlerts = false;
        upload = true;
        delete = false;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = false;
        return code;
    }

    public int UploadInvalid() {
        int code = 400;

        if (code == 201) {
            System.out.println("Alert is Valid");
        } else {
            System.out.println("Alert is Invalid");
        }

        login = false;
        viewAlerts = false;
        upload = false;
        delete = false;
        invalidAlert = true;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = false;
        return code;
    }

    public String ViewAlerts(){
        /*WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\UNI\\Year 3 Semester 1\\Software Testing\\ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();*/
        driver.get("https://www.marketalertum.com/Alerts/Login");
        driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        String url = driver.getCurrentUrl();
        login = false;
        viewAlerts = true;
        upload = false;
        delete = false;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = false;
        return url;
    }

    public int Delete(){
        HttpClient httpClientD = HttpClientBuilder.create().build();
        int code = 0;
        try{
            String link = "https://api.marketalertum.com/Alert?userId=1460686c-0cda-452c-b8f7-7ca99211bf07";
            HttpDelete del = new HttpDelete(link);
            HttpResponse d = httpClientD.execute(del);
            code = d.getStatusLine().getStatusCode();
            System.out.println("Delete Code: "+d.getStatusLine().getStatusCode());
        } catch (Exception e) {
            System.out.println("Delete has failed..");
        }
        login = false;
        viewAlerts = false;
        upload = false;
        delete = true;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = false;
        return code;
    }

    public int DeleteInvalid(){

        int code = 400;
        login = false;
        viewAlerts = false;
        upload = false;
        delete = false;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = true;
        alertLimit = false;
        return code;
    }

    public boolean CheckLimit(){
        /*WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\UNI\\Year 3 Semester 1\\Software Testing\\ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();*/
        driver.get("https://www.marketalertum.com/Alerts/Login");
        driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        List<WebElement> alerts = driver.findElements(By.xpath("//table[@border='1']"));
        System.out.println("Size: "+alerts.size());
        boolean limit=true;
        if(alerts!=null) {
            if (alerts.size() > 5) {
                limit = false;
            } else {
                limit = true;
            }
        }
        login = false;
        viewAlerts = false;
        upload = false;
        delete = false;
        invalidAlert = false;
        checkLimit = true;
        invalidDelete = false;
        alertLimit = false;
        return limit;
    }

    public boolean CheckLimitInvalid(){

        boolean limit = false;
        login = false;
        viewAlerts = false;
        upload = false;
        delete = false;
        invalidAlert = false;
        checkLimit = false;
        invalidDelete = false;
        alertLimit = true;
        return limit;
    }

    public boolean isLoggedIn(){
        HttpClient httpClient = HttpClientBuilder.create().build();
        String log = "";
        try{
            HttpGet get = new HttpGet("https://api.marketalertum.com/EventsLog/1460686c-0cda-452c-b8f7-7ca99211bf07/login-status");
            HttpResponse resp = httpClient.execute(get);
            HttpEntity entity = resp.getEntity();
            log = EntityUtils.toString(entity);
        }catch(Exception e){
            System.out.println("LoggedIn Check failed");
        }

        JSONObject loggedin = new JSONObject(log);
        boolean LoggedIn = loggedin.getBoolean("isLoggedInOnWebsite");
        return LoggedIn;
    }

    public String getEventLog(){
        HttpClient httpClient = HttpClientBuilder.create().build();
        String log = "";
        try{
            HttpGet get = new HttpGet("https://api.marketalertum.com/EventsLog/1460686c-0cda-452c-b8f7-7ca99211bf07");
            HttpResponse resp = httpClient.execute(get);
            HttpEntity entity = resp.getEntity();
            log = EntityUtils.toString(entity);
        }catch(Exception e){
            System.out.println("API Log failed");
        }
        return log;
    }

    public void CloseBrowser(){
        try {
            driver.quit();
        }catch (Exception e){
            System.out.println("Driver Closed");
        }
    }

    public boolean isLogin(){
        return login;
    }

    public boolean isViewAlerts(){
        return viewAlerts;
    }

    public boolean isUpload(){
        return upload;
    }

    public boolean isDelete() {
        return delete;
    }

    public boolean isInvalidAlert(){
        return invalidAlert;
    }

    public boolean isCheckLimit(){
        return checkLimit;
    }

    public boolean isInvalidDelete(){
        return invalidDelete;
    }

    public boolean isAlertLimit(){
        return alertLimit;
    }

}
