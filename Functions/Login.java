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
	System.out.println("�������¼��ʽ:1.�����ʺŵ�¼		2.QQ�ʺŵ�¼		3.΢���ʺŵ�¼");
	String login_type=reader.nextLine();
	switch(login_type)
	{
		case "1":
			System.out.println("�����붹���ʺ�:");
			String login_douban=reader.nextLine();
			System.out.println("�������ʺ�����:");
			String login_doubanpwd=reader.nextLine();
			int temp=userdaoimp.getLogin(login_type, login_douban, login_doubanpwd);
			switch(temp)
			{
			case 1:
				flag=1;
				i.setLogin_Account(login_douban);
				System.out.println("��¼�ɹ�:");
				System.out.println();
				break;
			case 0:
				System.out.println("��¼ʧ��:");
				break;
			default:
				break;
			}
			break;
		case "2":
			System.out.println("������QQ�ʺ�:");
			String login_qq=reader.nextLine();
			System.out.println("�������ʺ�����:");
			String login_qqpwd=reader.nextLine();
			int temp1=userdaoimp.getLogin(login_type, login_qq, login_qqpwd);
			switch(temp1)
			{
			case 1:
				flag=1;
				i.setLogin_Account(login_qq);
				System.out.println("��¼�ɹ�:");
				System.out.println();
				//System.out.println("������鿴�ĵ�Ӱ��:");
				//String movie_name=reader.nextLine();
				break;
			case 0:
				System.out.println("��¼ʧ��:");
				break;
			default:
				break;
			}
			break;
		case "3":
			System.out.println("������΢���ʺ�:");
			String login_wb=reader.nextLine();
			System.out.println("�������ʺ�����:");
			String login_wbpwd=reader.nextLine();
			int temp2=userdaoimp.getLogin(login_type, login_wb, login_wbpwd);
			switch(temp2)
			{
			case 1:
				flag=1;
				i.setLogin_Account(login_wb);
				System.out.println("��¼�ɹ�:");
				System.out.println();
				break;
			case 0:
				System.out.println("��¼ʧ��:");
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