package function;
import doubandao.*;
import java.util.*;
import java.sql.Timestamp;

public class Comment_F {
		ID id=new ID();
		Scanner reader=new Scanner(System.in);
		
		public void do_comment()//��������
		{
			Comment com=new Comment();
			System.out.println("��������������:");
			String comment_content=reader.nextLine();
			com.setComment_Content(comment_content);
			System.out.println("���Ƿ񿴹��ò���Ӱ:Y/N");
			String iswatch=reader.nextLine();
			com.setIsWatch(iswatch);

			if(iswatch.equals("n")||iswatch.equals("N"))
				System.out.println("��δ������Ӱ,���ܲμ�����");
			else
			{
				System.out.println("�Ƿ���:Y/N");
				String isscore=reader.nextLine();
				switch(isscore)
				{
				case "Y":
				case "y":
					System.out.println("����Ϊ��Ӱ���:");
					int score=reader.nextInt();
					com.setScore(score);
					break;
				case "N":
				case "n":
					break;
				}
					
			}
			String isphone=String.valueOf(((int)(10*Math.random()))%2);//�������0��1��־�Ƿ�Ϊ�ֻ��û�  1Ϊ�ֻ��û�
			com.setIsPhone(isphone);
			
			com.setMovie_ID(id.get_mID());
			com.setUsers_ID(id.get_ID());
			
			Timestamp time=new Timestamp(System.currentTimeMillis());
			com.setComment_Date(time);
			
			CommentDAOImp cdi=new CommentDAOImp();
			cdi.insertComment(com);
			
		}
		
		public void w_comment()//�鿴����
		{
			CommentDAOImp cdi=new CommentDAOImp();
			
			List<Comment> t=cdi.getComment_fm(id.get_mID());
			/*Iterator<Comment> it=t.iterator();
			while(it.hasNext())
			{
				System.out.print(it.next());
			}*/
			for(int i=0;i<t.size();i++)
			{
				if(t.get(i).getIsWatch().equals("y"))
					System.out.println(id.Movie_Title+"          ����");
				else
					System.out.println(id.Movie_Title+"          �뿴");
				System.out.println(t.get(i).getComment_Content());
				if(t.get(i).getIsPhone().equals("1"))
					System.out.println("����Ϊ:"+t.get(i).getScore()+"   "+t.get(i).getComment_Date()+"       �ֻ��û�");
				else
					System.out.println("����Ϊ:"+t.get(i).getScore()+"   "+t.get(i).getComment_Date()+"       �����û�");

				System.out.println();
				
			}
			System.out.println();

		}
}
