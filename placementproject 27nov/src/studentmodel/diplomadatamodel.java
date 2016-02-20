package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import projectbean.diplomacolleges;

public class diplomadatamodel {
	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public diplomadatamodel() {
		
		
		
		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int insertdiplomacollege(diplomacolleges diploma)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into diplomacolleges(dcollegename) values(?)");
			ps.setString(1,diploma.getDcollegename());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert diplomacollege : "+e);
		}

		return ret;
	}
	public int updatesdiplomacollege(diplomacolleges diploma)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update diplomacolleges set dcollegename=?dcollegeid=?");
			ps.setString(1, diploma.getDcollegename());
			ps.setString(2,diploma.getDcollegeid());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate department : "+e);
			}
		return ret;
	}
	public int deletediplomacollege(String dcollegeid)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("delete from diplomacolleges where dcollegeid=?");
			ps.setString(1, dcollegeid);
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete department : "+e);
			
		}
		return ret;
	}
	public String getdiplomacollege(String dcollegeid)
	{
		String ret="0";
		try {
			ps=con.prepareStatement("select * from diplomacolleges where dcollegeid=?");
			ps.setString(1, dcollegeid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ret=rs.getString("dcollegename");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public ArrayList getAlldiplomacolleges()
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select * from diplomacolleges");
			rs=ps.executeQuery();
			while(rs.next())
			{
				diplomacolleges diploma=new diplomacolleges();
				diploma.setDcollegeid(rs.getString("dcollegeid"));
				diploma.setDcollegename(rs.getString("dcollegename"));
				list.add(diploma);
			}
		} catch (Exception e) 
		{
			
		}
		
		return list;
	}
		
	}


