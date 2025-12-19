package constant;

public class Constants {
	public static final String EXCELFILE = System.getProperty("user.dir") + "\\src\\test\\resources\\liveLoginData.xlsx";
	 public static final String CONFIGFILE = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
	 
	 public static final String VALIDCREDENTIALSERROR = "User was unable to login with valid credentials";
	 public static final String VALIDUSERNAMEANDINVALIDPASSWORD = "User was able to login with invalid password";
	 public static final String INVALIDUSERNAMEANDVALIDPASSWORD = "User was able to login with invalid username";
	 public static final String INVALIDCREDENTIALSERROR = "User was able to login with invalid credentials";
	 
	 public static final String ADDNEWUSERERROR = "User was NOT added!"; 
	 public static final String SEARCHNEWUSERERROR = "Searched user does NOT match!";
	 public static final String RESETERROR =  "user list is not reset.";
	 
	 public static final String LOGOUTERROR =  "User was unable to LogOut Successfully";
	 
	 public static final String ADDNEWSERROR =   "Alert is Not Found";
	 public static final String SEARCHNEWSERROR = "Search result does not match expected news title";
}
