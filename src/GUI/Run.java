/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.TaiKhoan;

public class Run {
    
    public static frmMain homepage;// dùng để load thông tin mỗi khi có cập nhật mới
    public static frmLogIn frmlg; // khai báo biến tham chiếu đến class login để log vào tk
    public static TaiKhoan tk;// dùng để lưu thông tin tài khoản đang đăng nhập

    public static void main(String[] args) {
        login();
    }
    public static void login(){
        frmlg = new frmLogIn();
        frmlg.setVisible(true);       
    }  
    public static void Nuocgiaikhat(){// hiện lên trang chủ bán hàng
        homepage = new frmMain();
        homepage.setVisible(true);       
    }
   
   
}
