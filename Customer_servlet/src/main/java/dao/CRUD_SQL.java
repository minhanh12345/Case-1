package dao;

import services.NhanVienService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_SQL {

    public static void createCustomerSQL(String name,String birthday,String address,String phone,String email,int phongban){

        Connection connection = null;
        try {
            connection = ConnectMySql.getConnect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // tạo ra Statement bằng connection.
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        try {

            statement.executeUpdate("insert into nhanvien(name,birthday,address,phone,email,phongban) value ( "+name+","+birthday+","+address+","+phone+","+email+","+phongban+")");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void editCustomerSQL(int index,String name,String birthday,String address,String phone,String email,int phongban) throws SQLException, ClassNotFoundException {
        NhanVienService nhanVienService =new NhanVienService();
        int idEdit= ShowSelectNhanVien.seclect().get(index).getId();
        Connection connection = null;
        try {
            connection = ConnectMySql.getConnect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        try {

            PreparedStatement statement1 = connection.prepareStatement("update demojdbc.nhanvien set name=?,birthday=?,address=?,phone=?,email=?,phongban=? where id=?");
            statement1.setString(1,name);
            statement1.setString(2,birthday);
            statement1.setString(3,address);
            statement1.setString(4,phone);
            statement1.setString(5,email);
            statement1.setInt(6,phongban);
            statement1.setInt(7,idEdit);
            statement1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void deleteCustomerSQL(int index) throws SQLException, ClassNotFoundException {
        NhanVienService nhanVienService =new NhanVienService();
        int idEdit= ShowSelectNhanVien.seclect().get(index).getId();
        Connection connection = null;
        try {
            connection = ConnectMySql.getConnect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // tạo ra Statement bằng connection.
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        try {
            statement.executeUpdate("delete from nhanvien where id="+idEdit);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
