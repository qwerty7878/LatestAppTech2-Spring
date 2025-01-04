package com.example.testgeneric;


public class MemberRepository implements Repository<Member> {
    @Override
    public void save(Member member) {

    }

    @Override
    public Member findByid(int id) {
        return new Member((long) id, "홍길동");
    }
}
