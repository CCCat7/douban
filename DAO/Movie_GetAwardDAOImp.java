package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Movie_GetAwardDAOImp extends DAOBASE implements Movie_GetAwardDAO {

	private static final String INSERT_Movie_GetAward_SQL = "INSERT INTO Movie_GetAward VALUES(?, ?)";
	@Override
	public void insertMovie_GetAward(Movie_GetAward mga) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_Movie_GetAward_SQL);
			pst.setString(1, mga.getAward_Name());
			pst.setString(2, mga.getMovie_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Movie_GetAward_SQL = "DELETE FROM Movie_GetAward WHERE Award_Name = ? AND Movie_ID = ?";
	public void deleteMovie_GetAward(String award_name,String movie_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Movie_GetAward_SQL);
			pst.setString(1, award_name);
			pst.setString(2, movie_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Movie_GetAward_SQL = "UPDATE Movie_GetAward set Award_Name=? , Movie_ID=?";
	
	@Override
	public void updateMovie_GetAward(Movie_GetAward mga) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Movie_GetAward_SQL);
			pst.setString(1, mga.getAward_Name());
			pst.setString(2, mga.getMovie_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Movie_GetAward_SQL = "SELECT * FROM Movie_GetAward WHERE Award_Name = ? AND Movie_ID = ?";
	
	public Movie_GetAward getMovie_GetAward(String award_name,String movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Movie_GetAward mga = new Movie_GetAward();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Movie_GetAward_SQL);
			pst.setString(1, award_name);
			pst.setString(2, movie_ID);
			rs = pst.executeQuery();
			rs.next();
			mga.setAward_Name(rs.getString("Award_Name"));
			mga.setMovie_ID(rs.getString("Movie_ID"));
		
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mga;
	}
}
