package edu.osu;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.EJB;






import examples.cse769.EJB.Service.RatingManager;

public class RatingBean {

	@EJB 
	private RatingManager ratingManager;
	private String rating;
	private String comment;
	private String date;

	
	private LoginBean logBean;
	private BarBean barBean;
	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}
	
	public BarBean getBarBean() {
		return barBean;
	}

	public void setBarBean(BarBean barBean) {
		this.barBean = barBean;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public String add() {
		
		int ratingnum = Integer.parseInt(rating);
		Calendar c = new GregorianCalendar();
		Date today = c.getTime();
		
		setDate(today.toString());
		System.out.println(String.valueOf(barBean.getBarid()));
		System.out.println(String.valueOf(logBean.getUserid()));
		
		String ret = ratingManager.add(ratingnum, comment, date, barBean.getBarid(), logBean.getUserid());
		
		if(!ret.equalsIgnoreCase("fail"))
			return "true";
			else 
				return "false";

	}
	
}
