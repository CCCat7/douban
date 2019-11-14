package doubandao;

public interface UsersDAO {
	public void  insertUsers(Users usr);
	public void  deleteUsers(String users_ID);
	public void  updateUsers(Users usr);
	public Users  getUsers(String users_ID);
	
	
}
