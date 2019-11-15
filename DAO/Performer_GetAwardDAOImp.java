package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Performer_GetAwardDAOImp extends DAOBASE implements Performer_GetAwardDAO{
	private static final String INSERT_PERFORMER_GETAWARD_SQL = "INSERT INTO Performer_GetAward VALUES(?, ?)";
	@Override
	public void insertPerformer_GetAward(Performer_GetAward pg) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_PERFORMER_GETAWARD_SQL);
			pst.setString(1, pg.getAward_Name());
			pst.setString(2, pg.getPerformer_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_PERFORMER_GETAWARD_SQL = "DELETE FROM Performer_GetAward WHERE Award_Name = ? AND Performer_ID = ?";
	public void deletePerformer_GetAward(String award_Name, String performer_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_PERFORMER_GETAWARD_SQL);
			pst.setString(1, award_Name);
			pst.setString(2, performer_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_PERFORMER_GETAWARD_SQL = "UPDATE Performer_GetAward set Award_Name = ?, Performer_ID = ?";
	
	@Override
	public void updatePerformer_GetAward(Performer_GetAward pg) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_PERFORMER_GETAWARD_SQL);
			pst.setString(1, pg.getAward_Name());
			pst.setString(2, pg.getPerformer_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_PERFORMER_GETAWARD_SQL = "SELECT * FROM Performer_GetAward WHERE Award_Name = ? AND Performer_ID = ?";
	
	public Performer_GetAward  getPerformer_GetAward(String award_Name, String performer_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Performer_GetAward pg = new Performer_GetAward();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_PERFORMER_GETAWARD_SQL);
			pst.setString(1, award_Name);
			pst.setString(2, performer_ID);
			rs = pst.executeQuery();
			rs.next(); //-----------------
			pg.setAward_Name(rs.getString("Award_Name"));
			pg.setPerformer_ID(rs.getString("Performer_ID"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return pg;
	}
}
