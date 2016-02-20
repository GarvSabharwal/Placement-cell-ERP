package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import projectbean.diplomacolleges;
import projectbean.studentdiplomadetails;

public class studentdiplomadatamodel {

	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
public studentdiplomadatamodel() {
		
	databaseconnection dbc=new databaseconnection();
	
	con=dbc.databaseconnection();
		
	}
	public int insertstudentdiplomadetails(studentdiplomadetails sdiploma)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into studentdiplomadetails(studentid,trade,dcollegeid,percentage,yop) values(?,?,?,?,?)");
			ps.setString(1,sdiploma.getStudentid());
			ps.setString(2,sdiploma.getDtrade());
			ps.setString(3,sdiploma.getDcollegeid());
			ps.setString(4,sdiploma.getPercentage());
			ps.setString(5,sdiploma.getYearofpassing());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert diplomadetails : "+e);
		}

		return ret;
	}
	/*public int updatestudentdiplomadetails(studentdiplomadetails sdiploma)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update studentdiplomadetails set percentage=?,backlogs=? where studentid=?");
			
		
			ps.setString(1,sdiploma.getPercentage());
			ps.setString(2,sdiploma.getBacklogs());
			ps.setString(3,sdiploma.getStudentid());
			
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate studentdiploma : "+e);
			}
		return ret;
	}
	
	
	*/
	public ArrayList getAlldiplomacolleges(String studentid)
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select dcollegename,trade, percentage,yop from studentdiplomadetails inner join diplomacolleges on studentdiplomadetails.dcollegeid=diplomacolleges.dcollegeid where studentid=?");
			ps.setString(1, studentid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				studentdiplomadetails sdiploma=new studentdiplomadetails();
				
				sdiploma.setDcollegename(rs.getString("dcollegename"));
				sdiploma.setDtrade(rs.getString("trade"));
				sdiploma.setPercentage(rs.getString("percentage"));
				sdiploma.setYearofpassing(rs.getString("yop"));
				
				list.add(sdiploma);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

		
	}


