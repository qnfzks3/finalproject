package qnfzks3.finalproject.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qnfzks3.finalproject.model.Book;

import java.util.List;

@Repository("bookdao")
public class BookDAOImpl implements BookDAO{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Book> getAllBookList() {
        return sqlSession.selectList("book.selectBook");
    }
}
