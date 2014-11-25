/**
 * 
 */
package edu.osu;

import javax.ejb.EJB;

import examples.cse769.EJB.Service.AccountManager;

/**
 * @author Reddiah
 *
 */
public class RegisterBean
{
	@EJB 
	private AccountManager accountManager;
    private String name;
    private String password;
    private String valid;
    //radio


	public String getValid() {
		return valid;
	}


	public void setValid(String valid) {
		this.valid = valid;
	}


	public String getName ()
    {
        return name;
    }


    public void setName (final String name)
    {
		if(name.equalsIgnoreCase("!") || name.equalsIgnoreCase("@") || name.equalsIgnoreCase("#")
				|| name.equalsIgnoreCase("$") || name.equalsIgnoreCase("%") || name.equalsIgnoreCase("^")
				|| name.equalsIgnoreCase("&") || name.equalsIgnoreCase("*") || name.equalsIgnoreCase("(")
				|| name.equalsIgnoreCase(")") || name.equalsIgnoreCase("_") || name.equalsIgnoreCase("+")
				|| name.equalsIgnoreCase(""))
			setValid("Not a Valid User Name");
		else
			setValid("Valid User Name");


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


	public String register() {
		if((name.isEmpty() != true) && (password.isEmpty()!= true)) {
		String ret = accountManager.register(name, password);
		//helloService.password(password);
		if(!ret.equalsIgnoreCase("Exists"))
		return "true";
		else 
			return "Exists";
		}
		
		else return "false";
	}
	
}
