package sample.utils;

import sample.models.BannedListModel;
import sample.models.BookModel;
import sample.models.CustomerModel;
import sample.models.RentBookModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algorithms {

    /* TODO: optimize code
    *   Tạo 1 class cha Model, cho các class models extend Model sử dụng
    *   if(Model íntance models){
    *       //body
    *   }
    *
    *   để giảm code lặp
    *
    * */
    public static CustomerModel searchCusomerID(List<CustomerModel> list, String data) {
        //TODO: sắp xếp list theo thứ tự tăng dần dựa vào ID
        list.sort(new Comparator<CustomerModel>() {
            @Override
            public int compare(CustomerModel o1, CustomerModel o2) {
                return o1.getId_cus().compareTo(o2.getId_cus());
            }
        });

        //TODO: binary search
        int low = 0;
        int high = list.size() - 1;
        int mid;
        while (low <= high) {
            //chia mảng làm 2
            mid = (low + high) / 2;

            if (list.get(mid).getId_cus().compareTo(data) < 0) {
                low = mid + 1;
            } else if (list.get(mid).getId_cus().compareTo(data) > 0) {
                high = mid - 1;
            } else {
                return list.get(mid); //phần tử cần tìm
            }
        }
        return null; //ko tìm thấy phần tử
    }

    public static BookModel searchBook(List<BookModel> list, String data) {
        //TODO: sắp xếp list theo thứ tự tăng dần dựa vào ID
        list.sort(new Comparator<BookModel>() {
            @Override
            public int compare(BookModel o1, BookModel o2) {
                return o1.getId_book().compareTo(o2.getId_book());
            }
        });

        //TODO: binary search
        int low = 0;
        int high = list.size() - 1;
        int mid;
        while (low <= high) {
            //chia mảng làm 2
            mid = (low + high) / 2;

            if (list.get(mid).getId_book().compareTo(data) < 0) {
                low = mid + 1;
            } else if (list.get(mid).getId_book().compareTo(data) > 0) {
                high = mid - 1;
            } else {
                return list.get(mid); //phần tử cần tìm
            }
        }
        return null; //ko tìm thấy phần tử
    }

    public static RentBookModel searchRentBook(List<RentBookModel> list, String keyword) {
        list.sort(new Comparator<RentBookModel>() {
            @Override
            public int compare(RentBookModel o1, RentBookModel o2) {
                return o1.getIdRentBook().compareTo(o2.getIdRentBook());
            }
        });

        int low = 0;
        int high = list.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (list.get(mid).getIdRentBook().compareTo(keyword) < 0) {
                low = mid + 1;
            } else if (list.get(mid).getIdRentBook().compareTo(keyword) > 0) {
                high = mid - 1;
            } else {
                return list.get(mid);
            }
        }
        return null;
    }

    public static boolean isBanned(List<BannedListModel> list, String keyword){
//        list.sort(new Comparator<BannedListModel>() {
//            @Override
//            public int compare(BannedListModel o1, BannedListModel o2) {
//                return o1.getIdLibraryCard().compareTo(o2.getIdLibraryCard());
//            }
//        });

        for (BannedListModel model :list) {
            if (model.getIdLibraryCard().equals(keyword)){
                return true;
            }
        }
        return false;
    }

    public static boolean isCustomerRentingBook(List<RentBookModel>list, String IDkeyword){
//        list.sort(new Comparator<RentBookModel>() {
//            @Override
//            public int compare(RentBookModel o1, RentBookModel o2) {
//                return o1.getIdCustomer().compareTo(o2.getIdCustomer());
//            }
//        });

        for (RentBookModel model: list){
            if (model.getIdCustomer().equals(IDkeyword)){
                return true;
            }
        }
        return false;
    }

    public static boolean isBookOnRentBookList(List<RentBookModel> list, String IDBook){
//        list.sort(new Comparator<RentBookModel>() {
//            @Override
//            public int compare(RentBookModel o1, RentBookModel o2) {
//                return o1.getIdBook().compareTo(o2.getIdBook());
//            }
//        });

        for (RentBookModel model: list){
            if (model.getIdBook().equals(IDBook)){
                return true;
            }
        }
        return false;
    }
}
