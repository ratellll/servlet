MVC컨트롤러의 단점

포워드 중복
View로 이동하는 코드가 항상 중복호출이된다.
ViewPath또한 중복이심함 * 만일 jsp가아닌 다른 뷰로 변경하려면 전체코드를 변경해야함

공통처리가 어렵다
기능이 복잡해질수록 컨트롤러에서 공통으로 처리해야하는 부분이 점점 더 많아질것이다 공통기능을 메서드로 뽑으면될것같지만  
결과적으로 해당메소드를 계속호출해야하고 만일 호출하지않으면 실수가되고 호출자체가 중복이된다

-- 공통기능을 먼저 처리해야한다 -- 프론트 컨트롤러를 이용하여 문제를 해결가능




기본 Spring MVC 구조

HTTP 요청이 들어오면 DispatcherServlet이 요청을 받는다.
DispatcherServlet은 HandlerMapping을 통해 요청을 처리할 Controller를 찾는다.
HandlerMapping을 통해 찾은 HandlerAdapter를 DispatcherServlet에게 반환한다.
DispatcherServlet은 HandlerAdapter를 통해 Controller를 실행한다.
Controller는 요청을 처리하고, 처리 결과를 ModelAndView 객체에 담아 DispatcherServlet에게 반환한다.
DispatcherServlet은 ViewResolver를 통해 View를 찾는다.
View는 Model에 담긴 데이터를 사용해서 화면을 그리고, 그 결과를 DispatcherServlet에게 반환한다.
DispatcherServlet은 View를 통해 생성된 화면을 HTTP 응답으로 클라이언트에게 전송한다.



