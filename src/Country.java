
public class Country {

	String countryName;
	int population;
	
	public Country() {}

	public Country(String country, int population) {
		this.countryName = country;
		this.population = population;
	}

	public String getCountry() {
		return countryName;
	}

	public void setCountry(String country) {
		this.countryName= country;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return countryName +"(" + population + ")";
	}
}
