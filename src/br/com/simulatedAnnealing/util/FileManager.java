package br.com.simulatedAnnealing.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.com.simulatedAnnealing.Graph.City;
import br.com.simulatedAnnealing.Graph.Graph;


public class FileManager {
	
	private List<City> generateMatrix(List<String> list) {
		list.remove(0);
		List<City> citys = new ArrayList<City>();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			String[] el = list.get(i).split(" ");
			City node = new City(String.valueOf(i), Integer.parseInt(el[0]),Integer.parseInt(el[1]));
			citys.add(node);
		}
		
		return citys;
	}
	
	public List<City> readFile(String Filename) throws IOException {
		Path path = Paths.get(Filename);
		List<String> lines = Files.readAllLines(path);
		return generateMatrix(lines);
	}
}
