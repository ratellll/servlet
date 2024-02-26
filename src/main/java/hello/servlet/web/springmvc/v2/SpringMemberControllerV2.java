package hello.servlet.web.springmvc.v2;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller //연관성이 있는 컨트롤러끼리만 묶어서 한클래스에 넣어두는것도 좋은것
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newform() {
        return new ModelAndView("new-form");
    }


    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);

        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        int size= Integer.parseInt(request.getParameter("size"));
        int account = Integer.parseInt(request.getParameter("account"));

        Member member = new Member(username, age,size,account);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }




}
