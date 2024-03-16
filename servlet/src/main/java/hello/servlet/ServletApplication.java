package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	// 스프링부트에서 아래 뷰 리졸버를 자동으로 등록하는데, 이 때 아래와 같이
	// application.properties에 등록한 spring.mvc.view.prefix, suffix를 가져와서 등록한다
	@Bean
	InternalResourceViewResolver internalResourceViewResolver(){
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}

}
