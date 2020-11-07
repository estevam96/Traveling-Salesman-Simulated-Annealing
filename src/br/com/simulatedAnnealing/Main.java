package br.com.simulatedAnnealing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.simulatedAnnealing.Graph.City;
import br.com.simulatedAnnealing.Graph.Graph;
import br.com.simulatedAnnealing.simulatedAnnealing.SimulatedAnnealing;
import br.com.simulatedAnnealing.util.FileManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileManager fileManager = new FileManager();

		try {

			Scanner sm = new Scanner(System.in);
			System.out.println("Enter the number of traveling salesmen:");
			String SalesManNumber = sm.nextLine();
			System.out.println("Using 30 or 100 cities?:");
			String numberCitys = sm.nextLine();
			List<City> citys = new ArrayList<City>();
			if (numberCitys.equals("30")) {
				citys = fileManager.readFile(".\\src\\ncit30.dat");
			} else if (numberCitys.equals("100")) {
				citys = fileManager.readFile(".\\src\\ncit100.dat");
			}

			int range = (citys.size() / Integer.parseInt(SalesManNumber));

			Graph g = new Graph();
			SimulatedAnnealing annealing;
			switch (SalesManNumber) {
			case "1":
				g.setCitys(citys.subList(0, range));
				annealing = new SimulatedAnnealing();
				annealing.solver();
				break;
			case "2":
				g.setCitys(citys.subList(0, range));
				annealing = new SimulatedAnnealing();
				System.out.println("SalesMan 1");
				annealing.solver();
				List<City> part2 = citys.subList(range, citys.size());
				part2.add(0, citys.get(0));
				g.setCitys(part2);
				annealing = new SimulatedAnnealing();
				System.out.println("\n SalesMan 2");
				annealing.solver();
				break;
			case "3":
				g.setCitys(citys.subList(0, range));
				annealing = new SimulatedAnnealing();
				System.out.println("SalesMan 1");
				annealing.solver();
				part2 = citys.subList(range, citys.size() - range);
				part2.add(0, citys.get(0));
				g.setCitys(part2);
				annealing = new SimulatedAnnealing();
				System.out.println("\n SalesMan 1");
				annealing.solver();
				part2 = citys.subList(citys.size() - range, citys.size());
				part2.add(0, citys.get(0));
				g.setCitys(part2);
				annealing = new SimulatedAnnealing();
				System.out.println("\n SalesMan 3");
				annealing.solver();
				break;
			default:
				System.out.println("number of clerks must be between 1 and 3");
				break;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
