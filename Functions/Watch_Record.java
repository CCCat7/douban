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
		if(wdi.getCount(u_id)!=0)//���û��������¼��Ϊ��
		{
			System.out.println("	���������¼��	");
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
			else//�����¼����ʮ��
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
			System.out.println("û�������¼");
	}
	public void do_watch() //���������¼
	{
		String u_id=id.get_ID();
		String m_id=id.get_mID();
		List<Watch> w=wdi.getRecord(u_id);
		int o_count=0;//��¼�������ĵ�ԭ�м�¼�ı��
		int count=wdi.getCount(u_id);
		if(count!=0)//���û��������¼��Ϊ��
		{
			
			/*for(int i=0;i<w.size();i++)
			{
				if(w.get(i).getMovie_ID() == m_id && w.get(i).getUsers_ID() == u_id)//�ж��Ƿ����ظ��ļ�¼   �����
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
			{//�ж��Ƿ������ͬ�ļ�¼
				for(int i=0;i<w.size();i++)
				{
					if(w.get(i).getMovie_ID().equals(m_id)  && w.get(i).getUsers_ID().equals(u_id))//�ж��Ƿ����ظ��ļ�¼   �����
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
					if(w.get(i).getMovie_ID().equals(m_id) && w.get(i).getUsers_ID().equals(u_id))//�ж��Ƿ����ظ��ļ�¼   �����
					{
						flag=i;
						o_count=w.get(i).getNum();
					}
					
				}
				for(int i=0;i<w.size();i++)
				{
					if(w.get(i).getNum()>o_count && w.get(i).getNum()<(count+1))//����һ�� �ѷ�Χ�ڵı�ż�һ
					{
						w.get(i).setNum(w.get(i).getNum()-1);
					}
						
				}
				/*for(int i=0;i<w.size();i++)
				{
					if(w.get(i).getMovie_ID() == m_id && w.get(i).getUsers_ID() == u_id)//�ж��Ƿ����ظ��ļ�¼   �����
					{
						w.get(i).setNum(count);
					}
					
				}*/
				w.get(flag).setNum(count);	
				System.out.println("����");
				System.out.println(w.get(flag).getNum());
				wdi.updateRecord(w); 
			}
			else
			{
				System.out.println(exist);

				wat.setMovie_ID(m_id);
				wat.setUsers_ID(u_id);
				wat.setNum(count+1);
				System.out.println("�¼�");
				System.out.println(wat.getNum());
				wdi.insertWatch(wat);
			}
		}
		else
		{
			
			wat.setMovie_ID(m_id);
			wat.setUsers_ID(u_id);
			wat.setNum(count+1);
			System.out.println("ȷʵ�¼�");
			System.out.println(wat.getNum());
			wdi.insertWatch(wat);
		}
		
		
		
	}
	
}
