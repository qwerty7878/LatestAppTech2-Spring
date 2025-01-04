package com.example.testannotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. @Entity annotation이 선언된 클래스 탐색
        List<Class<?>> entityClasses = findEntityClasses("com.example");
        System.out.println("찾은 @Entity 클래스: " + entityClasses);

        // 2. Reflection으로 Bean 생성 및 필드 값 주입
        for (Class<?> clazz : entityClasses) {
            Object bean = createBean(clazz);
            System.out.println("생상된 Bean: " + bean);
        }
    }

    // @Entity 어노테이션이 선언된 클래스를 찾는 메서드
    private static List<Class<?>> findEntityClasses(String packageName) throws Exception {
        //  ?는 '알 수 없는 타입(unknown type)'을 의미, 즉 ?는 어떤 타입이든 허용한다라고 이해하면 됨
        List<Class<?>> entityClasses = new ArrayList<>();

        // 예제에서는 직접 Member 클래스 하나만 추가
        // 클래스 이름을 문자열(string)로 받아 해당 클래스를 메모리에 로드하고, Class 객체를 반환
        // Class.forName은 런타인 시점에 동적으로 클래스(패키지명.클래스명)을 로드
        // Reflection 활용 : 로드된 Class 객체를 통해 클래스의 필드, 메서드, 생성자 등 메타데이터에 접근할 수 있음
        Class<?> clazz = Class.forName("com.example.testannotation.Member");

        if (clazz.isAnnotationPresent(Entity.class)) {
            entityClasses.add(clazz);
        }
        return entityClasses;
    }

    //  Reflection으로 Bean 생성
    private static Object createBean(Class<?> clazz) throws Exception{
        // 1. 기본 생성자를 통해 객체 생성
        // 클래스의 기본 생성자(매개변수가 없는 생성자)를 가져오는 Reflection 메서드
        // (생성자의 접근 제한자(public, private, protected)에 관계없이 선언된 모든 생성자를 가져올 수 있음)
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);    // protected 생성자 접근 허용
        Object instance = constructor.newInstance();    //  new 없이 Reflection으로 동적으로 객체 생성

        // 2. 필드에 값 주입
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            // 필드에 @id 어노테이션이 선언되었을 때, 필드에 1L 값 설정
            if (field.isAnnotationPresent(id.class)){
                field.set(instance, 1L);    //  id값 설정
            }

            //  필드에 @Column 어노테이션이 선언되었을 때, 필드에 홍길동 값 설정
            if (field.isAnnotationPresent(Column.class)) {
                field.set(instance,"홍길동");  //  이름 값 설정
            }
        }

        return instance;
    }
}