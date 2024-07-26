
import java.sql.*;

public class SelectData {
    public static void main(String[] args) {
        try{

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url ="jdbc:mysql://localhost:3306/youtube";
            String userName = "root";
            String password ="_ _ _ _ _"; // your password goes here
            Connection con = DriverManager.getConnection(url,userName,password);

            String q= "select * from table1";
            Statement st =con.createStatement();
            ResultSet set =st.executeQuery(q);

            while(set.next()){
                int id= set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);

                System.out.println(id +" : "+name+" : "+city);

            }

            System.out.println("done....");


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
