package doubandao;

public interface MovieDAO {
	
	public void  insertMovie(Movie mov);
	public void  deleteMovie(String Movie_ID);
	public void  updateMovie(Movie mov);
	public Movie getMovie(String Movie_ID);
	
}
