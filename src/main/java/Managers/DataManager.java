package Managers;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;


public class DataManager {

	Properties properties;
	JSONObject ownerDetails;
	JSONObject petDetails;
	String configfilepath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"config.properties";
	String ownerDetailsPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"OwnerDetails.json";
	String petDetailsPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"PetDetails.json";
	String ownerDetailsFileContent;
	String petDetailsFileContent;
	public DataManager()
	{
		
		try {
			properties = new Properties();
			FileReader reader = new FileReader(configfilepath);
			properties.load(reader);
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			ownerDetailsFileContent = new String(Files.readAllBytes(Paths.get(ownerDetailsPath)));
			ownerDetails=new JSONObject(ownerDetailsFileContent);
			System.out.println(ownerDetails.toString());
			petDetailsFileContent = new String(Files.readAllBytes(Paths.get(petDetailsPath)));
			petDetails=new JSONObject(petDetailsFileContent);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(JSONException e) {
			
			e.printStackTrace();
		}
			
	}
	public String readConfigProperty(String Prop) {
		
		return properties.getProperty(Prop);
	}
	
	public String getOwnerDetails(String key) {
		
		return ownerDetails.getString(key).toString();
		
	}
public String getPetDetails(String key) {
		
		return petDetails.getString(key).toString();
		
	}
}
	

