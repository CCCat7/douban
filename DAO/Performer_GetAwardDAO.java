package doubandao;

public interface Performer_GetAwardDAO {
	public void  insertPerformer_GetAward(Performer_GetAward pg);
	public void  deletePerformer_GetAward(String award_Name, String performer_ID);
	public void  updatePerformer_GetAward(Performer_GetAward pg);
	public Performer_GetAward  getPerformer_GetAward(String award_Name, String performer_ID);
}
