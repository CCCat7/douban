
package doubandao;

public interface ListsDAO {
	
	public void  insertLists(Lists lis);
	public void  deleteLists(String Movie_ID,String Label_Content,String LikeUsers_ID);
	public void  updateLists(Lists lis);
	public Lists getLists(String Movie_ID,String Label_Content,String LikeUsers_ID);
	

}