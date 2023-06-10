package qnfzks3.finalproject.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import qnfzks3.finalproject.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Book> getBookListByCategory(Map<String, Object> params) {


        return sqlSession.selectList("book.selectFindBook",params);
    }

    @Override
    public int getBookCountByCategory(Map<String, Object> params) { //함수 안 매개변수는 주소창에서 가져오는 매개변수들을 의미
        return sqlSession.selectOne("book.countFindBook",params);
    }

    //정확히는 mapper 변수 받아올거야-> ...->controller 받아왔다!짠 이제 jsp로 보내주자 mapper에서 바로 컨트롤러와 이어지는거라고 보면 됨
    @Override
    public Book getInfo(String bookid) {
        return sqlSession.selectOne("book.selectBookInfo",bookid);  
    }

    @Override
    public int insertBook(Book newbook) {
        return sqlSession.insert("book.insertBook",newbook);  //이게 왜 인트야??
    }
}


