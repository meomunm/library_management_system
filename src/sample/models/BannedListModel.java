package sample.models;

public class BannedListModel {
    private String idLibraryCard;
    private String nameOfLibraryCard;
    private String dateofBannedList;

    public BannedListModel(String idLibraryCard, String nameOfLibraryCard, String dateofBannedList) {
        this.idLibraryCard = idLibraryCard;
        this.nameOfLibraryCard = nameOfLibraryCard;
        this.dateofBannedList = dateofBannedList;
    }

    public String getIdLibraryCard() {
        return idLibraryCard;
    }

    public void setIdLibraryCard(String idLibraryCard) {
        this.idLibraryCard = idLibraryCard;
    }

    public String getNameOfLibraryCard() {
        return nameOfLibraryCard;
    }

    public void setNameOfLibraryCard(String nameOfLibraryCard) {
        this.nameOfLibraryCard = nameOfLibraryCard;
    }

    public String getDateofBannedList() {
        return dateofBannedList;
    }

    public void setDateofBannedList(String dateofBannedList) {
        this.dateofBannedList = dateofBannedList;
    }
}
