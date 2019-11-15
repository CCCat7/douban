package doubandao;

public interface Participate_DiscussDAO {
	public void  insertParticipate_Discuss(Participate_Discuss pcd);
	public void  deleteParticipate_Discuss(String discuss_ID);
	public void  updateParticipate_Discuss(Participate_Discuss pcd);
	public Participate_Discuss  getParticipate_Discuss(String discuss_ID);
}
