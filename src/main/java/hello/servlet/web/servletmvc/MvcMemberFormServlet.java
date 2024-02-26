package hello.servlet.web.servletmvc;


import java.io.IOException;


@WebServlet(name = "MvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form.jsp")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //다른 서블릿이나  jsp로 이동할수있는기능 서버내부에서 다시 호출이 발생한다
        dispatcher.forward(request, response);


        //WEB-INF는 무조건 컨트롤러를 거쳐야지 접속가능하다
    }
}
