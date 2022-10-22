
package DTO;

import java.util.Date;

public class HoaDon {
    private int MaHoaDon, TongTien, TrangThai ,MaBan;
    private Date GioDen;
    
    public HoaDon(){
        this.MaHoaDon =0;
        this.TongTien =0;
        TrangThai =0;
        MaBan = 0;
        GioDen=null;
    }

    public HoaDon(int MaHoaDon, int MaBan, Date GioDen,int TongTien, int TrangThai) {
        this.MaHoaDon = MaHoaDon;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.MaBan = MaBan;
        this.GioDen = GioDen;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public Date getGioDen() {
        return GioDen;
    }

    public void setGioDen(Date GioDen) {
        this.GioDen = GioDen;
    }

   
    
}
