package BLL;
import java.sql.*;
import javax.swing.*;
public class ConnectSQL {
    final  String url="jdbc:mysql://localhost:3306/drink";
    final String user="root";
    final  String password="hoangquan2k1";
    public ConnectSQL(){

    }
        public  Connection openConnect() 
        {
            try
            {
                  return DriverManager.getConnection(url, user, password);
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Kết nối thất bại");
            }
            return null;
        }
        public boolean closeConnect() 
        {
            boolean check=false;
            try
            {
                Connection con =openConnect();
                if(con!=null)
                {
                    con.close();
                    check=true;
                }
            }
            catch(SQLException e)
            {
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
            return check;
        }
        
}
