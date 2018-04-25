package sample.models;

public class RentBookModel {
    private String idRentBook;
    private String idBook;
    private String idCustomer;
    private String nameOfBook;
    private String nameOfCustomer;
    private String dateOfRentBook;

    public RentBookModel(String idRentBook, String idBook, String idCustomer, String nameOfBook, String nameOfCustomer, String dateOfRentBook) {
        this.idRentBook = idRentBook;
        this.idBook = idBook;
        this.idCustomer = idCustomer;
        this.nameOfBook = nameOfBook;
        this.nameOfCustomer = nameOfCustomer;
        this.dateOfRentBook = dateOfRentBook;
    }

    public String getIdRentBook() {
        return idRentBook;
    }

    public String getIdBook() {
        return idBook;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public String getDateOfRentBook() {
        return dateOfRentBook;
    }
}
