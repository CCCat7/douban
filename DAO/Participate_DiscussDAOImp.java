package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Participate_DiscussDAOImp extends DAOBASE implements Participate_DiscussDAO {

	private static final String INSERT_Participate_Discuss_SQL = "INSERT INTO Participate_Discuss VALUES(?, ?, ?)";
	@Override
	public void insertParticipate_Discuss(Participate_Discuss pcd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_Participate_Discuss_SQL);
			pst.setString(1, pcd.getDiscuss_ID());
			pst.setString(2, pcd.getUsers_ID());
			pst.setString(3, pcd.getDiscuss_Content());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Participate_Discuss_SQL = "DELETE FROM Participate_Discuss WHERE Discuss_ID = ?";
	public void deleteParticipate_Discuss(String discuss_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Participate_Discuss_SQL);
			pst.setString(1, discuss_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Participate_Discuss_SQL = "UPDATE Participate_Discuss set Discuss_ID=? , Users_ID=?, Discuss_Content=?";
	
	@Override
	public void updateParticipate_Discuss(Participate_Discuss pcd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Participate_Discuss_SQL);
			pst.setString(1, pcd.getDiscuss_ID());
			pst.setString(2, pcd.getUsers_ID());
			pst.setString(3, pcd.getDiscuss_Content());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Participate_Discuss_SQL = "SELECT * FROM Participate_Discuss WHERE Discuss_ID = ?";
	
	public Participate_Discuss getParticipate_Discuss(String discuss_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Participate_Discuss pcd = new Participate_Discuss();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Participate_Discuss_SQL);
			pst.setString(1, discuss_ID);
			rs = pst.executeQuery();
			rs.next();
			pcd.setDiscuss_ID(rs.getString("Discuss_ID"));
			pcd.setUsers_ID(rs.getString("Users_ID"));
			pcd.setDiscuss_Content(rs.getString("Discuss_Content"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return pcd;
	}
}
