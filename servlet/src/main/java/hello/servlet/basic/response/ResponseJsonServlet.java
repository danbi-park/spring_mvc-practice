package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * HTTP 응답 데이터 : json 반환
 * */
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper obj = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        //참고로 "application/json"은 스펙상 utf-8을 사용하도록 정의되어 있다. 따라서 추가를 해도 의미없는 데이터가 된다.
        resp.setCharacterEncoding("utf-8");

        //객체 생성해주기
        HelloData helloData = new HelloData();
        helloData.setUsername("젋은단비");
        helloData.setAge(20);

        //{"username" : "젋은단비", "age":20}
        // writeValueAsString() : 객체를 JSON 문자로 변경할 수 있다.
        String result = obj.writeValueAsString(helloData);

        resp.getWriter().write(result);
    }
}
