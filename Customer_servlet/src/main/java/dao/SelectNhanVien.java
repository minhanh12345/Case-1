package dao;

import models.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectNhanVien {
    static String select = "select name,birthday,address,phone,email,phongban from nhanvien ";

    public static List<NhanVien> seclect() throws SQLException, ClassNotFoundException {
        ArrayList<NhanVien> list = new ArrayList<>();
        // tạo connect đến CSDL
        Connection connection = ConnectMySql.getConnect();
        // tạo ra Statement bằng connection.
        Statement statement = connection.createStatement();
        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String birthDayDate = resultSet.getString("birthday");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");
            Integer phongban = Integer.valueOf(resultSet.getString("phongban"));


            list.add(new NhanVien(name, birthDayDate, address, phone,email,phongban));
        }
        return list;
    }
}