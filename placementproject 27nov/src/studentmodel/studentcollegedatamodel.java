package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import projectbean.gcolleges;
import projectbean.studentcollegedetails;;

public class studentcollegedatamodel {

	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
public studentcollegedatamodel() {
		
	databaseconnection dbc=new databaseconnection();
	
	con=dbc.databaseconnection();
		
	}
	public int insertcollegedetails(studentcollegedetails scollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into studentcollegedetails(studentid,gcourse,gtrade,gcollegeid,gpercentage,gbacklogs,gyop) values(?,?,?,?,?,?,?)");
			ps.setString(1,scollege.getStudentid());
			ps.setString(2,scollege.getGcourse());
			ps.setString(3,scollege.getGtrade());
			ps.setString(4,scollege.getGcollegeid());
			ps.setString(6,scollege.getGbacklogs());
			ps.setString(5,scollege.getGpercentage());
			ps.setString(7,scollege.getGyearofpassing());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert gcollegedetails : "+e);
		}

		return ret;
	}
	public int updatestudentcollegedetails(studentcollegedetails scollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update studentcollegedetails set gpercentage=?,gbacklogs=? where studentid=?");
			
			ps.setString(1,scollege.getGpercentage());
			ps.setString(2,scollege.getGbacklogs());
			ps.setString(3,scollege.getStudentid());
		
			
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate studentcollege : "+e);
			}
		return ret;
	}
	
	
	
	public ArrayList getAllcolleges(String studentid)
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select gcourse,gtrade,gcollegename,gpercentage,gbacklogs,gyop from studentcollegedetails inner join gcolleges on studentcollegedetails.gcollegeid=gcolleges.gcollegeid where studentid=?;");
			ps.setString(1, studentid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				studentcollegedetails scollege=new studentcollegedetails();
				scollege.setGcourse(rs.getString("gcourse"));
				scollege.setGtrade(rs.getString("gtrade"));
				scollege.setGcollegename(rs.getString("gcollegename"));
				scollege.setGpercentage(rs.getString("gpercentage"));
				scollege.setGbacklogs(rs.getString("gbacklogs"));
				scollege.setGyearofpassing(rs.getString("gyop"));
				list.add(scollege);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

		
	}


