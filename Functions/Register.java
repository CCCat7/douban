package function;
import doubandao.*;
import java.util.Scanner;
import java.util.*;

import doubandao.Users;
import doubandao.UsersDAOImp;

public class Register {
	public void register()
	{
		Scanner reader=new Scanner(System.in);

		System.out.println("ÇëÊäÈëÕÊºÅ:");
		String account=reader.nextLine();
		System.out.println("ÇëÊäÈëÕÊ»§ÃÜÂë:");
		String pwd=reader.nextLine();
		String pwdtemp="0";
		while(!pwdtemp.equals(pwd))
		{
			System.out.println("ÇëÔÙ´ÎÊäÈëÃÜÂë:");
			pwdtemp=reader.nextLine();
	    }

		System.out.println("ÇëÊäÈëÊÖ»úºÅ:");
		String tel=reader.nextLine();
		System.out.println("ÇëÊäÈëêÇ³Æ");
		String name=reader.nextLine();
		System.out.println("ÇëÊäÈëÕÊ»§ÀàĞÍ:1.¶¹°êÕÊºÅµÇÂ¼		2.QQÕÊºÅµÇÂ¼		3.Î¢²©ÕÊºÅµÇÂ¼");
		String type=reader.nextLine();
		
		System.out.println(account+"   "+pwd+"   "+tel+"   "+name+"   "+type);
		
		Users user=new Users();
		UsersDAOImp u=new UsersDAOImp();
		int a=Integer.parseInt(u.getUsers_id());
		user.setUsers_ID(String.valueOf(a+1));
		user.setAccount(account);
		user.setPassword(pwd);
		user.setTel(tel);
		user.setUsers_Name(name);
		user.setAccount_Type(type);
		u.insertUsers(user);
		
	}
}
