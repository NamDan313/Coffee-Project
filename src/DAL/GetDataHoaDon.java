package DAL;

import DTO.HoaDon;
import DTO.Loai;
import BLL.ConnectSQL;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

public class GetDataHoaDon {

    private ConnectSQL checkconnect = new ConnectSQL();
    private Connection cn = checkconnect.openConnect();

    public Vector<Loai> GetLoai() {
        Vector<Loai> arrloai = null;
        String sql = "Select * From nhomon";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new Vector<Loai>();
            while (rs.next()) {
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai;
    }

    public int HuyHD(HoaDon hd) {
        int update = 0;
        String sql = "Delete From hoadon WHERE MaHoaDon = '" + hd.getMaHoaDon()+ "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;
    }

    public int ThanhToan(HoaDon hd) {
        int update = 0;
        String sql = "UPDATE hoadon SET TongTien = '" + hd.getTongTien() + "', TrangThai = 1 WHERE MaHoaDon = '" + hd.getMaHoaDon()+ "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;
    }

    public int InsertHoaDon(HoaDon hd, String gio) {
        int insert = 0;
        String sql = "Insert into hoadon (MaBan, GioDen, TrangThai) values ('" + hd.getMaBan() + "', '" + gio + "', '" + hd.getTrangThai() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        } catch (SQLException ex) {
        }
        return insert;
    }

    public HoaDon GetHDbyMaBan(int ma) {
        String sql;
        HoaDon arrhd = null;
        sql = "Select * From hoadon Where MaBan = '" + ma + "' AND TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrhd = new HoaDon(rs.getInt(1),rs.getInt(2),rs.getTimestamp(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;
    }



      
    public int GetMaHD(int ma){
        String sql;
        int mahd = 0;
            sql = "Select MaHoaDon From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mahd = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;        
    } 
    // đếm sl những khách hàng chưa thanh toán và up sản phẩm và chi tiết hóa đơn lên class gọi món
        public int CheckDsMon(int mahd, int maban){
        String sql;
        int dem = 0;
            sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '"+maban+"' AND ct.MaHoaDon = '"+mahd+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dem++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return dem;        
    } 

}
