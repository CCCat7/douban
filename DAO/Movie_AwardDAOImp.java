package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Movie_AwardDAOImp extends DAOBASE implements Movie_AwardDAO {

	private static final String INSERT_Movie_Award_SQL = "INSERT INTO Movie_Award VALUES(?, ?)";
	@Override
	public void insertMovie_Award(Movie_Award mad) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_Movie_Award_SQL);
			pst.setString(1, mad.getAward_Name());
			pst.setString(2, mad.getAward_Message());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Movie_Award_SQL = "DELETE FROM Movie_Award WHERE Award_Name = ?";
	public void deleteMovie_Award(String award_name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Movie_Award_SQL);
			pst.setString(1, award_name);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Movie_Award_SQL = "UPDATE Movie_Award set Award_Name=?, Award_Message=?";
	
	@Override
	public void updateMovie_Award(Movie_Award mad) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Movie_Award_SQL);
			pst.setString(1, mad.getAward_Name());
			pst.setString(2, mad.getAward_Message());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Movie_Award_SQL = "SELECT * FROM Movie_Award WHERE Award_Name = ?";
	
	public Movie_Award getMovie_Award(String award_name) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Movie_Award mad = new Movie_Award();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Movie_Award_SQL);
			pst.setString(1, award_name);
			rs = pst.executeQuery();
			rs.next();
			mad.setAward_Name(rs.getString("Award_Name"));
			mad.setAward_Message(rs.getString("Award_Message"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mad;
	}
}
