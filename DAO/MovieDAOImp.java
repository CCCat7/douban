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
	
	public void GetMovie_Message(String movie_ID)
	{
		MovieDAOImp s= new MovieDAOImp();
		System.out.println("电影："+s.getMovie(movie_ID).getMovie_Title()
				           +"\n导演："+s.GetDirector(movie_ID)
				           +"\n编剧："+s.getMovie(movie_ID).getWriter()
				           +"\n制片国家/地区："+s.getMovie(movie_ID).getCountry()
				           +"\n上映日期："+s.getMovie(movie_ID).getMovie_Date()
				           +"\n片长："+s.getMovie(movie_ID).getMovie_Time()
				           +"\n语言："+s.getMovie(movie_ID).getLanguage()
				           +"\n又名："+s.getMovie(movie_ID).getAnother_Name()
				           +"\nIMDb链接："+s.getMovie(movie_ID).getMovie_Link()
				           +"\n剧情简介："+s.getMovie(movie_ID).getMovie_Brief()
				);
	}
}