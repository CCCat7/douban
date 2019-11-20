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
			rs.next();
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
	
	private static final String GET_PERFROMER_NUM_SQL = "SELECT COUNT(Performer_ID) AS X\r\n" + 
			"FROM Performer_GetAward\r\n" + 
			"WHERE Award_Name=?";
	public int GetPerformer_Num(String award_name)//获该奖的演职员数量
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	    int Performer_Num = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_PERFROMER_NUM_SQL);
			pst.setString(1, award_name);
			rs = pst.executeQuery();
			rs.next();
			Performer_Num = rs.getInt("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Performer_Num;
	}
	
	private static final String GET_PerformerS_SQL = "SELECT Performer_Name\r\n" + 
			"FROM Performer AS X,Performer_GetAward AS Y\r\n" + 
			"WHERE X.Performer_ID=Y.Performer_ID AND Y.Award_Name=?";
	public String GetPerformers_Name(String award_name)//获得该奖的所有演职员
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=GetPerformer_Num(award_name);
		String [] Performer_Name = new String[num];
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_PerformerS_SQL);
			pst.setString(1, award_name);
			rs = pst.executeQuery();
			for(int i=0;i<num;i++)
			{
		    rs.next();
			Performer_Name[i] = rs.getString("Performer_Name");
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String AllPerformer=Performer_Name[0] + "/";
		for(int i=1;i<num-1;i++)
		AllPerformer = AllPerformer + Performer_Name[i] + "/";		
		AllPerformer = AllPerformer + Performer_Name[num-1];
		return AllPerformer;
	}
}
