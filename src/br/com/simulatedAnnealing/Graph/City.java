package br.com.simulatedAnnealing.Graph;

public class City {
	private String label;
	private int x, y;
	private boolean isVisited;

	/**
	 * @param label
	 * @param x
	 * @param y
	 * @param isVisited
	 */
	public City(String label, int x, int y) {
		super();
		this.label = label;
		this.x = x;
		this.y = y;
		this.isVisited = false;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the isVisited
	 */
	public boolean isVisited() {
		return isVisited;
	}

	/**
	 * @param isVisited the isVisited to set
	 */
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	/**
	 * 
	 * @param city neighbor
	 * @return Euclidean distance between cities
	 */
	public double distanceCalculation(City city) {
		double part1 = Math.pow(city.getX() - getX(), 2);
		double part2 = Math.pow(city.getY() - getY(), 2);

		return Math.sqrt(part1 + part2);
	}

	 @Override
   public String toString(){
       return getLabel() + " ==> ";
   }
}
