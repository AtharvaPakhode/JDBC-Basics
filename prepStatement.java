import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;

public class prepStatement {
    public static void main(String[] args) {
        try{

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url ="jdbc:mysql://localhost:3306/youtube";
            String userName = "root";
            String password ="_ _ _ _ _"; // your password goes here
            Connection con = DriverManager.getConnection(url,userName,password);

            //create a query
            for (int i = 1; i < 5 ; i++) {
            String q = "insert into table1 (Name,City) values (?,?)";

            //get the prepared statement

            PreparedStatement pst =con.prepareStatement(q);

            //set the values

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter name: ");
            String name = br.readLine();

            System.out.println("Enter city: ");
            String city = br.readLine();


            pst.setString(1,name);
            pst.setString(2,city);
            pst.executeUpdate();


            }



            System.out.println("inserted");
            con.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
