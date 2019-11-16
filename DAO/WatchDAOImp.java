package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WatchDAOImp extends DAOBASE implements WatchDAO {
	private static final String INSERT_WATCH_SQL = "INSERT INTO Watch VALUES(?, ?)";
	@Override
	public void insertWatch(Watch wth) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_WATCH_SQL);
			pst.setString(1, wth.getMovie_ID());
			pst.setString(2, wth.getUsers_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_WATCH_SQL = "DELETE FROM Watch WHERE Movie_ID = ? AND Users_ID = ?";
	public void deleteWatch(String movie_ID, String users_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_WATCH_SQL);
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
	
	private static final String UPDATE_WATCH_SQL = "UPDATE Watch set Movie_ID = ?, Users_ID = ?";
	
	@Override
	public void updateWatch(Watch wth) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_WATCH_SQL);
			pst.setString(1, wth.getMovie_ID());
			pst.setString(2, wth.getUsers_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_WATCH_SQL = "SELECT * FROM Watch WHERE Movie_ID = ? AND Users_ID = ?";
	
	public Watch getWatch(String movie_ID, String users_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Watch wth = new Watch();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_WATCH_SQL);
			pst.setString(1, movie_ID);
			pst.setString(2, users_ID);
			rs = pst.executeQuery();
			rs.next(); //-----------------
			wth.setMovie_ID(rs.getString("Movie_ID"));
			wth.setUsers_ID(rs.getString("Users_ID"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return wth;
	}
}
