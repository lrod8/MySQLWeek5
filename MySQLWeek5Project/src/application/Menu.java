package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FoodsDao;
import entity.Foods;

public class Menu {
	
	private FoodsDao foodsDao = new FoodsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Foods", //read 
			"Create Foods", //create
			"Delete Foods", //delete
			"Update Foods"); //update
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
				try {
					if (selection.equals("1")) {
						displayFoods();
					} else if (selection.equals("2")) {
						createFood();
					} else if (selection.equals("3")) {
						deleteFood();
					} else if (selection.equals("4")) {
						updateFood();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option: \n--------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayFoods() throws SQLException {
		foodsDao.getFoods();
	}
	
	private void createFood() throws SQLException {
		System.out.print("Enter new food item:");
		String foodName = scanner.nextLine();
		foodsDao.createNewFood(foodName);
	}
	
	private void deleteFood() throws SQLException {
		System.out.print("Enter food id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		foodsDao.deleteFoodById(id);
	}

	private void updateFood() throws SQLException {
		System.out.print("Enter food id to update:");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter food name update:");
		String foodName = scanner.nextLine();
		foodsDao.updateFoodById(id, foodName);
	}

}
