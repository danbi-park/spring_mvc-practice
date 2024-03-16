package hello.servlet.basic.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * HTTP Header 내용 조회하기
 *
 * */
@WebServlet(name= "requestHeaderServlet", urlPatterns="/request-header")
public class RequestHeaderServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
        printEtc(req);
    }

    private static void printStartLine(HttpServletRequest req) {
        System.out.println("--- Request Line started ---");

        System.out.println("req.getMethod() = " + req.getMethod()); //GET
        System.out.println("req.getProtocol() = " + req.getProtocol()); //HTTP/1.1
        System.out.println("req.getScheme() = " + req.getScheme()); //http
        System.out.println("req.getRequestURL() = " + req.getRequestURL()); // http://127.0.0.1:8080/request-header
        System.out.println("req.getRequestURI() = " + req.getRequestURI()); // /request-header
        System.out.println("req.getQueryString() = " + req.getQueryString()); //username=kim
        System.out.println("req.isSecure() = " + req.isSecure()); //false

        System.out.println("--- Request Line end ---");

        // 결과
//        Header started
//        host: 127.0.0.1:8080
//        connection: keep-alive
//        cache-control: max-age=0
//        sec-ch-ua: "Google Chrome";v="119", "Chromium";v="119", "Not?A_Brand";v="24"
//        sec-ch-ua-mobile: ?0
//        sec-ch-ua-platform: "macOS"
//        upgrade-insecure-requests: 1
//        user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36
//        accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
//        sec-fetch-site: none
//        sec-fetch-mode: navigate
//        sec-fetch-user: ?1
//        sec-fetch-dest: document
//        accept-encoding: gzip, deflate, br
//        accept-language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
//        Header end
    }


    /* Header 모든 정보 */
    private void printHeaders(HttpServletRequest req){
        System.out.println("Header started");
        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " +req.getHeader(headerName)));

        System.out.println("Header end");
    }

    /* 각편의 조회 */
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale()); //제일 위에 있는 Locale
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType()); //body가 없으면 null로 뜸 Get방식일때KX
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

    //기타 정보
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");

        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
        System.out.println();

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " + request.getLocalPort()); //

        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }
}
