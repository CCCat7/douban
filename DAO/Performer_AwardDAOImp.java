package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Performer_AwardDAOImp extends DAOBASE implements Performer_AwardDAO{
	private static final String INSERT_PERFORMER_AWARD_SQL = "INSERT INTO Performer_Award VALUES(?, ?)";
	@Override
	public void insertPerformer_Award(Performer_Award pa) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_PERFORMER_AWARD_SQL);
			pst.setString(1, pa.getAward_Name());
			pst.setString(2, pa.getAward_Message());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_PERFORMER_AWARD_SQL = "DELETE FROM Performer_Award WHERE Award_Name = ? AND Award_Message = ?";
	public void deletePerformer_Award(String award_Name,  String award_Message) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_PERFORMER_AWARD_SQL);
			pst.setString(1, award_Name);
			pst.setString(2, award_Message);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_PERFORMER_AWARD_SQL = "UPDATE Performer_GetAward set Award_Name = ?, Award_Message = ?";
	
	@Override
	public void updatePerformer_Award(Performer_Award pa) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_PERFORMER_AWARD_SQL);
			pst.setString(1, pa.getAward_Name());
			pst.setString(2, pa.getAward_Message());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_PERFORMER_AWARD_SQL = "SELECT * FROM Performer_Award WHERE Award_Name = ? AND Award_Message = ?";
	
	public Performer_Award  Performer_Award(String award_Name,  String award_Message) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Performer_Award pa = new Performer_Award();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_PERFORMER_AWARD_SQL);
			pst.setString(1, award_Name);
			pst.setString(2, award_Message);
			rs = pst.executeQuery();
			rs.next(); //-----------------
			pa.setAward_Name(rs.getString("Award_Name"));
			pa.setAward_Message(rs.getString("Award_Message"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return pa;
	}
}
