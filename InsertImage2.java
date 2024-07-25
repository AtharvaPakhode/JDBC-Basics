import javax.swing.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;

public class InsertImage2 {
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


            JFileChooser jfc = new JFileChooser() ;
            jfc.showOpenDialog(null);
            File f =jfc.getSelectedFile();
            FileInputStream fs = new FileInputStream(f);
            pst.setBinaryStream(1,fs,fs.available());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"success");


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
