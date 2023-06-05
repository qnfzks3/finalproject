package qnfzks3.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qnfzks3.finalproject.dao.BookDAO;
import qnfzks3.finalproject.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;


    @Override
    public List<Book> getAllBookList(int cpage) {
        int stbkid = (cpage - 1) * 5;
        return bookDAO.getAllBookList(stbkid);
    }

    @Override
    public int getCountBook() {
        return bookDAO.getCountBook();
    }
}
