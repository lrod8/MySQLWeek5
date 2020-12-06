package entity;

import java.util.List;

public class Foods {
	
	private int id;
	private String food;
	private List<Foods> foods;
	
	public Foods(int id, String food) {
		this.id = id;
		this.food = food;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public List<Foods> getFoods() {
		return foods;
	}

	public void setFoods(List<Foods> foods) {
		this.foods = foods;
	}

}
