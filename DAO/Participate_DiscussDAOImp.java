package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Participate_DiscussDAOImp extends DAOBASE implements Participate_DiscussDAO {

	private static final String INSERT_Participate_Discuss_SQL = "INSERT INTO Participate_Discuss VALUES(?, ?, ?, ?, ? ,?)";
	@Override
	public void insertParticipate_Discuss(Participate_Discuss pcd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_Participate_Discuss_SQL);
			pst.setString(1, pcd.getDiscuss_ID());
			pst.setString(2, pcd.getCreator_ID());
			pst.setInt(3, pcd.getComment_ID());
			pst.setString(4, pcd.getReviewer_ID());
			pst.setString(5, pcd.getDiscuss_Content());
			pst.setTimestamp(6, pcd.getComment_Date());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Participate_Discuss_SQL = "DELETE FROM Participate_Discuss WHERE Discuss_ID = ? AND Creator_ID = ? AND Comment_ID = ?";
	public void deleteParticipate_Discuss(String discuss_ID,String creator_ID,String comment_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Participate_Discuss_SQL);
			pst.setString(1, discuss_ID);
			pst.setString(2, creator_ID);
			pst.setString(3, comment_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Participate_Discuss_SQL = "UPDATE Participate_Discuss set Discuss_ID=? , Creator_ID=?, Comment_ID=?,Reviewer_ID=?,Discuss_Content=?,Comment_Date=?";
	
	@Override
	public void updateParticipate_Discuss(Participate_Discuss pcd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Participate_Discuss_SQL);
			pst.setString(1, pcd.getDiscuss_ID());
			pst.setString(2, pcd.getCreator_ID());
			pst.setInt(3, pcd.getComment_ID());
			pst.setString(4, pcd.getReviewer_ID());
			pst.setString(5, pcd.getDiscuss_Content());
			pst.setTimestamp(6, pcd.getComment_Date());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Participate_Discuss_SQL = "SELECT * FROM Participate_Discuss WHERE Discuss_ID = ? AND Creator_ID = ? AND Comment_ID = ?";
	
	public Participate_Discuss getParticipate_Discuss(String discuss_ID,String creator_ID,String comment_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Participate_Discuss pcd = new Participate_Discuss();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Participate_Discuss_SQL);
			pst.setString(1, discuss_ID);
			pst.setString(2, creator_ID);
			pst.setString(3, comment_ID);
			rs = pst.executeQuery();
			rs.next();
			pcd.setDiscuss_ID(rs.getString("Discuss_ID"));
			pcd.setCreator_ID(rs.getString("Creator_ID"));
			pcd.setComment_ID(rs.getInt("Comment_ID"));
			pcd.setReviewer_ID(rs.getString("Reviewer_ID"));
			pcd.setDiscuss_Content(rs.getString("Discuss_Content"));
			pcd.setComment_Date(rs.getTimestamp("Comment_Date"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return pcd;
	}
	
	private static final String GET_RESPONSE_NUM_SQL = "SELECT COUNT(Comment_ID) AS X\r\n" + 
			"FROM Participate_Discuss\r\n" + 
			"WHERE Discuss_ID=?";
	public int GetResponse_Num(String discuss_ID)//获得该小组讨论的回应数
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	    int Response_Num = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_RESPONSE_NUM_SQL);
			pst.setString(1, discuss_ID);
			rs = pst.executeQuery();
			rs.next();
			Response_Num = rs.getInt("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Response_Num;
	}
	
	private static final String GET_COMMENT_SQL = "SELECT *\r\n" + 
			"FROM Participate_Discuss\r\n" + 
			"WHERE Discuss_ID=? AND Reviewer_ID IS NULL";
	public List<Participate_Discuss> GetComment(String discuss_ID)//获得小组讨论中不是回复的所有评论
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
        List<Participate_Discuss> l=new ArrayList<Participate_Discuss>();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_COMMENT_SQL);
			pst.setString(1, discuss_ID);
			rs = pst.executeQuery();
			while(rs.next())
			{
				Participate_Discuss pcd=new Participate_Discuss();
				pcd.setDiscuss_ID(rs.getString("Discuss_ID"));
				pcd.setCreator_ID(rs.getString("Creator_ID"));
				pcd.setComment_ID(rs.getInt("Comment_ID"));
				pcd.setReviewer_ID(rs.getString("Reviewer_ID"));
				pcd.setDiscuss_Content(rs.getString("Discuss_Content"));
				pcd.setComment_Date(rs.getTimestamp("Comment_Date"));
				l.add(pcd);
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return l;
	}
	
	private static final String GET_REPLY_SQL = "SELECT * " + 
			"FROM Participate_Discuss\r\n" + 
			"WHERE Discuss_ID=? AND Creator_ID=? ";
	public List<Participate_Discuss> GetReply(String discuss_ID,String creator_ID)//获得小组讨论中的回复评论
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
        List<Participate_Discuss> l=new ArrayList<Participate_Discuss>();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_REPLY_SQL);
			pst.setString(1, discuss_ID);
			pst.setString(2, creator_ID);
			rs = pst.executeQuery();
			while(rs.next())
			{
				Participate_Discuss pcd=new Participate_Discuss();
				pcd.setDiscuss_ID(rs.getString("Discuss_ID"));
				pcd.setCreator_ID(rs.getString("Creator_ID"));
				pcd.setComment_ID(rs.getInt("Comment_ID"));
				pcd.setReviewer_ID(rs.getString("Reviewer_ID"));
				pcd.setDiscuss_Content(rs.getString("Discuss_Content"));
				pcd.setComment_Date(rs.getTimestamp("Comment_Date"));
				l.add(pcd);
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return l;
	}
}
