package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/*
 * HTTP 요청 : API 메시지 바디 - TEXT
 * 단순 텍스트, JSON, XML 등으로 전달할 수 있는데 최근 JSON이 표준화 되어 있다.
 * */
@WebServlet(name ="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 1. 단순 텍스트 조회 */
        // getInputStream() : HTTP 요청 바디 내용을 바이트 코드로 조회할 수 있습니다.
        ServletInputStream inputStream = req.getInputStream();
        // 바이트 코드 -> 문자로 변환
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //어떤 인코딩인지 알려줘야 함

        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("ok");
    }
}
