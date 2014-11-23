/**
 * 
 */
package edu.osu;

import java.io.IOException;
import java.util.logging.*;
import javax.ejb.EJB;

import examples.cse769.EJB.Service.LoginSession;

import examples.cse769.EJB.Service.HelloService;
/**
 * @author Reddiah
 *
 */
public class LoginBean
{


	//private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
	//Logger logger = LoggerFactory.getLogger(LoginBean.class);
    private static Logger logger = Logger.getLogger("edu.osu.LoginBean");
    private static FileHandler fh;
	@EJB 
	private HelloService helloService;
    private String name;
    private String password;
    private String selection = "login";
   

	@EJB private LoginSession loginSession;
	public String userName() {

 	   String[] params = new String[3];
 	   params[0] = name;
 	   params[1] = password;
 	   params[2] = selection;
 	   try {
 		   if(fh == null)
 	   fh = new FileHandler("final.txt");//"mylog.txt"
 	  fh.setFormatter(new SimpleFormatter());
      logger.addHandler(fh);
      logger.setLevel(Level.ALL);
      logger.entering("LoginBean", "userName", params);
 	   }
 		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		String res = loginSession.userName(name, password, selection);

	      logger.exiting("LoginBean", "userName", res);

		if (res.equalsIgnoreCase("success"))
		{
				
			return selection;
		}
		else if(res.equalsIgnoreCase("fail"))
			return "false";
		
		return "false";
	}
	
	
	public String getMessage() {
		//String pass = helloService.password(password);
		//return pass;
		return "lol";
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
	
}
