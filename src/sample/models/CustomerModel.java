package sample.models;

public class CustomerModel {
    private String id_cus;
    private String name_cus;
    private String mail_cus;
    private String born_date_cus;
    private String date_create_cus;
    private String address_cus;
    private String type_cus;

    public CustomerModel(String id_cus, String name_cus, String mail_cus, String born_date_cus, String date_create_cus, String address_cus, String type_cus) {
        this.id_cus = id_cus;
        this.name_cus = name_cus;
        this.mail_cus = mail_cus;
        this.born_date_cus = born_date_cus;
        this.date_create_cus = date_create_cus;
        this.address_cus = address_cus;
        this.type_cus = type_cus;
    }
    //TODO: lấy dữ liệu từ database đổ vào tableview

    public String getId_cus() {
        return id_cus;
    }

    public void setId_cus(String id_cus) {
        this.id_cus = id_cus;
    }

    public String getName_cus() {
        return name_cus;
    }

    public void setName_cus(String name_cus) {
        this.name_cus = name_cus;
    }

    public String getMail_cus() {
        return mail_cus;
    }

    public void setMail_cus(String mail_cus) {
        this.mail_cus = mail_cus;
    }

    public String getBorn_date_cus() {
        return born_date_cus;
    }

    public void setBorn_date_cus(String born_date_cus) {
        this.born_date_cus = born_date_cus;
    }

    public String getDate_create_cus() {
        return date_create_cus;
    }

    public void setDate_create_cus(String date_create_cus) {
        this.date_create_cus = date_create_cus;
    }

    public String getAddress_cus() {
        return address_cus;
    }

    public void setAddress_cus(String address_cus) {
        this.address_cus = address_cus;
    }

    public String getType_cus() {
        return type_cus;
    }

    public void setType_cus(String type_cus) {
        this.type_cus = type_cus;
    }
}
