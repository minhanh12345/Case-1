package services;

import dao.SelectNhanVien;
import models.NhanVien;

import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienService {
    public ArrayList<NhanVien> list = new ArrayList<>();

    public NhanVienService(){
        try {
            list = (ArrayList<NhanVien>) SelectNhanVien.seclect();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(NhanVien nhanVien){
        list.add(nhanVien);
    }

    public void edit(NhanVien nhanVien, int index){
        list.set(index, nhanVien);
    }

    public void delete(int index){
        list.remove(index);
    }

    public NhanVien findByName(String name){
        for (NhanVien c:list) {
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }



}