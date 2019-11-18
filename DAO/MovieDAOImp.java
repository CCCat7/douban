package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieDAOImp extends DAOBASE implements MovieDAO {

	private static final String INSERT_MOVIE_SQL = "INSERT INTO Movie VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	@Override
	public void insertMovie(Movie mov) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_MOVIE_SQL);
			pst.setString(1, mov.getMovie_ID());
			pst.setString(2, mov.getMovie_Title());
			pst.setString(3, mov.getWriter());
			pst.setString(4, mov.getCountry());
			pst.setString(5, mov.getMovie_Date());
			pst.setString(6, mov.getMovie_Time());
			pst.setString(7, mov.getLanguage());
			pst.setString(8, mov.getAnother_Name());
			pst.setString(9, mov.getMovie_Link());
			pst.setString(10, mov.getMovie_Brief());
			pst.setString(11, mov.getMovie_Img());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_MOVIE_SQL = "DELETE FROM Users WHERE Movie_ID = ?";
	public void deleteMovie(String movie_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_MOVIE_SQL);
			pst.setString(1, movie_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_MOVIE_SQL = "UPDATE Movie set Movie_ID=? , Movie_Title=?, Writer=?, Country=?, Movie_Date=?, Movie_Time=?,Language=?,Another_Name=?,Movie_Link=?,Movie_Brief=?";
	
	@Override
	public void updateMovie(Movie mov) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_MOVIE_SQL);
			pst.setString(1, mov.getMovie_ID());
			pst.setString(2, mov.getMovie_Title());
			pst.setString(3, mov.getWriter());
			pst.setString(4, mov.getCountry());
			pst.setString(5, mov.getMovie_Date());
			pst.setString(6, mov.getMovie_Time());
			pst.setString(7, mov.getLanguage());
			pst.setString(8, mov.getAnother_Name());
			pst.setString(9, mov.getMovie_Link());
			pst.setString(10, mov.getMovie_Brief());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_MOVIE_SQL = "SELECT * FROM Movie WHERE Movie_ID = ?";
	
	public Movie getMovie(String movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Movie mov = new Movie();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_MOVIE_SQL);
			pst.setString(1, movie_ID);
			rs = pst.executeQuery();
			rs.next();
			mov.setMovie_ID(rs.getString("Movie_ID"));
			mov.setMovie_Title(rs.getString("Movie_Title"));
			mov.setWriter(rs.getString("Writer"));
			mov.setCountry(rs.getString("Country"));
			mov.setMovie_Date(rs.getString("Movie_Date"));
			mov.setMovie_Time(rs.getString("Movie_Time"));
			mov.setLanguage(rs.getString("Language"));
			mov.setAnother_Name(rs.getString("Another_Name"));
			mov.setMovie_Link(rs.getString("Movie_Link"));
			mov.setMovie_Brief(rs.getString("Movie_Brief"));
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mov;
	}
	
	private static final String GET_MOVIE_ID_SQL = "SELECT Movie_ID FROM Movie WHERE Movie_Title = ?";
	public String GetMovie_ID(String movie_title)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String movie_ID = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_MOVIE_ID_SQL);
			pst.setString(1, movie_title);
			rs = pst.executeQuery();
			rs.next();
			movie_ID = rs.getString("Movie_ID");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return movie_ID;
	}
	
	private static final String GET_ID_SQL = "SELECT Count(Movie_ID) AS X FROM Movie ";
	public String GetID()
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	    String ID_Count = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_ID_SQL);
			rs = pst.executeQuery();
			rs.next();
			ID_Count = rs.getString("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ID_Count;
	}
	
	private static final String GET_Director_SQL = "SELECT Performer_Name FROM Performer AS X,Participate AS Y,Movie AS Z WHERE X.Performer_ID=Y.Performer_ID AND Y.Movie_ID=Z.Movie_ID AND X.Performer_Type='0' AND Z.Movie_ID=? ";
	public String GetDirector(String movie_ID)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String Director_Name = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Director_SQL);
			pst.setString(1, movie_ID);
			rs = pst.executeQuery();
			rs.next();
			Director_Name = rs.getString("Performer_Name");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Director_Name;
	}
	
	private static final String GET_ACTOR_NUM_SQL = "SELECT COUNT(Performer_Name) AS X FROM Performer AS X,Participate AS Y,Movie AS Z WHERE X.Performer_ID=Y.Performer_ID AND Y.Movie_ID=Z.Movie_ID AND X.Performer_Type='1' AND Z.Movie_ID=? ";
	public int GetActor_Num(String movie_ID)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	    int Actor_Num = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_ACTOR_NUM_SQL);
			pst.setString(1, movie_ID);
			rs = pst.executeQuery();
			rs.next();
			Actor_Num = rs.getInt("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Actor_Num;
	}
	
	private static final String GET_ACTOR_SQL = "SELECT Performer_Name FROM Performer AS X,Participate AS Y,Movie AS Z WHERE X.Performer_ID=Y.Performer_ID AND Y.Movie_ID=Z.Movie_ID AND X.Performer_Type='1' AND Z.Movie_ID=? ";
	public String GetPerformer(String movie_ID)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=GetActor_Num(movie_ID);
		String [] Actor_Name = new String[num];
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_ACTOR_SQL);
			pst.setString(1, movie_ID);
			rs = pst.executeQuery();
			for(int i=0;i<num;i++)
			{
		    rs.next();
			Actor_Name[i] = rs.getString("Performer_Name");
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String AllActor=Actor_Name[0] + "/";
		for(int i=1;i<num-1;i++)
		AllActor = AllActor + Actor_Name[i] + "/";		
		AllActor = AllActor + Actor_Name[num-1];
		return AllActor;
	}
	
	public void GetMovie_Message(String movie_ID)
	{
		System.out.println("电影："+getMovie(movie_ID).getMovie_Title()
				           +"\n导演："+GetDirector(movie_ID)
				           +"\n编剧："+getMovie(movie_ID).getWriter()
				           +"\n主演："+GetPerformer(movie_ID)
				           +"\n制片国家/地区："+getMovie(movie_ID).getCountry()
				           +"\n上映日期："+getMovie(movie_ID).getMovie_Date()
				           +"\n片长："+getMovie(movie_ID).getMovie_Time()
				           +"\n语言："+getMovie(movie_ID).getLanguage()
				           +"\n又名："+getMovie(movie_ID).getAnother_Name()
				           +"\nIMDb链接："+getMovie(movie_ID).getMovie_Link()
				           +"\n剧情简介："+getMovie(movie_ID).getMovie_Brief()
				);
	}
}