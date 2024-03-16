package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
* */
public class MemberRepository {

    // 싱글톤으로 관리할거기 때문에 static이 없어도 되긴한데, 명시적으로 표시하기로 함
    //
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // 싱글톤으로 관리
    private static final MemberRepository instance = new MemberRepository();

    // instance로만 접근할 수 있도록 함
    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //store에 대한 값을 다 꺼내서 arrayList에 삽입 //store자체를 보호하기 위해서
    }

    public void clearStore(){
        store.clear();
    }

}
