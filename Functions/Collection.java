package function;

import doubandao.*;
import java.util.*;

public class Collection {

	Scanner reader = new Scanner(System.in);

	public void w_collect()// 查看收藏列表
	{
		CollectDAOImp c = new CollectDAOImp();
		ID i = new ID();
		Login_Success loo = new Login_Success();
		if (c.Watch_Collect(i.get_ID()).equals("0")) {
			System.out.println("您还未收藏任何电影");// 通过用户id找
			System.out.println();
			loo.login_success();
		} else {
			System.out.println(c.Watch_Collect(i.get_ID()));// 通过用户id找

			System.out.println("请输入要查看的电影名:");
			String movie_title = reader.nextLine();
			Login_Success lo = new Login_Success();

			MovieDAOImp mdi = new MovieDAOImp();
			lo.setM_id(mdi.GetMovie_ID(movie_title));
			i.setMovie_Title(movie_title);
			MovieDAOImp m = new MovieDAOImp();
			Movie_CollectDAOImp mcd = new Movie_CollectDAOImp();
			m.GetMovie_Message(mcd.GetCollection_ID(movie_title));

		}
	}

	public void do_collect(String movie_id, String users_id)// 进行收藏,当前电影id和用户id
	{
		/*
		 * System.out.println("是否确定收藏此电影		Y/N"); String temp=reader.nextLine();
		 * switch(temp) { case "Y": case "y":
		 */
		Collect col = new Collect();
		col.setMovie_ID(movie_id);
		col.setUsers_ID(users_id);

		CollectDAOImp coldaoimp = new CollectDAOImp();
		coldaoimp.insertCollect(col);
		/*
		 * break; case "N": case "n": Login_Success lo=new Login_Success();
		 * lo.login_success();
		 */
	}

	public void don_collect(String movie_title, String movie_id)// 放到movie_collect表中
	{
		Movie_Collect mc = new Movie_Collect();
		mc.setMovie_ID(movie_id);
		mc.setMovie_Title(movie_title);
		Movie_CollectDAOImp mcd = new Movie_CollectDAOImp();
		mcd.insertMovie_Collect(mc);

	}

	public void delm_collect(String movie_title, String movie_id)// 从movie_collect表中删除
	{
		Movie_Collect mc = new Movie_Collect();
		mc.setMovie_ID(movie_id);
		mc.setMovie_Title(movie_title);
		Movie_CollectDAOImp mcd = new Movie_CollectDAOImp();
		mcd.deleteMovie_Collect(movie_id);

	}

	public void del_collect(String movie_id, String users_id)// 从collect表中删除
	{
		CollectDAOImp c = new CollectDAOImp();
		c.deleteCollect(movie_id, users_id);

	}
}
