package studentmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import projectbean.*;

public class yopdatamodel {

	ArrayList list;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	HttpSession session;
	
	public yopdatamodel() {
		
		
		
		databaseconnection dbc=new databaseconnection();
		
		con=dbc.databaseconnection();
		
	}
	public int insertyop(yop yop)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("insert into yop (yop) values(?)");
			ps.setString(1,yop.getYop());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert yop : "+e);
		}

		return ret;
	}
	public int updateyop(yop yop)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("update yop set yop=? where yopid=?");
			ps.setString(1, yop.getYop());
			ps.setString(2,yop.getYpoid());
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("udpate yop : "+e);
			}
		return ret;
	}
	public int deleteyop(String yopid)
	{
		int ret=0;
		try {
			ps=con.prepareStatement("delete from yop where yopid=?");
			ps.setString(1, yopid);
			ret=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete yop : "+e);
			
		}
		return ret;
	}
	public String getyop(String yop)
	{
		String ret="0";
		try {
			ps=con.prepareStatement("select * from yop where yopid=?");
			ps.setString(1, yop);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ret=rs.getString("yop");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ret;
	}
	public ArrayList getAllyop()
	{
		list=new ArrayList();
		try {
			ps=con.prepareStatement("select * from yop");
			rs=ps.executeQuery();
			while(rs.next())
			{
				yop yop=new yop();
				yop.setYpoid(rs.getString("yopid"));
				yop.setYop(rs.getString("yop"));;
				list.add(yop);
			}
		} catch (Exception e) {
			System.out.print("mai yaha hu"+e.getMessage());
		}
		
		return list;
	}


}
