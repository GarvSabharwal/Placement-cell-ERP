package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import projectbean.*;

public class coursedatamodel {

	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public coursedatamodel() {
		
		
		
databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int insertcourse(course course)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into course (coursename) values(?)");
			ps.setString(1,course.getCoursename());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert course : "+e);
		}

		return ret;
	}
	public int updatecourse(course course)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update course set coursename=? where courseid=?");
			ps.setString(1, course.getCoursename());
			ps.setString(2,course.getCourseid());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate course : "+e);
			}
		return ret;
	}
	public int deletecourse(String courseid)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("delete from course where courseid=?");
			ps.setString(1, courseid);
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete course : "+e);
			
		}
		return ret;
	}
	public String getcourse(String courseid)
	{
		String ret="0";
		try {
			ps=con.prepareStatement("select * from course where courseid=?");
			ps.setString(1, courseid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ret=rs.getString("coursename");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public ArrayList getAllcourses()
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select * from course");
			rs=ps.executeQuery();
			while(rs.next())
			{
				course course=new course();
				course.setCourseid(rs.getString("courseid"));
				course.setCoursename(rs.getString("coursename"));;
				list.add(course);
			}
		} catch (Exception e) {
			System.out.print("mai yaha hu"+e.getMessage());
		}
		
		return list;
	}

}
