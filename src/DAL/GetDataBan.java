package DAL;

import DTO.Ban;
import BLL.ConnectSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

public class GetDataBan {

    //  Tạo biến tham chiếu tới class connectsql, tạo thêm biến cn để lấy kết quả connect với 
    // mysql( hoặc lấy biến tham chiếu gọi thẳng tới phương thức mysql cũng được)
    private ConnectSQL checkconnect = new ConnectSQL();
    private Connection cn = checkconnect.openConnect();

    public Vector<Ban> GetBan(int maban) {
        Vector<Ban> arrBan = null;
        String sql;
        if (maban == 0) {
            sql = "Select * From ban";
        } else {
            sql = "Select * From ban Where MaBan = '" + maban + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new Vector<Ban>();
            while (rs.next()) {
                Ban sp = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
                arrBan.add(sp);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan;
    }

    public int UpdateBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TenBan = '" + b.GetTenBan() + "', TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
        }
        return update;
    }

    public int UpDateTrangThaiBan(Ban b) {
        int update = 0;
        String sql = "UPDATE ban SET TrangThai = '" + b.GetTrangThai() + "' WHERE MaBan = '" + b.GetMaBan() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
        }
        return update;
    }

    public int InsertBan(Ban b) {
        int insert = 0;
        String sql = "Insert into ban (TenBan, TrangThai) values ('" + b.GetTenBan() + "', '" + b.GetTrangThai() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm bàn không thành công");
        }
        return insert;
    }

    public boolean DeleteBan(int MaBan) {
        boolean check = false;
        try {
            String sql;
            sql = "Delete From ban Where MaBan = '" + MaBan + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
            check = true;
        } catch (SQLException ex) {

        }
        return check;
    }

    public Vector<Ban> SearchBan(String ten) {
        Vector<Ban> arrtd = null;
        String sql;
        sql = "SELECT * FROM ban WHERE TenBan LIKE '" + ten + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new Vector<Ban>();
            while (rs.next()) {
                Ban td = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
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

}
