package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CollectDAOImp extends DAOBASE implements CollectDAO {

	private static final String INSERT_COLLECT_SQL = "INSERT INTO Movie VALUES(?, ?)";
	@Override
	public void insertCollect(Collect col) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_COLLECT_SQL);
			pst.setString(1, col.getMovie_ID());
			pst.setString(2, col.getUsers_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_COLLECT_SQL = "DELETE FROM Collect WHERE Movie_ID = ? AND Users_ID = ?";
	public void deleteCollect(String movie_ID,String users_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_COLLECT_SQL);
			pst.setString(1, movie_ID);
			pst.setString(2, users_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_COLLECT_SQL = "UPDATE Movie set Movie_ID=? , Users_ID=?";
	
	@Override
	public void updateCollect(Collect col) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_COLLECT_SQL);
			pst.setString(1, col.getMovie_ID());
			pst.setString(2, col.getUsers_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_COLLECT_SQL = "SELECT * FROM Collect WHERE Movie_ID = ? AND Users_ID = ?";
	
	public Collect getCollect(String Movie_ID,String Users_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Collect col = new Collect();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_COLLECT_SQL);
			pst.setString(1, Movie_ID);
			pst.setString(2, Users_ID);
			rs = pst.executeQuery();
			rs.next();
			col.setMovie_ID(rs.getString("Movie_ID"));
			col.setUsers_ID(rs.getString("Users_ID"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return col;
	}
}
