package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Movie_CollectDAOImp extends DAOBASE implements Movie_CollectDAO {

	private static final String INSERT_Movie_Collect_SQL = "INSERT INTO Movie_Collect VALUES(?, ?)";
	@Override
	public void insertMovie_Collect(Movie_Collect mct) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_Movie_Collect_SQL);
			pst.setString(1, mct.getMovie_ID());
			pst.setString(2, mct.getMovie_Title());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Movie_Collect_SQL = "DELETE FROM Movie_Collect WHERE Movie_ID = ?";
	public void deleteMovie_Collect(String movie_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Movie_Collect_SQL);
			pst.setString(1, movie_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Movie_Collect_SQL = "UPDATE Movie_Collect set Movie_ID=? Movie_Title=?";
	
	@Override
	public void updateMovie_Collect(Movie_Collect mct) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Movie_Collect_SQL);
			pst.setString(1, mct.getMovie_ID());
			pst.setString(2, mct.getMovie_Title());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Movie_Collect_SQL = "SELECT * FROM Movie_Collect WHERE Movie_ID = ?";
	
	public Movie_Collect getMovie_Collect(String movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Movie_Collect mct = new Movie_Collect();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Movie_Collect_SQL);
			pst.setString(1, movie_ID);
			rs = pst.executeQuery();
			rs.next();
			mct.setMovie_ID(rs.getString("Movie_ID"));
			mct.setMovie_Title(rs.getString("Movie_Title"));
		
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mct;
	}
}
