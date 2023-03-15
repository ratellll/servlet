package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpServletResponse 확실하게 의미를보여줄수있음 모든상수확인가능  [status-Line]
        response.setStatus(HttpServletResponse.SC_OK);

        //response-header
        response.setHeader("Content-Type", "text/plain");
        //value뜻은 캐시를 완전히 무효화하겠다 라는뜻
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate ");
        //과거버전까지 캐시를 없애는것
        response.setHeader("Pragma", "no-cache");
        //내가 원하는 의미의 헤더를 생성가능
        response.setHeader("my-header","hello");


        //[Header 편의 메소드]
        //content(response);
        //cookie(response);
        //redirect(response);




        //test
        PrintWriter writer = response.getWriter();
        writer.println("ok");
            }
    private void content(HttpServletResponse response) {
    //Content-Type: text/plain;charset=utf-8
    //Content-Length: 2
    //response.setHeader("Content-Type", "text/plain;charset=utf-8");
     response.setContentType("text/plain");
     response.setCharacterEncoding("utf-8");
     //임의로 정할수있음 웬만하면 생략
     //response.setContentLength(2); // (생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //이 쿠키는 60초동안 유효하다
    //Set-Cookie: myCookie=good; Max-Age=600;
    // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        //쿠키메소드사용시 위에 라인과 같은 효과를 내어준다
     Cookie cookie = new Cookie("myCookie", "good");
     cookie.setMaxAge(600); //600초
            response.addCookie(cookie);
    }


    private void redirect(HttpServletResponse response) throws IOException {

        //Status Code 302 상태코드 설정
        //Location: /basic/hello-form.html 보내는 위치
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");

        //redirect사용시 위에 두 라인을 사용하는것
        response.sendRedirect("/basic/hello-form.html");
    }

}
