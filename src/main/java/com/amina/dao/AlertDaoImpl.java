package com.amina.dao;

import java.util.LinkedList;
import java.util.List;
import java.sql.*;

import org.springframework.stereotype.Repository;

import com.amina.domain.Alert;

@Repository
public class AlertDaoImpl implements AlertDao{

	@Override
	public List<Alert> getAllAlert() {
		//JDBC CODE TO GET ALL PRODUCT NAMES AND QUANTITY
		List<Alert> alerts = new LinkedList<Alert>();
		
		//load teradata jdbc driver
		try{
			Class.forName("com.teradata.jdbc.TeraDriver");
			System.out.println("######## DRIVER SUCCESSFULLY LOADED ##########");
		}catch (ClassNotFoundException exc){
			System.out.println("Couldn't load driver ... \n ");
			exc.printStackTrace();
		}
		
		//connect to Teradata db
		
		String url = "jdbc:teradata://192.168.1.26/TMODE=ANSI,CHARSET=UTF8";
		String user = "dbc";
		String pwd = "dbc";
		Connection connection = null;
		try{
			System.out.println("######## CREATING CONNECTION ...");
			connection = DriverManager.getConnection(url, user, pwd);
			System.out.println("######## CREATED CONNECTION ");
			Statement statement = connection.createStatement();
			System.out.println("######## CREATED STATEMENT ");
			ResultSet resultat = statement.executeQuery("select * from PRVIEW.ALERTES where qte_rayo < seuil");
			
			while(resultat.next()){
				String productName = resultat.getString("LIBL_PRDT");
				String aisleName = resultat.getString("LIBL_RAYO");
				int quantiteRayon = resultat.getInt("QTE_RAYO");
				int seuil = resultat.getInt("SEUIL");
				Alert a = new Alert();
				a.setProductName(productName);
				a.setProductQuantity(quantiteRayon);
				a.setProductThreshold(seuil);
				a.setAisleName(aisleName);
				System.out.println(a.toString());
				alerts.add(a);
			}
			
		}catch(SQLException e){
			System.out.println("######## COULD NOT OPEN CONNECTION TO TERADATA ############");
			
		}finally{
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("######## COULD NOT CLOSE CONNECTIONS ##########");
				}
			}
		}
		
		return alerts;
	}

}
