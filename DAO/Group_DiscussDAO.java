package doubandao;

public interface Group_DiscussDAO {
	public void  insertGroup_Discuss(Group_Discuss gd);
	public void  deleteGroup_Discuss(String Discuss_ID);
	public void  updateGroup_Discuss(Group_Discuss gd);
	public Group_Discuss getGroup_Discuss(String Discuss_ID);
}
