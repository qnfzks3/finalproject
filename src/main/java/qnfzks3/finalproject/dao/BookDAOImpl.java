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
    public List<Book> getAllBookList(int stbkid) {
        return sqlSession.selectList("book.selectBook",stbkid);
    }

    @Override
    public int getCountBook() {
        return sqlSession.selectOne("book.countBook");  //sqlSession.selectOne()은 MyBatis에서 단일 결과를 조회하는 메서드

    }










}


