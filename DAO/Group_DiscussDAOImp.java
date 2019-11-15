package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;


public class Group_DiscussDAOImp extends DAOBASE implements Group_DiscussDAO {

	private static final String INSERT_GRUOP_DISCUSS_SQL = "INSERT INTO Group_Discuss VALUES(?, ?, ?, ?, ?)";
	@Override
	
	public void insertGroup_Discuss(Group_Discuss gd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_GRUOP_DISCUSS_SQL);
			pst.setString(1, gd.getDiscuss_ID());
			pst.setString(2, gd.getMovie_ID());
			pst.setString(3, gd.getUsers_ID());
			pst.setString(4, gd.getDiscuss_Title());
			pst.setTimestamp(5, gd.getDiscuss_Date());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_GRUOP_DISCUSS_SQL = "DELETE FROM Group_Discuss WHERE Discuss_ID = ? ";
	public void deleteGroup_Discuss(String Discuss_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_GRUOP_DISCUSS_SQL);
			pst.setString(1, Discuss_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_GRUOP_DISCUSS_SQL = "UPDATE Group_Discuss set Discuss_ID =?,Movie_ID=? , Users_ID=?, Discuss_Title=?, Discuss_Date=?";
	
	@Override
	public void updateGroup_Discuss(Group_Discuss gd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_GRUOP_DISCUSS_SQL);
			pst.setString(1, gd.getDiscuss_ID());
			pst.setString(2, gd.getMovie_ID());
			pst.setString(3, gd.getUsers_ID());
			pst.setString(4, gd.getDiscuss_Title());
			pst.setTimestamp(5, gd.getDiscuss_Date());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_GROUP_DISCUSS_SQL = "SELECT * FROM Group_Discuss WHERE Discuss_ID=?";
	
	public Group_Discuss getGroup_Discuss(String Discuss_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Group_Discuss gd = new Group_Discuss();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_GROUP_DISCUSS_SQL);
			pst.setString(1, Discuss_ID);
			rs = pst.executeQuery();
			rs.next();
			gd.setDiscuss_ID(rs.getString("Discuss_ID"));
			gd.setMovie_ID(rs.getString("Movie_ID"));
			gd.setUsers_ID(rs.getString("Users_ID"));
			gd.setDiscuss_Title(rs.getString("Discuss_Title"));
			gd.setDiscuss_Date(rs.getTimestamp("Discuss_Date"));
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return gd;
	}
}
