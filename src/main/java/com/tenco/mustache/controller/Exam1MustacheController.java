package com.tenco.mustache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

// @Controller -> IOC 의 대상이 된다
// @Controller : IOC --> 제어의 역전
@Controller
public class Exam1MustacheController {

    // URL 맵핑 설계 (주소 설계)
    // http://localhost:80/example/test1
    @GetMapping("/example/test1")
    public String basic1(Model model) {
        System.out.println("basic1 메서드 호출 됨");

        // 1. 데이터를 Model 객체에 추가하기
        // 1.1 기본 변수 출력 : 머스태치 파일에서 {{key}} 값으로 출력할 수 있다.
        model.addAttribute("stringValue","안녕 머스태치!~");
        model.addAttribute("intValue",1234);

        // 2.  데이터를 Model 객체에 추가 하기
        // 2.1 HTML 이스케이프 해제: {{{key}}}로 HTML 태그를 렌더링하도록 설정 (가능한 사용 x 주의해서 사용)
        //     XSS 보안에 취약해 진다.
        model.addAttribute("htmlContent",
                "<strong>굵게</strong>와 <em>기울임</em> 텍스트");

        // 3. 데이터를 Model 객체에 추가 하기
        // 3.1 섹션 : {{#key}} ..... {{/key}}
        //           #key 값이 참으로 평가 될 때 렌더링 됨  (Truthy - null 아니거나 빈 컬렉션이 아닐 때)
        model.addAttribute("hasData",true);
        model.addAttribute("data","비밀 메세지");

        // 4. 데이터를 Model 객체에 추가 하기
        // 4.1 부정 섹션: {{^key}} .... {{/key}} 로 조건이 거짓일 때 렌더링, null 값 설정
        //               #key 값이 거짓으로 평가 될 때 렌더링 됨  (Falsy - null 이거나 빈 컬렉션이 일 때)
        model.addAttribute("noData",null);

        List<String> items = new ArrayList<>();
        items.add("사과");
        items.add("바나나");
        items.add("오렌지");

        // 5.  데이터를 Model 객체에 추가 하기
        // 5.1 컬렉션 반복: {{#collection}}으로 리스트를 반복 출력
        model.addAttribute("items",items);

        // 6. 주석: 템플릿에서 {{! comment }}로 렌더링되지 않는 주석 처리
        // (컨트롤러에서는 별도 처리 불필요, 뷰에서 확인)

        // 7. 부분 템플릿 {{> partialName}} 으로 다른 템플릿을 포함
        // 뷰단에서 사용을 합니다.

        // 서버 설정(yml 파일 확인)
        // prefix - classpath:/templates/
        // return - examples/test1
        // suffix - .mustache
        // 완성 - src/main/resources/templates/examples/test1.mustache

        return "examples/test1";
    }
}
