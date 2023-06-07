package qnfzks3.finalproject.dao;

import qnfzks3.finalproject.model.Book;

import java.util.List;
import java.util.Map;

public interface BookDAO {
    List<Book> getAllBookList(int stbkid);

    int getCountBook();


    List<Book> getBookListByCategory(Map<String, Object> params);


    int getBookCountByCategory(Map<String, Object> params);

}
