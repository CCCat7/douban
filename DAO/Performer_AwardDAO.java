package doubandao;

public interface Performer_AwardDAO {
	public void  insertPerformer_Award(Performer_Award pa);
	public void  deletePerformer_Award(String award_Name,  String award_Message);
	public void  updatePerformer_Award(Performer_Award pa);
	public Performer_Award  Performer_Award(String award_Name,  String award_Message);
}
