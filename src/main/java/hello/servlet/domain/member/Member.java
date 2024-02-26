package hello.servlet.domain.member;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private Long id;
    private String username;
    private int age;
    private int size;
    private int account;

    public Member() {

    }

    public Member(String username, int age, int size, int account) {
        this.username = username;
        this.age = age;
        this.size = size;
        this.account = account;
    }
}
