
package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LabelDAOImp extends DAOBASE implements LabelDAO {

	private static final String INSERT_LABEL_SQL = "INSERT INTO Label VALUES(?, ?)";
	@Override
	
	public void insertLabel(Label lab) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_LABEL_SQL);
			pst.setString(1, lab.getLabel_Content());
			pst.setString(2, lab.getUsers_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}

	private static final String DELETE_LABEL_SQL = "DELETE FROM Label WHERE Label_Content = ? AND Users_ID = ?";
	public void deleteLabel(String Label_Content,String Users_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_LABEL_SQL);
			pst.setString(1, Label_Content);
			pst.setString(2, Users_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_LABEL_SQL = "UPDATE Label set Label_Content =?,Users_ID=?";
	
	@Override
	public void updateLabel(Label lab) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_LABEL_SQL);
			pst.setString(1, lab.getLabel_Content());
			pst.setString(2, lab.getUsers_ID());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_LABEL_SQL = "SELECT * FROM Label WHERE Label_Content=? AND Users_ID = ?";
	
	public Label getLabel(String Label_Content,String Users_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Label lab = new Label();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_LABEL_SQL);
			pst.setString(1, Label_Content);
			pst.setString(2, Users_ID);
			rs = pst.executeQuery();
			rs.next();
			lab.setLabel_Content(rs.getString("Label_Content"));
			lab.setUsers_ID(rs.getString("Users_ID"));
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return lab;
	}
	
	private static final String GET_CLIICK_NUM_SQL = "SELECT COUNT(Users_ID) AS X\r\n" + 
			"FROM Label\r\n" + 
			"WHERE Label_Content=?";
	public int GetClick_Num(String label_content)//获得该标签的点击量
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	    int Click_Num = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_CLIICK_NUM_SQL);
			pst.setString(1, label_content);
			rs = pst.executeQuery();
			rs.next();
			Click_Num = rs.getInt("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Click_Num;
	}
}
