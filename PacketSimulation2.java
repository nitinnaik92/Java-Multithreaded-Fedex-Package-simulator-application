package myproject;

import java.util.*;
import java.sql.*;

class PacketSimulation2 implements Runnable{
   
	String resultset=new String();
	ArrayList <Integer> pathlist=new ArrayList<Integer>(); 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
	    String path=null;
		String url="jdbc:mysql://localhost:3306/mydatabase?useSSL=false";
		String uname="root";
		String pass="root";
		String query="UPDATE packagedetails SET Present="+path+"\"";
        try {Class.forName("com.mysql.cj.jdbc.Driver");}catch(Exception e){}
        Connection con=DriverManager.getConnection(url,uname,pass);
		 Statement st=con.createStatement();
//		 int output= st.executeUpdate(query); 
		 
		packageobject packet=new packageobject();
		ResultSet rs= st.executeQuery("SELECT * FROM PACKAGEDETAILS WHERE TRACKID=1091");
		Dijkstra obj=new Dijkstra();
		System.out.println("Execute loop");
		while(rs.next()) {
			
			 int trackid=rs.getInt(1);
			 String source=rs.getString(2);
			 String destination=rs.getNString(3);
			 pathlist=obj.getShortestPath(obj.Cityid(source),obj.Cityid(destination));
			 for(int i=0;i<pathlist.size();i++) {
			 path=obj.cityName(pathlist.get(i));
			 
			 System.out.println(path);
			 System.out.println();
			 resultset+= "  \n" + path;
			 int out= st.executeUpdate("UPDATE packagedetails SET Present= \"" + resultset + "\" WHERE TRACKID =" + trackid);
			 
			 Thread.sleep(5000);
			 }
		System.out.println(resultset);
			
	}
				rs.close();
	}
		
	
	catch(SQLException se) {
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	
}

