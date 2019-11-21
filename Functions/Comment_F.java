package function;
import doubandao.*;
import java.util.*;
import java.sql.Timestamp;

public class Comment_F {
		ID id=new ID();
		Scanner reader=new Scanner(System.in);
		
		public void do_comment()//进行评论
		{
			Comment com=new Comment();
			System.out.println("请输入您的评论:");
			String comment_content=reader.nextLine();
			com.setComment_Content(comment_content);
			System.out.println("您是否看过该部电影:Y/N");
			String iswatch=reader.nextLine();
			com.setIsWatch(iswatch);

			if(iswatch.equals("n")||iswatch.equals("N"))
				System.out.println("您未看过电影,不能参加评分");
			else
			{
				System.out.println("是否打分:Y/N");
				String isscore=reader.nextLine();
				switch(isscore)
				{
				case "Y":
				case "y":
					System.out.println("请您为电影打分:");
					int score=reader.nextInt();
					com.setScore(score);
					break;
				case "N":
				case "n":
					break;
				}
					
			}
			String isphone=String.valueOf(((int)(10*Math.random()))%2);//随机产生0或1标志是否为手机用户  1为手机用户
			com.setIsPhone(isphone);
			
			com.setMovie_ID(id.get_mID());
			com.setUsers_ID(id.get_ID());
			
			Timestamp time=new Timestamp(System.currentTimeMillis());
			com.setComment_Date(time);
			
			CommentDAOImp cdi=new CommentDAOImp();
			cdi.insertComment(com);
			
		}
		
		public void w_comment()//查看评论
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
					System.out.println(id.Movie_Title+"          看过");
				else
					System.out.println(id.Movie_Title+"          想看");
				System.out.println(t.get(i).getComment_Content());
				if(t.get(i).getIsPhone().equals("1"))
					System.out.println("分数为:"+t.get(i).getScore()+"   "+t.get(i).getComment_Date()+"       手机用户");
				else
					System.out.println("分数为:"+t.get(i).getScore()+"   "+t.get(i).getComment_Date()+"       其他用户");

				System.out.println();
				
			}
			System.out.println();

		}
}
