package settingsobject;

public class GenericSettings {
	private String userhomedir;
	public GenericSettings(){
		userhomedir = System.getProperty("user.home"); //get user homedirectory (platform indp)
	}

}
