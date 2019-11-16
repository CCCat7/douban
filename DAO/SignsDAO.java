package doubandao;

public interface SignsDAO {
	public void  insertSigns(Signs sig);
	public void  deleteSigns(String movie_ID,  String label_Content);
	public void  updateSigns(Signs sig);
	public Signs  getSigns(String movie_ID,  String label_Content);
}
