package function;

import doubandao.*;
import java.util.*;

public class Collection {

	Scanner reader = new Scanner(System.in);

	public void w_collect()// �鿴�ղ��б�
	{
		CollectDAOImp c = new CollectDAOImp();
		ID i = new ID();
		Login_Success loo = new Login_Success();
		if (c.Watch_Collect(i.get_ID()).equals("0")) {
			System.out.println("����δ�ղ��κε�Ӱ");// ͨ���û�id��
			System.out.println();
			loo.login_success();
		} else {
			System.out.println(c.Watch_Collect(i.get_ID()));// ͨ���û�id��

			System.out.println("������Ҫ�鿴�ĵ�Ӱ��:");
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

	public void do_collect(String movie_id, String users_id)// �����ղ�,��ǰ��Ӱid���û�id
	{
		/*
		 * System.out.println("�Ƿ�ȷ���ղش˵�Ӱ		Y/N"); String temp=reader.nextLine();
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

	public void don_collect(String movie_title, String movie_id)// �ŵ�movie_collect����
	{
		Movie_Collect mc = new Movie_Collect();
		mc.setMovie_ID(movie_id);
		mc.setMovie_Title(movie_title);
		Movie_CollectDAOImp mcd = new Movie_CollectDAOImp();
		mcd.insertMovie_Collect(mc);

	}

	public void delm_collect(String movie_title, String movie_id)// ��movie_collect����ɾ��
	{
		Movie_Collect mc = new Movie_Collect();
		mc.setMovie_ID(movie_id);
		mc.setMovie_Title(movie_title);
		Movie_CollectDAOImp mcd = new Movie_CollectDAOImp();
		mcd.deleteMovie_Collect(movie_id);

	}

	public void del_collect(String movie_id, String users_id)// ��collect����ɾ��
	{
		CollectDAOImp c = new CollectDAOImp();
		c.deleteCollect(movie_id, users_id);

	}
}
