package doubandao;

public interface Movie_TypesDAO {
	public void  insertMovie_Types(Movie_Types mt);
	public void  deleteMovie_Types(String Movie_Title,String Movie_Type);
	public void  updateMovie_Types(Movie_Types mt);
	public Movie_Types getMovie_Types(String Movie_Title,String Movie_Type);
}
