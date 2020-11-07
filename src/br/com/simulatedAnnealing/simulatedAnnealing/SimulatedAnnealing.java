package br.com.simulatedAnnealing.simulatedAnnealing;

import java.util.List;
import java.util.Random;

import br.com.simulatedAnnealing.Graph.City;
import br.com.simulatedAnnealing.travelingSalesman.TravelingSalesmanRoute;

public class SimulatedAnnealing {
	double temp = 10000;
	double coolingRate = 0.003;
	TravelingSalesmanRoute router;

	/**
	 * @param router
	 */
	public SimulatedAnnealing() {
		super();
		this.router = new TravelingSalesmanRoute();
		this.router.generateRouter();
	}

	public SimulatedAnnealing(List<City> citys) {
		super();
		this.router = new TravelingSalesmanRoute(citys);
	}
	
	public double acceptanceProbability(double energy, double newEnergy, double temperature) {
		if (newEnergy < energy) {
			return 1.0;
		}
		return Math.exp((energy - newEnergy) / temperature);
	}

	public void solver() {
		TravelingSalesmanRoute best = new TravelingSalesmanRoute(router.getCitys());
		while (temp > 1) {
			TravelingSalesmanRoute newRouter = new TravelingSalesmanRoute(router.getCitys());

			int possition1 = (int)(newRouter.routerSize() * Math.random());
			int possition2 = (int)(newRouter.routerSize() * Math.random());
			
			if(possition1 != 0 && possition2 != 0) {
				City city1 = newRouter.getCity(possition1);
				City city2 = newRouter.getCity(possition2);

				newRouter.setCity(possition2, city1);
				newRouter.setCity(possition1, city2);

				double currentEnergy = router.getDistance();
				double neighbourEnergy = newRouter.getDistance();

				if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
					router = new TravelingSalesmanRoute(newRouter.getCitys());
				}

				if (router.getDistance() < best.getDistance()) {
					best = new TravelingSalesmanRoute(router.getCitys());
				}
				this.temp *= 1 - coolingRate;
			}
		}
		System.out.println("============================================================ \n");
		System.out.println("Final solution distance: " + String.format("%.2f", best.getDistance()));
		System.out.println("Tour: " + best);
	}
}
