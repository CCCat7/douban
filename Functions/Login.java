package function;
import doubandao.*;
import java.util.Scanner;
import java.util.*;



public class Login {
	


	public void login()
	{
	ID i=new ID();
	int flag=0;
	UsersDAOImp userdaoimp=new UsersDAOImp();
	Scanner reader=new Scanner(System.in);
	System.out.println("ÇëÊäÈëµÇÂ¼·½Ê½:1.¶¹°êÕÊºÅµÇÂ¼		2.QQÕÊºÅµÇÂ¼		3.Î¢²©ÕÊºÅµÇÂ¼");
	String login_type=reader.nextLine();
	switch(login_type)
	{
		case "1":
			System.out.println("ÇëÊäÈë¶¹°êÕÊºÅ:");
			String login_douban=reader.nextLine();
			System.out.println("ÇëÊäÈëÕÊºÅÃÜÂë:");
			String login_doubanpwd=reader.nextLine();
			int temp=userdaoimp.getLogin(login_type, login_douban, login_doubanpwd);
			switch(temp)
			{
			case 1:
				flag=1;
				i.setLogin_Account(login_douban);
				System.out.println("µÇÂ¼³É¹¦:");
				System.out.println();
				break;
			case 0:
				System.out.println("µÇÂ¼Ê§°Ü:");
				break;
			default:
				break;
			}
			break;
		case "2":
			System.out.println("ÇëÊäÈëQQÕÊºÅ:");
			String login_qq=reader.nextLine();
			System.out.println("ÇëÊäÈëÕÊºÅÃÜÂë:");
			String login_qqpwd=reader.nextLine();
			int temp1=userdaoimp.getLogin(login_type, login_qq, login_qqpwd);
			switch(temp1)
			{
			case 1:
				flag=1;
				i.setLogin_Account(login_qq);
				System.out.println("µÇÂ¼³É¹¦:");
				System.out.println();
				//System.out.println("ÇëÊäÈë²é¿´µÄµçÓ°Ãû:");
				//String movie_name=reader.nextLine();
				break;
			case 0:
				System.out.println("µÇÂ¼Ê§°Ü:");
				break;
			default:
				break;
			}
			break;
		case "3":
			System.out.println("ÇëÊäÈëÎ¢²©ÕÊºÅ:");
			String login_wb=reader.nextLine();
			System.out.println("ÇëÊäÈëÕÊºÅÃÜÂë:");
			String login_wbpwd=reader.nextLine();
			int temp2=userdaoimp.getLogin(login_type, login_wb, login_wbpwd);
			switch(temp2)
			{
			case 1:
				flag=1;
				i.setLogin_Account(login_wb);
				System.out.println("µÇÂ¼³É¹¦:");
				System.out.println();
				break;
			case 0:
				System.out.println("µÇÂ¼Ê§°Ü:");
				break;
			default:
				break;
			}
			break;
		default:
			break;
	}

}
}