package doubandao;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users x= new Users();
		x.setAccount("1");
		x.setAccount_Type("2");
		x.setPassword("3");
		x.setTel("4");
		x.setUsers_ID("5");
		x.setUsers_Name("6");
		UsersDAOImp s= new UsersDAOImp();
		s.insertUsers(x);
	}

}
