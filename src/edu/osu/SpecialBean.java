package edu.osu;

import java.util.List;

import javax.ejb.EJB;

import examples.cse769.EJB.Service.ItemManager;
public class SpecialBean {

	private int specialid;
	private String title;
	private List<List<String>> items;
	@EJB
	private ItemManager itemManager;
	public int getSpecialid() {
		return specialid;
	}
	public void setSpecialid(int specialid) {
		this.specialid = specialid;
	}
	public List<List<String>> getItems() {
		return items;
	}
	public void setItems(List<List<String>> items) {
		this.items = items;
	}
	
	public String findItem() {
		
		items = itemManager.findForSpecial(specialid);
		
		if(items.isEmpty())
			return "false";
		
		else
		{return "true";}
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
