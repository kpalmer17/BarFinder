package edu.osu;

import javax.ejb.EJB;



import examples.cse769.EJB.Service.RatingManager;

public class RatingBean {

	@EJB 
	private RatingManager ratingManager;
	private String rating;
	private String comment;
	private String date;
	private String barid;
	
	private LoginBean logBean;

	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
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

	public String getBarid() {
		return barid;
	}

	public void setBarid(String barid) {
		this.barid = barid;
	}
	
	public String add() {
		
		int ratingnum = Integer.parseInt(rating);
		int baridnum = Integer.parseInt(barid);
		
		String ret = ratingManager.add(ratingnum, comment, date, baridnum, logBean.getUserid());
		
		if(!ret.equalsIgnoreCase("fail"))
			return "true";
			else 
				return "false";

	}
	
}
