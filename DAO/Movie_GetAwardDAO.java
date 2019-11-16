package doubandao;

public interface Movie_GetAwardDAO {
	public void  insertMovie_GetAward(Movie_GetAward mga);
	public void  deleteMovie_GetAward(String award_name,String movie_ID);
	public void  updateMovie_GetAward(Movie_GetAward mga);
	public Movie_GetAward  getMovie_GetAward(String award_name,String movie_ID);	
}
