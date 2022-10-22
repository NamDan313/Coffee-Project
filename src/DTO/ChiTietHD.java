
package DTO;

public class ChiTietHD {
    private int MaChiTietHD, MaHoaDon, SoLuong, Gia;
    private String MaMon;
    // lưu ds các món ăn, số lượng và giá
    public ChiTietHD(){
        MaMon = "";
        MaChiTietHD =0;
        MaHoaDon =0;
        SoLuong =0;
        Gia = 0;
    }

    public ChiTietHD(int MaChiTietHD, int MaHoaDon, int SoLuong, int Gia, String MaMon) {
        this.MaChiTietHD = MaChiTietHD;
        this.MaHoaDon = MaHoaDon;
        this.SoLuong = SoLuong;
        this.Gia = Gia;
        this.MaMon = MaMon;
    }

    public int getMaChiTietHD() {
        return MaChiTietHD;
    }

    public void setMaChiTietHD(int MaChiTietHD) {
        this.MaChiTietHD = MaChiTietHD;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    
}
