

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ConverterMSG {

	public static void main(String[] args) {
 
StringBuilder sb=new StringBuilder();
	
String csvFile = "c://TNG//messageBundle.csv";
String line = "";
String cvsSplitBy = ",";
Path outputPath=Paths.get("c://TNG//messages.properties");

try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
int i=0;
    while ((line = br.readLine()) != null) {

        // use comma as separator
        String[] country = line.split(cvsSplitBy);
if(country.length>0 && country[0].trim().length()>0 &&(country.length>1?true:false)) {
	i++;

        System.out.println(i+") Country [code= " + country[0]+ " , value=" + country[1] + "]");
sb.append(country[0]+"="+country[1]+System.getProperty("line.separator"));
Files.write(outputPath, sb.toString().getBytes());    
	}
    }


} catch (IOException e) {
    e.printStackTrace();
}

	}

}
