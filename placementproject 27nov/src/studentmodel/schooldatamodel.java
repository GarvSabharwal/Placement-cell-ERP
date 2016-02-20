package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;



import projectbean.*;

public class schooldatamodel {
	
	
	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public schooldatamodel() {
		
		
		
		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int insertschooldetaisl(schooldetails sd)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into studentschooldetails (studentid,tenrollno,tenper,twelverollno,twelveper) values(?,?,?,?,?)");
			ps.setString(1,sd.getStudentid());
			ps.setString(2,sd.getTenrollno());
			ps.setString(3,sd.getTenper());
			ps.setString(4,sd.getTwelverollno());
			ps.setString(5,sd.getTwelveper());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert college : "+e);
		}

		return ret;
	}
	
	public ArrayList getAll(String studentid)
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select tenper,twelveper from studentschooldetails where studentid=?");
			ps.setString(1, studentid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				schooldetails sd=new schooldetails();
				sd.setTenper(rs.getString("tenper"));
			sd.setTwelveper(rs.getString("twelveper"));
				list.add(sd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
		
	}





