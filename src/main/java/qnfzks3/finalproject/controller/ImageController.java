package qnfzks3.finalproject.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@Controller
public class ImageController {
    private static final String IMAGE_DIRECTORY = "C:/upload"; // 이미지 디렉토리 경로


    //@PathVariable 는 url 경로 변수 , HttpServletResponse 는 http 응답 처리 객체 클라이언트에 보내고 싶을 때 사용
    @GetMapping("/image/{imageName}") //왜 url에 http://localhost:8080/list/booklist?cpg=1 를 쳤는데 이미지가 출력되는걸까?
    public void serveImage(@PathVariable String imageName, HttpServletResponse response) { //

        //<img src="<c:url value='/image/${book.imagePath}' />"  /> jps에 이렇게 적어서 경로 url을 넣으면 이미지가 나오도록
        // 컨트롤러로 설정해줌 - url은 단순히 클라이언트를 출력만 조정하는 것이 아닌 클라이언트안에 일부분도 원하는 것을 다양하게 출력 가능

        try {
            // 이미지 파일 경로
            String imagePath = IMAGE_DIRECTORY + File.separator + imageName;
            //File.separator는 Windows 운영 체제에서는 파일 경로를 백슬래시(\)로 구분하며,
            // Linux 또는 macOS와 같은 Unix 기반 운영 체제에서는 슬래시(/)를 사용, 그렇게 /가들어갈지 \가 들어갈지 환경에 맞게 구분자사용

            // 이미지를 읽어와서 response에 출력
            FileInputStream inputStream = new FileInputStream(imagePath);
            //FileInputStream은 경로상에 있는 파일을 읽기위한 메서드
            // FileInputStream(imagePath) 경로상의 파일을 읽어와 객체를 생성해서 FileInputStream inputStream 안에 저장
            IOUtils.copy(inputStream, response.getOutputStream());
            //IOUtils.copy(): inputStream에서 읽은 데이터를 response 객체의 출력 스트림(response.getOutputStream())에 복사(저장)해서
            //데이터를 전송할 때 쓰인다.-파일을 읽어서 웹 응답으로 보냄 - 버퍼로 보냄 
            // 즉, 이미지 데이터를 HTTP 응답으로 보냅니다.(버퍼에 보내기 위해서 응답에 저장하는 과정)
            
            response.flushBuffer();
            // 웹 응답은 일반적으로 버퍼링 되어 먼저 버퍼에 쓰여진 다음 클라이언트에게 전달된다.
            //response.flushBuffer(): 버퍼에 있는 데이터를 실제 응답으로 플러시합니다. 즉, 이미지 데이터가 클라이언트로 전송
            // response에 저장해서 버퍼링 하고 버퍼링 되면 버퍼에 있는 걸 클라이언트에 출력  response(응답) 저장 -> 버퍼 -> 클라이언트

        } catch (IOException e) {
            // 예외 처리
            e.printStackTrace();
        }
    }
}






//정리 = 경로를 지정하고 경로로 지정된 파일을 읽어와서 클라이언트 응답에 저장 하면 버퍼링 됬을 때, 버퍼에 파일이 저장되며 버퍼를 클라이언트에 출력