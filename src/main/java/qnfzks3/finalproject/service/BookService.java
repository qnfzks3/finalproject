package qnfzks3.finalproject.service;

import qnfzks3.finalproject.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBookList(Integer cpage);

    public int getCountBook();

    List<Book> getBookListByCategory(String category,String fkey,Integer cpg);

    public int getCountBookCategory(String category,String fkey);


    List<Book> getBookInfo(String bookid);
}
