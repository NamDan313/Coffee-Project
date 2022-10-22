package DAL;

import DTO.TaiKhoan;
import BLL.ConnectSQL;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

public class GetDataTaiKhoan {

    private ConnectSQL checkconnect = new ConnectSQL();
    private Connection cn = checkconnect.openConnect();

    public int UpdateTK(TaiKhoan b) {
        int update = 0;
        String sql = "UPDATE taikhoan SET username = '" + b.GetUsername() + "', password = '" + b.GetPassword() + "', lv = '" + b.GetLv() + "' WHERE id = '" + b.GetID() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }

    public TaiKhoan GetTaiKhoan(String name, String pass) {
        // lấy thông tin tên và pass của tài khoản trong mysql
        TaiKhoan td = null;
        String sql;
        sql = "SELECT * FROM taikhoan Where username = '" + name + "' AND password='" + pass + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }

    public TaiKhoan GetTaiKhoan(int id) {
        // sửa tk dựa theo id 
        TaiKhoan td = null;
        String sql;
        sql = "SELECT * FROM taikhoan WHERE id = '" + id + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }

    public int InserTK(TaiKhoan b) {
        int insert = 0;
        String sql = "Insert into taikhoan (username, password, lv) values ('" + b.GetUsername() + "', '" + b.GetPassword() + "', '" + b.GetLv() + "')";
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

    public boolean DeleteTaiKhoan(int id) {
        boolean check = false;
        try {
            String sql;
            sql = "Delete From taikhoan Where id = '" + id + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            check = true;
        } catch (SQLException ex) {

        }
        return check;
    }

    public Vector<TaiKhoan> GetTaiKhoan() {
        Vector<TaiKhoan> arrtd = null;
        String sql;
        sql = "SELECT * FROM taikhoan ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new Vector<TaiKhoan>();
            while (rs.next()) {
                TaiKhoan td = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
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

    public boolean CheckLogin(TaiKhoan tk) {
        boolean check = false;
        String sql;
        sql = "Select * From taikhoan Where username = '" + tk.GetUsername() + "' AND password='" + tk.GetPassword() + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                check = true;
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check;
    }

}
