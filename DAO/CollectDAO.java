package doubandao;

public interface CollectDAO {
	
	public void  insertCollect(Collect col);
	public void  deleteCollect(String Movie_ID,String Users_ID);
	public void  updateCollect(Collect col);
	public Collect getCollect(String Movie_ID,String Users_ID);
	
}

