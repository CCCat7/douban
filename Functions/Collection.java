package function;
import doubandao.*;
import java.util.*;
public class Collection {
	
	Scanner reader=new Scanner(System.in);
	
	public void w_collect()//�鿴�ղ��б�
	{
		CollectDAOImp c=new CollectDAOImp();
		ID i=new ID();
		System.out.print(c.Watch_Collect(i.get_ID()));
		System.out.println("������Ҫ�鿴�ĵ�Ӱ��:");
		String movie_title=reader.nextLine();
		MovieDAOImp m=new MovieDAOImp();
		m.GetMovie_Message(m.GetMovie_ID(movie_title));
		
		
	}

	public void do_collect(String movie_id,String users_id)//�����ղ�,��ǰ��Ӱid���û�id
	{
		String temp=null;
		System.out.println("�Ƿ�ȷ���ղش˵�Ӱ		Y/N");
		temp=reader.nextLine();
		switch(temp)
		{
		case "Y":
		case "y":
			Collect col=new Collect();
			col.setMovie_ID(movie_id);
			col.setUsers_ID(users_id);
			
			CollectDAOImp coldaoimp=new CollectDAOImp();
			coldaoimp.insertCollect(col);
		}
		
		
	}

}
