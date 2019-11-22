package function;
import java.util.List;
import java.util.Scanner;

import doubandao.*;

public class Watch_Record
{
	Scanner reader = new Scanner(System.in);
	ID id=new ID();
	Watch wat=new Watch();
	WatchDAOImp wdi=new WatchDAOImp();
	MovieDAOImp mdi=new MovieDAOImp();
	int add_1;
	
	
	public void watch()
	{
		String u_id=id.get_ID();
		if(wdi.getCount(u_id)!=0)//该用户的浏览记录不为空
		{
			System.out.println("	您的浏览记录：	");
			List<Watch> w=wdi.getRecord(u_id);
			String[] a=new String[10];
			if(w.size()>10)
			{
				for(int i=w.size();i>=w.size()-9;i--)
					for(int j=0;j<w.size();j++)
					{
						if(w.get(j).getNum()==i)
							System.out.println(mdi.getMovie(w.get(j).getMovie_ID()).getMovie_Title());
					}
			}
			else//如果记录不够十个
			{
				for(int i=w.size();i>=1;i--)
					for(int j=0;j<w.size();j++)
					{
						if(w.get(j).getNum()==i)
							System.out.println(mdi.getMovie(w.get(j).getMovie_ID()).getMovie_Title());
					}
				

			}
			
			/*for(int i=0;i<w.size();i++)
			{
				String movie_title=null;
				movie_title=mdi.getMovie(w.get(i).getMovie_ID()).getMovie_Title();
				System.out.println("	"+movie_title);
			}*/
		}
		else
			System.out.println("没有浏览记录");
	}
	public void do_watch() //增加浏览记录
	{
		String u_id=id.get_ID();
		String m_id=id.get_mID();
		List<Watch> w=wdi.getRecord(u_id);
		int o_count=0;//记录将被更改的原有记录的标号
		int count=wdi.getCount(u_id);
		if(count!=0)//该用户的浏览记录不为空
		{
			
			/*for(int i=0;i<w.size();i++)
			{
				if(w.get(i).getMovie_ID() == m_id && w.get(i).getUsers_ID() == u_id)//判断是否有重复的记录   如果有
				{
					o_count=w.get(i).getNum();
					w.get(i).setNum(count);
				}
			}
			for(int i=0;i<w.size();i++)
			{
				if(w.get(i).getNum()>o_count && w.get(i).getNum()<(count+1) && w.get(i).getMovie_ID()!=m_id)
				{
					w.get(i).setNum(w.get(i).getNum()-1);
				}
					
			}*/
			int exist=0;
			{//判断是否存在相同的记录
				for(int i=0;i<w.size();i++)
				{
					if(w.get(i).getMovie_ID().equals(m_id)  && w.get(i).getUsers_ID().equals(u_id))//判断是否有重复的记录   如果有
					{
						exist=1;
						o_count=w.get(i).getNum();
					}
					
				}
			}
			if(exist==1)
			{
				System.out.println(exist);
				int flag=0;
				for(int i=0;i<w.size();i++)
				{
					if(w.get(i).getMovie_ID().equals(m_id) && w.get(i).getUsers_ID().equals(u_id))//判断是否有重复的记录   如果有
					{
						flag=i;
						o_count=w.get(i).getNum();
					}
					
				}
				for(int i=0;i<w.size();i++)
				{
					if(w.get(i).getNum()>o_count && w.get(i).getNum()<(count+1))//遍历一遍 把范围内的标号减一
					{
						w.get(i).setNum(w.get(i).getNum()-1);
					}
						
				}
				/*for(int i=0;i<w.size();i++)
				{
					if(w.get(i).getMovie_ID() == m_id && w.get(i).getUsers_ID() == u_id)//判断是否有重复的记录   如果有
					{
						w.get(i).setNum(count);
					}
					
				}*/
				w.get(flag).setNum(count);	
				System.out.println("更新");
				System.out.println(w.get(flag).getNum());
				wdi.updateRecord(w); 
			}
			else
			{
				System.out.println(exist);

				wat.setMovie_ID(m_id);
				wat.setUsers_ID(u_id);
				wat.setNum(count+1);
				System.out.println("新加");
				System.out.println(wat.getNum());
				wdi.insertWatch(wat);
			}
		}
		else
		{
			
			wat.setMovie_ID(m_id);
			wat.setUsers_ID(u_id);
			wat.setNum(count+1);
			System.out.println("确实新加");
			System.out.println(wat.getNum());
			wdi.insertWatch(wat);
		}
		
		
		
	}
	
}
