
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class holderDao {
  
    public static Connection getConnection() //get Connection to database
    {  
        Connection con=null;  
        try
        {            
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");  
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return con;  
    }

    public static int save(Account acc) 
    {  
        int status=0;  
        try
        {  
            Connection con=holderDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into account(no,holder,password) values (?,?,?)");  
            ps.setString(1,acc.getNo() + "");
            ps.setString(2,acc.getHolder());  
            ps.setString(3,acc.getPassword());

            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }  
          
        return status;  
    }

    public static int update(Account acc) 
    {  
        int status=0;  
        try
        {  
            Connection con=holderDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update account set holder=?,password=? where no=?");  
            ps.setString(1,acc.getHolder());
            ps.setString(2,acc.getPassword());  
            ps.setInt(5,acc.getNo());  

            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }  
          
        return status;  
    }  
    public static int delete(int no)
    {  
        int status=0;  
        try
        {  
            Connection con=holderDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from account where no=?");  
            ps.setString(1,no + "");  
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
        return status;  
    }  

    public static boolean accountExists(int no){
        try{  
            Connection con = holderDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select no from account");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next())
            {  
                if(rs.equals(no)) {
                    con.close();  
                    return true;
                }
            }  
            con.close();  
        }
        catch(Exception m)
        {
            m.printStackTrace();
        }    
        return false; 
    }
}
