package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;



import projectbean.pgcolleges;

public class pgcollegedatamodel {
	
	
	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public pgcollegedatamodel() {
		
		
		
		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int insertpgcollege(pgcolleges pgcollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into pgcolleges(pgcollegename) values(?)");
			ps.setString(1,pgcollege.getPgcollegename());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert pgcollege : "+e);
		}

		return ret;
	}
	public int updatepgcollege(pgcolleges pgcollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update pgcolleges set pgcollegename=? where pgcollegeid=?");
			ps.setString(1, pgcollege.getPgcollegename());
			ps.setString(2,pgcollege.getPgcollegeid());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate pgcollege : "+e);
			}
		return ret;
	}
	public int deletepgcollege(String pgcollegeid)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("delete from pgcolleges where pgcollegeid=?");
			ps.setString(1, pgcollegeid);
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete pgcolleges : "+e);
			
		}
		return ret;
	}
	public String getpgcollege(String pgcollegeid)
	{
		String ret="0";
		try {
			ps=con.prepareStatement("select * from pgcolleges where pgcollegeid=?");
			ps.setString(1, pgcollegeid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ret=rs.getString("pgcollegename");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public ArrayList getAllpgcolleges()
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select * from pgcolleges");
			rs=ps.executeQuery();
			while(rs.next())
			{
				pgcolleges pgcollege=new pgcolleges();
				pgcollege.setPgcollegeid(rs.getString("pgcollegeid"));
				pgcollege.setPgcollegename(rs.getString("pgcollegename"));
				list.add(pgcollege);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
		
	}





