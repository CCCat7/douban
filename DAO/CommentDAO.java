package doubandao;

public interface CommentDAO {
	
	public void  insertComment(Comment com);
	public void  deleteComment(String Users_ID,String Movie_ID);
	public void  updateComment(Comment com);
	public Comment getComment(String Users_ID,String Movie_ID);
	

}
