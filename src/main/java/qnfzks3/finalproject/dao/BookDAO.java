package qnfzks3.finalproject.dao;

import qnfzks3.finalproject.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAllBookList(int stbkid);

    int getCountBook();
}
