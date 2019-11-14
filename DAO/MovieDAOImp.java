package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovieDAOImp extends DAOBASE implements MovieDAO {

	private static final String INSERT_MOVIE_SQL = "INSERT INTO Movie VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
	private static final String GET_MOVIE_SQL = "SELECT * FROM Users WHERE Movie_ID = ?";
	
	public Movie getMovie(String Movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Movie mov = new Movie();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_MOVIE_SQL);
			pst.setString(1, Movie_ID);
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
}
