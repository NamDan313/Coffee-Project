package DTO;
public class DsOrder {
    // thong tin ve các món ăn cụ thể khi gọi món
    private String TenMon, MaMon, DVT; 
    private int Gia, SoLuong, MaHoaDon;
    
    public DsOrder(){
        TenMon = MaMon = DVT = "";
        Gia = SoLuong = MaHoaDon = 0;
    }
    public DsOrder(String MaMon, String TenMon, String DVT, int SoLuong, int Gia, int MaHoaDon){
        this.MaMon = MaMon;
        this.MaHoaDon = MaHoaDon;
        this.TenMon = TenMon;
        this.DVT = DVT;
        this.Gia= Gia;
        this.SoLuong = SoLuong;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }
  
}
