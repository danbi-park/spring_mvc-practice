package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
import hello.itemservice.web.validation.ItemValidator;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
*/

@SpringBootApplication
public class ItemServiceApplication /*implements WebMvcConfigurer*/ {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	/* 검증 글로벌 설정!
	@Override
	public Validator getValidator() {
		return new ItemValidator();
	}*/
}
