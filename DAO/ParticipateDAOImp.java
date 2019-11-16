package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ParticipateDAOImp extends DAOBASE implements ParticipateDAO {

	private static final String INSERT_Participate_SQL = "INSERT INTO Participate VALUES(?, ?)";
	@Override
	public void insertParticipate(Participate pcp) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_Participate_SQL);
			pst.setString(1, pcp.getPerformer_ID());
			pst.setString(2, pcp.getMovie_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Participate_SQL = "DELETE FROM Participate WHERE Performer_ID = ? AND Movie_ID = ?";
	public void deleteParticipate(String performer_ID,String movie_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Participate_SQL);
			pst.setString(1, performer_ID);
			pst.setString(2, movie_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Participate_SQL = "UPDATE Participate set Performer_ID=? , Movie_ID=?";
	
	@Override
	public void updateParticipate(Participate pcp) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Participate_SQL);
			pst.setString(1, pcp.getPerformer_ID());
			pst.setString(2, pcp.getMovie_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Participate_SQL = "SELECT * FROM Participate WHERE Performer_ID = ? AND Movie_ID = ?";
	
	public Participate getParticipate(String performer_ID,String movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Participate pcp = new Participate();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Participate_SQL);
			pst.setString(1, performer_ID);
			pst.setString(2, movie_ID);
			rs = pst.executeQuery();
			rs.next();
			pcp.setPerformer_ID(rs.getString("Perfromer_ID"));
			pcp.setMovie_ID(rs.getString("Movie_ID"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return pcp;
	}
}
