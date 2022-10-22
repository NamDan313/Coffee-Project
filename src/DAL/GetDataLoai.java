
package DAL;

import DTO.Loai;
import BLL.ConnectSQL;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

public class GetDataLoai {

    private ConnectSQL checkconnect=new ConnectSQL();
    private Connection cn=checkconnect.openConnect();
    
    public Vector<Loai> GetLoai(){
        Vector<Loai> arrloai = null;
        String sql = "Select * From nhommon";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new Vector<Loai>();
            while(rs.next()){
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return arrloai; 
    }
    public int InsertLoai(Loai b){
        int insert = 0;
        String sql = "Insert into nhommon (TenLoai, MauSac) values ('"+b.GetTenLoai()+"', '"+b.GetMauSac()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        return insert;
    }
    public Loai GetLoaiByMa(String manhom){
        Loai loai = null;
        String sql = "Select * From nhommon Where MaLoai = '"+manhom+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                loai = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return loai; 
    } 
    public int UpdateLoai(Loai b){
        int update = 0;
        String sql = "UPDATE nhommon SET TenLoai = '"+b.GetTenLoai()+"', MauSac = '"+b.GetMauSac()+"' WHERE MaLoai = '"+b.GetMaLoai()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update Loại không thành công !");
        }
        return update;
    }
    public Vector<Loai> SearchLoai(String ten){
        Vector<Loai> arrtd = null;
        String sql;
            sql = "SELECT * FROM nhommon WHERE TenLoai LIKE '"+ten+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new Vector<Loai>();
            while(rs.next()){
                Loai td = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    } 
       public boolean DeleteNhom(String ma){
        boolean check = false;
        try{
            String sql;
                sql = "Delete From nhommon Where MaLoai = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            check = true;
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        }catch(SQLException ex){
            
        }
        return check;
    }
   public Vector GetNhomMon(){
        Vector arrloai = null;
        String sql = "Select * From nhommon";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new Vector();
            Loai all = new Loai(null, "Tất cả các món","");
            arrloai.add(all);            
            while(rs.next()){
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai; 
    }
}