import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTable {
    public static void main(String[] args) {
        try{

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url ="jdbc:mysql://localhost:3306/youtube";
            String userName = "root";
            String password ="_ _ _ _ _"; // your password goes here
            Connection con = DriverManager.getConnection(url,userName,password);

            String q= "UPDATE table1 set Name=? , City=? where Id=?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("new name: ");
            String name = br.readLine();

            System.out.print("new City: ");
            String city = br.readLine();

            System.out.print("Old Id: ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pst = con.prepareStatement(q);
            pst.setString(1,name);
            pst.setString(2,city);
            pst.setString(3,String.valueOf(id));
            pst.executeUpdate();

            System.out.println("updated");


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
