package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import projectbean.gcolleges;
import projectbean.studentpgcollegedetails;;

public class studentpgcollegedatamodel {

	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
public studentpgcollegedatamodel() {
		
	databaseconnection dbc=new databaseconnection();
	
	con=dbc.databaseconnection();
		
	}
	public int insertpgcollegedetails(studentpgcollegedetails spgcollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into studentpgcollegedetails(studentid,pgcourse,pgcollegeid,pgtrade,pgpercentage,pgbacklogs,pgyop) values(?,?,?,?,?,?,?)");
			ps.setString(1,spgcollege.getStudentid());
			ps.setString(2,spgcollege.getPgcourse());
			ps.setString(3,spgcollege.getPgtrade());
			ps.setString(4,spgcollege.getPgcollegeid());
			ps.setString(5,spgcollege.getPgpercentage());
			ps.setString(6,spgcollege.getPgbacklogs());
			ps.setString(7,spgcollege.getPgyearofpassing());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert pgcollegedetails : "+e);
		}

		return ret;
	}
	public int updatestudentpgdetails(studentpgcollegedetails spgcollege)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update studentpgcollegedetails set pgpercentage=?,pgbacklogs=? where studentid=?");
			
			ps.setString(1,spgcollege.getPgpercentage());
			ps.setString(2,spgcollege.getPgbacklogs());
			ps.setString(3,spgcollege.getStudentid());
		
			
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate studentpgcollege : "+e);
			}
		return ret;
	}
	
	
	
	public ArrayList getAllpgcolleges(String studentid)
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select pgcourse,pgtrade,pgcollegename,pgpercentage,pgbacklogs,pgyop from studentpgcollegedetails inner join pgcolleges on studentpgcollegedetails.pgcollegeid=pgcolleges.pgcollegeid where studentid=?");
			ps.setString(1, studentid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				studentpgcollegedetails spgcollege=new studentpgcollegedetails();
				spgcollege.setPgcourse(rs.getString("pgcourse"));
				spgcollege.setPgtrade(rs.getString("pgtrade"));
				spgcollege.setPgcollegename(rs.getString("pgcollegename"));
				spgcollege.setPgpercentage(rs.getString("pgpercentage"));
				spgcollege.setPgbacklogs(rs.getString("pgbacklogs"));
				spgcollege.setPgyearofpassing(rs.getString("pgyearofpassing"));
				list.add(spgcollege);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

		
	}


