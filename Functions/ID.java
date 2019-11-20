package function;

import doubandao.*;

public class ID {//通过
	
	public static String Login_Account;
	//public static String Movie_Title;
	
	/*public static String getMovie_Title() {
		return Movie_Title;
	}*/

	/*public static void setMovie_Title(String movie_Title) {
		Movie_Title = movie_Title;
	}*/

	public String getLogin_Account() {//
		return Login_Account;
	}

	public void setLogin_Account(String login_Account) {
		Login_Account = login_Account;
	}
	public void print()
	{
		System.out.println(Login_Account);
	}
	public String get_ID()//获取当前用户的id
	{
		
		 UsersDAOImp udp=new UsersDAOImp();
		 //System.out.println(getLogin_Account());
		// System.out.println(udp.getUsers_id(getLogin_Account()));
		return udp.getUsers_id(getLogin_Account());
	}
	/*public String get_mID() //获取当前电影的id
	{
		
		MovieDAOImp mdp=new MovieDAOImp();
		return mdp.GetMovie_ID(getMovie_Title());
	}*/
}
