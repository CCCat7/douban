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
	
	private static final String GET_Performer_ID_SQL = "SELECT Z.Performer_ID FROM Movie AS X,Participate AS Y,Performer AS Z WHERE X.Movie_ID=Y.Movie_ID AND Y.Performer_ID=Z.Performer_ID AND X.Movie_ID=? AND Z.Performer_Name=?";
	public String GetPerformer_ID(String movie_ID,String performer_name)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String performer_ID = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Performer_ID_SQL);
			pst.setString(1, movie_ID);
			pst.setString(2, performer_name);
			rs = pst.executeQuery();
			rs.next();
			performer_ID = rs.getString("Performer_ID");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return performer_ID;
	}
	
	public void GetPerformer_Message(String movie_ID,String performer_ID)//输出演职员相关信息
	{
		System.out.println("姓名："+getPerformer(performer_ID).getPerformer_Name()
				           +"\n性别："+getPerformer(performer_ID).getPerformer_Sex()
				           +"\n出生日期："+getPerformer(performer_ID).getPerformer_Birth()
				);
		if(GetAward_Num(performer_ID)!=0)
			System.out.println("获得奖项："+GetAwards_Name(performer_ID));
	}
	
	private static final String GET_AWARD_NUM_SQL = "SELECT COUNT(Award_Name) AS X\r\n" + 
			"FROM Performer_GetAward\r\n" + 
			"WHERE Performer_ID=?";
	public int GetAward_Num(String performer_ID)//获得该演职员的获奖数量
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	    int Award_Num = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_AWARD_NUM_SQL);
			pst.setString(1, performer_ID);
			rs = pst.executeQuery();
			rs.next();
			Award_Num = rs.getInt("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Award_Num;
	}
	
	private static final String GET_AWARDS_SQL = "SELECT Award_Name\r\n" + 
			"FROM Performer_GetAward\r\n" + 
			"WHERE Performer_ID=?";
	public String GetAwards_Name(String performer_ID)//获得该演职员得到的所有奖项
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=GetAward_Num(performer_ID);
		String [] Award_Name = new String[num];
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_AWARDS_SQL);
			pst.setString(1, performer_ID);
			rs = pst.executeQuery();
			for(int i=0;i<num;i++)
			{
		    rs.next();
		    Award_Name[i] = rs.getString("Award_Name");
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String AllAward=Award_Name[0];
		if(num>1)
		{
			AllAward+="/";
			for(int i=1;i<num-1;i++)
				AllAward = AllAward + Award_Name[i] + "/";		
			AllAward = AllAward + Award_Name[num-1];
		}
		return AllAward;
	}
}
