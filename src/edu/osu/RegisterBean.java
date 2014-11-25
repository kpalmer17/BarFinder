/**
 * 
 */
package edu.osu;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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

    public void validateName(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0) {
        	setValid("not valid");
        	throw new ValidatorException(new FacesMessage("Name cannot be empty."));
        }	
        else if(s.contains("!") || s.contains("@") || s.contains("#")
				|| s.contains("$") || s.contains("%") || s.contains("^")
				|| s.contains("&") || s.contains("*") || s.contains("(")
				|| s.contains(")") || s.contains("+") ) {
        	setValid("not valid");
        	throw new ValidatorException(new FacesMessage("Name cannot contain (!@#$%^&*()+)"));
				} else {
					
			setValid("Valid");
		}
        
    }
    
    public void validatePassword(FacesContext f, UIComponent c, Object obj){
        String s=(String)obj;
        if(s.length()==0) {
        	throw new ValidatorException(new FacesMessage("Password cannot be empty."));
        }	
        
    }
    

	public String register() {
		if((name.isEmpty() != true) && (password.isEmpty()!= true) && (valid != "not valid")) {
		String ret = accountManager.register(name, password);
		//helloService.password(password);
		if(!ret.equalsIgnoreCase("Exists"))
		return "true";
		else 
			return "Exists";
		}
		
		else return "Exists";
	}
	
}
