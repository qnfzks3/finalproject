package qnfzks3.finalproject.service;

import qnfzks3.finalproject.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBookList(int cpage);

    public int getCountBook();

}
