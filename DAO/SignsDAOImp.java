package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignsDAOImp extends DAOBASE implements SignsDAO{
	private static final String INSERT_SIGNS_SQL = "INSERT INTO Signs VALUES(?, ?)";
	@Override
	public void insertSigns(Signs sig) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_SIGNS_SQL);
			pst.setString(1, sig.getMovie_ID());
			pst.setString(2, sig.getLabel_Content());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_SIGNS_SQL = "DELETE FROM Signs WHERE Movie_ID = ? AND Label_Content = ?";
	public void deleteSigns(String movie_ID,  String label_Content) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_SIGNS_SQL);
			pst.setString(1, movie_ID);
			pst.setString(2, label_Content);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_SIGNS_SQL = "UPDATE Signs set Movie_ID = ?, Label_Content = ?";
	
	@Override
	public void updateSigns(Signs sig) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_SIGNS_SQL);
			pst.setString(1, sig.getMovie_ID());
			pst.setString(2, sig.getLabel_Content());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_SIGNS_SQL = "SELECT * FROM Signs WHERE Movie_ID = ? AND Label_Content = ?";
	
	public Signs getSigns(String movie_ID,  String label_Content) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Signs sig = new Signs();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_SIGNS_SQL);
			pst.setString(1, movie_ID);
			pst.setString(2, label_Content);
			rs = pst.executeQuery();
			rs.next(); //-----------------
			sig.setMovie_ID(rs.getString("Movie_ID"));
			sig.setLabel_Content(rs.getString("Label_Content"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return sig;
	}
}
