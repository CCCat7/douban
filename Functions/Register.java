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

		System.out.println("�������ʺ�:");
		String account=reader.nextLine();
		System.out.println("�������ʻ�����:");
		String pwd=reader.nextLine();
		String pwdtemp="0";
		while(!pwdtemp.equals(pwd))
		{
			System.out.println("���ٴ���������:");
			pwdtemp=reader.nextLine();
	    }

		System.out.println("�������ֻ���:");
		String tel=reader.nextLine();
		System.out.println("�������ǳ�");
		String name=reader.nextLine();
		System.out.println("�������ʻ�����:1.�����ʺŵ�¼		2.QQ�ʺŵ�¼		3.΢���ʺŵ�¼");
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
