/**
 * 
 */
package edu.osu;

import javax.ejb.EJB;

import examples.cse769.EJB.Service.AccountManager;
/**
 * @author Palmer.419
 *
 */
public class LoginBean
{

	@EJB 
	private AccountManager accounts;
    private String name;
    private String password;
    private int userid = -1;
    
   
	public String login() {

 	   String[] params = new String[2];
 	   params[0] = name;
 	   params[1] = password;



		String res = accounts.login(name, password);

		
		if(res.equalsIgnoreCase("fail"))
			return "false";
		else
		{
			setUserid(Integer.parseInt(res));
			return "login";
		}
	}
	
	public String getName ()
    {
		return name;
	}


    public void setName (final String name)
    {
	    this.name = name;
	}


	public String getPassword ()
	{
	    return password;
	}

	public void setPassword (final String password)
	{
	    this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
