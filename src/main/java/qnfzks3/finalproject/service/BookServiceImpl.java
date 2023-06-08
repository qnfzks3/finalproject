package qnfzks3.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qnfzks3.finalproject.dao.BookDAO;
import qnfzks3.finalproject.model.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;


    @Override
    public List<Book> getAllBookList(Integer cpage) {
        int stbkid = (cpage - 1) * 5;
        return bookDAO.getAllBookList(stbkid);
    }

    @Override
    public int getCountBook() {
        return bookDAO.getCountBook();
    } //페이지 네이션 총 페이지 수

    @Override
    public List<Book> getBookListByCategory(String category,String fkey,Integer cpg) {  //검색 리스트 이기때문에 매개변수가 많다.
        int stbkid = (cpg - 1) * 5;

        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("fkey", fkey);
        params.put("stbkid", stbkid);

        return bookDAO.getBookListByCategory(params);
    }


    @Override
    public int getCountBookCategory(String category,String fkey) { //페이지 네이션 총 페이지 수

        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("fkey", fkey);

        return bookDAO.getBookCountByCategory(params);
    }

    @Override
    public Book getBookInfo(String bookid) {
        return bookDAO.getInfo(bookid);
    }
}
