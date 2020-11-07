package br.com.simulatedAnnealing.Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private static List<City> citys = new ArrayList<>();
	
	public static void addCity(City city) {
		citys.add(city);
	}
	
	public static City getCity(int index) {
		return citys.get(index);
	}
	
	public void setCitys (List<City> cityList) {
		citys = cityList;
	}
	
	public static int totalCitys() {
		return citys.size();
	}
}
