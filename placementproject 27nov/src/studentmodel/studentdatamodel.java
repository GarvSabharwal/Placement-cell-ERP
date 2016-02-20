package studentmodel;

import java.sql.*;
import java.util.*;

import javax.activation.*;
import javax.servlet.http.HttpSession;

import projectbean.*;

public class studentdatamodel {
	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	public studentdatamodel() {
		// TODO Auto-generated constructor stub
	

		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
	
}
	/////////////////////////personaldetails///////////////
public int insertstudentdetails(studentpersonaldetails student)
{
	int ret=0;
	try {
		ps=con.prepareStatement("insert into studentpersonaldetails(studentid,firstname,lastname,dateofbirth,gender,address,city,state,pincode,mobileno) values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,student.getStudentid());
		ps.setString(2,student.getFisrstname());
		ps.setString(3,student.getLastname());
		ps.setString(4,student.getDateofbirth());
		ps.setString(5,student.getGender());
		ps.setString(6,student.getAddress());
		ps.setString(7,student.getCity());
		ps.setString(8,student.getState());
		ps.setString(9,student.getPincode());
		ps.setString(10,student.getMobileno());
		
		
		ret=ps.executeUpdate();
	} catch (Exception e) {
		System.out.println("insert student : "+e);
	}

	return ret;
}
public int updatestudentdetails(studentpersonaldetails student)
{
	int ret=0;
	try {
		ps=con.prepareStatement("update studentpersonaldetails set fisrstname=?,lastname=?,dateofbirth=?,gender=?,address=?,city=?,state=?,pincode=?,mobileno=? where studentid=?");
		ps.setString(1, student.getFisrstname());
		ps.setString(2, student.getLastname());
		ps.setString(3, student.getDateofbirth());
		ps.setString(4,student.getGender());
		ps.setString(5,student.getAddress());
		ps.setString(6,student.getCity());
		ps.setString(7,student.getState());
		ps.setString(8,student.getPincode());
		ps.setString(9,student.getMobileno());
		ps.setString(10,student.getStudentid());
		ret=ps.executeUpdate();
	} catch (Exception e) {
		System.out.println("udpate department : "+e);
		}
	return ret;
}

public String getstudentdetailById(String studentId)
{
	String ret="0";
	try {
		ps=con.prepareStatement("select mobileno from studentdetails where studentid=?");
		ps.setString(1, studentId);
		rs=ps.executeQuery();
		if(rs.next())
		{
			ret=rs.getString("mobileno");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return ret;
}


/*public int deletestudent(String studentid)
{
	int ret=0;
	try {
		ps=con.prepareStatement("delete studentpersonaldetails where studentid=?");
		ps.setString(1, studentid);
		ret=ps.executeUpdate();
	} catch (Exception e) {
		System.out.println("delete student : "+e);
		
	}
	return ret;
}*/
public ArrayList getallpersonaldetails(String studentid)
{
	list=new ArrayList();
	try {
		ps=con.prepareStatement("select * from studentpersonaldetails where studentid=?");
		ps.setString(1, studentid);
		rs=ps.executeQuery();
		while(rs.next())
		{
			studentpersonaldetails student=new studentpersonaldetails();
		
			student.setFisrstname(rs.getString("firstname"));
			student.setLastname(rs.getString("lastname"));
			student.setDateofbirth(rs.getString("dateofbirth"));
			student.setGender(rs.getString("gender"));
			student.setAddress(rs.getString("address"));
			student.setCity(rs.getString("city"));
			student.setState(rs.getString("state"));
			student.setPincode(rs.getString("pincode"));
			student.setMobileno(rs.getString("mobileno"));
			list.add(student);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return list;
}
/////////////////////////////student registration//////////////////////////////////////////////////////////////////////////////////////////////////


public int registerstudent(studentregistration registerstudent)
{
	int ret=0;
	try {
		ps=con.prepareStatement("insert into registerstudent(username,Emailid,password) values(?,?,?)");
		ps.setString(1, registerstudent.getUsername());
		ps.setString(2,registerstudent.getEmailid());
		ps.setString(3,registerstudent.getPassword());
		
		
		ret=ps.executeUpdate();
	} catch (Exception e) {
		System.out.println("registerstudent : "+e);
	}
	System.out.println(registerstudent.getUsername());
	return ret;
}
/*public int updatestudentdetails(studentdetails student)
{
	int ret=0;
	try {
		ps=con.prepareStatement("update DepartmentDetails set StudentName=?,StudentDob=?,StudentEmail=?,StudentPhone=?,StudentGender=?,TenthRollno=?,Tenthper=?,TwelveRollno=?,Twelvwper=?,CollegeCourse=?,University=?,CollegeName=?,Graduationper=?,YearofPassing=? where StudentId=?");
		ps.setString(1, student.getStudentName());
		ps.setString(2, student.getStudentDob());
		ps.setString(3, student.getStudentEmail());
		ps.setString(4,student.getStudentPhone());
		ps.setString(5,student.getStudentGender());
		ps.setString(6,student.getTenthRollno());
		ps.setString(7,student.getTentehper());
		ps.setString(8,student.getTwelveRollno());
		ps.setString(9,student.getTwelveper());
		ps.setString(10,student.getCollegeCourse());
		ps.setString(11,student.getUniversity());
		ps.setString(12,student.getCollegeName());
		ps.setString(13,student.getGraduationper());
		ps.setString(14,student.getYearofPassing());
		ps.setString(15,student.getStudenId());
		ret=ps.executeUpdate();
	} catch (Exception e) {
		System.out.println("udpate department : "+e);
		}
	return ret;
}
public int deleteDepartment(String departmentID)
{
	int ret=0;
	try {
		ps=con.prepareStatement("delete DepartmentDetails where iDepartmentID=?");
		ps.setString(1, departmentID);
		ret=ps.executeUpdate();
	} catch (Exception e) {
		System.out.println("delete department : "+e);
		
	}
	return ret;
}*/

public String getstudentregistrationid(String emailid)
{
	
	String ret="0";
	try {
		ps=con.prepareStatement("select studentid from registerstudent where emailID=?");
		ps.setString(1, emailid);
		rs=ps.executeQuery();
		if(rs.next())
		{
			ret=rs.getString("studentid");
		}
		System.out.println(ret);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return ret;
}
public ArrayList getstudentusername()
{
	list=new ArrayList();
	
	try {
		ps=con.prepareStatement("select username from resgisterstudent ");
		rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(rs.getString("username"));
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return list;
}


public ArrayList getstudentinitaldetails(String studentid)
{
	list=new ArrayList();
	String ret="0";
	try {
		ps=con.prepareStatement("select * from resgisterstudent where studentid=?");
		ps.setString(1, studentid);
		rs=ps.executeQuery();
		while(rs.next())
		{
			studentregistration student=new studentregistration();
			student.setUsername(rs.getString("username"));
			student.setEmailid(rs.getString("emailid"));
			student.setPassword(rs.getString("password"));
			list.add(student);
		}
		System.out.println(ret);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return list;
}
public String getstudentdetails(String emailid)
{
	
	String ret="0";
	try {
		ps=con.prepareStatement("select * from resgisterstudent where emailid=?");
		ps.setString(1, emailid);
		rs=ps.executeQuery();
		if(rs.next())
		{
			studentregistration student=new studentregistration();
			ret=rs.getString("password");
			
		}
		System.out.println(ret);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return ret;
}


















}