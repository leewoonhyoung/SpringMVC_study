package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);

    }
    @Test
    void findAll(){
        //given
        Member member1 = new Member("hello1", 10);
        Member member2= new Member("hello2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> findAll = memberRepository.findAll();
        //then
        Assertions.assertThat(findAll.size()).isEqualTo(2);
    }


}