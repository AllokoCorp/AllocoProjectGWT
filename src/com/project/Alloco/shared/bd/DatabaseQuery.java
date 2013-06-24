package com.project.Alloco.shared.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Alloco.shared.model.allocoUser;

public class DatabaseQuery {

	private java.sql.Connection dbConnect;
	private java.sql.Statement dbStatement;
	
	public DatabaseQuery(){
		try{
			System.out.println("[TRACE] DATABASEQUERY: DatabaseQuery()");
			this.dbConnect = MySQLConnection.getInstance().getConnection();
			
		} catch (Exception ex) {
			System.out.println("[EXCEPTION]  DatabaseQuery: DatabaseQuery()");
		}
	}
	
	public allocoUser getUser(String userName, String password) throws SQLException , Exception {
		
		System.out.println("[TRACE] DATABASEQUERY: getUser");
		String requete = "SELECT * FROM alloco.user_info"; 
		requete += " WHERE name= '"+ userName +"' AND password= '"+ password +"';";
		
		return getRequestedObject( requete , allocoUser.class );
	}

	
	
	//public List<VlpScheduledTask> getScheduledTasksUntilDate( long date ){
		//String requete = "SELECT * FROM virtuallabportal.vlpscheduledtask where scheduledDate >= "+date+";";
		
		//return getRequestedList( requete , VlpScheduledTask.class );
	//}
	
	
	private <T extends Object> List<T> getRequestedList( String requete , Class<T> c ){
		System.out.println("[TRACE] DATABASEQUERY: getRequestedList");
		List<T> result = new ArrayList<T>();
		ResultSet rs = exec(requete);
		try{
			if( rs != null )
			{
				while(rs.next())
				{
					result.add((T) getRequestedObjectFromResultSet( rs , c ) );
				}
			}
		}catch(Exception e){
			System.out.println("[EXCEPTION]  DatabaseQuery: getRequestedList()");
		}
		return result;
	}
	
	private <T extends Object> T getRequestedObject( String requete , Class<T> c ){
		System.out.println("[TRACE] DATABASEQUERY: getRequestedObject");
		T result = null;
		ResultSet rs = exec(requete);
		try
		{
			
			if( rs != null && rs.first() )
			{
				System.out.println("[TRACE] DATABASEQUERY: getRequestedObject if rs != null && rs.first()");
				result = (T)getRequestedObjectFromResultSet( rs , c );
			}
		}
		catch(Exception e)
		{
			System.out.println("[EXCEPTION]  DatabaseQuery: getRequestedObject()");
		}	
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends Object> T getRequestedObjectFromResultSet( ResultSet rs , Class<T> c ){
		System.out.println("[TRACE] DATABASEQUERY: getRequestedObjectFromResultSet");
		T object = null;
		if( c == allocoUser.class )
		{
			object = (T)allocoUserFromResultSet( rs );
		}
		//else if( c == VlpUser.class )
		//{
			//object = (T)userFromResultSet( rs );
		//}
		return object;
	}
	
	/*
	private VlpTag tagFromResultSet( ResultSet rs )  {
		VlpTag tag = null;
		try
		{
			//logger.info("Trying to retrieve a tag from a resultset");
			tag= new VlpTag ( rs.getString("buid"),
				VlpTag.TagType.values()[rs.getInt("tagType")] ,
				rs.getString("tagValue"),
				rs.getLong("lastUpdated") );
		}
		catch(Exception e)
		{
			//logger.error("Exception in DatabaseQuery:tagFromResultSet ",e);
		}
		return tag;
	}	
	*/
	
	private allocoUser allocoUserFromResultSet( ResultSet rs ){
		System.out.println("[TRACE] DATABASEQUERY: allocoUserFromResultSet");
		allocoUser user = null;
		try
		{
			user = new allocoUser(
				rs.getString("name"),
				rs.getString("sex"),
				rs.getString("birth"),
				rs.getString("email"),
				rs.getString("password") );	
		}
		catch(Exception e)
		{
			System.out.println("[EXCEPTION]  DatabaseQuery: allocoUserFromResultSet()");
		}
		return user;
	}

	private ResultSet exec(String requete){
		System.out.println("[TRACE] DATABASEQUERY: exec");
		try 
		{
			
			if( this.dbConnect == null ){
				
				System.out.println("[TRACE] DATABASEQUERY: exec this.dbConnect == null");
				return null;
			}
			this.dbStatement = this.dbConnect.createStatement();

			if( this.dbStatement == null ){
				
				System.out.println("[TRACE] DATABASEQUERY: exec this.dbStatement == null");
				return null;
			}

            ResultSet rs = this.dbStatement.executeQuery(requete);
            return rs;
        } 
		catch (Exception e) 
		{
			System.out.println("[EXCEPTION]  DatabaseQuery: exec");
        }
        return null;
	}

	public allocoUser validateUser(String  userName, String password) {
		System.out.println("[TRACE] DATABASEQUERY: validateUser");
		allocoUser user = null;
		
		try {
			System.out.println("UserName:" + userName + "Password: " + password );
			user = getUser(userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[EXCEPTION]  DatabaseQuery: validateUser() SQLException e");
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("[EXCEPTION]  DatabaseQuery: validateUser() Exception e");
			e.printStackTrace();
		}
			
		return user;
	}
	
}
