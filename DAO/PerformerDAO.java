package doubandao;

public interface PerformerDAO {
	public void  insertPerformer(Performer pfr);
	public void  deletePerformer(String performer_ID);
	public void  updatePerformer(Performer pfr);
	public Performer  getPerformer(String performer_ID);
}
