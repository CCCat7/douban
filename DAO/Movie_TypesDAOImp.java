package doubandao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class Movie_TypesDAOImp extends DAOBASE implements Movie_TypesDAO{
	private static final String INSERT_LISTS_SQL = "INSERT INTO Movie_Types VALUES(?, ?)";
	@Override
	public void insertMovie_Types(Movie_Types mt) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(INSERT_LISTS_SQL);
			pst.setString(1, mt.getMovie_Title());
			pst.setString(2, mt.getMovie_Type());

			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private static final String DELETE_Movie_Types_SQL = "DELETE FROM Movie_Types WHERE Movie_Title = ? AND Movie_Type = ? ";
	public void deleteMovie_Types(String movie_title,String movie_type) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(DELETE_Movie_Types_SQL);
			pst.setString(1, movie_title);
			pst.setString(2, movie_type);
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static final String UPDATE_Movie_Types_SQL = "UPDATE Lists set Movie_Title=? , Movie_Type=?";
	
	@Override
	public void updateMovie_Types(Movie_Types mt) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(UPDATE_Movie_Types_SQL);
			pst.setString(1, mt.getMovie_Title());
			pst.setString(2, mt.getMovie_Type());
		
			pst.executeUpdate();
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private static final String GET_Movie_Types_SQL = "SELECT * FROM Movie_Types WHERE Movie_Title = ? AND Movie_Type=? ";
	
	public Movie_Types getMovie_Types(String movie_title,String movie_type) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Movie_Types mt=new Movie_Types();
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Movie_Types_SQL);
			pst.setString(1, movie_title);
			pst.setString(2, movie_type);
			rs = pst.executeQuery();
			rs.next();
			mt.setMovie_Title(rs.getString("Movie_Title"));
			mt.setMovie_Type(rs.getString("Movie_Type"));
	
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return mt;
	}
	
	
	private static final String GET_NUMFTYPE_SQL = "SELECT COUNT(Movie_Title) AS X FROM Movie_Types WHERE Movie_Type=? ";
	//某种类型有多少电影
	public int getMovie_TitleNUM(String movie_type) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_NUMFTYPE_SQL);
			pst.setString(1, movie_type);
			rs = pst.executeQuery();
			rs.next();
			num=rs.getInt("X");
	
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return num;
	}
	
	private static final String GET_NUMFTITLE_SQL = "SELECT COUNT(Movie_Type) AS X FROM Movie_Types WHERE Movie_Title=? ";
	//某个电影有多少类型
	public int getMovie_TypesNUM(String movie_title) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_NUMFTITLE_SQL);
			pst.setString(1, movie_title);
			rs = pst.executeQuery();
			rs.next();
			num=rs.getInt("X");
	
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return num;
	}
	
	
	private static final String GET_Movie_TitleFTYPE_SQL = "SELECT Movie_Title FROM Movie_Types WHERE Movie_Type=? ";
	
	public String getMovie_FTYPE(String movie_type) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=getMovie_TitleNUM(movie_type);
		String [] mt=new String[num];
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Movie_TitleFTYPE_SQL);
			pst.setString(1, movie_type);
			rs = pst.executeQuery();
			for(int i=0;i<num;i++)
			{
		    rs.next();
			mt[i] = rs.getString("Movie_Title");
			}
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		String ALLmt=mt[0];
	    if(num>1)
	    {
	    	ALLmt+="/";
			for(int i=1;i<num-1;i++)
				ALLmt = ALLmt + mt[i] + "/";		
			ALLmt = ALLmt + mt[num-1];
	    }
		return ALLmt;
	}
	
	
	private static final String GET_Movie_TitleFTITLE_SQL = "SELECT Movie_Type FROM Movie_Types WHERE Movie_Title=? ";
	
	public String getMovie_FTITLE(String movie_title) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=getMovie_TypesNUM(movie_title);
		String [] mt=new String[num];
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_Movie_TitleFTITLE_SQL);
			pst.setString(1, movie_title);
			rs = pst.executeQuery();
			for(int i=0;i<num;i++)
			{
		    rs.next();
			mt[i] = rs.getString("Movie_Type");
			}
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		String ALLmt=mt[0];
	    if(num>1)
	    {
	    	ALLmt+="/";
			for(int i=1;i<num-1;i++)
				ALLmt = ALLmt + mt[i] + "/";		
			ALLmt = ALLmt + mt[num-1];
	    }
		return ALLmt;
	}
	
	private static final String GET_TYPESUM_SQL = "SELECT COUNT(DISTINCT(Movie_Type)) AS X FROM Movie_Types ";
	//某个电影有多少类型
	public int getTypesNUM() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_TYPESUM_SQL);
			rs = pst.executeQuery();
			rs.next();
			num=rs.getInt("X");
	
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return num;
	}
private static final String GET_TYPES_SQL = "SELECT DISTINCT(Movie_Type) AS X FROM Movie_Types";
	
	public String getMovie_FTITLE() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int num=getTypesNUM();
		String [] mt=new String[num];
		try {
			conn = getConnection();
			pst = conn.prepareStatement(GET_TYPES_SQL);
		
			rs = pst.executeQuery();
			for(int i=0;i<num;i++)
			{
		    rs.next();
			mt[i] = rs.getString("X");
			}
			
			pst.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		String ALLmt=mt[0];
		if(num>1)
		{
			ALLmt+="/";
			for(int i=1;i<num-1;i++)
				ALLmt = ALLmt + mt[i] + "/";		
			ALLmt = ALLmt + mt[num-1];
		}
		return ALLmt;
	}
}
