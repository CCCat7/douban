
package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListsDAOImp extends DAOBASE implements ListsDAO {

	private static final String INSERT_LISTS_SQL = "INSERT INTO Lists VALUES(?, ?, ?)";
	@Override
	public void insertLists(Lists lis) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_LISTS_SQL);
			pst.setString(1, lis.getMovie_ID());
			pst.setString(2, lis.getLabel_Content());
			pst.setString(3, lis.getLikeUsers_ID());

			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_LISTS_SQL = "DELETE FROM Lists WHERE Movie_ID = ? AND Label_Content = ? AND LikeUsers_ID = ?";
	public void deleteLists(String movie_ID,String label_Content,String likeUsers_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_LISTS_SQL);
			pst.setString(1, movie_ID);
			pst.setString(2, label_Content);
			pst.setString(3, likeUsers_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_LISTS_SQL = "UPDATE Lists set Movie_ID=? , Label_Content=?, LikeUsers_ID=?";
	
	@Override
	public void updateLists(Lists lis) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_LISTS_SQL);
			pst.setString(1, lis.getMovie_ID());
			pst.setString(2, lis.getLabel_Content());
			pst.setString(3, lis.getLikeUsers_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_LISTS_SQL = "SELECT * FROM Lists WHERE Movie_ID = ? AND Label_Content=? AND LikeUsers_ID=?";
	
	public Lists getLists(String Movie_ID,String Label_Content,String LikeUsers_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Lists lis = new Lists();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_LISTS_SQL);
			pst.setString(1, Movie_ID);
			pst.setString(2, Label_Content);
			pst.setString(3, LikeUsers_ID);
			rs = pst.executeQuery();
			rs.next();
			lis.setMovie_ID(rs.getString("Movie_ID"));
			lis.setLabel_Content(rs.getString("Label_Content"));
			lis.setLikeUsers_ID(rs.getString("LikeUsers_ID"));
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return lis;
	}
}
