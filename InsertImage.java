
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;
import java.sql.PreparedStatement;

public class InsertImage {
    public static void main(String[] args) {
        try{

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            String url ="jdbc:mysql://localhost:3306/youtube";
            String userName = "root";
            String password ="_ _ _ _ _"; // your password goes here
            Connection con = DriverManager.getConnection(url,userName,password);

            String q= "insert into images(pic) values(?)";

            PreparedStatement pst = con.prepareStatement(q);
            FileInputStream fs = new FileInputStream("image path");
            pst.setBinaryStream(1,fs,fs.available());
            pst.executeUpdate();

            System.out.println("inserted.....");



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
