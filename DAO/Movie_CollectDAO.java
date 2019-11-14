package doubandao;

public interface Movie_CollectDAO {
	public void  insertMovie_Collect(Movie_Collect mct);
	public void  deleteMovie_Collect(String movie_ID);
	public void  updateMovie_Collect(Movie_Collect mct);
	public Movie_Collect   getMovie_Collect(String movie_ID);	
}
