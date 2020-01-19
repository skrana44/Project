package com.hcl.jsh.dao;

import java.util.ArrayList;

import com.hcl.jsh.model.Pets;

public interface PetsDAO 
{
	public boolean addPet(Pets p,String userid);
	public ArrayList<Pets> searchPet(Pets p);
	public ArrayList<Pets> showmyPet(String userid);
	public boolean buyPet(String pet_id, String userid);
	public boolean removePet(String pet_id);
	public ArrayList<Pets> purchase_history(String user_id);
	public ArrayList<Pets> fetch_pet_types();
	public ArrayList<Pets> show_all_pets(String userid);
	
}
