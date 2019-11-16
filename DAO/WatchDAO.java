package doubandao;

public interface WatchDAO {
	public void  insertWatch(Watch wth);
	public void  deleteWatch(String movie_ID, String users_ID);
	public void  updateWatch(Watch wth);
	public Watch  getWatch(String movie_ID, String users_ID);
}
