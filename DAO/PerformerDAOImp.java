package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PerformerDAOImp extends DAOBASE implements PerformerDAO {

	private static final String INSERT_Performer_SQL = "INSERT INTO Performer VALUES(?, ?, ?, ?, ?)";
	@Override
	public void insertPerformer(Performer pfr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_Performer_SQL);
			pst.setString(1, pfr.getPerformer_ID());
			pst.setString(2, pfr.getPerformer_Type());
			pst.setString(3, pfr.getPerformer_Name());
			pst.setString(4, pfr.getPerformer_Sex());
			pst.setString(5, pfr.getPerformer_Birth());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Performer_SQL = "DELETE FROM Performer WHERE Performer_ID = ?";
	public void deletePerformer(String performer_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Performer_SQL);
			pst.setString(1, performer_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Performer_SQL = "UPDATE Performer set Performer_ID=? , Performer_Type=?, Performer_Name=?, Performer_Sex=?, Performer_Birth=?";
	
	@Override
	public void updatePerformer(Performer pfr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Performer_SQL);
			pst.setString(1, pfr.getPerformer_ID());
			pst.setString(2, pfr.getPerformer_Type());
			pst.setString(3, pfr.getPerformer_Name());
			pst.setString(4, pfr.getPerformer_Sex());
			pst.setString(5, pfr.getPerformer_Birth());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Performer_SQL = "SELECT * FROM Performer WHERE Performer_ID = ?";
	
	public Performer getPerformer(String performer_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Performer pfr = new Performer();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Performer_SQL);
			pst.setString(1, performer_ID);
			rs = pst.executeQuery();
			rs.next();
			pfr.setPerformer_ID(rs.getString("Performer_ID"));
			pfr.setPerformer_Type(rs.getString("Performer_Type"));
			pfr.setPerformer_Name(rs.getString("Performer_Name"));
			pfr.setPerformer_Sex(rs.getString("Performer_Sex"));
			pfr.setPerformer_Birth(rs.getString("Performer_Birth"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return pfr;
	}
}
