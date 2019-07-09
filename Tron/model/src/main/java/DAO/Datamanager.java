package DAO;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Datamanager extends AbstractDatamanager{

	private final static String sqlGetMapByID ="{call insertdata(?,?)}";


	public void save(int player , int time){
		final CallableStatement callStatement = prepareCall(sqlGetMapByID);
	    try {
			callStatement.setInt(1, player);
			callStatement.setInt(2, time);
			callStatement.execute();
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	     
	}
	



}
