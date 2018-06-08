package rest.jersey;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;




public class AllienRepository {

	List<Alien> aliens;

	Connection con = null;
	
	public AllienRepository(){
		
		String url ="jdbc:mysql://localhost:3306/restdb";
		String username="root";
		String password="";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,username,password);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}
	/** Mock
	public AllienRepository() {
		// TODO Auto-generated constructor stub

		aliens = new ArrayList<>();

		Alien a1 = new Alien();
		a1.setId(101);
		a1.setName("Navin");
		a1.setPoints(60);

		Alien a2 = new Alien();
		a2.setId(102);
		a2.setName("Corf");
		a2.setPoints(77);

		aliens.add(a1);
		aliens.add(a2);
	}**/
	
/*#####################################################################**/
	
	public List<Alien> getAliens() {

		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from alien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aliens;
		
	}

	public Alien getAlien(int id) {

		Alien a = new Alien();
		String sql = "select * from alien where id="+id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**MOCK
		for (Alien a : aliens) {
			if (a.getId()==id) {
				return a;
			}

		}
		return null;**/
		return a;
	}

	public void create(Alien a1) {
		
		String sql="insert into alien values(?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3,a1.getPoints());
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//aliens.add(a1);
	}
	
	
	//DELETE FROM alien WHERE id=2;
	//UPDATE `alien` SET `id`=1,`name`='Jorge',`point`=2 WHERE `id`=1
	
	public void update(Alien a1) {
		
		String sql="UPDATE alien SET name=?,point=? WHERE id=?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, a1.getName());
			st.setInt(2,a1.getPoints());
			st.setInt(3,a1.getId());
			
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//aliens.add(a1);
	}
	public void delete(int id) 
	{
		String sql="DELETE FROM alien WHERE id=?";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,id);
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
