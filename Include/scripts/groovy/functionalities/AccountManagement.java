package functionalities;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.lang.RandomStringUtils;

import com.opencsv.CSVWriter;

public class AccountManagement {

	  public boolean addAccountToCsv(String csvPath, String email, String password, String amount) {
		  try {
			  
		      CSVWriter writer = new CSVWriter(new FileWriter(csvPath, true));
  
		      String data = "1,"+ email +","+ password +","+ amount;
		    	  
		      String [] record = data.split(",");

			  writer.writeNext(record);

		      writer.close();
		      
		      return true;
		      
		  }catch(IOException e) {
			  e.printStackTrace();
			  return false;
		  }
	  }
	  
	  public void createFileCSV(String file, String delim) {
			final String NEXT_LINE = "\n";
			try {
				FileWriter fw = new FileWriter(file);

				fw.append("id,email,password,amount").append(NEXT_LINE);

				fw.flush();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }
	  
	  public String generateUsername(String type) {
		  
		  String email = "";
		  String temp = RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz1234567890_-.");
		  email = temp.substring(0, temp.length()) + "@"+type+".com";
		  
		  return email;
	  }
	  
	  public String substractUserName(String email) {
		  try {
			  
			int index = email.indexOf('@');
			String username = email.substring(0,index);
			 
			return username.replace('+', '_');
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	  }
	  
	  public static void main(String[] args) {
		    
	  }
}