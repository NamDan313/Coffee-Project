package DAL;

import DTO.DsOrder;
import BLL.ConnectSQL;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

public class GetDataDsOrder {

    private ConnectSQL checkconnect = new ConnectSQL();
    private Connection cn = checkconnect.openConnect();

    // load thông tin tên loại nước cụ thể theo mã hóa đơn
    public Vector<DsOrder> GetDsOrder(int ma) {
        Vector<DsOrder> arrDs = null;
        String sql;
        sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '" + ma + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new Vector<DsOrder>();
            while (rs.next()) {
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public Vector<DsOrder> GetGiaSoLuong(String ma) {
        Vector<DsOrder> arrDs = null;
        String sql;
        sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND ct.MaMon = '" + ma + "'";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new Vector<DsOrder>();
            while (rs.next()) {

                DsOrder order = new DsOrder();
                order.setGia(rs.getInt(1));
                order.setSoLuong(rs.getInt(2));
                order.setTenMon(rs.getString(3));
                order.setDVT(rs.getString(4));
                arrDs.add(order);
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
        }
        return arrDs;
    }

}
