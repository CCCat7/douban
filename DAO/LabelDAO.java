
package doubandao;

public interface LabelDAO {
	
	public void  insertLabel(Label lab);
	public void  deleteLabel(String Label_Content,String Users_ID);
	public void  updateLabel(Label lab);
	public Label getLabel(String Movie_ID,String Users_ID);
	
}
