package doubandao;

public interface ParticipateDAO {
	public void  insertParticipate(Participate pcp);
	public void  deleteParticipate(String performer_ID,String movie_ID);
	public void  updateParticipate(Participate pcp);
	public Participate  getParticipate(String performer_ID,String movie_ID);
}
