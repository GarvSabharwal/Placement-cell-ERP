package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import projectbean.gcolleges;

public class collegedatamodel {
	
	
	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public collegedatamodel() {
		
		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int insertcollege(gcolleges gcollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into gcolleges (gcollegename) values(?)");
			ps.setString(1,gcollege.getCollegename());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert college : "+e);
		}

		return ret;
	}
	public int updatecollege(gcolleges gcollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update gcolleges set gcollegename=? where gcollegeid=?");
			ps.setString(1, gcollege.getCollegename());
			ps.setString(2,gcollege.getCollegeid());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate college : "+e);
			}
		return ret;
	}
	public int deletecollege(String gcollegeid)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("delete from gcolleges where gcollegeid=?");
			ps.setString(1, gcollegeid);
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete colleges : "+e);
			
		}
		return ret;
	}
	public String getcollege(String gcollegeid)
	{
		String ret="0";
		try {
			ps=con.prepareStatement("select * from gcolleges where gcollegeid=?");
			ps.setString(1, gcollegeid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ret=rs.getString("gcollegename");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public ArrayList getAllgcolleges()
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select * from gcolleges");
			rs=ps.executeQuery();
			while(rs.next())
			{
				gcolleges college=new gcolleges();
				college.setCollegeid(rs.getString("gcollegeid"));
				college.setCollegename(rs.getString("gcollegename"));;
				list.add(college);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
		
	}





