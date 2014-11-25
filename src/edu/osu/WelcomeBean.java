/**
 * 
 */
package edu.osu;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;



import examples.cse769.EJB.Service.RatingManager;
import examples.cse769.EJB.Service.BarManager;



/**
 * @author Reddiah
 *
 */
public class WelcomeBean
{
	
	@EJB 
	private RatingManager ratingManager;
	@EJB
	private BarManager barManager;
	
	private LoginBean logBean;
    private String label;
    private String searchtext;
    private List<List<String>> ratings = new ArrayList<List<String>>();
    private List<List<String>> bars = new ArrayList<List<String>>();
    
	
	public LoginBean getLogBean() {
		return logBean;
	}

	public void setLogBean(LoginBean logBean) {
		this.logBean = logBean;
	}

	
	public List<List<String>> getRatings() {
		return ratings;
	}

	public void setRatings(List<List<String>> ratings) {
		this.ratings = ratings;
	}
	
	public List<List<String>> getBars() {
		return bars;
	}

	public void setBars(List<List<String>> bars) {
		this.bars = bars;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSearchText() {
		return searchtext;
	}

	public void setSearchText(String searchtext) {
		this.searchtext = searchtext;
	}

	public String search() {
		
		bars = barManager.find(label, searchtext);
		
		if(bars.isEmpty())
			return "false";
		
		else
		{return "true";}
	}
	
	
	public String rating() {
		
		ratings = ratingManager.findForUser(logBean.getUserid());
		
		if(ratings.isEmpty())
			return "ratingfail";
		
		else
		{return "rating";}
	}
}
