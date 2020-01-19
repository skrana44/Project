package com.hcl.jsh.actions;

import java.util.ArrayList;

import com.hcl.jsh.dao.PetsDAOImpl;
import com.hcl.jsh.model.Pets;

public class PetService 
{
	PetsDAOImpl pdi=new PetsDAOImpl();
	
	public ArrayList<Pets> fetch_pets()
	{
		return pdi.fetch_pet_types();
	}
	
	public boolean insert_pet(Pets p,String userid)
	{
		return pdi.addPet(p, userid);
	}
	public ArrayList<Pets> search_Pets(Pets p)
	{
		return pdi.searchPet(p);
	}
	public ArrayList<Pets> my_Pet(String userid)
	{
		return pdi.showmyPet(userid);
	}
	public boolean pet_buy(String pet_id, String userid)
	{
		return pdi.buyPet(pet_id, userid);
	}
	public boolean remove(String pet_id)
	{
		return pdi.removePet(pet_id);
	}
	public ArrayList<Pets> history(String user_id)
	{
		return pdi.purchase_history(user_id);
	}
	public ArrayList<Pets> show_all(String user_id)
	{
		return pdi.show_all_pets(user_id);
	}

}
