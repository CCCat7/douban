package function;

import doubandao.*;
import java.util.Scanner;
import java.util.*;

public class Login_Success // ��¼�ɹ����ҳ��
{
	Scanner reader = new Scanner(System.in);
	int flag = 0;
	ID i = new ID();
	MovieDAOImp mdi = new MovieDAOImp();
	Comment_F cf = new Comment_F();
	WatchDAOImp wdi=new WatchDAOImp();
	Watch_Record wr=new Watch_Record();
	Movie_TypesDAOImp mtdi=new Movie_TypesDAOImp();
	public static String m_id = null;// ��Ӱid

	public String getM_id() 
	{
		return m_id;
	}

	public void setM_id(String m_id)
	{
		this.m_id = m_id;
	}

	public String getMovie_title() 
	{
		return movie_title;
	}

	public void setMovie_title(String movie_title) 
	{
		this.movie_title = movie_title;
	}

	String movie_title = null;

	public void iflag()// �жϸõ�Ӱ�Ƿ��ղ�
	{
		String id = i.get_ID();// ��ȡ�û�id
		CollectDAOImp cdi = new CollectDAOImp();
		String movie_t = cdi.Watch_Collect(id);// �õ������ղ�����

		if (movie_t != "0") {
			String[] a = movie_t.split("/");
			for (int l = 0; l < a.length; l++)
				if (a[l].equals(i.getMovie_Title()))// ����ղ��б����ղش˵�Ӱ flagΪ1
					flag = 1;
		} else {
			flag = 0;
		}
	}

	public void watch_movie() 
	{
		System.out.println("������Ҫ�鿴�ĵ�Ӱ��:");
		movie_title = reader.nextLine();
		i.setMovie_Title(movie_title);
		wr.do_watch();
		setMovie_title(movie_title);
		m_id = mdi.GetMovie_ID(movie_title);
		setM_id(m_id);
		
		// m.GetMovie_Message(m.GetMovie_ID(movie_title));//��ȡ��Ӱ��Ϣ
		mdi.GetMovie_Message(m_id);// ��ȡ��Ӱ��Ϣ

		iflag();
	}
	public void watch_movieft() //�����Ͳ���
	{
		System.out.println(mtdi.getMovie_FTITLE());
		System.out.println("������Ҫ�鿴�ĵ�Ӱ����:");
		String type = reader.nextLine();
		System.out.println(mtdi.getMovie_FTYPE(type));

	}
	public void login_success()
	{

		System.out.println("������Ҫ���еĲ���:1.�鿴��Ӱ		2.�����Ͳ鿴��Ӱ		3.�鿴�ղ��б�		4.�鿴�����ʷ		0.�˳�");
		/*
		 * ID i=new ID(); MovieDAOImp mdi=new MovieDAOImp(); String mt=null;
		 */
		// System.out.println(i.get_ID());
		String type = reader.nextLine();
		switch (type) {
		case "1":
			watch_movie();
			break;
		case "2":
			watch_movieft();
			login_success();
			break;
		case "3":
			Collection col = new Collection();
			col.w_collect();
			iflag();
			break;
		case "4":
			wr.watch();
			login_success();
			break;
		case "0":
			System.exit(0);
			break;
		default:
			break;
		}
		if (flag == 0)
		{
			System.out.println("������Ҫ���еĲ���:1.�鿴��ְԱ��Ϣ		2.����		3.�鿴����		4.����С������		");
			System.out.println("              5.��������		6.�ղ�		7.�鿴��Ӱ���������Ϣ		8.�鿴������Ӱ��Ϣ		0.�˳�");
			String t = reader.nextLine();
			switch (t) 
			{
			case "1":
				break;
			case "2":
				cf.do_comment();
				login_success();
				break;
			case "3":
				cf.w_comment();
				login_success();
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				Collection col = new Collection();
				Movie_CollectDAOImp mcd = new Movie_CollectDAOImp();
				col.do_collect(m_id, i.get_ID());
				if (mcd.getMovie_Collect(m_id).getMovie_Title().equals(movie_title))
					break;
				else 
				{

					col.don_collect(getMovie_title(), m_id);
				}
				break;
			case "7":
				break;
			case "8":
				login_success();
				break;
			case "0":
				System.exit(0);
				break;
			default:
				break;
			}
		} 
		else 
		{
			System.out.println("������Ҫ���еĲ���:1.�鿴��ְԱ��Ϣ		2.����		3.�鿴����		4.����С������		");
			System.out.println("              5.��������		6.ȡ���ղ�		7.�鿴��Ӱ���������Ϣ		8.�鿴������Ӱ��Ϣ		0.�˳�");
			String t = reader.nextLine();
			switch (t)
			{
			case "1":
				break;
			case "2":
				cf.do_comment();
				login_success();
				break;
			case "3":
				cf.w_comment();
				login_success();

				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				Collection c = new Collection();
				CollectDAOImp cdi = new CollectDAOImp();
				int sum = cdi.Collect_usersSum(getM_id());// �õ��ղظõ�Ӱ������

				if (sum > 1)
				{
					c.del_collect(getM_id(), i.get_ID());
					System.out.println("ȡ���ɹ�!");
				} 
				else if (sum == 1)// ����õ�Ӱ��collect���б��ղصĴ�������1
				{
					c.delm_collect(movie_title, getM_id());
					c.del_collect(getM_id(), i.get_ID());
					System.out.println("ȡ���ɹ�!");

				}
				login_success();
				break;
			case "7":
				break;
			case "8":
				login_success();
				break;
			case "0":
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

}
