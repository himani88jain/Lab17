
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class CountriesApp {

	private static Path filePath = Paths.get("Country.txt");
			
	public static void main(String[] args) {
		Scanner scnr=new Scanner(System.in);

		System.out.println("Welcome to Countries Maintainence Application!");
		while(true) {
			System.out.println("1-See the list of Countries");
			System.out.println("2-Add a country");
			System.out.println("3-Exit\n");
			try {
        System.out.println("Enter menu number: ");
        int menu_no=scnr.nextInt();
        if(menu_no==3) {
        	break;
        }

        else if(menu_no==1) {
        	List<Country> things = readFile();
			int i = 1; 
			for (Country thing : things) {
				System.out.println(i++ + ". " + thing);
			}
			System.out.println();
        }
        else if(menu_no==2) {
        	Country c = getInputFromUser(scnr);
			System.out.println("Adding " + c);
			appendLineToFile(c);
			System.out.println();
        }
   
        else {
        	System.out.println("invalid Command");
        }
			}catch(InputMismatchException e) {
				System.out.println("Please enter valid menu number");
				scnr.nextLine();
			}
		}
		
		System.out.println("GoodBye");
		scnr.close();
	}
	
	
	public static Country getInputFromUser(Scanner scnr) {
		scnr.nextLine();
		String countryName = Validator.getString(scnr, "Enter Country: ");
		int population = Validator.getInt(scnr, "Enter population: ");
		return new Country(countryName,population);

	}
	 
	
	public static List<Country> readFile(){
		try {
			List<String> lines = Files.readAllLines(filePath);
			ArrayList<Country> country=new ArrayList<>();
					for(String line:lines) {
				String[] parts=line.split("~~~");
				String countryName=parts[0];
				int population=Integer.parseInt(parts[1]);
				country.add(new Country(countryName,population));
			}
			return country;
		}catch(IOException e) {
			System.out.println("Unable to read file");
			return new ArrayList<>();
		}
	}
	
	public static void appendLineToFile(Country c) {
		String line=c.getCountry()+"~~~"+c.getPopulation();
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}
	
	
}


