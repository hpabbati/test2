package csvParserPackage;

import edu.duke.*;
import org.apache.commons.csv.*;


public class MyCSVParser {
		
		public static void main(String[] args) {
			
			MyCSVParser p = new MyCSVParser();
			
			FileResource fr = new FileResource();
			CSVParser parser = fr.getCSVParser();
			
			//Calling the method getCountryInfo
			//String exportOfInterest = "coffee";
			String countryOfInterest = "Germany";
			//String result = p.getCountryInfo(parser, countryOfInterest);
			System.out.println("The Countries that exported Coffee are : ");
			//System.out.println(result);
			
			
			//Calling the method listExportersTwoProducts
			MyCSVParser q = new MyCSVParser();
			String exportItem1 = "diamonds";
			String exportItem2 = "gold";
			System.out.println("The Countries that exported Gold and Diamonds are : ");
			q.listExportersTwoProducts(parser, exportItem1, exportItem2);
			
			//Calling the method numberOfExporters
			MyCSVParser r = new MyCSVParser();
			String exportItem = "gold";
			int count = r.numberOfExporters(parser, exportItem);
			System.out.println("The number of countries that exported Gold are : " + count);
			
			
					
		}
		
		public int numberOfExporters(CSVParser parser, String exportItem){
			
			int countryCount = 0;
			for(CSVRecord record : parser){
				String exports = record.get("Exports");
				if(exports.contains(exportItem)){
					countryCount = countryCount + 1;
				}
			}
			return countryCount;
			
		}
		
		
		
		
		public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
			for(CSVRecord record : parser ){
				String exports = record.get("Exports");
				if(exports.contains(exportItem1)&& exports.contains(exportItem2)){
					System.out.println(record.get("Country"));
				}
			}
		}
		
		
		
		public String getCountryInfo(CSVParser parser, String country){
			String cName;
			String result = "NOT FOUND";
			for(CSVRecord record : parser){
				cName = record.get("Country");
				if(cName.equals(country)){
					System.out.println("Inside if loop");
					String exports = record.get("Exports");
					String value = record.get("Value (dollars)");
					result = cName + ":" + cName + ":" + value;
				}
			}
			return result;
		}

		
		
		
		
		/*public void getExports(CSVParser parser, String exportOfInterest){
			
			for(CSVRecord record : parser){
				String exports = record.get("Exports");
				//System.out.print(exports);
				if (exports.contains(exportOfInterest)){
					System.out.println(record.get("Country"));
				}
			}
			for(CSVRecord record : parser){
				System.out.print(record.get("Country")+ "	");
		
				System.out.println(record.get("Value (dollars)"));
			}
		}*/
}

	



