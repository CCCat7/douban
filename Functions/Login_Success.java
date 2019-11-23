package function;

import doubandao.*;
import java.util.Scanner;
import java.util.*;

public class Login_Success // 登录成功后的页面
{
	Scanner reader = new Scanner(System.in);
	int flag = 0;
	ID i = new ID();
	MovieDAOImp mdi = new MovieDAOImp();
	Comment_F cf = new Comment_F();
	WatchDAOImp wdi=new WatchDAOImp();
	Watch_Record wr=new Watch_Record();
	Movie_TypesDAOImp mtdi=new Movie_TypesDAOImp();
	public static String m_id = null;// 电影id

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

	public void iflag()// 判断该电影是否被收藏
	{
		String id = i.get_ID();// 获取用户id
		CollectDAOImp cdi = new CollectDAOImp();
		String movie_t = cdi.Watch_Collect(id);// 得到所有收藏内容

		if (movie_t != "0") {
			String[] a = movie_t.split("/");
			for (int l = 0; l < a.length; l++)
				if (a[l].equals(i.getMovie_Title()))// 如果收藏列表已收藏此电影 flag为1
					flag = 1;
		} else {
			flag = 0;
		}
	}

	public void watch_movie() 
	{
		System.out.println("请输入要查看的电影名:");
		movie_title = reader.nextLine();
		i.setMovie_Title(movie_title);
		wr.do_watch();
		setMovie_title(movie_title);
		m_id = mdi.GetMovie_ID(movie_title);
		setM_id(m_id);
		
		// m.GetMovie_Message(m.GetMovie_ID(movie_title));//获取电影信息
		mdi.GetMovie_Message(m_id);// 获取电影信息

		iflag();
	}
	public void watch_movieft() //按类型查找
	{
		System.out.println(mtdi.getMovie_FTITLE());
		System.out.println("请输入要查看的电影类型:");
		String type = reader.nextLine();
		System.out.println(mtdi.getMovie_FTYPE(type));

	}
	public void login_success()
	{

		System.out.println("请输入要进行的操作:1.查看电影		2.按类型查看电影		3.查看收藏列表		4.查看浏览历史		0.退出");
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
			System.out.println("请输入要进行的操作:1.查看演职员信息		2.评论		3.查看评论		4.创建小组讨论		");
			System.out.println("              5.参与讨论		6.收藏		7.查看电影奖项相关信息		8.查看其他电影信息		0.退出");
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
			System.out.println("请输入要进行的操作:1.查看演职员信息		2.评论		3.查看评论		4.创建小组讨论		");
			System.out.println("              5.参与讨论		6.取消收藏		7.查看电影奖项相关信息		8.查看其他电影信息		0.退出");
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
				int sum = cdi.Collect_usersSum(getM_id());// 得到收藏该电影的人数

				if (sum > 1)
				{
					c.del_collect(getM_id(), i.get_ID());
					System.out.println("取消成功!");
				} 
				else if (sum == 1)// 如果该电影在collect表中被收藏的次数等于1
				{
					c.delm_collect(movie_title, getM_id());
					c.del_collect(getM_id(), i.get_ID());
					System.out.println("取消成功!");

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
