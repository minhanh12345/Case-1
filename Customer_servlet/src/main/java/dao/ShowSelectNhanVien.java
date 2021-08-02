package dao;

import models.NhanVien;
import models.ShowNhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowSelectNhanVien {
    static String select = "select * from nhanvien";

    public static List<ShowNhanVien> seclect() throws SQLException, ClassNotFoundException {
        ArrayList<ShowNhanVien> list = new ArrayList<>();
        // tạo connect đến CSDL
        Connection connection = ConnectMySql.getConnect();
        // tạo ra Statement bằng connection.
        Statement statement = connection.createStatement();
        // thực câu truy vấn bằng statement.executeQuery và kết quả trả về là ResultSet;
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            Integer id=resultSet.getInt("id");
            String name = resultSet.getString("name");
            String birthDayDate = resultSet.getString("birthday");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");
            String phongban =resultSet.getString("phongban");


            list.add(new ShowNhanVien(id,name, birthDayDate, address, phone,email,phongban));
        }
        return list;
    }
}
