package aspects;

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

import larva.*;
public aspect _asp_Runtime0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Runtime0.initialize();
}
}
before () : (call(* *.DeleteInvalid(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 184/*DeleteInvalid*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 184/*DeleteInvalid*/);
}
}
before () : (call(* *.HandleBadState(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 192/*HandleBadState*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 192/*HandleBadState*/);
}
}
before () : (call(* *.ViewAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 186/*ViewAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 186/*ViewAlerts*/);
}
}
before () : (call(* *.CheckLimit(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 188/*CheckLimit*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 188/*CheckLimit*/);
}
}
before () : (call(* *.Login(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 174/*Login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 174/*Login*/);
}
}
before () : (call(* *.LoginInvalid(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 172/*LoginInvalid*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 172/*LoginInvalid*/);
}
}
before () : (call(* *.UploadInvalid(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 178/*UploadInvalid*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 178/*UploadInvalid*/);
}
}
before () : (call(* *.Delete(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 182/*Delete*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 182/*Delete*/);
}
}
before () : (call(* *.Upload(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 176/*Upload*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 176/*Upload*/);
}
}
before () : (call(* *.Logout(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 194/*Logout*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 194/*Logout*/);
}
}
before () : (call(* *.CheckLimitInvalid(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 190/*CheckLimitInvalid*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 190/*CheckLimitInvalid*/);
}
}
before () : (call(* *.UploadCheckInvalid(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Runtime0.lock){

_cls_Runtime0 _cls_inst = _cls_Runtime0._get_cls_Runtime0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 180/*UploadCheckInvalid*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 180/*UploadCheckInvalid*/);
}
}
}