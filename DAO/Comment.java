
package doubandao;

public class Comment {
	private String Users_ID;
	private String Movie_ID;
	private String IsWatch;
	private String Comment_Content;
	private int Score;
	private java.sql.Timestamp Comment_Date;
	private String IsPhone;
	public String getUsers_ID() {
		return Users_ID;
	}
	public void setUsers_ID(String users_ID) {
		Users_ID = users_ID;
	}
	public String getMovie_ID() {
		return Movie_ID;
	}
	public void setMovie_ID(String movie_ID) {
		Movie_ID = movie_ID;
	}
	public String getIsWatch() {
		return IsWatch;
	}
	public void setIsWatch(String isWatch) {
		IsWatch = isWatch;
	}
	public String getComment_Content() {
		return Comment_Content;
	}
	public void setComment_Content(String comment_Content) {
		Comment_Content = comment_Content;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public java.sql.Timestamp getComment_Date() {
		return Comment_Date;
	}
	public void setComment_Date(java.sql.Timestamp comment_Date) {
		Comment_Date = comment_Date;
	}
	public String getIsPhone() {
		return IsPhone;
	}
	public void setIsPhone(String isPhone) {
		IsPhone = isPhone;
	}
	
	

}
