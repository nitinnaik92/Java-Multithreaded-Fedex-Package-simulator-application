package myproject;

import java.util.Scanner;
import java.sql.*;


public class InsertPacket {

	public static void main(String[] args) throws Exception{
		int packagenum;
		// TODO Auto-generated method stub
		System.out.println("------         WELCOME TO PACKAGE DATA ENTRY       --------------\n");
		System.out.println("Enter the number of package details to be entered : ");
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		packagenum = reader.nextInt();
		
		for(int i=0;i<packagenum;i++) {
			packageobject obj=new packageobject(); 
            
			System.out.println("Enter the trackid of the package : ");
			obj.setTrackid(reader.nextInt());
			System.out.println("Enter the source of the package : ");
			obj.setSource(reader.next());
			System.out.println("Enter the destination of the package : ");
			obj.setDestination(reader.next());
			
			String url="jdbc:mysql://localhost:3306/mydatabase?useSSL=false";
			String uname="root";
			String pass="root";
			String query="SELECT * FROM packagedetails";
			String query2="INSERT INTO packagedetails (trackid,Source,Destination) VALUES ("+obj.getTrackid()+"," + "\"" + obj.getSource()+"\"" +","+"\"" +obj.getDestination()+"\"" +")";
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection(url,uname,pass);
	 Statement st=con.createStatement();
	 int output= st.executeUpdate(query2);
	 
	 if( output >=0)
	 System.out.println(" Updated the Package Details Successfully\n");
	ResultSet rs= st.executeQuery(query);
	 rs.next();
	 int trackid=rs.getInt(1);
	 String source=rs.getString(2);
	 String destination=rs.getNString(3);
	System.out.println("trackid : "+trackid+"\nsource : " +source +"\ndestination : "+destination); 
	
		 st.close();
		 con.close();
	}

}
}

