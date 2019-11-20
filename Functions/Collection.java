package function;
import doubandao.*;
import java.util.*;
public class Collection {
	
	Scanner reader=new Scanner(System.in);
	
	public void w_collect()//查看收藏列表
	{
		CollectDAOImp c=new CollectDAOImp();
		ID i=new ID();
		System.out.print(c.Watch_Collect(i.get_ID()));
		System.out.println("请输入要查看的电影名:");
		String movie_title=reader.nextLine();
		MovieDAOImp m=new MovieDAOImp();
		Movie_CollectDAOImp mcd=new Movie_CollectDAOImp();
		m.GetMovie_Message(mcd.GetCollection_ID(movie_title));
		
		
	}

	public void do_collect(String movie_id,String users_id)//进行收藏,当前电影id和用户id
	{
		/*System.out.println("是否确定收藏此电影		Y/N");
		String temp=reader.nextLine();
		switch(temp)
		{
		case "Y":
		case "y":*/
			Collect col=new Collect();
			col.setMovie_ID(movie_id);
			col.setUsers_ID(users_id);
			
			CollectDAOImp coldaoimp=new CollectDAOImp();
			coldaoimp.insertCollect(col);
		/*	break;
		case "N":
		case "n":
			Login_Success lo=new Login_Success();
			lo.login_success();*/
		}
	
	public void don_collect(String movie_title,String movie_id)//放到movie_collect表中
	{
		Movie_Collect mc=new Movie_Collect();
		mc.setMovie_ID(movie_id);
		mc.setMovie_Title(movie_title);
		Movie_CollectDAOImp mcd=new Movie_CollectDAOImp();
		mcd.insertMovie_Collect(mc);
		
	}
}


