package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Foods;

public class FoodsDao {
	
	private Connection connection;
	private final String GET_FOODS_QUERY = "SELECT * FROM foods";
	private final String CREATE_NEW_FOOD_QUERY = "INSERT INTO foods(food) VALUES (?)";
	private final String DELETE_FOOD_BY_ID_QUERY = "DELETE FROM foods WHERE id = ?";
	private final String UPDATE_FOOD_BY_ID_QUERY = "UPDATE foods SET food = ? WHERE id = ?";

	public FoodsDao() {
		connection = DBConnection.getConnection();
	}
	
	public void getFoods() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_FOODS_QUERY).executeQuery();
		while (rs.next()) {
			System.out.println("Id: " + rs.getInt(1) + "\tFood: " + rs.getString(2));
		}
	}
	
	public void createNewFood(String foodName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_FOOD_QUERY);
		ps.setString(1, foodName);
		ps.executeUpdate();
	}

	public void deleteFoodById (int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_FOOD_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateFoodById (int id, String foodName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_FOOD_BY_ID_QUERY);
		ps.setInt(2, id);
		ps.setString(1, foodName);
		ps.executeUpdate();
	}

}
