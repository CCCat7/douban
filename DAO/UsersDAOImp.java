package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDAOImp extends DAOBASE implements UsersDAO {

	private static final String INSERT_USERS_SQL = "INSERT INTO Users VALUES(?, ?, ?, ?, ?, ?)";
	@Override

	public void insertUsers(Users usr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_USERS_SQL);
			pst.setString(1, usr.getUsers_ID());
			pst.setString(2, usr.getAccount());
			pst.setString(3, usr.getPassword());
			pst.setString(4, usr.getTel());
			pst.setString(5, usr.getUsers_Name());
			pst.setString(6, usr.getAccount_Type());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_USERS_SQL = "DELETE FROM Users WHERE Users_ID = ?";
	public void deleteUsers(String users_ID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_USERS_SQL);
			pst.setString(1, users_ID);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_USERS_SQL = "UPDATE Users set Users_ID=? , Account=?, Password=?, Tel=?, Users_Name=?, Account_Type=?";
	
	@Override
	public void updateUsers(Users usr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_USERS_SQL);
			pst.setString(1, usr.getUsers_ID());
			pst.setString(2, usr.getAccount());
			pst.setString(3, usr.getPassword());
			pst.setString(4, usr.getTel());
			pst.setString(5, usr.getUsers_Name());
			pst.setString(6, usr.getAccount_Type());
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_USERS_SQL = "SELECT * FROM Users WHERE Users_ID = ?";
	
	public Users getUsers(String users_ID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Users usr = new Users();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_USERS_SQL);
			pst.setString(1, users_ID);
			rs = pst.executeQuery();
			rs.next();
			usr.setAccount(rs.getString("Account"));
			usr.setAccount_Type(rs.getString("Account_Type"));
			usr.setPassword(rs.getString("Password"));
			usr.setTel(rs.getString("Tel"));
			usr.setUsers_ID(rs.getString("Users_ID"));
			usr.setUsers_Name(rs.getString("Users_Name"));
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return usr;
	}
	
	private static final String GET_USERS_LOGIN_SQL = "SELECT Users_ID FROM Users WHERE Account_Type = ? AND Account=? AND Password=?";
	public int getLogin(String users_type,String users_acco,String users_pwd) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Users usr = new Users();
		int flag=0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_USERS_LOGIN_SQL);
			pst.setString(1, users_type);
			pst.setString(2, users_acco);
			pst.setString(3, users_pwd);
			rs = pst.executeQuery();
			rs.next();
			usr.setUsers_ID(rs.getString("Users_ID"));
			if(usr.getUsers_ID().length()!=0)
			{
				flag=1;
			}
			else
				flag=0;
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	private static final String GET_USERSACCOUNT_SQL = "SELECT COUNT(Users_ID) AS X FROM Users";

	public String getUsers_id()
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Users usr = new Users();
		String m=null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_USERSACCOUNT_SQL);
			rs = pst.executeQuery();
			rs.next();
			m=rs.getString("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}
	
	private static final String GET_NOWID_SQL = "SELECT Users_ID FROM Users WHERE Account=?";//通过帐号获取当前用户id

	public String getUsers_id(String account)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Users usr = new Users();
		String m=null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_NOWID_SQL);
			pst.setString(1, account);
			rs = pst.executeQuery();
			rs.next();
			m=rs.getString("Users_ID");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}
}
