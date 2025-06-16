package com.tenco.mustache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication : 스프링 부트 자동 설정 활성화
 *
 * 컴포넌트 스캔의 시작점
 * 내장 톰캣 서버 실행
 */
@SpringBootApplication
public class MustacheApplication {

	// 코드의 진입점
	public static void main(String[] args) {
		SpringApplication.run(MustacheApplication.class, args);
	}

}
