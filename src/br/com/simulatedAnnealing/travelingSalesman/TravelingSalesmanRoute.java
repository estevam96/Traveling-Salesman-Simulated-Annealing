package br.com.simulatedAnnealing.travelingSalesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.com.simulatedAnnealing.Graph.City;
import br.com.simulatedAnnealing.Graph.Graph;

public class TravelingSalesmanRoute {
	private List<City> holdCitys = new ArrayList<>();
	private double distance;

	/**
	 * 
	 */
	public TravelingSalesmanRoute() {
		super();
		for (int i = 0; i < Graph.totalCitys(); i++) {
			holdCitys.add(null);
		}
		this.distance = 0;
	}

	/**
	 * @param holdCitys
	 */
	public TravelingSalesmanRoute(List<City> holdCitys) {
		super();
		this.holdCitys = new ArrayList<>(holdCitys);
	}

	public List<City> getCitys() {
		return holdCitys;
	}

	public void setCity(int index, City city) {
		holdCitys.set(index, city);
		distance = 0;
	}

	public City getCity(int index) {
		return holdCitys.get(index);
	}

	public void generateRouter() {
		for (int i = 0; i < Graph.totalCitys(); i++) {
			setCity(i, Graph.getCity(i));
		}
		City firstCity = holdCitys.remove(0);
		Collections.shuffle(holdCitys);
		holdCitys.add(0, firstCity);
	}

	public double getDistance() {
		if (distance == 0) {
			double routeDistance = 0;

			for (int i = 0; i < holdCitys.size(); i++) {
				City currentCity = getCity(i);
				City fromCity;

				if (i + 1 < routerSize()) {
					fromCity = getCity(i + 1);
				} else {
					fromCity = getCity(0);
				}
				routeDistance += currentCity.distanceCalculation(fromCity);
			}
			distance = routeDistance;
		}
		return distance;
	}

	public int routerSize() {
		return holdCitys.size();
	}
	
	@Override
  public String toString() {
      String geneString = "|";
      for (int i = 0; i < routerSize(); i++) {
          geneString += getCity(i)+"|";
      }
      return geneString;
  }
}
