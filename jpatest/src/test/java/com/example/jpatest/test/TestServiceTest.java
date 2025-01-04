package com.example.jpatest.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TestServiceTest {

    @InjectMocks
    private TestService testService;    //  테스트 대상 서비스

    @Mock
    private MemberRepository memberRepository;  //  Mock 객체로 의존성 대체

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //  Mock 객체 초기
    }

    @Test
    void getAllMembers() {
        //  Mock 데이터 설정
        when(memberRepository.findAll()).thenReturn(Arrays.asList(
                new Member(1L, "John"),
                new Member(2L, "Jane")

        ));

        //  테스트 실행
        List<Member> members = testService.getAllMembers();

        //  검증
        assertEquals(2, members.size());
        assertEquals("John",members.get(0).getName());
        assertEquals("Jane",members.get(1).getName());
    }
}