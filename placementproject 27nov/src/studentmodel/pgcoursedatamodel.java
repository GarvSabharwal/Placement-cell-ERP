package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import projectbean.*;

public class pgcoursedatamodel {

	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public pgcoursedatamodel() {
		
		
		
		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int insertpgcourse(pgcourse course)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into pgcourse (pgcoursename) values(?)");
			ps.setString(1,course.getPgcoursename());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert course : "+e);
		}

		return ret;
	}
	public int updatepgcourse(pgcourse course)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update pgcourse set pgcoursename=? where pgcourseid=?");
			ps.setString(1, course.getPgcoursename());
			ps.setString(2,course.getPgcourseid());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate course : "+e);
			}
		return ret;
	}
	public int deletepgcourse(String pgcourseid)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("delete from pgcourse where pgcourseid=?");
			ps.setString(1, pgcourseid);
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete course : "+e);
			
		}
		return ret;
	}
	public String getpgcourse(String pgcourseid)
	{
		String ret="0";
		try {
			ps=con.prepareStatement("select * from pgcourse where pgcourseid=?");
			ps.setString(1, pgcourseid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ret=rs.getString("pgcoursename");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public ArrayList getpgAllcourses()
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select * from pgcourse");
			rs=ps.executeQuery();
			while(rs.next())
			{
				pgcourse course=new pgcourse();
				course.setPgcourseid(rs.getString("pgcourseid"));
				course.setPgcoursename(rs.getString("pgcoursename"));;
				list.add(course);
			}
		} catch (Exception e) {
			System.out.print("mai yaha hu"+e.getMessage());
		}
		
		return list;
	}

}
