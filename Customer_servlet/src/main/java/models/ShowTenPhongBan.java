package models;

public class ShowTenPhongBan {
    private String name;
    private String  birthDayDate;
    private String address;
    private String phone;
    private String email;
    private String phongban;

    public ShowTenPhongBan() {
    }

    public ShowTenPhongBan(String name, String birthDayDate, String address, String phone, String email, String phongban) {
        this.name = name;
        this.birthDayDate = birthDayDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.phongban = phongban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDayDate() {
        return birthDayDate;
    }

    public void setBirthDayDate(String birthDayDate) {
        this.birthDayDate = birthDayDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }
}
