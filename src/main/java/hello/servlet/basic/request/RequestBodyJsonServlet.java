package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
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
 * HTTP 요청 : API 메시지 바디 - JSON
 * 단순 텍스트, JSON, XML 등으로 전달할 수 있는데 최근 JSON이 표준화 되어 있다.
 * */
@WebServlet(name ="requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    // JSON 결과를  파싱할 수 있도록 JSON 변환 라이브러리를 사용한다.
    // Jackson, Gson 등
    // Spring boot, Spring MVC를 선택하명 Jackson 라이브러리 ObjectMapper를 함께 제공한다.
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        // objectMapper로 요청 바디 객체로 파싱하기
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        System.out.println("helloData.getUsername() = " + helloData.getUsername());
        System.out.println("helloData.getAge() = " + helloData.getAge());

        resp.getWriter().write("ok");
    }
}
