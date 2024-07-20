
import java.sql.*;
public class statement {
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

            String q = "CREATE TABLE table1 ("
                    + "Id INT(20) PRIMARY KEY AUTO_INCREMENT, "
                    + "Name VARCHAR(200) NOT NULL, "
                    + "City VARCHAR(40) NOT NULL)";
            //create a statement
            Statement st =con.createStatement();
            st.executeUpdate(q);
            System.out.println("table is created");
            con.close();



        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}