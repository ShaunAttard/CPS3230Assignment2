package larva;


import org.json.JSONObject;
import java.util.List;
import org.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Runtime0 implements _callable{

public static PrintWriter pw; 
public static _cls_Runtime0 root;

public static LinkedHashMap<_cls_Runtime0,_cls_Runtime0> _cls_Runtime0_instances = new LinkedHashMap<_cls_Runtime0,_cls_Runtime0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\shaun\\workspace\\Testing Part 2/src/output_Runtime.txt");

root = new _cls_Runtime0();
_cls_Runtime0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Runtime0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int code ;
 public int del ;
 public boolean alerts ;
 public int event ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Runtime0() {
}

public void initialisation() {
}

public static _cls_Runtime0 _get_cls_Runtime0_inst() { synchronized(_cls_Runtime0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Runtime0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Runtime0_instances){
_performLogic_RuntimeVerification(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Runtime0[] a = new _cls_Runtime0[1];
synchronized(_cls_Runtime0_instances){
a = _cls_Runtime0_instances.keySet().toArray(a);}
for (_cls_Runtime0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Runtime0_instances){
_cls_Runtime0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_RuntimeVerification = 75;

public void _performLogic_RuntimeVerification(String _info, int... _event) {

_cls_Runtime0.pw.println("[RuntimeVerification]AUTOMATON::> RuntimeVerification("+") STATE::>"+ _string_RuntimeVerification(_state_id_RuntimeVerification, 0));
_cls_Runtime0.pw.flush();

if (0==1){}
else if (_state_id_RuntimeVerification==73){
		if (1==0){}
		else if ((_occurredEvent(_event,186/*ViewAlerts*/)) && (alerts ==true )){
		_cls_Runtime0.pw .println ("Alert Limit not exceeded, Redirecting to Alerts Page...");

		_state_id_RuntimeVerification = 71;//moving to state alertsPage
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,186/*ViewAlerts*/)) && (alerts ==false )){
		_cls_Runtime0.pw .println ("Alert Limit exceeded, Redirecting to Bad State...");

		_state_id_RuntimeVerification = 70;//moving to state alertLimit
		_goto_RuntimeVerification(_info);
		}
}
else if (_state_id_RuntimeVerification==74){
		if (1==0){}
		else if ((_occurredEvent(_event,186/*ViewAlerts*/)) && (del ==200 )){
		_cls_Runtime0.pw .println ("Delete Successful, Redirecting to Alerts Page...");

		_state_id_RuntimeVerification = 71;//moving to state alertsPage
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,186/*ViewAlerts*/)) && (del ==400 )){
		_cls_Runtime0.pw .println ("Delete Failed, Redirecting to Bad State...");

		_state_id_RuntimeVerification = 69;//moving to state invalidDelete
		_goto_RuntimeVerification(_info);
		}
}
else if (_state_id_RuntimeVerification==68){
		if (1==0){}
		else if ((_occurredEvent(_event,174/*Login*/))){
		_cls_Runtime0.pw .println ("Recovering from Bad State...");

		_state_id_RuntimeVerification = 71;//moving to state alertsPage
		_goto_RuntimeVerification(_info);
		}
}
else if (_state_id_RuntimeVerification==69){
		if (1==0){}
		else if ((_occurredEvent(_event,174/*Login*/))){
		_cls_Runtime0.pw .println ("Recovering from Bad State...");

		_state_id_RuntimeVerification = 71;//moving to state alertsPage
		_goto_RuntimeVerification(_info);
		}
}
else if (_state_id_RuntimeVerification==71){
		if (1==0){}
		else if ((_occurredEvent(_event,176/*Upload*/))){
		code =uploadValid ();
_cls_Runtime0.pw .println ("Alert uploaded!");

		_state_id_RuntimeVerification = 72;//moving to state uploadAlert
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,178/*UploadInvalid*/))){
		code =uploadInvalid ();
_cls_Runtime0.pw .println ("Alert uploaded!");

		_state_id_RuntimeVerification = 72;//moving to state uploadAlert
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,180/*UploadCheckInvalid*/))){
		code =uploadValid ();
_cls_Runtime0.pw .println ("Alert uploaded!");

		_state_id_RuntimeVerification = 72;//moving to state uploadAlert
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,182/*Delete*/))){
		del =deleteValid ();
_cls_Runtime0.pw .println ("Delete Request Sent");

		_state_id_RuntimeVerification = 74;//moving to state deleteAlert
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,184/*DeleteInvalid*/))){
		del =deleteInvalid ();
_cls_Runtime0.pw .println ("Delete Request Sent");

		_state_id_RuntimeVerification = 74;//moving to state deleteAlert
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,194/*Logout*/))){
		_cls_Runtime0.pw .println ("Logged out of the System");

		_state_id_RuntimeVerification = 75;//moving to state loginPage
		_goto_RuntimeVerification(_info);
		}
}
else if (_state_id_RuntimeVerification==75){
		if (1==0){}
		else if ((_occurredEvent(_event,172/*LoginInvalid*/))){
		_cls_Runtime0.pw .println ("Invalid Credentials");

		_state_id_RuntimeVerification = 75;//moving to state loginPage
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,174/*Login*/))){
		_cls_Runtime0.pw .println ("Logged in");

		_state_id_RuntimeVerification = 71;//moving to state alertsPage
		_goto_RuntimeVerification(_info);
		}
}
else if (_state_id_RuntimeVerification==72){
		if (1==0){}
		else if ((_occurredEvent(_event,188/*CheckLimit*/)) && (code ==201 )){
		alerts =checkLimit ();
_cls_Runtime0.pw .println ("Alert was Valid, Checking Alert Limit...");

		_state_id_RuntimeVerification = 73;//moving to state checkAlertLimit
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,190/*CheckLimitInvalid*/)) && (code ==201 )){
		alerts =checkLimitInvalid ();
_cls_Runtime0.pw .println ("Alert was Valid, Checking Alert Limit...");

		_state_id_RuntimeVerification = 73;//moving to state checkAlertLimit
		_goto_RuntimeVerification(_info);
		}
		else if ((_occurredEvent(_event,188/*CheckLimit*/)) && (code !=201 )){
		_cls_Runtime0.pw .println ("Alert was Invalid, Redirecting to Bad State...");

		_state_id_RuntimeVerification = 68;//moving to state invalidAlert
		_goto_RuntimeVerification(_info);
		}
}
else if (_state_id_RuntimeVerification==70){
		if (1==0){}
		else if ((_occurredEvent(_event,174/*Login*/))){
		_cls_Runtime0.pw .println ("Recovering from Bad State...");

		_state_id_RuntimeVerification = 71;//moving to state alertsPage
		_goto_RuntimeVerification(_info);
		}
}
}

public void _goto_RuntimeVerification(String _info){
_cls_Runtime0.pw.println("[RuntimeVerification]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_RuntimeVerification(_state_id_RuntimeVerification, 1));
_cls_Runtime0.pw.flush();
}

public String _string_RuntimeVerification(int _state_id, int _mode){
switch(_state_id){
case 73: if (_mode == 0) return "checkAlertLimit"; else return "checkAlertLimit";
case 74: if (_mode == 0) return "deleteAlert"; else return "deleteAlert";
case 68: if (_mode == 0) return "invalidAlert"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidAlert "+new _BadStateExceptionRuntime().toString()+" ";
case 69: if (_mode == 0) return "invalidDelete"; else return "!!!SYSTEM REACHED BAD STATE!!! invalidDelete "+new _BadStateExceptionRuntime().toString()+" ";
case 71: if (_mode == 0) return "alertsPage"; else return "alertsPage";
case 72: if (_mode == 0) return "uploadAlert"; else return "uploadAlert";
case 75: if (_mode == 0) return "loginPage"; else return "loginPage";
case 70: if (_mode == 0) return "alertLimit"; else return "!!!SYSTEM REACHED BAD STATE!!! alertLimit "+new _BadStateExceptionRuntime().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
int uploadValid(){
JSONObject json = new JSONObject();

json.put("userId","1460686c-0cda-452c-b8f7-7ca99211bf07");
json.put("alertType", 6);
json.put("heading", "Jumper Windows 11 Laptop");
json.put("description", "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD");
json.put("url", "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth");
json.put("imageUrl", "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg");
json.put("postedBy", "1460686c-0cda-452c-b8f7-7ca99211bf07");
json.put("priceInCents", 24999);

int code = 201;
return code;
}

int uploadInvalid(){
JSONObject json = new JSONObject();
String temp = "noone";

json.put("userId","1460686c-0cda-452c-b8f7-7ca99211bf07");
json.put("alertType", 8);
json.put("heading", "Jumper Windows 11 Laptop");
json.put("description", "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD");
json.put("url", "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth");
json.put("imageUrl", "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg");
json.put("postedBy", temp);
json.put("priceInCents", 24999);

int code = 400;
return code;
}

int deleteValid(){
int code = 200;
return code;
}

int deleteInvalid(){
int code = 400;
return code;
}

boolean checkLimit(){
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.marketalertum.com/Alerts/Login");
driver.findElement(By.id("UserId")).sendKeys("1460686c-0cda-452c-b8f7-7ca99211bf07");
driver.switchTo().activeElement().sendKeys(Keys.ENTER);
List<WebElement> alerts = driver.findElements(By.xpath("//table[@border='1']"));
System.out.println("Size: "+alerts.size());
boolean limit;
if(alerts.size()>5){
limit = false;
} else {
limit = true;
}
driver.quit();
return limit;
}

boolean checkLimitInvalid(){
boolean limit = false;
return limit;
}
}