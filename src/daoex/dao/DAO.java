package daoex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import daoex.entity.Dept;

public interface DAO<T> {
	static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	T get(int id);
	ArrayList<T> getAll();
	int insert(T item);
	int update(T item);
	int delete(int id);
	
	default Connection getConnection() {
		
		try {
			Connection con = DriverManager.getConnection(URL, "c##user1", "1234");
			return con;
		} catch (SQLException e) {
			System.out.println("오라클 db에 연결할 수 없습니다.");
			return null;
			}
	}
	
}
