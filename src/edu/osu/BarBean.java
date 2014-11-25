package edu.osu;

import java.util.List;

import javax.ejb.EJB;

import examples.cse769.EJB.Service.RatingManager;
import examples.cse769.EJB.Service.MenuManager;
import examples.cse769.EJB.Service.SpecialManager;
import examples.cse769.EJB.Service.ActivityManager;
import examples.cse769.EJB.Service.EventManager;

public class BarBean {

	private int barid;
	private String name;
	private List<List<String>> ratings;
	private List<List<String>> menus;
	private List<List<String>> specials;
	private List<List<String>> activities;
	private List<List<String>> events;
	@EJB 
	private RatingManager ratingManager;
	@EJB 
	private MenuManager menuManager;
	@EJB
	private SpecialManager specialManager;
	@EJB
	private ActivityManager activityManager;
	@EJB
	private EventManager eventManager;
	
	public int getBarid() {
		return barid;
	}
	public void setBarid(int barid) {
		this.barid = barid;
	}
	public List<List<String>> getRatings() {
		return ratings;
	}
	public void setRatings(List<List<String>> ratings) {
		this.ratings = ratings;
	}
	public List<List<String>> getMenus() {
		return menus;
	}
	public void setMenus(List<List<String>> menus) {
		this.menus = menus;
	}
	public List<List<String>> getSpecials() {
		return specials;
	}
	public void setSpecials(List<List<String>> specials) {
		this.specials = specials;
	}
	public List<List<String>> getActivities() {
		return activities;
	}
	public void setActivities(List<List<String>> activities) {
		this.activities = activities;
	}
	public List<List<String>> getEvents() {
		return events;
	}
	public void setEvents(List<List<String>> events) {
		this.events = events;
	}
	
	public String findMenu() {
		
		menus = menuManager.findForBar(barid);
		
		if(menus.isEmpty())
			return "false";
		
		else
		{return "menu";}
	}
	
	public String findSpecial() {
		
		specials = specialManager.findForBar(barid);
		
		if(specials.isEmpty())
			return "false";
		
		else
		{return "special";}
	}
	
	public String findActivity() {
		
		activities = activityManager.findForBar(barid);
		
		if(activities.isEmpty())
			return "false";
		
		else
		{return "activity";}
	}
	public String findEvent() {
		
		events = eventManager.findForBar(barid);
		
		if(events.isEmpty())
			return "false";
		
		else
		{return "event";}
	}
	public String findRating() {
		
		ratings = ratingManager.findForBar(barid);
		
		if(ratings.isEmpty())
			return "ratingfail";
		
		else
		{return "rating";}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
