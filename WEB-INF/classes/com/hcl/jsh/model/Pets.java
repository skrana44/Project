package com.hcl.jsh.model;



public class Pets
{
	private String pet_id;
	private String user_id;
	private String pet_name;
	private int pet_age;
	private String pet_place;
	private String pet_type;
	private String pet_size;
	private String pet_sex;
	
	public Pets(String pet_id,String user_id, String pet_name, int pet_age, String pet_place,
			String pet_type, String pet_size, String pet_sex) {
		super();
		this.pet_id = pet_id;
		this.user_id = pet_id;
		this.pet_name = pet_name;
		this.pet_age = pet_age;
		this.pet_place = pet_place;
		this.pet_type = pet_type;
		this.pet_size = pet_size;
		this.pet_sex = pet_sex;
	}
	public Pets() {}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPet_id() {
		return pet_id;
	}
	public void setPet_id(String pet_id) {
		this.pet_id = pet_id;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	public int getPet_age() {
		return pet_age;
	}
	public void setPet_age(int pet_age) {
		this.pet_age = pet_age;
	}
	public String getPet_place() {
		return pet_place;
	}
	public void setPet_place(String pet_place) {
		this.pet_place = pet_place;
	}
	public String getPet_type() {
		return pet_type;
	}
	public void setPet_type(String pet_type) {
		this.pet_type = pet_type;
	}
	public String getPet_size() {
		return pet_size;
	}
	public void setPet_size(String pet_size) {
		this.pet_size = pet_size;
	}
	public String getPet_sex() {
		return pet_sex;
	}
	public void setPet_sex(String pet_sex) {
		this.pet_sex = pet_sex;
	}

	@Override
	public String toString() {
		return "Pets [pet_name=" + pet_name + ", pet_age=" + pet_age
				+ ", pet_place=" + pet_place + ", pet_type=" + pet_type
				+ ", pet_size=" + pet_size + ", pet_sex=" + pet_sex
				+  "]";
	}	
	
	public String genPetId(String pet_type)
	{
		String pet_id = "";
		Character x = pet_type.charAt(0);
		String s=x.toString();
		
		pet_id = s +(int)((Math.random()*8999)+1000);
		return pet_id.toUpperCase();
	}
}
