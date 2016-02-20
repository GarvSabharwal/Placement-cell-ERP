package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;



import projectbean.*;

public class tradedatamodel {
	
	
	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public tradedatamodel() {
		
		
		
		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int inserttrade(gtrades trade)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into gtrade (gtradename) values(?)");
			ps.setString(1,trade.getGtradename());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert trade : "+e);
		}

		return ret;
	}
	public int updatetrade(gtrades trade)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update gtrade set gtradename=? where gtradeid=?");
			ps.setString(1, trade.getGtradename());
			ps.setString(2,trade.getGtradeid());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate gtrade : "+e);
			}
		return ret;
	}
	public int deletetrade(String gtradeid)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("delete from gtrade where gtradeid=?");
			ps.setString(1, gtradeid);
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete gtrades : "+e);
			
		}
		return ret;
	}
	public String gettrade(String gtradeid)
	{
		String ret="0";
		try {
			ps=con.prepareStatement("select * from gtrade where gtradeid=?");
			ps.setString(1, gtradeid);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ret=rs.getString("gtradename");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public ArrayList getAllgtrades()
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select * from gtrade");
			rs=ps.executeQuery();
			while(rs.next())
			{
				gtrades trade=new gtrades();
				trade.setGtradeid(rs.getString("gtradeid"));
				trade.setGtradename(rs.getString("gtradename"));;
				list.add(trade);
			}
		} catch (Exception e) {
			System.out.print("mai yaha hu"+e.getMessage());
		}
		
		return list;
	}
		
	}





