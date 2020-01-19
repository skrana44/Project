package com.hcl.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hcl.jsh.model.Jdbcutil;
import com.hcl.jsh.model.Pets;

//DAO Implementation class with methods of PetsDAO interface
public class PetsDAOImpl implements PetsDAO 
{

	//Method to add a pet to Pets table
	@Override
	public boolean addPet(Pets p,String userid) 
	{
		Jdbcutil.loaddriver();
		boolean flag = false;
		Connection con = null;
		con=Jdbcutil.getConnection();
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;

		String insertpets = "insert into pets values(?,?,?,?,?,?,?,?)";
		String check = "select pet_id from pets where pet_id='"+p.genPetId(p.getPet_type())+"'";
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(check);
			ps=con.prepareStatement(insertpets);
			if(rs.next())
			{
			flag = false;
			}
			else
			{
			ps.setString(1,p.genPetId(p.getPet_type()));
			ps.setString(2,userid);
			ps.setString(3, p.getPet_name());
			ps.setInt(4, p.getPet_age());
			ps.setString(5, p.getPet_place());
			ps.setString(6, p.getPet_type());
			ps.setString(7, p.getPet_size());
			ps.setString(8, p.getPet_sex());
			int i = ps.executeUpdate();
			
			if(i!=0)
				flag =true;
			}
			

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(ps!=null) 	ps.close();
				if(con!=null)	con.close();
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			}
		}
		return flag;

	}

	//Method to search a pet with different parameters
	@Override
	public ArrayList<Pets> searchPet(Pets p) 
	{
		Jdbcutil.loaddriver();
		Connection con = null;
		con=Jdbcutil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Pets> list2 = new ArrayList<Pets>();

		String searchpets = "select * from pets where pet_type='"+p.getPet_type()+"'";
		if(p.getPet_size()!=null)
		{
			searchpets+=" and pet_size='"+p.getPet_size()+"'";
		}
		if(p.getPet_name()!=null && !p.getPet_name().equals(""))
		{
			searchpets+=" and pet_name='"+p.getPet_name()+"'";
		}
		if(p.getPet_age()!=0)
		{
			searchpets+=" and pet_age="+p.getPet_age()+"";
		}
		if(p.getPet_place()!=null && !p.getPet_place().equals(""))
		{
			searchpets+=" and pet_place='"+p.getPet_place()+"'";
		}
		
		
		try 
		{
			stmt = con.createStatement();
			rs= stmt.executeQuery(searchpets);
			while(rs.next())
			{
			
			    Pets p1 = new Pets();	
				p1.setPet_id(rs.getString(1));
				p1.setUser_id(rs.getString(2));
				p1.setPet_name(rs.getString(3));
				p1.setPet_age(rs.getInt(4));
				p1.setPet_place(rs.getString(5));
				p1.setPet_type(rs.getString(6));
				p1.setPet_size(rs.getString(7));
				p1.setPet_sex(rs.getString(8));
				list2.add(p1);

				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list2;
		
	}

	//Method to list the pets added by user
	@Override
	public ArrayList<Pets> showmyPet(String userid) 
	{
	Jdbcutil.loaddriver();
	Connection con=null;
	con = Jdbcutil.getConnection();
	ResultSet rs=null;
	PreparedStatement ps = null;
	String mypets = "select * from pets where user_id=?";
	ArrayList<Pets> l1 = new ArrayList<>();
	
	
	try 
	{
		ps=con.prepareStatement(mypets);
		ps.setString(1, userid);
		rs = ps.executeQuery();
		while(rs.next())
		{
			Pets p = new Pets();
			p.setPet_id(rs.getString(1));
			rs.getString(2);
			p.setPet_name(rs.getString(3));
			p.setPet_age(rs.getInt(4));
			p.setPet_place(rs.getString(5));
			p.setPet_type(rs.getString(6));
			p.setPet_size(rs.getString(7));
			p.setPet_sex(rs.getString(8));
			
			l1.add(p);
			
		}
		
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return l1;
		
	}

	//Method to buy a pet
	@Override
	public boolean buyPet(String pet_id, String userid) 
	{
		Jdbcutil.loaddriver();
		Connection con=null;
		con = Jdbcutil.getConnection();
		Statement stmt = null;
		ResultSet rs =null;
		PreparedStatement ps =null;
	
		String buy = "delete from pets where pet_id='"+pet_id+"'";
		String result = "select * from pets where pet_id='"+pet_id+"' ";
		String pet_trans = "insert into pet_transactions(pet_type,owner_id,pur_qty,pur_date,pet_id,cust_id) values(?,?,?,now(),?,?)";
		try 
		{
			
			stmt = con.createStatement();
		
			rs = stmt.executeQuery(result);
			ps  = con.prepareStatement(pet_trans);
			while(rs.next())
			{
				
				ps.setString(1,rs.getString("pet_type"));
				ps.setString(2,rs.getString("user_id"));
				ps.setString(3,"1");
				ps.setString(4, pet_id);
				ps.setString(5, userid);
				
				ps.executeUpdate();
				
			}
			stmt.executeUpdate(buy);
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return false;
	}

	//Method to remove a pet added by a user
	@Override
	public boolean removePet(String pet_id) 
	{
		boolean flag = false;
		Jdbcutil.loaddriver();
		Connection con=null;
		con = Jdbcutil.getConnection();
		PreparedStatement ps = null;
		String remove = "delete from pets where pet_id=?";
		
		try 
		{
			
			ps = con.prepareStatement(remove);
			ps.setString(1, pet_id);
			
		int i = 	ps.executeUpdate();
		if(i!=0)
			flag = true;
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return flag;
	}


	//Method to list the purchases made by the specific user
	@Override
	public ArrayList<Pets> purchase_history(String user_id) 
	{
		Jdbcutil.loaddriver();
		Connection con=null;
		con = Jdbcutil.getConnection();
		ResultSet rs=null;
		PreparedStatement ps = null;
		String history = "select * from pet_transactions where cust_id=?";
		ArrayList<Pets> plist = new ArrayList<Pets>();
		try 
		{
			ps=con.prepareStatement(history);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Pets p = new Pets();
				p.setPet_id(rs.getString("pet_id"));
				p.setUser_id(rs.getString("owner_id"));
				plist.add(p);

				
			}
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return plist;
		}

	//Method to fetch data from the static database table to Search page
	@Override
	public ArrayList<Pets> fetch_pet_types() 
	{
		Jdbcutil.loaddriver();
		Connection con=null;
		con = Jdbcutil.getConnection();
		Statement stmt = null;
		ResultSet rs=null;
		String gettypes = "select pet_type from pettypes";
		ArrayList<Pets> pettypelist = new ArrayList<Pets>();
		try 
		{
			stmt=con.createStatement();
			rs = stmt.executeQuery(gettypes);
			while(rs.next())
			{
				Pets p = new Pets();
				p.setPet_type(rs.getString(1));

				pettypelist.add(p);

				
			}
				
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return pettypelist;
	}

	//Method to list and buy all the pets
	@Override
	public ArrayList<Pets> show_all_pets(String userid) 
	{
		Jdbcutil.loaddriver();
		Connection con = null;
		con=Jdbcutil.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;

		ArrayList<Pets> list2 = new ArrayList<Pets>();

		String searchpets = "select * from pets where user_id<>?";
		
		
		try 
		{	ps = con.prepareStatement(searchpets);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
			
			    Pets p1 = new Pets();	
				p1.setPet_id(rs.getString(1));
				p1.setUser_id(rs.getString(2));
				p1.setPet_name(rs.getString(3));
				p1.setPet_age(rs.getInt(4));
				p1.setPet_place(rs.getString(5));
				p1.setPet_type(rs.getString(6));
				p1.setPet_size(rs.getString(7));
				p1.setPet_sex(rs.getString(8));
				list2.add(p1);

				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list2;
	}
}
