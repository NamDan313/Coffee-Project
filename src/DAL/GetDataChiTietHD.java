package DAL;

import DTO.ChiTietHD;
import DAL.GetDataHoaDon;
import BLL.ConnectSQL;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

public class GetDataChiTietHD {

    private ConnectSQL checkconnect = new ConnectSQL();
    private Connection cn = checkconnect.openConnect();

    private GetDataHoaDon hd = new GetDataHoaDon();

    // lấy thông tin chi tiết của món khách muốn gọi
    public ChiTietHD GetDsChiTiet(String ma, int maban) {
        ChiTietHD arrDs = null;
        String sql;

        sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '" + ma + "' AND MaBan = '" + maban + "' AND hd.TrangThai = 0";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                arrDs = new ChiTietHD();
                arrDs.setSoLuong(rs.getInt(1));
                arrDs.setGia(rs.getInt(2));
                arrDs.setMaChiTietHD(rs.getInt(3));
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;
    }

    public int UpdateChiTiet(ChiTietHD ct) {
        int update = 0;
        String sql = "UPDATE chitiethd SET SoLuong = '" + ct.getSoLuong() + "', Gia = '" + ct.getGia() + "' WHERE MaChiTietHD = '" + ct.getMaChiTietHD() + "'";
        try {
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;
    }

    public int InsertChiTietHD(ChiTietHD cthd) {
        int insert = 0;
        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('" + cthd.getMaHoaDon() + "', '" + cthd.getMaMon() + "', '" + cthd.getSoLuong() + "', '" + cthd.getGia() + "')";
        try {
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !" + ex.toString());
        }
        return insert;
    }
// khi khách muốn hủy món

    public int DeleteMon(String mamon, int mahd, int maban) {
        int check = 0;
        try {
            String sql;
            sql = "Delete From chitiethd Where MaMon = '" + mamon + "' AND MaHoaDon = '" + mahd + "'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if (hd.CheckDsMon(mahd, maban) == 0) {
                check = 2;
            }
            if (!checkconnect.closeConnect()) {
                JOptionPane.showMessageDialog(null, "Đóng kết nối thất bại");
            }           
        } catch (SQLException ex) {

        }
        return check;
    }

}
