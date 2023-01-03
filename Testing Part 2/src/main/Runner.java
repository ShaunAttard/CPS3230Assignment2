package main;

public class Runner {
	
	public static void main(String [] args){
		
		APIRuntimeVerification api = new APIRuntimeVerification();
		api.getEventLog();
		
		api.LoginInvalid();
		
		api.Login();
		
		int code = api.Upload();
		System.out.println("Code: "+code);
		
		int upinval = api.UploadInvalid();
		api.Login();
		
		int uplimitinval = api.UploadCheckInvalid();
		api.Login();

        int del = api.Delete();
		int deli = api.DeleteInvalid();
		
		api.Login();
		api.Logout();
        System.out.println();
        
	}

}
