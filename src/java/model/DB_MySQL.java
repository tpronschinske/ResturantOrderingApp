/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Travis
 */
public class DB_MySQL implements DatabaseAccess {
    private Connection conn;

	/**
	 * Default constructor should be used when you do not want to
	 * immediately open a connection to the database. When the
	 * connection is needed, call the openConnection method.
	 */
	public DB_MySQL() {}
	
	

	public void openConnection(String driverClassName, String url, String username, String password) 
	throws IllegalArgumentException, ClassNotFoundException, SQLException
	{
		String msg = "Error: url is null or zero length!";
		if( url == null || url.length() == 0 ) throw new IllegalArgumentException(msg);
		username = (username == null) ? "" : username;
		password = (password == null) ? "" : password;
		Class.forName (driverClassName);
		conn = DriverManager.getConnection(url, username, password);
	}
		
	public void closeConnection() throws SQLException {
		conn.close();
	}

	public List findRecords(String sqlString, boolean closeConnection) 
	throws SQLException, Exception
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		final List list = new ArrayList();
		Map record = null;

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlString);
			metaData = rs.getMetaData();
			final int fields = metaData.getColumnCount();

			while( rs.next() ) {
				record = new HashMap();
				for( int i=1; i <= fields; i++ ) {
					try {
						record.put( metaData.getColumnName(i), rs.getObject(i) );
					} catch(NullPointerException npe) { 
						// no need to do anything... if it fails, just ignore it and continue
					}
				} // end for
				list.add(record);
			} // end while

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				stmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return list; // will  be null if none found
	}



	public Map getRecordByID(String table, String primaryKeyField, Object keyValue, boolean closeConnection)
	throws SQLException, Exception
	{
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		final Map record=new HashMap();

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			stmt = conn.createStatement();
			String sql2;

			if(keyValue instanceof String){
				sql2 = "= '" + keyValue + "'";}
			else {
				sql2 = "=" + keyValue;}

			final String sql="SELECT * FROM " + table + " WHERE " + primaryKeyField + sql2;
			rs = stmt.executeQuery(sql);
			metaData = rs.getMetaData();
			metaData.getColumnCount();
			final int fields=metaData.getColumnCount();

			// Retrieve the raw data from the ResultSet and copy the values into a Map
			// with the keys being the column names of the table.
			if(rs.next() ) {
				for( int i=1; i <= fields; i++ ) {
					record.put( metaData.getColumnName(i), rs.getObject(i) );
				}
			}

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				stmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return record;
	}


	public boolean insertRecord(String tableName, List colDescriptors, List colValues, boolean closeConnection)
	throws SQLException, Exception
	{
		PreparedStatement pstmt = null;
		int recsUpdated = 0;

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			pstmt = buildInsertStatement(conn,tableName,colDescriptors);

			final Iterator i=colValues.iterator();
			int index = 1;
			while( i.hasNext() ) {
				final Object obj=i.next();
				if(obj instanceof String){
					pstmt.setString( index++,(String)obj );
				} else if(obj instanceof Integer ){
					pstmt.setInt( index++,((Integer)obj).intValue() );
				} else if(obj instanceof Long ){
					pstmt.setLong( index++,((Long)obj).longValue() );
				} else if(obj instanceof Double ){
					pstmt.setDouble( index++,((Double)obj).doubleValue() );
				} else if(obj instanceof java.sql.Date ){
					pstmt.setDate(index++, (java.sql.Date)obj );
				} else if(obj instanceof Boolean ){
					pstmt.setBoolean(index++, ((Boolean)obj).booleanValue() );
				} else {
					if(obj != null) pstmt.setObject(index++, obj);
				}
			}
			recsUpdated = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		if(recsUpdated == 1){
			return true;
		} else {
			return false;
		}
	}



	public int updateRecords(String tableName, List colDescriptors, List colValues,
							 String whereField, Object whereValue, boolean closeConnection)
							 throws SQLException, Exception
	{
		PreparedStatement pstmt = null;
		int recsUpdated = 0;

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			pstmt = buildUpdateStatement(conn,tableName,colDescriptors,whereField);

			final Iterator i=colValues.iterator();
			int index = 1;
			boolean doWhereValueFlag = false;
			Object obj = null;

			while( i.hasNext() || doWhereValueFlag) {
				if(!doWhereValueFlag){ obj = i.next();}

				if(obj instanceof String){
					pstmt.setString( index++,(String)obj );
				} else if(obj instanceof Integer ){
					pstmt.setInt( index++,((Integer)obj).intValue() );
				} else if(obj instanceof Long ){
					pstmt.setLong( index++,((Long)obj).longValue() );
				} else if(obj instanceof Double ){
					pstmt.setDouble( index++,((Double)obj).doubleValue() );
				} else if(obj instanceof java.sql.Timestamp ){
					pstmt.setTimestamp(index++, (java.sql.Timestamp)obj );
				} else if(obj instanceof java.sql.Date ){
					pstmt.setDate(index++, (java.sql.Date)obj );
				} else if(obj instanceof Boolean ){
					pstmt.setBoolean(index++, ((Boolean)obj).booleanValue() );
				} else {
					if(obj != null) pstmt.setObject(index++, obj);
				}

				if(doWhereValueFlag){ break;} // only allow loop to continue one time
				if(!i.hasNext() ) {          // continue loop for whereValue
					doWhereValueFlag = true;
					obj = whereValue;
				}
			}

			recsUpdated = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return recsUpdated;
	}


	
	public int deleteRecords(String tableName, String whereField, Object whereValue, boolean closeConnection)
	throws SQLException, Exception
	{
		PreparedStatement pstmt = null;
		int recsDeleted = 0;

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			pstmt = buildDeleteStatement(conn,tableName,whereField);

			// delete all records if whereField is null
			if(whereField != null ) {
				if(whereValue instanceof String){
					pstmt.setString( 1,(String)whereValue );
				} else if(whereValue instanceof Integer ){
					pstmt.setInt( 1,((Integer)whereValue).intValue() );
				} else if(whereValue instanceof Long ){
					pstmt.setLong( 1,((Long)whereValue).longValue() );
				} else if(whereValue instanceof Double ){
					pstmt.setDouble( 1,((Double)whereValue).doubleValue() );
				} else if(whereValue instanceof java.sql.Date ){
					pstmt.setDate(1, (java.sql.Date)whereValue );
				} else if(whereValue instanceof Boolean ){
					pstmt.setBoolean(1, ((Boolean)whereValue).booleanValue() );
				} else {
					if(whereValue != null) pstmt.setObject(1, whereValue);
				}
			}

			recsDeleted = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return recsDeleted;
	}


	private PreparedStatement buildInsertStatement(Connection conn_loc, String tableName, List colDescriptors)
	throws SQLException {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		(sql.append(tableName)).append(" (");
		final Iterator i=colDescriptors.iterator();
		while( i.hasNext() ) {
			(sql.append( (String)i.next() )).append(", ");
		}
		sql = new StringBuffer( (sql.toString()).substring( 0,(sql.toString()).lastIndexOf(", ") ) + ") VALUES (" );
		for( int j = 0; j < colDescriptors.size(); j++ ) {
			sql.append("?, ");
		}
		final String finalSQL=(sql.toString()).substring(0,(sql.toString()).lastIndexOf(", ")) + ")";
		//System.out.println(finalSQL);
		return conn_loc.prepareStatement(finalSQL);
	}


	private PreparedStatement buildUpdateStatement(Connection conn_loc, String tableName,
												   List colDescriptors, String whereField)
	throws SQLException {
		StringBuffer sql = new StringBuffer("UPDATE ");
		(sql.append(tableName)).append(" SET ");
		final Iterator i=colDescriptors.iterator();
		while( i.hasNext() ) {
			(sql.append( (String)i.next() )).append(" = ?, ");
		}
		sql = new StringBuffer( (sql.toString()).substring( 0,(sql.toString()).lastIndexOf(", ") ) );
		((sql.append(" WHERE ")).append(whereField)).append(" = ?");
		final String finalSQL=sql.toString();
		return conn_loc.prepareStatement(finalSQL);
	}


	private PreparedStatement buildDeleteStatement(Connection conn_loc, String tableName, String whereField)
	throws SQLException {
		final StringBuffer sql=new StringBuffer("DELETE FROM ");
		sql.append(tableName);

		// delete all records if whereField is null
		if(whereField != null ) {
			sql.append(" WHERE ");
			(sql.append( whereField )).append(" = ?");
		}

		final String finalSQL=sql.toString();
//		System.out.println(finalSQL);
		return conn_loc.prepareStatement(finalSQL);
	}
        
        public static void main(String[] args) throws Exception {
            DB_MySQL db = new DB_MySQL();
            db.openConnection("com.mysql.jdbc.Driver", 
                    "jdbc:mysql://localhost:3306/restaurant", 
                    "root", "admin");
            
            List records = db.findRecords("select * from menu_item", true);
            
            System.out.println(records);
        }
        


} // end class

