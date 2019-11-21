package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;


public class CommentDAOImp extends DAOBASE implements CommentDAO {

	private static final String INSERT_COMMENT_SQL = "INSERT INTO Comment VALUES(?, ?, ?, ?, ?, ?, ?)";
	@Override
	
	public void insertComment(Comment com) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_COMMENT_SQL);
			pst.setString(1, com.getUsers_ID());
			pst.setString(2, com.getMovie_ID());
			pst.setString(3, com.getIsWatch());
			pst.setString(4, com.getComment_Content());
			pst.setInt(5, com.getScore());
			pst.setTimestamp(6, com.getComment_Date());
			pst.setString(7, com.getIsPhone());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_COMMENT_SQL = "DELETE FROM Comment WHERE Users_ID = ? AND Movie_ID = ?";
	public void deleteComment(String users_ID,String movie_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_COMMENT_SQL);
			pst.setString(1, users_ID);
			pst.setString(2, movie_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_COMMENT_SQL = "UPDATE Comment set Users_ID =?,Movie_ID=? , IsWatch=?, Comment_Content=?, Score=?, Comment_Date=?,IsPhone=?";
	
	@Override
	public void updateComment(Comment com) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_COMMENT_SQL);
			pst.setString(1, com.getUsers_ID());
			pst.setString(2, com.getMovie_ID());
			pst.setString(3, com.getIsWatch());
			pst.setString(4, com.getComment_Content());
			pst.setInt(5, com.getScore());
			pst.setTimestamp(6, com.getComment_Date());
			pst.setString(7, com.getIsPhone());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_COMMENT_SQL = "SELECT * FROM Comment WHERE Users_ID=? AND Movie_ID = ?";
	
	public Comment getComment(String Users_ID,String Movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Comment com = new Comment();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_COMMENT_SQL);
			pst.setString(1, Users_ID);
			pst.setString(2, Movie_ID);
			rs = pst.executeQuery();
			rs.next();
			com.setUsers_ID(rs.getString("Users_ID"));
			com.setMovie_ID(rs.getString("Movie_ID"));
			com.setIsWatch(rs.getString("IsWatch"));
			com.setComment_Content(rs.getString("Comment_Content"));
			com.setScore(rs.getInt("Score"));
			com.setComment_Date(rs.getTimestamp("Comment_Date"));
			com.setIsPhone(rs.getString("IsPhone"));
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return com;
	}
	
private static final String GET_COMMENT_FORM_MOVIE_SQL = "SELECT * FROM Comment WHERE Movie_ID = ?";
	//获取该电影的评论
	public List<Comment> getComment_fm(String Movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Comment> c=new ArrayList<>();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_COMMENT_FORM_MOVIE_SQL);
			pst.setString(1, Movie_ID);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Comment com=new Comment();
				com.setUsers_ID(rs.getString("Users_ID"));
				com.setMovie_ID(rs.getString("Movie_ID"));
				com.setIsWatch(rs.getString("IsWatch"));
				com.setComment_Content(rs.getString("Comment_Content"));
				com.setScore(rs.getInt("Score"));
				com.setComment_Date(rs.getTimestamp("Comment_Date"));
				com.setIsPhone(rs.getString("IsPhone"));
				c.add(com);
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return c;
	}
	
	private static final String GET_COMMENT_UNUM_SQL = "SELECT COUNT(SCORE) AS X FROM Comment WHERE Movie_ID = ? AND SCORE!='0'";
	//获取评论该电影的有效分数的人数
	public int getComment_Unum(String Movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int usersnum=0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_COMMENT_UNUM_SQL);
			pst.setString(1, Movie_ID);
			rs = pst.executeQuery();
			rs.next();

			usersnum=(rs.getInt("X"));
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return usersnum;
	}
	private static final String GET_COMMENT_TOTAL_SQL = "SELECT SUM(SCORE) AS Y FROM Comment WHERE Movie_ID = ? AND SCORE!='0'";
	//获取评论该电影的有效分数的人数
	public int getComment_Total(String Movie_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int snum=0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_COMMENT_TOTAL_SQL);
			pst.setString(1, Movie_ID);
			rs = pst.executeQuery();
			rs.next();

			snum=(rs.getInt("Y"));
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return snum;
	}
}
