package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * HTTP 응답 : 기본 사용법
 * 헤더, 쿠키, 리다이렉션 설정
 * */
@WebServlet(name= "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // [status line]
        // HTTP 시작 라인
        // setStatus(200), 의미를 바로 파악할 수 있도록 상수 사용!
        resp.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
        resp.setHeader("Content-Type" , "text/plain;charset=utf-8"); //인코딩도 같이 적용
        //캐시 무효화
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");

        // header 커스텀 가능!
        resp.setHeader("my-header", "hello");


        //[Header의 편의 메서드]
        content(resp); //위 내용을 간단하게 메소드로
        cookie(resp); // 쿠키 관련된 메서드
        redirect(resp); // 리다이렉트 메소드


        resp.getWriter().write("안녕하세요"); // 인코딩 charset=utf-8 적용했기 때문에 가넝

        // [Message Body]
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("ok");

    }


    //[Header의 편의 메서드 - header 설정 메소드]
    private void content(HttpServletResponse resp){
//        resp.setHeader("Content-Type" , "text/plain;charset=utf-8");
        // 위 내용을 아래처럼 쓸 수도 있음
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.setContentLength(3); // 생략 시 자동 생성, 참고로 print("ok") -> 2, println("ok") -> 3 : enter가 들어가서 하나 추가됨
    }

    //[Header의 편의 메서드 - 쿠키]
    private void cookie(HttpServletResponse resp){
        //Set-Cookie : myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good;Max-Age=600;");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초 동안 유효하도록 설정
        resp.addCookie(cookie);

    }

    //[Header의 편의 메서드 - 리다이렉트]
    private void redirect(HttpServletResponse resp) throws IOException {
        //Status Code 302
        //lLocation: /basic/hello-form.html

//        resp.setStatus(HttpServletResponse.SC_FOUND); // 302
        // resp.setHeader("Location", "/basic/hello-form.html");
        // 위 두 줄을 아래 한 줄로 ! 302도 됨
        resp.sendRedirect("/basic/hello-form.html");

    }
}