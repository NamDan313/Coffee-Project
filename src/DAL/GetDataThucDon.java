
package DAL;

import DTO.ThucDon;
import BLL.ConnectSQL;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

public class GetDataThucDon {

    private ConnectSQL checkconnect = new ConnectSQL();
    private Connection cn = checkconnect.openConnect();
    // hàm để lấy thông tin các loại nước
    public Vector<ThucDon> GetThucDon(String ma) {
        Vector<ThucDon> arrThucDon = null;
        String sql;
        if (ma == null) {
            sql = "Select * From thucdon";
        } else {
            sql = "Select * From thucdon Where MaLoai = '" + ma + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new Vector<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

    public int InsertThucDon(ThucDon td) {
        int insert = 0;
        String sql = "Insert into thucdon (TenMon, MaLoai, DonGia, DVT) values ('" + td.GetTenMon() + "', '" + td.GetMaLoai() + "', '" + td.GetDonGia() + "', '" + td.GetDVT() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        } catch (SQLException ex) {
        }
        return insert;
    }

    public boolean DeleteThucDon(String Mamon) {
        boolean check = false;
        try {
            String sql;
                sql = "Delete From thucdon Where MaMon = '" +Mamon + "'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            check = true;
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return check;
    }

    public int UpdateThucDon(ThucDon td) {
        int update = 0;
        String sql = "UPDATE thucdon SET TenMon = '" + td.GetTenMon() + "', MaLoai = '" + td.GetMaLoai() + "', DonGia = '" + td.GetDonGia() + "', DVT = '" + td.GetDVT() + "' WHERE MaMon = '" + td.GetMaMon() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update món không thành công !");
        }
        return update;
    }



    public Vector<ThucDon> SearchMon(String ten) {
        Vector<ThucDon> arrtd = null;
        String sql;
        sql = "SELECT * FROM thucdon WHERE TenMon LIKE '" + ten + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new Vector<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrtd.add(td);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }

    public Vector<ThucDon> GetThucDonByMa(String ma) {
        Vector<ThucDon> arrThucDon = null;
        String sql;

        sql = "Select * From thucdon Where MaMon = '" + ma + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new Vector<ThucDon>();
            while (rs.next()) {
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;
    }

}
