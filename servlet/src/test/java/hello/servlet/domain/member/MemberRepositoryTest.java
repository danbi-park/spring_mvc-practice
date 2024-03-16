package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    // 스프링을 쓰면 getInstance() 처럼 싱글톤으로 만들어줄 필요가 없음
    // 스프링 자체가 싱글톤을 보장해줌
    MemberRepository memberRepository =  MemberRepository.getInstance();

    // 각 테스트가 끝날 시 작업
    // repository 비워주기,
    // 전체 테스트 시 순서가 보장되지 않기 때문에 오류가 뜰 위험 이 있음
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //given
        Member member = new Member("dbPark", 28);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

    @Test
    void clear() {
    }
}