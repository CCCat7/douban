package doubandao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			rs.next();
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
	
	private static final String GET_LABEL_SQL = "SELECT *\r\n" + 
			"FROM Signs\r\n" + 
			"WHERE Movie_ID=?";
	public List<Signs> GetLabels(String movie_ID)//获得该电影的所有标签
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
        List<Signs> l=new ArrayList<Signs>();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_LABEL_SQL);
			pst.setString(1, movie_ID);
			rs = pst.executeQuery();
			while(rs.next())
			{
				Signs s=new Signs();
				s.setMovie_ID(rs.getString("Movie_ID"));
				s.setLabel_Content(rs.getString("Label_Content"));
				l.add(s);
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return l;
	}
	
	private static final String GET_MOVIE_NUM_SQL = "SELECT COUNT(Movie_ID) AS X\r\n" + 
			"FROM Signs\r\n" + 
			"WHERE Label_Content=?";
	public int GetMovie_Num(String label_content)//获得拥有该标签的电影数
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
	    int Movie_Num = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_MOVIE_NUM_SQL);
			pst.setString(1, label_content);
			rs = pst.executeQuery();
			rs.next();
			Movie_Num = rs.getInt("X");
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Movie_Num;
	}
	
	private static final String GET_MOVIES_SQL = "SELECT Movie_Title\r\n" + 
			"FROM Movie AS X, Signs AS Y\r\n" + 
			"WHERE X.Movie_ID=Y.Movie_ID AND Label_Content=?";
	public String GetMovies_Name(String label_content)//获得该标签标识的所有电影
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=GetMovie_Num(label_content);
		String [] Movies_Title = new String[num];
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_MOVIES_SQL);
			pst.setString(1, label_content);
			rs = pst.executeQuery();
			for(int i=0;i<num;i++)
			{
		    rs.next();
		    Movies_Title[i] = rs.getString("Movie_Title");
			}
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String AllMovie=Movies_Title[0];
		if(num>1)
		{
			AllMovie+="/";
			for(int i=1;i<num-1;i++)
				AllMovie = AllMovie + Movies_Title[i] + "/";		
			AllMovie = AllMovie + Movies_Title[num-1];
		}
		return AllMovie;
	}
}
