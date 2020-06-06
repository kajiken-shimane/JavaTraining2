package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DB {

	static public Map<String,String> getDB(String sql) throws ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
        ResultSet rs = null;
        Map<String,String> columList =  new HashMap<String,String>();

	    //接続文字列
	    String url = "jdbc:postgresql://localhost:5432/mydb";
	    String user = "postgres";
	    String password = "postgres";

	    try{
	    	//Driver読み込み
	    	Class.forName("org.postgresql.Driver");

	        //PostgreSQLへ接続
	        conn = DriverManager.getConnection(url, user, password);

	        //自動コミットOFF
	        conn.setAutoCommit(false);

	      //SELECT文の実行
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            //SELECT結果の受け取り
            while(rs.next()){
            	ResultSetMetaData rsmd = rs.getMetaData();
            	int numberOfColumns = rsmd.getColumnCount();

            	for(int i=0;i<numberOfColumns;i++) {
            		String columName = rsmd.getColumnName(i+1);
            		String columValue = rs.getString(columName);
            		columList.put(columName, columValue);
            	}
            }
	    }
	    catch (SQLException e){
	        e.printStackTrace();
	    }
	    finally {
	        try {
	        	if(rs != null)rs.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
	    }

	    return columList;
	}
}
