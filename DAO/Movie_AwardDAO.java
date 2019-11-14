package doubandao;

public interface Movie_AwardDAO {
	public void  insertMovie_Award(Movie_Award mad);
	public void  deleteMovie_Award(String award_name);
	public void  updateMovie_Award(Movie_Award mad);
	public Movie_Award  getMovie_Award(String award_name);
}
