package function;
import doubandao.*;
import java.util.Scanner;
public class Start {



	public void Start()
	{
		Login lo=new Login();
		Register reg=new Register();
		Scanner reader=new Scanner(System.in);
		System.out.println("1.�û���¼			2.�û�ע��			0.�˳�ϵͳ");
		String start=reader.nextLine();
		UsersDAOImp userdaoimp=new UsersDAOImp();
		Login_Success ls=new Login_Success();
		int flag=0;
		switch(start)
		{
		case "1":
			lo.login();
	
			break;
		case "2":
			reg.register();
			Start();
			break;
		case "0":
			System.exit(0);
			break;
		default:
		break;	
		}
		ls.login_success();
	}
	
}
