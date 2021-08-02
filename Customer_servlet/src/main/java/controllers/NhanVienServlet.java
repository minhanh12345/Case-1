package controllers;

import dao.CRUD_SQL;
import dao.ShowSelectNhanVien;
import dao.ShowSelectTenPhongBan;
import models.NhanVien;
import services.NhanVienService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/nhanvien"})
public class NhanVienServlet extends HttpServlet {
    NhanVienService nhanVienService = new NhanVienService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showphongban":
                try {
                    req.setAttribute("listCustomer", ShowSelectTenPhongBan.seclect());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                requestDispatcher = req.getRequestDispatcher("views/ShowNhanVien.jsp");
                requestDispatcher.forward(req, resp);
                break;
            case "create":
                resp.sendRedirect("views/createNhanVien.jsp");
                break;
            case "edit":
                int indexEdit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("nhanvien", nhanVienService.list.get(indexEdit));
                requestDispatcher = req.getRequestDispatcher("views/editNhanVien.jsp");
                requestDispatcher.forward(req, resp);
                break;

            case "delete":
                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    CRUD_SQL.deleteCustomerSQL(index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                nhanVienService.delete(index);
                resp.sendRedirect("/nhanvien");
                break;

            case "find":
                resp.sendRedirect("views/FindCustomer.jsp");
                break;
            default:
                req.setAttribute("listCustomer", nhanVienService.list);
                requestDispatcher = req.getRequestDispatcher("views/ShowNhanVien.jsp");
                requestDispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        switch (action) {

            case "create":

                String name = req.getParameter("name");
                String birthDayDate = req.getParameter("birthDayDate");
                String address = req.getParameter("address");
                String phone=req.getParameter("phone");
                String email=req.getParameter("email");
               Integer phongban= Integer.valueOf(req.getParameter("phongban"));

                NhanVien nhanVien = new NhanVien(name, birthDayDate, address, phone,email,phongban);
                nhanVienService.save(nhanVien);
                CRUD_SQL.createCustomerSQL( name, birthDayDate, address,phone,email,phongban);


                // chuyển hướng request và response sang thàng jsp
                req.setAttribute("listCustomer", nhanVienService.list);
                requestDispatcher = req.getRequestDispatcher("views/ShowNhanVien.jsp");
                requestDispatcher.forward(req, resp);
                break;

            case "edit":

                String nameEdit = req.getParameter("name");
                String birthDayDateEdit = req.getParameter("birthDayDate");
                String addressEdit = req.getParameter("address");
                String phoneEdit=req.getParameter("phone");
                String emailEdit=req.getParameter("email");
               Integer phongbanEdit= Integer.valueOf(req.getParameter("phongban"));

                int index = Integer.parseInt(req.getParameter("index"));

                NhanVien nhanVienEdit = new NhanVien(nameEdit,birthDayDateEdit, addressEdit,phoneEdit,emailEdit,phongbanEdit);
                nhanVienService.edit(nhanVienEdit, index);
                try {
                    CRUD_SQL.editCustomerSQL(index, nameEdit, birthDayDateEdit, addressEdit,phoneEdit,emailEdit,phongbanEdit);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                // chuyển hướng request và response sang thàng jsp
                req.setAttribute("listCustomer", nhanVienService.list);
                requestDispatcher = req.getRequestDispatcher("views/ShowNhanVien.jsp");
                requestDispatcher.forward(req, resp);

                break;
            case "find":


                String nameFind = req.getParameter("nameFind");
                NhanVien nhanVienFind = nhanVienService.findByName(nameFind);
                String result;
                if (nhanVienFind == null) {
                    result = "ko co";
                } else {
                    result = nhanVienFind.toString();
                }


                req.setAttribute("CustomerFind", result);
                requestDispatcher = req.getRequestDispatcher("views/ShowFind.jsp");
                requestDispatcher.forward(req, resp);
        }
    }
}
