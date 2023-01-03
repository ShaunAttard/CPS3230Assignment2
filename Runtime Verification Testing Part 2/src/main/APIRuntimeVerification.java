package main;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class APIRuntimeVerification {
	
	public void Login(){
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.marketalertum.com/Alerts/Login");
		driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.quit();
	}
	
	public void LoginInvalid(){
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.marketalertum.com/Alerts/Login");
		driver.findElement(By.id("UserId")).sendKeys("Incorrect");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.quit();
	}
	
	public void Logout(){
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\UNI\\Year 3 Semester 1\\Software Testing\\ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/Alerts/Login");
        driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='/Home/Logout']")).click();
        driver.quit();
    }
	
	public void ViewAlerts(){
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.marketalertum.com/Alerts/Login");
		driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
        driver.quit();
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
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse hr;
        int code = 0;
        
        try{
        	HttpPost req = new HttpPost("https://api.marketalertum.com/Alert");
        	req.addHeader("content-type", "application/json");
        	StringEntity parameters = new StringEntity(obj.toString());
        	req.setEntity(parameters);
        	hr = httpClient.execute(req);
        	System.out.println("Response code: "+hr.getStatusLine());
        	code = hr.getStatusLine().getStatusCode();
        	httpClient.close();
        	
        }catch (Exception e){
        	System.out.println("Alert was not uploaded");
        }

		if(code == 201){
			System.out.println("Alert is Valid");
		}
        
        CheckLimit();
        ViewAlerts();
        
        return code;
	}
	
	public int UploadInvalid(){
		JSONObject obj = new JSONObject();
		final String id = "1460686c-0cda-452c-b8f7-7ca99211bf07";
		String temp = "noone";
		
		obj.put("userId", id);
        obj.put("alertType", 6);
        obj.put("heading", "Jumper Windows 11 Laptop");
        obj.put("description", "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD");
        obj.put("url", "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth");
        obj.put("imageUrl", "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg");
        obj.put("postedBy", temp);
        obj.put("priceInCents", 24999);
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse hr;
        int code = 0;
        
        try{
        	HttpPost req = new HttpPost("https://api.marketalertum.com/Alert");
        	req.addHeader("content-type", "application/json");
        	StringEntity parameters = new StringEntity(obj.toString());
        	req.setEntity(parameters);
        	hr = httpClient.execute(req);
        	System.out.println("Response code: "+hr.getStatusLine());
        	code = hr.getStatusLine().getStatusCode();
        	httpClient.close();
        	
        }catch (Exception e){
        	System.out.println("Alert was not uploaded");
        }

		if(code == 201){
			System.out.println("Alert is Valid");
		} else {
			System.out.println("Alert is Invalid");
		}
        
        CheckLimit();
        ViewAlerts();
        
        return code;
	}
	
	public int UploadCheckInvalid(){
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
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse hr;
        int code = 0;
        
        try{
        	HttpPost req = new HttpPost("https://api.marketalertum.com/Alert");
        	req.addHeader("content-type", "application/json");
        	StringEntity parameters = new StringEntity(obj.toString());
        	req.setEntity(parameters);
        	hr = httpClient.execute(req);
        	System.out.println("Response code: "+hr.getStatusLine());
        	code = hr.getStatusLine().getStatusCode();
        	httpClient.close();
        	
        }catch (Exception e){
        	System.out.println("Alert was not uploaded");
        }

		if(code == 201){
			System.out.println("Alert is Valid");
		}
        
        CheckLimitInvalid();
        ViewAlerts();
        
        return code;
	}
        
	public String getEventLog(){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		String log;
		try{
        	HttpGet get = new HttpGet("https://api.marketalertum.com/EventsLog/1460686c-0cda-452c-b8f7-7ca99211bf07");
        	HttpResponse resp = httpClient.execute(get);
        	HttpEntity entity = resp.getEntity();
        	log = EntityUtils.toString(entity);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return log;
	}
	
	public List<Integer> getAllEventLogType(){
		List<Integer> arr = new ArrayList<>();
		String ret = getEventLog();
		JSONArray data = new JSONArray(ret);
		
		for (int i=0; i<data.length();i++){
			JSONObject temp = data.getJSONObject(i);
			arr.add(temp.getInt("eventLogType"));
		}
		return arr;
	}
	
	public int getEventLogType(){
		String ret = getEventLog();
		JSONArray data = new JSONArray(ret);
		int event = -1;
	
		if(!data.isEmpty()){
			JSONObject temp = data.getJSONObject(0);
			event = temp.getInt("eventLogType");
			System.out.println("EventType: "+event);
		} else {
			System.out.println("No Event Type registered");
		}
		
		return event;
	}
		
	public int Delete(){
		CloseableHttpClient httpClientD = HttpClientBuilder.create().build();
		int code = 0;
		try{
            String link = "https://api.marketalertum.com/Alert?userId=1460686c-0cda-452c-b8f7-7ca99211bf07";
            HttpDelete del = new HttpDelete(link);
            HttpResponse d = httpClientD.execute(del);
            code = d.getStatusLine().getStatusCode();
            System.out.println("Delete Code: "+d.getStatusLine());
            System.out.println();
            httpClientD.close();
        } catch (Exception e) {
            System.out.println("Delete has failed..");
        }
		ViewAlerts();
		return code;
	}
	
	public int DeleteInvalid(){
		CloseableHttpClient httpClientD = HttpClientBuilder.create().build();
		int code = 0;
		try{
            String link = "https://api.marketalertum.com/Alert?userId=wrong";
            HttpDelete del = new HttpDelete(link);
            HttpResponse d = httpClientD.execute(del);
            code = d.getStatusLine().getStatusCode();
            System.out.println("Delete Code: "+d.getStatusLine());
            System.out.println();
            httpClientD.close();
        } catch (Exception e) {
            System.out.println("Delete has failed..");
        }
		ViewAlerts();
		return code;
	}
	
	public boolean CheckLimit(){
		boolean limit = true;
        return limit;
	}
	
	public boolean CheckLimitInvalid(){
		boolean limit = false;
		return limit;
	}

}
